package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.dao.Userdao;


import entity.Users;

public class RegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����ַ�����
		request.setCharacterEncoding("utf-8");

		Users u = new Users();
		String username, mypassword, gender, email, introduce, phone;
		String confirmpass;
		// �ӿͻ��˻�ȡ�û�������Ϣ
		username = request.getParameter("username");
		gender = request.getParameter("gender");
		mypassword = request.getParameter("mypassword");
		email = request.getParameter("email");
		introduce = request.getParameter("introduce");
		phone = request.getParameter("phone");
		confirmpass = request.getParameter("confirmpass");
		// ��װ�û���Ϣ
		u.setUsername(username);
		u.setMypassword(mypassword);
		u.setGender(gender);
		u.setEmail(email);
		u.setIntroduce(introduce);
		u.setPhone(phone);

		// // ��ȡsession
		// request.getSession().setAttribute("regUser", u);
		// ����ת��
		try {
			if (confirmpass.equals(mypassword)) {
				try {
					// ����û���Ϣ�����ݿ�
					Userdao.addUsers(u);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("../regsuccess.jsp").forward(
						request, response);

			} else {
				request.getRequestDispatcher("../regfail.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
