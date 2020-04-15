package kz.itstep.action;


import kz.itstep.dao.TaskDao;
import kz.itstep.dao.UserDao;
import kz.itstep.entity.Task;
import kz.itstep.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static kz.itstep.AppConstant.*;


public class LoginAction implements Action {
    private Logger logger = Logger.getLogger(LoginAction.class);
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userDao.findByLoginAndPassword(login, password);

        if(user != null && user.getRoleId() == 1){
            TaskDao courceDao = new TaskDao();
            List<Task> cources = courceDao.findAll();

            request.setAttribute(COURCES, cources);

            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);


            response.sendRedirect("/fs/admin");
            //request.getRequestDispatcher(URL_HI_PAGE).forward(request, response);
        }
        else{
            logger.info("Неверный логин или пароль! (" + login + " | " + password + ")");
            request.setAttribute(ERROR_LOGIN, "Неверный логин или пароль!");
            request.getRequestDispatcher(URL_AUTHORIZATION_PAGE).forward(request, response);

        }

    }
}
