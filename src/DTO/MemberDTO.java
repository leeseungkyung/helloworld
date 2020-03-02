package DTO;

public class MemberDTO {
	private String mid;
	private String password;
	private String name;
	private String phoneNumber;
	private String birthday;
	private String sex;
	private String eMail;
	private String admin;
	
	public MemberDTO(String mid, String password, String name, String phoneNumber, String birthday, String sex,
			String eMail, String admin) {
		super();
		this.mid = mid;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.sex = sex;
		this.eMail = eMail;
		this.admin = admin;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
}

