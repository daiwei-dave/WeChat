package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.dao.SellerDao;
import com.imooc.dao.Userdao;

import entity.Seller;
import entity.Users;

/**
 * Servlet implementation class maifangServlet
 */
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 添加卖方信息到数据库
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("utf-8");
		Seller m=new Seller();
		String book_name, zuozhe_name, chubanshe_name,phone,maifang_name;
		
		// 从客户端获取信息
		book_name = request.getParameter("book_name");
		zuozhe_name = request.getParameter("zuozhe_name");
		chubanshe_name= request.getParameter("chubanshe_name");
		phone = request.getParameter("phone");
		maifang_name=request.getParameter("maifang_name");
		// 封装信息
		m.setBook_name(book_name);
		m.setZuozhe_name(zuozhe_name);
		m.setChubanshe_name(chubanshe_name);
		m.setPhone(phone);
		m.setMaifang_name(maifang_name);

		// // 获取session
		// request.getSession().setAttribute("regUser", u);
		
		
				try {
					// 添加信息到数据库
					SellerDao.addMaiFang(m);
					// 请求转发
					request.getRequestDispatcher("/tspoison.cn/exchange/tijiaosuccess.jsp").forward(request,
							response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
