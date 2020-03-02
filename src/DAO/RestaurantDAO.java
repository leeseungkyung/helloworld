package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import DTO.*;


public class RestaurantDAO {
	PreparedStatement pst = null;
	Connection conn = null;
	ResultSet rs;
	String sql;
	RestaurantDTO rdto;

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


	
	// Restaurant 이름만 가져오기
	public ArrayList<String> getSelectRestaurantName(String code) {
		try {
			getConn();
			ArrayList<String> list = new ArrayList<>();
			sql = "SELECT RESTAURANT_NAME FROM RESTAURANT WHERE RID LIKE ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, code+"%");
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getFinally();
		}
		return null;
	}
	
	
	//Id Search
	public String getRID(String name) {
		try {
			getConn();
			sql = "SELECT RID FROM RESTAURANT WHERE RESTAURANT_NAME=?";
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
	
	
}// end MemberDAO
