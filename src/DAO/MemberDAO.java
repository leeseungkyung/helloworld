package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberDAO {
	PreparedStatement pst = null;
	Connection conn = null;
	ResultSet rs;
	String sql;

	Scanner sc = new Scanner(System.in);

	//JDBC 연결
	public Connection getConn() {
		try {
			String url = "jdbc:oracle:thin:@192.168.0.53:1521:xe";
			String user = "hello";
			String pw = "12345";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 연결
			conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}//end getConnection method


	//JDBC 연결 끊기.
	public void getFinally() {
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//pst close
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//conn close
	}//end getFinally method

	
	//회원가입		by 태영
	public int insertFuction(String mid,  String password, String name, String phone, String birthday, int sex, String eMail) {
		String sql = "INSERT INTO member values(?,?,?,?,?,?,?,?)";
		try {
			connCheck(getConn());	
			pst = conn.prepareStatement(sql);
			pst.setString(1, mid);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, phone);
			pst.setString(5, birthday);
			pst.setInt(6, sex);
			pst.setString(7, eMail);
			pst.setString(8, null);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		return 0;
	}
	
	
	// 중복체크
	public boolean idDoubleCheck(String checkID) {
		try {
			connCheck(getConn());
			sql = "SELECT * FROM MEMBER WHERE MID=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, checkID);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		return false;
	}
	
	
	
	// 로그인
	public boolean doubleCheck(String checkID, String checkPW) {
		try {
			connCheck(getConn());
			sql = "SELECT * FROM MEMBER WHERE MID=? AND PASSWORD=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, checkID);
			pst.setString(2, checkPW);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				return true;
			}
            return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		
		return false;
	}
	
	//Id Search
	public String searchID(String name) {
		try {
			getConn();
			sql = "SELECT MID FROM MEMBER WHERE NAME=?";
			pst = conn.prepareCall(sql);
			pst.setString(1, name);
			
			rs = pst.executeQuery();
			while(rs.next()) {
					return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		return null;
	}

     
	
	//PW Search
	public String searchPW(String id, String birthday) {
		try {
			getConn();
			sql = "SELECT PASSWORD FROM MEMBER WHERE MID=? AND BIRTHDAY=?";
			pst = conn.prepareCall(sql);
			pst.setString(1, id);
			pst.setString(2, birthday);
			rs = pst.executeQuery();
			while(rs.next()) {
					return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		return null;
	}

	
	
	//쿼리문 실행 여부 체크		by 태영
	public void check (int cnt) {
		if(cnt > 0) {
			System.out.println("성공적으로 완료했습니다.");
		} else {
			System.out.println("실패했습니다.");
		}
	}
	
	
	//DB연결 여부 체크		by 태영
	public void connCheck(Connection conn) {
		if(conn != null) {
			System.out.println("DB에 연결되었습니다.");
		} else {
			System.out.println("실패했습니다.");
		}
	}
	
	
	public int pwUpdate(String beforepw, String afterpw) {

		try {
			getConn();
			sql = "update member set password=? where id=?";				
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, beforepw);
			pst.setString(2, afterpw);
			
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("수정성공");
				
			} else {
				System.out.println("수정실패");
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	

	
	
}// end MemberDAO
