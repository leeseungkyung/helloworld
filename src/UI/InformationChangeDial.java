package UI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class InformationChangeDial extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField txt_id;
   private JTextField txt_pw;
   private JTextField txt_name;
   private JTextField txt_hp;
   private JTextField txt_birth;
   private JTextField txt_mail;
   private JTextField txt_sex;
   private JButton btn_ok;
	  String sPath = new File("").getAbsolutePath();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         InformationChangeDial dialog = new InformationChangeDial();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public InformationChangeDial() {
      setBounds(100, 100, 504, 486);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(Color.WHITE);
      contentPanel.setForeground(Color.WHITE);
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      SpringLayout sl_contentPanel = new SpringLayout();
      contentPanel.setLayout(sl_contentPanel);
      
      JLabel lb_id = new JLabel("\uC544\uC774\uB514:");
      lb_id.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_id);
      
      JLabel lb_pw = new JLabel("\uBE44\uBC00\uBC88\uD638:");
      lb_pw.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_pw);
      
      JLabel lb_name = new JLabel("\uC774\uB984:");
      lb_name.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_name);
      
      JLabel lb_hp = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638:");
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_name, 0, SpringLayout.EAST, lb_hp);
      lb_hp.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_hp);
      
      JLabel lb_birth = new JLabel("\uC0DD\uC77C:");
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_hp, 0, SpringLayout.EAST, lb_birth);
      lb_birth.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_birth);
      
      JLabel lb_sex = new JLabel("\uC131\uBCC4:");
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, lb_sex, -131, SpringLayout.SOUTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_birth, 0, SpringLayout.EAST, lb_sex);
      lb_sex.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_sex);
      
      JLabel lb_mail = new JLabel("\uC774\uBA54\uC77C:");
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_mail, 327, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_sex, 0, SpringLayout.EAST, lb_mail);
      lb_mail.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 20));
      contentPanel.add(lb_mail);
      
      txt_id = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_id, 4, SpringLayout.NORTH, txt_id);
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_id, -23, SpringLayout.WEST, txt_id);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_id, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_id, 37, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_id, -360, SpringLayout.SOUTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_id, -32, SpringLayout.EAST, contentPanel);
      contentPanel.add(txt_id);
      txt_id.setColumns(10);
      
      txt_pw = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_pw, 4, SpringLayout.NORTH, txt_pw);
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_pw, -6, SpringLayout.WEST, txt_pw);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_pw, 10, SpringLayout.SOUTH, txt_id);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_pw, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_pw, -32, SpringLayout.EAST, contentPanel);
      contentPanel.add(txt_pw);
      txt_pw.setColumns(10);
      
      txt_name = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_name, 4, SpringLayout.NORTH, txt_name);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_pw, -19, SpringLayout.NORTH, txt_name);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_name, 0, SpringLayout.WEST, txt_id);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_name, -32, SpringLayout.EAST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_name, 128, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_name, -269, SpringLayout.SOUTH, contentPanel);
      contentPanel.add(txt_name);
      txt_name.setColumns(10);
      
      txt_hp = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_hp, 4, SpringLayout.NORTH, txt_hp);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_hp, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_hp, 16, SpringLayout.SOUTH, txt_name);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_hp, -32, SpringLayout.EAST, contentPanel);
      contentPanel.add(txt_hp);
      txt_hp.setColumns(10);
      
      txt_birth = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, lb_birth, 4, SpringLayout.NORTH, txt_birth);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_birth, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_hp, -19, SpringLayout.NORTH, txt_birth);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_birth, -32, SpringLayout.EAST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_birth, 225, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_birth, -172, SpringLayout.SOUTH, contentPanel);
      contentPanel.add(txt_birth);
      txt_birth.setColumns(10);
      
      JLabel lblNewLabel_1 = new JLabel("");
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -131, SpringLayout.SOUTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 236, SpringLayout.WEST, contentPanel);
      contentPanel.add(lblNewLabel_1);
      
      txt_mail = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.EAST, lb_mail, -23, SpringLayout.WEST, txt_mail);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_mail, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_mail, -32, SpringLayout.EAST, contentPanel);
      contentPanel.add(txt_mail);
      txt_mail.setColumns(10);
      
      txt_sex = new JTextField();
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_mail, 14, SpringLayout.SOUTH, txt_sex);
      sl_contentPanel.putConstraint(SpringLayout.WEST, txt_sex, 314, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, txt_sex, -32, SpringLayout.EAST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, txt_sex, 278, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_sex, -119, SpringLayout.SOUTH, contentPanel);
      contentPanel.add(txt_sex);
      txt_sex.setColumns(10);
      {
         btn_ok = new JButton("\uC218\uC815\uC644\uB8CC");
         sl_contentPanel.putConstraint(SpringLayout.WEST, btn_ok, 148, SpringLayout.WEST, contentPanel);
         btn_ok.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
     
         		
         	}
         });
         sl_contentPanel.putConstraint(SpringLayout.NORTH, btn_ok, 369, SpringLayout.NORTH, contentPanel);
         sl_contentPanel.putConstraint(SpringLayout.SOUTH, btn_ok, -15, SpringLayout.SOUTH, contentPanel);
         btn_ok.setBackground(new Color(153, 0, 51));
         btn_ok.setForeground(new Color(255, 255, 255));
         contentPanel.add(btn_ok);
         
         
         btn_ok.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 18));
         btn_ok.setActionCommand("¼öÁ¤¿Ï·á");
         getRootPane().setDefaultButton(btn_ok);
      }
      {
         JButton btn_cancel = new JButton("\uC218\uC815\uCDE8\uC18C");
         sl_contentPanel.putConstraint(SpringLayout.SOUTH, txt_mail, -15, SpringLayout.NORTH, btn_cancel);
         sl_contentPanel.putConstraint(SpringLayout.EAST, btn_ok, -39, SpringLayout.WEST, btn_cancel);
         sl_contentPanel.putConstraint(SpringLayout.WEST, btn_cancel, 314, SpringLayout.WEST, contentPanel);
         btn_cancel.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		
         	}
         });
         sl_contentPanel.putConstraint(SpringLayout.NORTH, btn_cancel, 369, SpringLayout.NORTH, contentPanel);
         sl_contentPanel.putConstraint(SpringLayout.SOUTH, btn_cancel, -15, SpringLayout.SOUTH, contentPanel);
         sl_contentPanel.putConstraint(SpringLayout.EAST, btn_cancel, -32, SpringLayout.EAST, contentPanel);
         btn_cancel.setBackground(new Color(153, 0, 51));
         btn_cancel.setForeground(new Color(255, 255, 255));
         contentPanel.add(btn_cancel);
         btn_cancel.setFont(new Font("HSº½¹Ù¶÷Ã¼", Font.PLAIN, 18));
         btn_cancel.setActionCommand("¼öÁ¤Ãë¼Ò");
         btn_cancel.setBorderPainted(false);
      }
      btn_ok.setBorderPainted(false);
      
      JPanel panel = new JPanel();
      sl_contentPanel.putConstraint(SpringLayout.WEST, lb_pw, 6, SpringLayout.EAST, panel);
      sl_contentPanel.putConstraint(SpringLayout.NORTH, panel, 46, SpringLayout.NORTH, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel, -30, SpringLayout.NORTH, btn_ok);
      panel.setBackground(Color.WHITE);
      sl_contentPanel.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, contentPanel);
      sl_contentPanel.putConstraint(SpringLayout.EAST, panel, 15, SpringLayout.WEST, lb_hp);
      contentPanel.add(panel);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon(sPath+"\\img\\info.jpg"));
      panel.add(lblNewLabel);
     
      
      
      {
         JPanel buttonPane = new JPanel();
         buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
         getContentPane().add(buttonPane, BorderLayout.SOUTH);
         
      }
   }
}