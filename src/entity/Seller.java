package entity;


/**
 * ����ͼ�������Ϣ
 * @author Administrator
 *
 */
public class Seller {
	//����
	private String book_name;
	//������
	private String zuozhe_name;
	//������
	private String chubanshe_name;
	//�绰����
	private String phone;
	//��������
	private String maifang_name;
	public String getMaifang_name() {
		return maifang_name;
	}
	public void setMaifang_name(String maifang_name) {
		this.maifang_name = maifang_name;
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
		return "Seller [book_name=" + book_name + ", zuozhe_name="
				+ zuozhe_name + ", chubanshe_name=" + chubanshe_name
				+ ", phone=" + phone + ", maifang_name=" + maifang_name + "]";
	}
	

}
