package chinh.anh.controller;

import chinh.anh.model.Users;
import chinh.anh.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        String pageLink = "";
        if(session.getAttribute("user")!=null){
            pageLink = "WEB-INF/form-login/profile.jsp";
        } else {
            pageLink = "WEB-INF/form-login/login.jsp";
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(pageLink);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        Users users = userService.findByUsernameAndPassword(username,password);
        String destPage = "WEB-INF/form-login/login.jsp";
        if(users !=null){
            HttpSession session = req.getSession();
            session.setAttribute("user", users);
            System.out.println("Check session user luc login ==>"+session.getAttribute("user"));
            req.setAttribute("user", users);

            destPage = "WEB-INF/form-login/profile.jsp";
        }else {
            String message = "Login failed! Please check username/password";
            req.setAttribute("message", message);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
        dispatcher.forward(req,resp);
    }
}
