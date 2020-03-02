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


	
	// Restaurant �̸��� ��������
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
