package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.imooc.service.loginTest;



/**
 * Servlet implementation class LogServlet
 */
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("utf-8");
				
		String username, mypassword;
		// 从客户端获取用户姓名与密码
		username = request.getParameter("username");
		mypassword = request.getParameter("mypassword");
		
		try {
			if(loginTest.logintest(username, mypassword)){
				//用户名和密码一致则返回成功页面
				request.getRequestDispatcher("../success.jsp").forward(request,
						response);
			}else{
				//用户名和密码不一致则返回失败页面
				request.getRequestDispatcher("../fail.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
