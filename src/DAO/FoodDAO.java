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

	//JDBC ����
	public Connection getConn() {
		try {
			String url = "jdbc:oracle:thin:@192.168.0.53:1521:xe";
			String user = "hello";
			String pw = "12345";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// ����
			conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}//end getConnection method


	//JDBC ���� ����.
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


	
	//������ ���� ���� üũ		by �¿�
	public void check (int cnt) {
		if(cnt > 0) {
			System.out.println("���������� �Ϸ��߽��ϴ�.");
		} else {
			System.out.println("�����߽��ϴ�.");
		}
	}
	
	
	//DB���� ���� üũ		by �¿�
	public void connCheck(Connection conn) {
		if(conn != null) {
			System.out.println("DB�� ����Ǿ����ϴ�.");
		} else {
			System.out.println("�����߽��ϴ�.");
		}
	}
	
	
}// end MemberDAO
