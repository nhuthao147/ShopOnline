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
import vn.iotstar.Models.ProductModel;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.Services.IProductWebService;
import vn.iotstar.Services.Impl.CategoryServiceImpl;
import vn.iotstar.Services.Impl.ProductWebServiceImpl;

@WebServlet(urlPatterns = { 
		"/product/list","/product/detail","/product/loadAjax"})
public class ProductController extends HttpServlet {
	IProductWebService productService = new ProductWebServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("product/list")) {
			productPage(req, resp);
		}
		if (url.contains("product/detail")) {
			productDetail(req, resp);
		}
		if (url.contains("product/loadAjax")) {
			productLoadAjax(req, resp);
		}
	}
	protected void productLoadAjax(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//bước 3: Thiết lập dữ liệu lên JSP
		List<ProductModel> list = productService.getTop3Product();
		req.setAttribute("listAllproduct", list);
		//bước 4: Trả v�? trang JSP nào
		RequestDispatcher rq = 
				req.getRequestDispatcher("/views/web/product_ajax.jsp");
		rq.forward(req, resp);
	}
		protected void productDetail(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {
			String productid = req.getParameter("productid");
			// lay du lieu va day len view
			ProductModel product = 
					productService.findById(Integer.parseInt(productid));
			req.setAttribute("product", product);
			// lay du lieu tất cả category va day len view
			List<CategoryModel> categoryList = categoryService.findALL();
			req.setAttribute("categoryList", categoryList);
			req.getRequestDispatcher("/views/web/productDetail.jsp").forward(req, resp);
		}
		protected void productPage(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {
			String categoryid = req.getParameter("categoryid");
			String indexPage = req.getParameter("index");
			//phân trang, khởi tạo trang đầu
			if (indexPage == null) {
				indexPage = "1";
			}
			if (categoryid == null) {
				indexPage = "2";
			}
			int indexp= Integer.parseInt(indexPage);
			//Get data từ DAO
			int countP = productService.countAll();
			//chia trang cho count
			int endPage = countP/3;
			if(countP % 3 !=0) {
				endPage ++;
			}
			List<ProductModel> productListNew = 
					productService.findAllPage(indexp-1);
			req.setAttribute("topProduct", productService.findTopProduct());
			req.setAttribute("productListNew", productListNew);
			req.setAttribute("listAllproduct", productListNew);
			req.setAttribute("countproductAll", countP);
			// lay du lieu va day len view
			List<CategoryModel> categoryList = categoryService.findALL();
			req.setAttribute("categoryList", categoryList);
			//Truyền lên JSP
			req.setAttribute("endP", endPage);
			req.setAttribute("tag", indexp);
			req.setAttribute("cateid", categoryid);
			req.getRequestDispatcher("/views/web/product-list-ajax.jsp").forward(req, resp);

		}
	}