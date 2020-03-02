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

public class A002 {

	private JFrame frame;
	String sPath = new File("").getAbsolutePath();
	Login login;
	
	public static String id;
	public static MemberDTO member;
	ArrayList<String> RNameL;							//½Ä´ç ÀÌ¸§ ¸®½ºÆ®
	RestaurantDAO rdao = new RestaurantDAO();			// DAO
	RestaurantDTO rdto;									// DTO
	private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public A002(String id) {
		initialize();
	}
	public A002() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A002 window = new A002(id);
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
		panel_1.setLayout(null);							//Panel_1 ÃÊ±âÈ­
		panel_1.setSize(700, 500);							//Panel_1¿¡ ´ëÇÑ Á¶Àý
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
		btn_logout.setFont(new Font("aºñÅ¸¹Î", Font.PLAIN, 16));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ·Î±×¾Æ¿ô ¹öÆ° ´­·¶À» ¶§ ´Ù½Ã ·Î±×ÀÎ ÆäÀÌÁö ¶ç¿öÁÖ±â
				frame.dispose();
				new Login(); // ·Î±×ÀÎ ¼º°ø½Ã ¸Þ´ºÈ­¸é ¶ß±â
				login.main(null);
//				Login login = new Login(); // phoneDial ¶ç¿öÁÖ±âÀ§ÇØ¼­ ºÒ·¯¿À´Â°Í
//				login.setVisible(true);// ¶ç¿öÁÖ´Â
//				frame.setVisible(false); // ²ô´Â°Ç ÀüÃ¼ÀûÀÎ GUI ÀÚÃ¼°¡ FrameÀ¸·Î °¨½ÎÁ® ÀÖ±â ¶§¹®¿¡ frameÀ» Å°°í ²ô°í ÇØ¾ßÇÔ.

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
		btn_manager.setFont(new Font("aºñÅ¸¹Î", Font.PLAIN, 16));
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
		btn_info.setFont(new Font("aºñÅ¸¹Î", Font.PLAIN, 16));
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
		
		JPanel Panel_Object = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.WEST, Panel_Object, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, Panel_Object, 111, SpringLayout.NORTH, panel_2);
		Panel_Object.setBackground(SystemColor.activeCaption);
		sl_panel_2.putConstraint(SpringLayout.NORTH, Panel_Object, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, Panel_Object, -10, SpringLayout.WEST, scrollbar);
		panel_2.add(Panel_Object);
		SpringLayout sl_Panel_Object = new SpringLayout();
		Panel_Object.setLayout(sl_Panel_Object);
		
		JLabel lblNoImage = new JLabel("No image");
		lblNoImage.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		lblNoImage.setHorizontalAlignment(SwingConstants.CENTER);
		sl_Panel_Object.putConstraint(SpringLayout.NORTH, lblNoImage, 10, SpringLayout.NORTH, Panel_Object);
		sl_Panel_Object.putConstraint(SpringLayout.WEST, lblNoImage, 10, SpringLayout.WEST, Panel_Object);
		sl_Panel_Object.putConstraint(SpringLayout.SOUTH, lblNoImage, 90, SpringLayout.NORTH, Panel_Object);
		sl_Panel_Object.putConstraint(SpringLayout.EAST, lblNoImage, 90, SpringLayout.WEST, Panel_Object);
		Panel_Object.add(lblNoImage);
		
		JPanel panel_left = new JPanel();
		sl_Panel_Object.putConstraint(SpringLayout.NORTH, panel_left, 10, SpringLayout.NORTH, Panel_Object);
		sl_Panel_Object.putConstraint(SpringLayout.WEST, panel_left, 6, SpringLayout.EAST, lblNoImage);
		sl_Panel_Object.putConstraint(SpringLayout.SOUTH, panel_left, 90, SpringLayout.NORTH, Panel_Object);
		sl_Panel_Object.putConstraint(SpringLayout.EAST, panel_left, 463, SpringLayout.EAST, lblNoImage);
		Panel_Object.add(panel_left);
		SpringLayout sl_panel_left = new SpringLayout();
		panel_left.setLayout(sl_panel_left);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 15));
		sl_panel_left.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, panel_left);
		sl_panel_left.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, panel_left);
		panel_left.add(lblName);
		
		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_price, 6, SpringLayout.SOUTH, lblName);
		sl_panel_left.putConstraint(SpringLayout.WEST, lbl_price, 0, SpringLayout.WEST, lblName);
		panel_left.add(lbl_price);
		
		JLabel lbl_MinPrice = new JLabel("MinPrice");
		sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_MinPrice, 0, SpringLayout.NORTH, lbl_price);
		sl_panel_left.putConstraint(SpringLayout.WEST, lbl_MinPrice, 57, SpringLayout.EAST, lbl_price);
		lbl_MinPrice.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_left.add(lbl_MinPrice);
		
		JLabel lbl_Count = new JLabel("Count");
		sl_panel_left.putConstraint(SpringLayout.NORTH, lbl_Count, 8, SpringLayout.SOUTH, lbl_price);
		sl_panel_left.putConstraint(SpringLayout.WEST, lbl_Count, 0, SpringLayout.WEST, lblName);
		lbl_Count.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_left.add(lbl_Count);
		
		textField = new JTextField();
		sl_panel_left.putConstraint(SpringLayout.NORTH, textField, 30, SpringLayout.NORTH, panel_left);
		sl_panel_left.putConstraint(SpringLayout.EAST, textField, -31, SpringLayout.EAST, panel_left);
		textField.setText("12");
		textField.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_left.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u25C0");
		sl_panel_left.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_left.putConstraint(SpringLayout.EAST, lblNewLabel_1, -57, SpringLayout.EAST, panel_left);
		sl_panel_left.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 31, SpringLayout.NORTH, panel_left);
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 15));
		panel_left.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u25B6");
		sl_panel_left.putConstraint(SpringLayout.NORTH, label, 31, SpringLayout.NORTH, panel_left);
		sl_panel_left.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.EAST, textField);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 15));
		panel_left.add(label);
		
		JLabel label_1 = new JLabel("");
		sl_panel_left.putConstraint(SpringLayout.WEST, label_1, 26, SpringLayout.EAST, lbl_MinPrice);
		sl_panel_left.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, lbl_price);
		label_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_left.add(label_1);
		
		JLabel lblDelibery_fee = new JLabel("Delibery_fee");
		sl_panel_left.putConstraint(SpringLayout.NORTH, lblDelibery_fee, 0, SpringLayout.NORTH, lbl_price);
		sl_panel_left.putConstraint(SpringLayout.WEST, lblDelibery_fee, 0, SpringLayout.WEST, label_1);
		lblDelibery_fee.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		panel_left.add(lblDelibery_fee);
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
		lbl_Name.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbl_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Name.setBackground(Color.WHITE);
		lbl_Name.setText(this.id+"´Ô");
		panel.add(lbl_Name);

		JLabel lbl_Welcome = new JLabel("\uD658\uC601\uD569\uB2C8\uB2E4!!!");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_Welcome, 49, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_Name, -6, SpringLayout.NORTH, lbl_Welcome);
		lbl_Welcome.setBackground(Color.GREEN);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_Welcome, 0, SpringLayout.WEST, btn_logout);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_Welcome, 0, SpringLayout.EAST, btn_logout);
		panel.add(lbl_Welcome);
		A002.setResizable(false); // Å©±âº¯°æºÒ°¡
		
	}

	private static void setResizable(boolean b) {
		// TODO Auto-generated method stub

	}
}