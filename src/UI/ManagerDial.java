package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class ManagerDial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	  String sPath = new File("").getAbsolutePath();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManagerDial dialog = new ManagerDial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManagerDial() {
		setBounds(100, 100, 508, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JButton btn_1 = new JButton("\uC694\uCCAD\uC0AC\uD56D \uBCF4\uAE30");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btn_1, 232, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btn_1, 159, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btn_1, -24, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btn_1, -158, SpringLayout.EAST, contentPanel);
		btn_1.setForeground(new Color(255, 255, 255));
		btn_1.setBackground(new Color(255, 204, 51));
		btn_1.setFont(new Font("HSº½¹Ù¶÷Ã¼ 2.0", Font.PLAIN, 20));
	
		contentPanel.add(btn_1);
		
		JButton btn_2 = new JButton("\uC5C5\uC18C \uCD94\uAC00\uD558\uAE30");
		sl_contentPanel.putConstraint(SpringLayout.WEST, btn_2, 0, SpringLayout.WEST, btn_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btn_2, -24, SpringLayout.NORTH, btn_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btn_2, 0, SpringLayout.EAST, btn_1);
		btn_2.setForeground(new Color(255, 255, 255));
		btn_2.setBackground(new Color(255, 102, 0));
		btn_2.setFont(new Font("HSº½¹Ù¶÷Ã¼ 2.0", Font.PLAIN, 20));
		contentPanel.add(btn_2);
		
		JButton btn_3 = new JButton("\uC8FC\uBB38\uB0B4\uC5ED \uD655\uC778");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btn_3, 29, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btn_3, -227, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btn_2, 22, SpringLayout.SOUTH, btn_3);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btn_3, 0, SpringLayout.WEST, btn_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btn_3, -158, SpringLayout.EAST, contentPanel);
		btn_3.setForeground(new Color(255, 255, 255));
		btn_3.setFont(new Font("HSº½¹Ù¶÷Ã¼ 2.0", Font.PLAIN, 20));
		btn_3.setBackground(new Color(255, 51, 0));
		btn_1.setBorderPainted(false);
		btn_2.setBorderPainted(false);
		btn_3.setBorderPainted(false);
		contentPanel.add(btn_3);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 29, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.EAST, btn_3);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, btn_3);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 120, SpringLayout.EAST, btn_3);
		lblNewLabel.setIcon(new ImageIcon(sPath+"\\img\\food-1.jpg"));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 66, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -9, SpringLayout.WEST, btn_2);
		lblNewLabel_1.setIcon(new ImageIcon(sPath+"\\img\\food-4.jpg"));
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 44, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 13, SpringLayout.EAST, btn_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -67, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, -22, SpringLayout.EAST, contentPanel);
		lblNewLabel_2.setIcon(new ImageIcon(sPath+"\\img\\food-2.jpg"));
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 200, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -9, SpringLayout.WEST, btn_1);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -33, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(sPath+"\\img\\food-5.jpg"));
		contentPanel.add(lblNewLabel_3);

		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
