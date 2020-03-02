package FOOD;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class C001 {

	private JFrame frame;
	String sPath = new File("").getAbsolutePath();
	Login login;
	
	public static String id;
	public static MemberDTO member;
	ArrayList<String> RNameL;							//식당 이름 리스트
	RestaurantDAO rdao = new RestaurantDAO();			// DAO
	RestaurantDTO rdto;									// DTO
	
	/**
	 * Create the application.
	 */
	public C001(String id) {
		initialize();
	}
	public C001() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					C001 window = new C001(id);
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
		C001.setResizable(false); // 크기변경불가
		
	}

	private static void setResizable(boolean b) {
		// TODO Auto-generated method stub

	}
}