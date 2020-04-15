package kz.itstep.action;

import kz.itstep.dao.TaskDao;
import kz.itstep.dao.UserDao;
import kz.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static kz.itstep.AppConstant.*;

public class DeleteAction implements Action {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter(USER_ID_ATTR);
        int userId = Integer.valueOf(userIdStr);

        UserDao userDao = new UserDao();

        User user = userDao.findById(userId);
        userDao.delete(user);
        response.sendRedirect("/fs/users");
    }
}
