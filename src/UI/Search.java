package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import oracle.jdbc.driver.Message;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import DAO.MemberDAO;
import javax.swing.ImageIcon;

public class Search extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_birthday;
	private JTextField txt_id;
	private JTextField txt_name;
	MemberDAO mdao = new MemberDAO();
	   String sPath = new File("").getAbsolutePath();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Search dialog = new Search();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search() {
		setBounds(100, 100, 500, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		setResizable(false);
		

		JPanel panel_1 = new JPanel();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel_1, -5, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, panel_1, -15, SpringLayout.EAST, contentPanel);
		panel_1.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JPanel panel = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, panel_1);
		panel.setBackground(new Color(255, 255, 255));
		panel_1.add(panel);

		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, panel_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 127, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 34, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -29, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel_1);
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lb_name = new JLabel("\uC774\uB984 :");
		lb_name.setForeground(new Color(178, 34, 34));
		lb_name.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
		panel.add(lb_name);

		JButton btn_idsearch = new JButton("ID\uCC3E\uAE30");
		sl_panel.putConstraint(SpringLayout.NORTH, btn_idsearch, 18, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lb_name, 11, SpringLayout.NORTH, btn_idsearch);
		sl_panel.putConstraint(SpringLayout.WEST, btn_idsearch, 288, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btn_idsearch, -10, SpringLayout.EAST, panel);
		btn_idsearch.setForeground(new Color(255, 255, 255));
		btn_idsearch.setBackground(new Color(139, 0, 0));
		btn_idsearch.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
		panel.add(btn_idsearch);

		txt_name = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, txt_name, 154, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lb_name, -6, SpringLayout.WEST, txt_name);
		sl_panel.putConstraint(SpringLayout.NORTH, txt_name, 8, SpringLayout.NORTH, btn_idsearch);
		txt_name.setForeground(new Color(0, 0, 0));
		txt_name.setColumns(10);
		panel.add(txt_name);
		panel_1.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lbl_pw = new JLabel("      ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lbl_pw, -25, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lbl_pw, 71, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lbl_pw, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lbl_pw, -38, SpringLayout.EAST, panel_2);
		panel_2.add(lbl_pw);

		JLabel lb_id = new JLabel("ID :");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lb_id, 15, SpringLayout.NORTH, panel_2);
		lb_id.setBackground(new Color(17,90,96));
		lb_id.setForeground(new Color(178, 34, 34));
		lb_id.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
		panel_2.add(lb_id);

		JLabel lb_birth = new JLabel("\uC0DD\uB144\uC6D4\uC77C :");
		sl_panel_2.putConstraint(SpringLayout.EAST, lb_id, 0, SpringLayout.EAST, lb_birth);
		lb_birth.setForeground(new Color(178, 34, 34));
		lb_birth.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
		panel_2.add(lb_birth);

		txt_birthday = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, lb_birth, 3, SpringLayout.NORTH, txt_birthday);
		sl_panel_2.putConstraint(SpringLayout.EAST, lb_birth, -6, SpringLayout.WEST, txt_birthday);
		sl_panel_2.putConstraint(SpringLayout.WEST, txt_birthday, 120, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, txt_birthday, -6, SpringLayout.NORTH, lbl_pw);
		txt_birthday.setForeground(new Color(0, 0, 0));
		txt_birthday.setColumns(10);
		panel_2.add(txt_birthday);

		// START PW Search by 태영
		JButton btn_pwsearch = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		sl_panel_2.putConstraint(SpringLayout.WEST, btn_pwsearch, 252, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btn_pwsearch, -10, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btn_pwsearch, -6, SpringLayout.NORTH, lbl_pw);
		btn_pwsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = mdao.searchPW(txt_id.getText(), txt_birthday.getText());
				if (text != null) {
					lbl_pw.setText("찾고자 하는 PASSWORD는 \"" + text + "\"입니다.");
				} else {
					lbl_pw.setText("찾을 수 없는 사용자입니다.");
				}
			}
		});
		btn_pwsearch.setForeground(new Color(255, 255, 255));
		btn_pwsearch.setBackground(new Color(139, 0, 0));
		btn_pwsearch.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
		panel_2.add(btn_pwsearch);

		txt_id = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, btn_pwsearch, 0, SpringLayout.NORTH, txt_id);
		sl_panel_2.putConstraint(SpringLayout.NORTH, txt_id, -3, SpringLayout.NORTH, lb_id);
		sl_panel_2.putConstraint(SpringLayout.EAST, txt_id, 0, SpringLayout.EAST, txt_birthday);
		txt_id.setForeground(new Color(0, 0, 0));
		txt_id.setColumns(10);
		panel_2.add(txt_id);
				
				JLabel lblNewLabel = new JLabel("");
				sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, lb_name);
				panel.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(sPath+"\\img\\searchimg.jpg"));
				sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.NORTH, panel);
				
				JLabel lbl_id = new JLabel("");
				sl_panel.putConstraint(SpringLayout.SOUTH, btn_idsearch, -8, SpringLayout.NORTH, lbl_id);
				sl_panel.putConstraint(SpringLayout.NORTH, lbl_id, 63, SpringLayout.NORTH, panel);
				sl_panel.putConstraint(SpringLayout.WEST, lbl_id, 138, SpringLayout.WEST, panel);
				sl_panel.putConstraint(SpringLayout.SOUTH, lbl_id, -10, SpringLayout.SOUTH, panel);
				sl_panel.putConstraint(SpringLayout.EAST, lbl_id, -10, SpringLayout.EAST, panel);
				panel.add(lbl_id);

		// START ID Search by 승경
		btn_idsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = mdao.searchID(txt_name.getText());
				if (text != null) {
					lbl_id.setText( txt_name.getText()+"님의 ID는"+ text + " 입니다.");
				} else {
					lbl_id.setText("찾을 수 없는 사용자입니다.");
				}
			}
		});// End ID Search

	}

}