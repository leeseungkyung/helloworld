package FOOD;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DAO.RestaurantDAO;
import DTO.MemberDTO;
import DTO.RestaurantDTO;

import UI.*;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

public class A001 {

	private JFrame frame;
	String sPath = new File("").getAbsolutePath();
	Login login;
	
	public static String id;
	public static MemberDTO member;
	ArrayList<String> RNameL;							//식당 이름 리스트
	RestaurantDAO rdao = new RestaurantDAO();			// DAO
	RestaurantDTO rdto;									// DTO
	private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public A001(String id) {
		initialize();
	}
	public A001() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A001 window = new A001(id);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 732, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);							//Panel_1 초기화
		panel_1.setSize(700, 500);							//Panel_1에 대한 조절
		panel_1.setBackground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 159, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		sl_panel.putConstraint(SpringLayout.NORTH, btn_logout, 128, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btn_logout, 602, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btn_logout, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btn_logout, -10, SpringLayout.EAST, panel);
		btn_logout.setForeground(new Color(255, 255, 255));
		btn_logout.setBackground(new Color(153, 0, 0));
		btn_logout.setFont(new Font("a비타민", Font.PLAIN, 16));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그아웃 버튼 눌렀을 때 다시 로그인 페이지 띄워주기
				frame.dispose();
				new Login(); // 로그인 성공시 메뉴화면 뜨기
				login.main(null);
//				Login login = new Login(); // phoneDial 띄워주기위해서 불러오는것
//				login.setVisible(true);// 띄워주는
//				frame.setVisible(false); // 끄는건 전체적인 GUI 자체가 Frame으로 감싸져 있기 때문에 frame을 키고 끄고 해야함.

			}
		});
		panel.add(btn_logout);

		JButton btn_manager = new JButton("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		sl_panel.putConstraint(SpringLayout.NORTH, btn_manager, 66, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btn_manager, 602, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btn_manager, 0, SpringLayout.EAST, btn_logout);
		btn_manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManagerDial md = new ManagerDial();
				md.setVisible(true);

			}

		});
		btn_manager.setForeground(new Color(255, 255, 255));
		btn_manager.setBackground(new Color(153, 0, 0));
		btn_manager.setFont(new Font("a비타민", Font.PLAIN, 16));
		panel.add(btn_manager);

		JButton btn_info = new JButton("\uC815\uBCF4\uC218\uC815");
		sl_panel.putConstraint(SpringLayout.NORTH, btn_info, 97, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btn_info, -6, SpringLayout.NORTH, btn_logout);
		sl_panel.putConstraint(SpringLayout.SOUTH, btn_manager, -6, SpringLayout.NORTH, btn_info);
		sl_panel.putConstraint(SpringLayout.WEST, btn_info, 0, SpringLayout.WEST, btn_logout);
		sl_panel.putConstraint(SpringLayout.EAST, btn_info, 0, SpringLayout.EAST, btn_logout);
		btn_info.setForeground(new Color(255, 255, 255));
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_info.setBackground(new Color(153, 0, 0));
		btn_info.setFont(new Font("a비타민", Font.PLAIN, 16));
		panel.add(btn_info);
		panel_1.setToolTipText("");
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 486, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 600, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		Scrollbar scrollbar = new Scrollbar();
		sl_panel_2.putConstraint(SpringLayout.NORTH, scrollbar, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, scrollbar, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, scrollbar, 0, SpringLayout.EAST, panel_2);
		panel_2.add(scrollbar);
		
		
		
		// it's that Select Menu UI & DAO conn				by 태영
		JPanel Panel_Object[] = new JPanel[5];
		JLabel lblNoImage[] = new JLabel[5];
		JPanel panel_left[] = new JPanel[5];
		JLabel lblName[] = new JLabel[5];
		JLabel lbl_price[] = new JLabel[5];
		JLabel lbl_MinPrice[] = new JLabel[5];
		JLabel lblDelibery_fee[] = new JLabel[5];
		JLabel lbl_Count[] = new JLabel[5];
		JTextField textFild[] = new JTextField[5];
		JLabel lbTextRight[] = new JLabel[5];
		JLabel lblTxtLeft[] = new JLabel[5];

		

		int incrate= 10;
		for (int i = 0; i < 5; i++) {
			Panel_Object[i] = new JPanel();
			lblNoImage[i] = new JLabel();
			panel_left[i] = new JPanel();
			lblName[i] = new JLabel();
			lbl_price[i] = new JLabel();
			lbl_MinPrice[i] = new JLabel();
			lblDelibery_fee[i] = new JLabel();
			lbl_Count[i] = new JLabel();
			textFild[i] = new JTextField();
			lbTextRight[i] = new JLabel("\u25B6");
			lblTxtLeft[i] = new JLabel("\u25C0");
			
			Panel_Object[i].setSize(1000, 500);
			
			//밑그림이 될 Panel 생성
			sl_panel_2.putConstraint(SpringLayout.NORTH, Panel_Object[i], incrate, SpringLayout.NORTH, panel_2);
			sl_panel_2.putConstraint(SpringLayout.WEST, Panel_Object[i], 10, SpringLayout.WEST, panel_2);
			sl_panel_2.putConstraint(SpringLayout.SOUTH, Panel_Object[i], 100, SpringLayout.NORTH, panel_2);
			sl_panel_2.putConstraint(SpringLayout.EAST, Panel_Object[i], 573, SpringLayout.WEST, panel_2);
			Panel_Object[i].setBackground(SystemColor.activeCaption);
			panel_2.add(Panel_Object[i]);
			SpringLayout sl_Panel_Object = new SpringLayout();
			Panel_Object[i].setLayout(sl_Panel_Object);
//			
////			// left image 출력하는 구문 만든것
////			lblNoImage[i].setIcon(new ImageIcon(sPath + "\\img\\noimage.jpeg"));
////			lblNoImage[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			lblNoImage[i].setHorizontalAlignment(SwingConstants.CENTER);
////			sl_Panel_Object.putConstraint(SpringLayout.NORTH, lblNoImage[i], 10, SpringLayout.NORTH, Panel_Object[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.WEST, lblNoImage[i], 10, SpringLayout.WEST, Panel_Object[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.SOUTH, lblNoImage[i], 90, SpringLayout.NORTH, Panel_Object[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.EAST, lblNoImage[i], 90, SpringLayout.WEST, Panel_Object[i]);
////			Panel_Object[i].add(lblNoImage[i]);
////			
////			
////			sl_Panel_Object.putConstraint(SpringLayout.NORTH, panel_left[i], 10, SpringLayout.NORTH,  Panel_Object[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.WEST, panel_left[i], 6, SpringLayout.EAST, lblNoImage[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.SOUTH, panel_left[i], 90, SpringLayout.NORTH,  Panel_Object[i]);
////			sl_Panel_Object.putConstraint(SpringLayout.EAST, panel_left[i], 463, SpringLayout.EAST, lblNoImage[i]);
////			Panel_Object[i].add(panel_left[i]);
////			SpringLayout sl_panel_left = new SpringLayout();
////			panel_left[i].setLayout(sl_panel_left);
////		
////			//메뉴이름
////			lblName[i].setHorizontalAlignment(SwingConstants.LEFT);
////			sl_panel_left.putConstraint(SpringLayout.EAST, lblName[i], 366, SpringLayout.WEST, panel_left[i]);
////			lblName[i].setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lblName[i], 10, SpringLayout.NORTH, panel_left[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lblName[i], 10, SpringLayout.WEST, panel_left[i]);
////			panel_left[i].add(lblName[i]);
////			
////
////			//메뉴가격
////			lbl_price[i].setHorizontalAlignment(SwingConstants.LEFT);
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_price[i], 6, SpringLayout.SOUTH, lblName[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lbl_price[i], 10, SpringLayout.WEST, panel_left[i]);
////			lbl_price[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			panel_left[i].add(lbl_price[i]);
////			
////			//최소 주문 금액			
////			lbl_MinPrice[i].setHorizontalAlignment(SwingConstants.LEFT);
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_MinPrice[i], 0, SpringLayout.NORTH, lbl_price[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lbl_MinPrice[i], 57, SpringLayout.EAST, lbl_price[i]);
////			lbl_MinPrice[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			panel_left[i].add(lbl_MinPrice[i]);
////			
////			//배달비
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lblDelibery_fee[i], 0, SpringLayout.NORTH, lbl_price[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lblDelibery_fee[i], 0, SpringLayout.WEST, lbl_price[i]);
////			lblDelibery_fee[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			panel_left[i].add(lblDelibery_fee[i]);
//////		btn_info.setBorderPainted(false);				//왜 있는지 모름. 갑자기 생김
//////		btn_logout.setBorderPainted(false);
//////		btn_manager.setBorderPainted(false);
////			
////		
////			//주문 예약한 사람의 수
////			lbl_Count[i].setHorizontalAlignment(SwingConstants.LEFT);
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_Count[i], 8, SpringLayout.SOUTH, lbl_price[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lbl_Count[i], 10, SpringLayout.WEST, panel_left[i]);
////			lbl_Count[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			panel_left[i].add(lbl_Count[i]);
////			
////			//텍스트필드로써 사용자가 직접 숫자 입력 혹은 증감할 때 대상이 되는 object
////			sl_panel_left.putConstraint(SpringLayout.NORTH, textFild[i], 30, SpringLayout.NORTH, panel_left[i]);
////			sl_panel_left.putConstraint(SpringLayout.EAST, textFild[i], -31, SpringLayout.EAST, panel_left[i]);
////			textFild[i].setText("0");
////			textFild[i].setFont(new Font("나눔고딕", Font.PLAIN, 12));
////			panel_left[i].add(textFild[i]);
////			textFild[i].setColumns(10);
////			
////
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lblTxtLeft[i], 31, SpringLayout.NORTH, panel_left[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lblTxtLeft[i], 6, SpringLayout.EAST, textFild[i]);
////			lblTxtLeft[i].setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
////			panel_left[i].add(lblTxtLeft[i]);
////			
////			JLabel lblRight = new JLabel("\u25B6");
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lbTextRight[i], 22, SpringLayout.NORTH, panel_left[i]);
////			sl_panel_left.putConstraint(SpringLayout.WEST, lbTextRight[i], 2, SpringLayout.EAST, textFild[i]);
////			lblRight.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
////			panel_left[i].add(lblRight);
////			
////			JLabel lblLeft = new JLabel("\u25C0");
////			sl_panel_left.putConstraint(SpringLayout.NORTH, lblTxtLeft[i], 23, SpringLayout.NORTH, lbTextRight[i]);
////			sl_panel_left.putConstraint(SpringLayout.EAST, lblTxtLeft[i], -2, SpringLayout.WEST, textFild[i]);
////			lblLeft.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
////			panel_left[i].add(lblTxtLeft[i]);
			incrate += 110;
		}
		
		////작업 끝
		
		

		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 6, SpringLayout.EAST, panel_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		panel_1.add(panel_3);
		btn_info.setBorderPainted(false);
		btn_logout.setBorderPainted(false);
		btn_manager.setBorderPainted(false);

		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -136, SpringLayout.EAST, panel);
		lblNewLabel.setIcon(new ImageIcon(sPath + "\\img\\label.jpg"));
		panel.add(lblNewLabel);

		JLabel lbl_Name = new JLabel("\uD5C8\uC6D0\uC2DD");
		sl_panel.putConstraint(SpringLayout.WEST, lbl_Name, 602, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_Name, 0, SpringLayout.EAST, btn_logout);
		lbl_Name.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Name.setBackground(Color.WHITE);
		lbl_Name.setText(this.id+"님");
		panel.add(lbl_Name);

		JLabel lbl_Welcome = new JLabel("\uD658\uC601\uD569\uB2C8\uB2E4!!!");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_Welcome, 49, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_Name, -6, SpringLayout.NORTH, lbl_Welcome);
		lbl_Welcome.setBackground(Color.GREEN);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_Welcome, 0, SpringLayout.WEST, btn_logout);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_Welcome, 0, SpringLayout.EAST, btn_logout);
		panel.add(lbl_Welcome);
		A001.setResizable(false); // 크기변경불가
		
	}

	private static void setResizable(boolean b) {
		// TODO Auto-generated method stub

	}
}