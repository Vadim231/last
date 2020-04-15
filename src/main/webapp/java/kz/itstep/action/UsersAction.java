package kz.itstep.action;

import kz.itstep.DTO.UserDTO;
import kz.itstep.dao.RoleDao;
import kz.itstep.dao.UserDao;
import kz.itstep.entity.Role;
import kz.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static kz.itstep.AppConstant.USERS;
import static kz.itstep.AppConstant.URL_USERS_PAGE;

public class UsersAction implements Action {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        if (request.getAttribute("deleted")!=null){
            boolean deleted = (boolean)request.getAttribute("deleted");
            System.out.println(deleted);
        }

        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();

        List<User> users = userDao.findAll();
        List<Role> roles = roleDao.findAll();

        List<UserDTO> userDTOList = UserDTO.map(users,roles);

        request.setAttribute(USERS, userDTOList);
        request.getRequestDispatcher(URL_USERS_PAGE).forward(request, response);
    }
}
