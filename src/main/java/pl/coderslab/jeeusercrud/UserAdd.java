package pl.coderslab.jeeusercrud;

import pl.coderslab.User;
import pl.coderslab.entity.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("inputUser"));
        user.setEmail(req.getParameter("inputEmail"));
        user.setPassword(req.getParameter("inputPassword"));

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
        resp.sendRedirect(req.getContextPath() + "/user/list");

//        System.out.println(user);
    }
}
