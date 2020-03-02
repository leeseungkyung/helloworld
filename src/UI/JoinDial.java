package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JoinDial extends JDialog {
	MemberDAO mdao;	//by 태영
	private int sexInsert; 

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_eMail;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_id;
	private JPasswordField pw;
	private JPasswordField pwre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinDial dialog = new JoinDial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinDial() {
		setBounds(100, 100, 454, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(178, 34, 34));
		contentPanel.setForeground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel, -5, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, panel, -5, SpringLayout.EAST, contentPanel);
		panel.setBackground(new Color(250, 235, 215));
		panel.setForeground(new Color(25, 25, 112));
		contentPanel.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		
		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setForeground(new Color(178, 34, 34));
		panel.add(lbl_id);
		lbl_id.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		txt_id = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txt_id, -1, SpringLayout.NORTH, lbl_id);
		sl_panel.putConstraint(SpringLayout.WEST, txt_id, 20, SpringLayout.EAST, lbl_id);
		sl_panel.putConstraint(SpringLayout.EAST, txt_id, -194, SpringLayout.EAST, panel);
		panel.add(txt_id);
		txt_id.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		txt_id.setColumns(10);
		
		JLabel lbl_pw = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_pw, -285, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_id, -27, SpringLayout.NORTH, lbl_pw);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_id, 0, SpringLayout.EAST, lbl_pw);
		lbl_pw.setForeground(new Color(178, 34, 34));
		lbl_pw.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		panel.add(lbl_pw);
		
		JLabel lbl_rwPW = new JLabel("\uD328\uC2A4\uC6CC\uB4DC \uD655\uC778");
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_rwPW, -244, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_pw, 0, SpringLayout.EAST, lbl_rwPW);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_rwPW, 10, SpringLayout.WEST, panel);
		lbl_rwPW.setForeground(new Color(178, 34, 34));
		panel.add(lbl_rwPW);
		lbl_rwPW.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		JLabel lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setForeground(new Color(178, 34, 34));
		panel.add(lbl_name);
		lbl_name.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		txt_name = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txt_name, 131, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txt_name, 21, SpringLayout.EAST, lbl_name);
		sl_panel.putConstraint(SpringLayout.SOUTH, txt_name, -201, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txt_name, -194, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_name, 5, SpringLayout.NORTH, txt_name);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lbl_phone = new JLabel("\uD578\uB4DC\uD3F0");
		sl_panel.putConstraint(SpringLayout.WEST, lbl_phone, 0, SpringLayout.WEST, lbl_id);
		lbl_phone.setForeground(new Color(178, 34, 34));
		panel.add(lbl_phone);
		lbl_phone.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		JComboBox Combo_phone = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, Combo_phone, 171, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Combo_phone, 18, SpringLayout.EAST, lbl_phone);
		sl_panel.putConstraint(SpringLayout.SOUTH, Combo_phone, -161, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Combo_phone, -265, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_phone, 5, SpringLayout.NORTH, Combo_phone);
		Combo_phone.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		Combo_phone.setForeground(new Color(255, 255, 255));
		Combo_phone.setBackground(new Color(178, 34, 34));
		panel.add(Combo_phone);
		Combo_phone.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017", "018", "019"}));
		
		txt_phone = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txt_phone, -2, SpringLayout.NORTH, lbl_phone);
		sl_panel.putConstraint(SpringLayout.WEST, txt_phone, 19, SpringLayout.EAST, Combo_phone);
		sl_panel.putConstraint(SpringLayout.EAST, txt_phone, -130, SpringLayout.EAST, panel);
		panel.add(txt_phone);
		txt_phone.setColumns(10);
		
		JLabel lbl_Birthday = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_Birthday, 219, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_Birthday, 0, SpringLayout.EAST, lbl_id);
		lbl_Birthday.setForeground(new Color(178, 34, 34));
		panel.add(lbl_Birthday);
		lbl_Birthday.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		
		JComboBox Combo_Year = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, Combo_Year, -5, SpringLayout.NORTH, lbl_Birthday);
		sl_panel.putConstraint(SpringLayout.WEST, Combo_Year, 20, SpringLayout.EAST, lbl_Birthday);
		Combo_Year.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		Combo_Year.setBackground(new Color(178, 34, 34));
		Combo_Year.setForeground(new Color(255, 255, 255));
		panel.add(Combo_Year);
		Combo_Year.setToolTipText("\uC5F0\uB3C4");
		Combo_Year.setModel(new DefaultComboBoxModel(new String[] {"\uB144\uB3C4", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
		
		JComboBox combo_Month = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, combo_Month, 187, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, combo_Month, -206, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Combo_Year, 0, SpringLayout.SOUTH, combo_Month);
		sl_panel.putConstraint(SpringLayout.EAST, Combo_Year, -14, SpringLayout.WEST, combo_Month);
		sl_panel.putConstraint(SpringLayout.NORTH, combo_Month, 214, SpringLayout.NORTH, panel);
		combo_Month.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		combo_Month.setBackground(new Color(178, 34, 34));
		combo_Month.setForeground(new Color(255, 255, 255));
		panel.add(combo_Month);
		combo_Month.setToolTipText("\uB2EC");
		combo_Month.setModel(new DefaultComboBoxModel(new String[] {"\uB2EC", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JComboBox combo_day = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, combo_day, -6, SpringLayout.NORTH, lbl_Birthday);
		sl_panel.putConstraint(SpringLayout.WEST, combo_day, 19, SpringLayout.EAST, combo_Month);
		sl_panel.putConstraint(SpringLayout.SOUTH, combo_day, 46, SpringLayout.SOUTH, txt_phone);
		sl_panel.putConstraint(SpringLayout.EAST, combo_day, 0, SpringLayout.EAST, txt_phone);
		combo_day.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		combo_day.setBackground(new Color(178, 34, 34));
		combo_day.setForeground(new Color(255, 255, 255));
		panel.add(combo_day);
		combo_day.setToolTipText("\uB0A0\uC9DC");
		combo_day.setModel(new DefaultComboBoxModel(new String[] {"\uC77C\uC790", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JLabel lbl_sex = new JLabel("\uC131\uBCC4");
		sl_panel.putConstraint(SpringLayout.WEST, lbl_name, 0, SpringLayout.WEST, lbl_sex);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_sex, 0, SpringLayout.EAST, lbl_id);
		lbl_sex.setForeground(new Color(178, 34, 34));
		panel.add(lbl_sex);
		lbl_sex.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		JRadioButton rb_Man = new JRadioButton("\uB0A8\uC131");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_sex, 1, SpringLayout.NORTH, rb_Man);
		sl_panel.putConstraint(SpringLayout.NORTH, rb_Man, 256, SpringLayout.NORTH, panel);
		rb_Man.setFont(new Font("배달의민족 한나체 Pro", Font.PLAIN, 12));
		rb_Man.setBackground(new Color(178, 34, 34));
		rb_Man.setForeground(new Color(255, 255, 255));
		panel.add(rb_Man);
		
		JRadioButton rb_Female = new JRadioButton("\uC5EC\uC131");
		sl_panel.putConstraint(SpringLayout.NORTH, rb_Female, 256, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, combo_Month, -14, SpringLayout.NORTH, rb_Female);
		rb_Female.setFont(new Font("배달의민족 한나체 Pro", Font.PLAIN, 12));
		sl_panel.putConstraint(SpringLayout.WEST, rb_Female, 184, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, rb_Man, -17, SpringLayout.WEST, rb_Female);
		rb_Female.setBackground(new Color(178, 34, 34));
		rb_Female.setForeground(new Color(255, 255, 255));
		panel.add(rb_Female);

		//Start Sex Radio ButtonGroup	by 태영
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(rb_Man);
		sexGroup.add(rb_Female);
		//End Sex Radio ButtonGroup		by 태영
		
		JLabel lbl_email = new JLabel("\uC774\uBA54\uC77C");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_email, 22, SpringLayout.SOUTH, lbl_sex);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_email, 0, SpringLayout.WEST, lbl_id);
		lbl_email.setForeground(new Color(178, 34, 34));
		panel.add(lbl_email);
		lbl_email.setFont(new Font("배달의민족 한나체 Pro", Font.BOLD, 15));
		
		txt_eMail = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txt_eMail, -2, SpringLayout.NORTH, lbl_email);
		sl_panel.putConstraint(SpringLayout.WEST, txt_eMail, 19, SpringLayout.EAST, lbl_email);
		sl_panel.putConstraint(SpringLayout.EAST, txt_eMail, -220, SpringLayout.EAST, panel);
		panel.add(txt_eMail);
		txt_eMail.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, txt_eMail);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -88, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txt_eMail, 0, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, 9, SpringLayout.SOUTH, lbl_email);
		comboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, -2, SpringLayout.NORTH, lbl_email);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"@naver.com", "@daum.net", "@gmail.com"}));
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uC5EC\uBD80 \uD655\uC778");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -5, SpringLayout.NORTH, lbl_id);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 32, SpringLayout.EAST, txt_id);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -257, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -26, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(139, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		
		//start id double check
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberDAO mdao = new DAO.MemberDAO();
				if (mdao.idDoubleCheck(txt_id.getText()) == true){
					//txt_id.setText("");
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "리셋!", JOptionPane.DEFAULT_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				}
				mdao.getFinally();		//연결끊기
			}
		});
		panel.add(btnNewButton);
		
		pw = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, pw, 55, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pw, 20, SpringLayout.EAST, lbl_pw);
		sl_panel.putConstraint(SpringLayout.SOUTH, pw, 25, SpringLayout.NORTH, lbl_pw);
		sl_panel.putConstraint(SpringLayout.EAST, pw, -194, SpringLayout.EAST, panel);
		panel.add(pw);
		
		pwre = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, pwre, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, pwre, -238, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pwre, 0, SpringLayout.WEST, txt_id);
		sl_panel.putConstraint(SpringLayout.EAST, pwre, -194, SpringLayout.EAST, panel);
		panel.add(pwre);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, -12, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, txt_name);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(250, 235, 215));
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pc-19\\Desktop\\main.jpg"));
		panel_1.add(lblNewLabel_1);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				//it's made 태영, that is join
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						//Start Radio Button data insert				by 태영
						if(rb_Man.isSelected()) {
							sexInsert = 1;		// 1 is Man
						} else if (rb_Man.isSelected()) {
							sexInsert = 2;		// 2 is Female
						}
						//end Radio Button data insert
						
						
						//start char[] -> String
						//getPassword는 return 타입이 char배열. string으로 전환해주기 위한 함수
						String secuPass="";
						char[] charPass = pw.getPassword();
						for(char cha : charPass){ 
							Character.toString(cha); 
							secuPass += (secuPass.equals("")) ? ""+cha+"" : ""+cha+"";
						}
						//end char[] -> String

						mdao = new MemberDAO();
						// TODO Auto-generated method stub
						int cnt = mdao.insertFuction(	txt_id.getText(), 													//id
														secuPass, 															//password
														txt_name.getText(), 												//name
														Combo_phone.getSelectedItem().toString() + txt_phone.getText(), 	//PhoneNumber
														Combo_Year.getSelectedItem().toString() +							//Birthday
														combo_Month.getSelectedItem().toString() +
														combo_day.getSelectedItem().toString(),
														sexInsert,															//Sex
														txt_eMail.getText());												//Email

						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "가입 성공", "리셋!", JOptionPane.DEFAULT_OPTION);
						} else {
							JOptionPane.showMessageDialog(null, "가입 실패", "리셋!", JOptionPane.DEFAULT_OPTION);
						}
						//Start JoinDail and login setVisible
						setVisible(false);
						Login gui = new Login();
						gui.main(null);
						//End JoinDail and login setVisible
					}
				}); //end  join 
			}
			
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				//it's made 태영, that is JoinDail and login setVisible
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						Login gui = new Login();
						gui.main(null);
					}
				}); //end  JoinDail and login setVisible
			}
		}
	}
}
