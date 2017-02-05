package entity;


/**
 * 用户基本信息
 * @author Administrator
 *
 */
public class Users {
	private String username;
	private String mypassword;
	private String email;
	private String gender;
	private String phone;//电话号码
//	private Date birthday;
//	private String[] favorites;
	private String introduce;
//	private boolean flag;
//	public String[] getFavorites() {
//		return favorites;
//	}
//	public void setFavorites(String[] favorites) {
//		this.favorites = favorites;
//	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
//	public boolean isFlag() {
//		return flag;
//	}
//	public void setFlag(boolean flag) {
//		this.flag = flag;
//	}
	public Users(){
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMypassword() {
		return mypassword;
	}
	public void setMypassword(String mypassword) {
		this.mypassword = mypassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	public Date getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
	
}
