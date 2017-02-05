package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.dao.BuyerDao;
import com.imooc.dao.SellerDao;
import com.imooc.dao.Userdao;

import entity.Buyer;
import entity.Seller;
import entity.Users;

/**
 * Servlet implementation class maifangServlet
 */
public class BuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyerServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �����ַ�����
		request.setCharacterEncoding("utf-8");
		Buyer b = new Buyer();
		String book_name, zuozhe_name, chubanshe_name, phone, buyer_name;

		// �ӿͻ��˻�ȡ��Ϣ
		book_name = request.getParameter("book_name");
		zuozhe_name = request.getParameter("zuozhe_name");
		chubanshe_name = request.getParameter("chubanshe_name");
		phone = request.getParameter("phone");
		buyer_name = request.getParameter("buyer_name");
		// ��װ��Ϣ
		b.setBook_name(book_name);
		b.setZuozhe_name(zuozhe_name);
		b.setChubanshe_name(chubanshe_name);
		b.setPhone(phone);
		b.setBuyer_name(buyer_name);

		// // ��ȡsession
		// request.getSession().setAttribute("regUser", u);

		// ����û���Ϣ�����ݿ�
		try {
			BuyerDao.addBuyer(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����ת��
		request.getRequestDispatcher("/exchange/tijiaosuccess.jsp").forward(
				request, response);

	}

}
