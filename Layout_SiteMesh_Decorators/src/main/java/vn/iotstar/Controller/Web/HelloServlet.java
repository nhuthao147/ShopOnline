package vn.iotstar.Controller.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/hello","/xin-chao"})
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719396342298294724L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name="";
		//Nhận cookie
		Cookie[] cookie = req.getCookies();
		for (Cookie c: cookie) {
			if(c.getName().equals("username")) {
				name = c.getValue();}}
		if(name.equals("")){
			//chuyển sang trang LoginServlet
			resp.sendRedirect("/login");
		}
		//hiển thị lên trang bằng đối tượng PrintWriter()
		printWriter.println("Xin chao " + name);

	}
}
