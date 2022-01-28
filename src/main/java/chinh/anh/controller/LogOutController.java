package chinh.anh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogOutController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
//        System.out.println("tren -->"+request.getAttribute("user"));
//        LoginControoler loginControoler = new LoginControoler();
//        loginControoler.returnUser(request);
//        System.out.println("check user tren -->"+loginControoler.returnUser(request));
//        Users users =
//
////        UserServiceImpl userService = new UserServiceImpl();
//       if(loginControoler.returnUser(request)!=null){
//           request.removeAttribute("user");
//           System.out.println("duoi-->"+request.getAttribute("user"));
//           response.sendRedirect("/login");
//           return;
//       }
//        System.out.println("check ==> "+request.getAttribute("user"));
//        response.sendRedirect("/login");

        if(session!=null){
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("/login");
            return;
        }
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
