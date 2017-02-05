package entity;


/**
 * 所卖图书基本信息
 * @author Administrator
 *
 */
public class Buyer {
	//书名
	private String book_name;
	//作者名
	private String zuozhe_name;
	//出版社
	private String chubanshe_name;
	//电话号码
	private String phone;
	//买方姓名
	private String buyer_name;
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_name() {
		return buyer_name;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getZuozhe_name() {
		return zuozhe_name;
	}
	public void setZuozhe_name(String zuozhe_name) {
		this.zuozhe_name = zuozhe_name;
	}
	public String getChubanshe_name() {
		return chubanshe_name;
	}
	public void setChubanshe_name(String chubanshe_name) {
		this.chubanshe_name = chubanshe_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Buyer [book_name=" + book_name + ", zuozhe_name=" + zuozhe_name
				+ ", chubanshe_name=" + chubanshe_name + ", phone=" + phone
				+ ", buyer_name=" + buyer_name + "]";
	}
	

}
