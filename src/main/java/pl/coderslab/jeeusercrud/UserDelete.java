package pl.coderslab.jeeusercrud;

import pl.coderslab.entity.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        req.setAttribute("user", userDAO.read(userId));
        getServletContext().getRequestDispatcher("/users/delete.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        UserDAO userToDelete = new UserDAO();
        userToDelete.delete(userId);
        resp.sendRedirect(req.getContextPath() + "/user/list");
    }
}
