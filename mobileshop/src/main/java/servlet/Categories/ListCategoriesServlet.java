package servlet.Categories;

import dao.DAO;
import dao.CategoriesDAO;
import dao.implementsDAO.CategoriesDAOimplements;
import model.Categories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCategories")
public class ListCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        CategoriesDAOimplements categoriesDAO = new CategoriesDAOimplements(dao);
        List<Categories> listCategories1 = categoriesDAO.getAll();
        session.setAttribute("categories", listCategories1);
        //session.setAttribute("categoriesDAO", categoriesDAO);
        req.getRequestDispatcher("listCategories.jsp").forward(req,resp);
    }
}