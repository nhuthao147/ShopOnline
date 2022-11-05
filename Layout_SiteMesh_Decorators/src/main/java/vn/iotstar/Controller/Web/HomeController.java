package vn.iotstar.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.Models.ProductModel;
import vn.iotstar.Services.IProductWebService;
import vn.iotstar.Services.Impl.ProductWebServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	IProductWebService productService = new ProductWebServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> lastProductList = productService.findLastProduct();
		req.setAttribute("lastProductList", lastProductList);
		
		List<ProductModel> bestProductList = productService.findBestProduct();
		req.setAttribute("bestProductList", bestProductList);
		
		ProductModel topProduct = productService.findTopProduct();
		req.setAttribute("topProduct", topProduct);
		
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}

}
