package vn.iotstar.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.Models.CategoryModel;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.Services.Impl.CategoryServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/uploadmulti" })
@MultipartConfig(
		fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
		maxFileSize         = 1024 * 1024 * 10, // 10 MB
		maxRequestSize      = 1024 * 1024 * 15, // 15 MB
		location            = "C:/Users/hao/Pictures/Image_Web_Java"
		)
public class CategoryAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse
			resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
			resp) throws ServletException, IOException {
		//						User ServletFileUpload
		//						CategoryModel category = new CategoryModel();
		//						DiskFileItemFactory diskFileItemFactory = new
		//								DiskFileItemFactory();
		//						ServletFileUpload servletFileUpload = new
		//								ServletFileUpload(diskFileItemFactory);
		//						servletFileUpload.setHeaderEncoding("UTF-8"); 
		//						try {
		//							resp.setContentType("text/html");
		//							resp.setCharacterEncoding("UTF-8");
		//							req.setCharacterEncoding("UTF-8");
		//							List<FileItem> items = servletFileUpload.parseRequest(req);
		//							for (FileItem item : items) {
		//								if (item.get().equals("name")) {
		//									category.setCatename(item.getString("UTF-8"));
		//								} else if (item.getFieldName().equals("image")) {
		//									String originalFileName = item.getName();
		//									int index = originalFileName.lastIndexOf(".");
		//									String ext = originalFileName.substring(index + 1);
		//									String fileName = System.currentTimeMillis() + "." + ext;
		//									File file = new File(Constant.DIR + "/category/" + fileName);
		//									item.write(file);
		//									
		//									category.setImage("category/"+fileName);
		//								}
		//							}
		//							category.setStatus(1);
		//							cateService.insert(category);
		//							resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		//						} catch (FileUploadException e) {
		//							e.printStackTrace();
		//						} catch (Exception e) {
		//							e.printStackTrace();
		//						}

		//	User Multipart
		CategoryModel category = new CategoryModel();

		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			category.setCatename(req.getParameter("name"));

			Part part= req.getPart("image");
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			int index = filename.lastIndexOf(".");
			String ext = filename.substring(index + 1);
			filename = System.currentTimeMillis() + "." + ext;

			part.write(Constant.DIR + "/category/" + filename);
			category.setImage("category/"+filename);
			category.setStatus(1);

			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}