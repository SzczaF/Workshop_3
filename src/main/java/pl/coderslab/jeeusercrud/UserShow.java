package pl.coderslab.jeeusercrud;

import pl.coderslab.User;
import pl.coderslab.entity.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        req.setAttribute("user", userDAO.read(userId));
        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(req, resp);
    }
}
