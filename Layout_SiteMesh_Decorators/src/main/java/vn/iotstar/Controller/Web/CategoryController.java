package vn.iotstar.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.Models.CategoryModel;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.Services.Impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/category" })
public class CategoryController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse
			resp) throws ServletException, IOException {
		List<CategoryModel> cateList = cateService.findALL();
		req.setAttribute("cateList", cateList);
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/views/web/category.jsp");
		dispatcher.forward(req, resp);
	}
	
}