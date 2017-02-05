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
		// �����ַ�����
		request.setCharacterEncoding("utf-8");
				
		String username, mypassword;
		// �ӿͻ��˻�ȡ�û�����������
		username = request.getParameter("username");
		mypassword = request.getParameter("mypassword");
		
		try {
			if(loginTest.logintest(username, mypassword)){
				//�û���������һ���򷵻سɹ�ҳ��
				request.getRequestDispatcher("../success.jsp").forward(request,
						response);
			}else{
				//�û��������벻һ���򷵻�ʧ��ҳ��
				request.getRequestDispatcher("../fail.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
