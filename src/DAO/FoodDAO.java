package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import DTO.*;


public class FoodDAO {
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
