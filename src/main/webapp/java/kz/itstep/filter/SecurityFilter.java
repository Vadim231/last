package kz.itstep.filter;

import kz.itstep.dao.RoleDao;
import kz.itstep.entity.Role;
import kz.itstep.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SecurityFilter implements Filter {
    Logger logger = Logger.getLogger(SecurityFilter.class);
    private String admin = "admin";
    private String user = "user";

    private final Set<String> adminAccess = new HashSet<>();
    private final Set<String> userAccess = new HashSet<>();
    private final Set<String> questAccess = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initAdminAccess();
        initQuestAccess();
        initUserAccess();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getPathInfo();
        if(path.contains("jquery")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        Role role = null;
        try{
            User user = (User)req.getSession().getAttribute("currentUser");
            RoleDao roleDao = new RoleDao();
            role = roleDao.findById(user.getRoleId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        if(role == null){
            if(!questAccess.contains(path)){
                logger.warn("access denied!");
                resp.sendRedirect("/");
                return;
            }
        } else if(role.getName().equals(admin)){
            if(!adminAccess.contains(path)){
                logger.warn("access denied!");
                resp.sendRedirect("/fs/cources");
                return;
            }
        } else if(role.getName().equals(this.user)){
            if(!userAccess.contains(path)){
                logger.warn("access denied!");
                resp.sendRedirect("/fs/cources");
                return;
            }
        }



        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void initQuestAccess(){
        questAccess.add("/registration");
        questAccess.add("/authorization");
        questAccess.add("/login");

    }

    private void initUserAccess(){
        userAccess.add("/cources");
        userAccess.add("/cource");
        userAccess.add("/info");
        userAccess.add("/hi");
        userAccess.add("/buy");
        userAccess.add("/profile");
        userAccess.add("/profile/edit");
        userAccess.add("/logout");

    }

    private void initAdminAccess(){
        adminAccess.add("/admin");
        adminAccess.add("/cources");
        adminAccess.add("/cource");
        adminAccess.add("/info");
        adminAccess.add("/buy");
        adminAccess.add("/delete");
        adminAccess.add("/profile");
        adminAccess.add("/profile/edit");
        adminAccess.add("/logout");
    }
}
