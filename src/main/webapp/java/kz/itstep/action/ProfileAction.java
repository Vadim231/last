package kz.itstep.action;

import kz.itstep.DTO.UserDTO;
import kz.itstep.dao.RoleDao;
import kz.itstep.dao.TaskDao;
import kz.itstep.dao.PurchasedCourceDao;
import kz.itstep.dao.UserDao;
import kz.itstep.entity.Role;
import kz.itstep.entity.Task;
import kz.itstep.entity.DoneTask;
import kz.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static kz.itstep.AppConstant.*;

public class ProfileAction implements Action {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter(USER_ID_ATTR));
        UserDao userDao = new UserDao();
        User user = userDao.findById(userId);

        RoleDao roleDao = new RoleDao();
        Role role = roleDao.findById(user.getRoleId());


        //DoneTaskDao doneTaskDao = new DoneTaskDao();
        TaskDao taskDao = new TaskDao();

        //List<DoneTask> doneTasks = purchasedCourceDao.findByUserId(user.getId());
        List<Task> tasks = taskDao.findByUserId(userId);

        request.setAttribute(PROFILE, user);
        request.setAttribute(PROFILE_ROLE, role);
        request.setAttribute(USER_TASKS, tasks);
        request.getRequestDispatcher(URL_PROFILE_PAGE).forward(request, response);
    }
}
