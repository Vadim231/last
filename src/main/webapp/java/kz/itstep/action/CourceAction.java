package kz.itstep.action;

import kz.itstep.dao.TaskDao;
import kz.itstep.dao.PurchasedCourceDao;
import kz.itstep.entity.Task;
import kz.itstep.entity.DoneTask;
import kz.itstep.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static kz.itstep.AppConstant.*;

public class CourceAction implements Action {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courceId = request.getParameter("courceId");
        TaskDao courceDao = new TaskDao();
        Task cource = courceDao.findById(Integer.parseInt(courceId));

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");

        PurchasedCourceDao purchasedCourceDao = new PurchasedCourceDao();
        List<DoneTask> purchasedCourceList = purchasedCourceDao.findByUserId(user.getId());
        DoneTask purchasedCource = new DoneTask(user.getId(), cource.getId());
        if(purchasedCourceList != null){
            boolean contains = false;
            for (int i = 0; i < purchasedCourceList.size(); i++) {
                if(purchasedCource.getCourceId() == purchasedCourceList.get(i).getCourceId() && purchasedCource.getUserId() == purchasedCourceList.get(i).getUserId()){
                    contains = true;
                }
            }
            request.setAttribute(IS_PURCHASED, contains);
        }

        request.setAttribute(COURCE, cource);
        request.getRequestDispatcher(COURCE_PAGE).forward(request, response);
    }
}
