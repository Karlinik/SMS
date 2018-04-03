package com.nikola.sms_03.service;

import com.nikola.sms_03.example.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nikola Karlikova on 01.04.2018.
 */

@WebServlet(
        name = "EmployeeServlet",
        urlPatterns = {"/employee"}
)

public class PersonServlet extends HttpServlet {
    PersonService personService;

    PersonServlet(){
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("searchAction");

        if(action!=null){
            switch(action){
                case "searchById":
                    searchPersonById(request, response);
                    break;
                case "searchByName":
                    searchPersonByName(request, response);
                    break;
            }
        } else{
            List<Person> result = personService.getAllPersons();
            forwardListPerson(request, response, result);
        }

    }

    private void searchPersonById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idEmployee = Integer.valueOf(req.getParameter("idEmployee"));
        Person employee = null;
        try {
            employee = personService.getPerson(idEmployee);
        } catch (Exception ex) {
            Logger.getLogger(PersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("employee", employee);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-employee.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void searchPersonByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String employeeName = req.getParameter("employeeName");
        List<Person> result = personService.searchPersonByName(employeeName);
        forwardListPerson(req, resp, result);
    }

    private void forwardListPerson(HttpServletRequest req, HttpServletResponse resp, List employeeList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/list-employees.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("employeeList", employeeList);
        dispatcher.forward(req, resp);
    }
}
