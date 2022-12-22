package pl.coderslab.jeeusercrud;

import pl.coderslab.User;
import pl.coderslab.entity.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Parameter;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        req.setAttribute("user", userDAO.read(userId));
        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("inputId")));
        user.setUserName(req.getParameter("inputUser"));
        user.setEmail(req.getParameter("inputEmail"));
        user.setPassword(req.getParameter("inputPassword"));

        System.out.println(user);
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
        resp.sendRedirect(req.getContextPath() + "/user/list");

    }
}
