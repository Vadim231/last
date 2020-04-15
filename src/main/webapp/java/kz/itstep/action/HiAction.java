package kz.itstep.action;

import kz.itstep.dao.TaskDao;
import kz.itstep.dao.LanguageDao;
import kz.itstep.entity.Task;
import kz.itstep.entity.Language;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static kz.itstep.AppConstant.*;


public class HiAction implements Action{

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDao courceDao = new TaskDao();
        LanguageDao languageDao = new LanguageDao();

        List<Language> languages = languageDao.findAll();
        List<Task> cources = courceDao.findAll();

        String pricing_type_eq = null;
        String language_eq = null;

        try{
            pricing_type_eq = request.getParameter("pricing_type_eq");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            language_eq = request.getParameter("language_eq");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



        request.setAttribute(COURCES, cources);
        request.setAttribute(LANGUAGES, languages);
        request.getRequestDispatcher(URL_HI_PAGE).forward(request, response);
    }
}
