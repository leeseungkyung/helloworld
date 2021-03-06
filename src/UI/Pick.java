package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;


import java.awt.Color;
import java.awt.Font;

public class Pick {

   private JFrame frame;
   String sPath = new File("").getAbsolutePath();
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Pick window = new Pick();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Pick() {
      initialize();
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
      panel_1.setBackground(new Color(255, 255, 255));
      springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
      springLayout.putConstraint(SpringLayout.NORTH, panel_1, 159, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      
      JButton btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
      sl_panel.putConstraint(SpringLayout.WEST, btn_logout, 602, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_logout, 0, SpringLayout.SOUTH, panel);
      btn_logout.setForeground(new Color(255, 255, 255));
      btn_logout.setBackground(new Color(153, 0, 0));
      btn_logout.setFont(new Font("a비타민", Font.PLAIN, 16));
      btn_logout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            
            
            //로그아웃 버튼 눌렀을 때 다시 로그인 페이지 띄워주기
            
//            Login login = new Login();  //phoneDial 띄워주기위해서 불러오는것
//            login.setVisible(true);// 띄워주는
//            frame.setVisible(false); //끄는건 전체적인 GUI 자체가 Frame으로 감싸져 있기 때문에 frame을 키고 끄고 해야함. 
            
         }
      });
      panel.add(btn_logout);
      
      JButton btn_manager = new JButton("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_manager, 73, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_manager, -43, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, btn_logout, 6, SpringLayout.SOUTH, btn_manager);
      sl_panel.putConstraint(SpringLayout.EAST, btn_logout, 0, SpringLayout.EAST, btn_manager);
      sl_panel.putConstraint(SpringLayout.WEST, btn_manager, 602, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, btn_manager, -10, SpringLayout.EAST, panel);
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
      sl_panel.putConstraint(SpringLayout.NORTH, btn_info, 26, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_info, -10, SpringLayout.NORTH, btn_manager);
      sl_panel.putConstraint(SpringLayout.EAST, btn_info, 0, SpringLayout.EAST, btn_logout);
      btn_info.setForeground(new Color(255, 255, 255));
      btn_info.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		
      		InformationChangeDial icd = new InformationChangeDial();
      		frame.dispose();
      		icd.setVisible(true);
      		
      		
      	}
      });
      btn_info.setBackground(new Color(153, 0, 0));
      btn_info.setFont(new Font("a비타민", Font.PLAIN, 16));
      panel.add(btn_info);
      panel_1.setToolTipText("");
      frame.getContentPane().add(panel_1);
      SpringLayout sl_panel_1 = new SpringLayout();
      panel_1.setLayout(sl_panel_1);
      
      JButton btn_korea = new JButton("");
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_korea, 10, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_korea, 10, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_korea, -500, SpringLayout.EAST, panel_1);
      
      btn_korea.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
     
         }
      });
      btn_korea.setIcon(new ImageIcon(sPath+"\\img\\한식.jpg"));
      panel_1.add(btn_korea);
      
      JButton btn_china = new JButton("\uC911\uC2DD");
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_china, 0, SpringLayout.NORTH, btn_korea);
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_china, 16, SpringLayout.EAST, btn_korea);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_china, 0, SpringLayout.SOUTH, btn_korea);
      btn_china.setIcon(new ImageIcon(sPath+"\\img\\중식.jpg"));
      panel_1.add(btn_china);
      
      JButton btn_amarican = new JButton("\uC591\uC2DD");
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_china, -18, SpringLayout.WEST, btn_amarican);
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_amarican, 10, SpringLayout.NORTH, panel_1);
      btn_amarican.setIcon(new ImageIcon(sPath+"\\img\\양식.jpg"));
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_amarican, 488, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_amarican, -10, SpringLayout.EAST, panel_1);
      panel_1.add(btn_amarican);
      
      JButton btn_school = new JButton("");
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_school, 10, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_korea, -6, SpringLayout.NORTH, btn_school);
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_school, 179, SpringLayout.NORTH, panel_1);
      btn_school.setIcon(new ImageIcon(sPath+"\\img\\분식.jpg"));
      btn_school.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            btn_school.setFocusPainted(false);////////
         }
      });
      panel_1.add(btn_school);
      
      JButton btn_pizza = new JButton("\uD53C\uC790");
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_school, -26, SpringLayout.WEST, btn_pizza);
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_pizza, 179, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_pizza, 258, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_pizza, 0, SpringLayout.SOUTH, btn_school);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_pizza, -10, SpringLayout.EAST, btn_china);
      btn_pizza.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn_pizza.setIcon(new ImageIcon(sPath+"\\img\\피자.jpg"));
      panel_1.add(btn_pizza);
      
      JButton btn_fastfood = new JButton("");
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_fastfood, 179, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_amarican, -6, SpringLayout.NORTH, btn_fastfood);
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_fastfood, 504, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_fastfood, -10, SpringLayout.EAST, panel_1);
      btn_fastfood.setIcon(new ImageIcon(sPath+"\\img\\패스트푸드.jpg"));
      panel_1.add(btn_fastfood);
      
      JButton btn_japan = new JButton("");
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_japan, 10, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_japan, -500, SpringLayout.EAST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_school, -15, SpringLayout.NORTH, btn_japan);
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_japan, 340, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_japan, 0, SpringLayout.SOUTH, panel_1);
      btn_japan.setIcon(new ImageIcon(sPath+"\\img\\일식.jpg"));
      panel_1.add(btn_japan);
      
      JButton btn_chichen = new JButton("\uCE58\uD0A8");
      sl_panel_1.putConstraint(SpringLayout.NORTH, btn_chichen, 6, SpringLayout.SOUTH, btn_pizza);
      sl_panel_1.putConstraint(SpringLayout.WEST, btn_chichen, 26, SpringLayout.EAST, btn_japan);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_chichen, -9, SpringLayout.SOUTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btn_chichen, -252, SpringLayout.EAST, panel_1);
      btn_chichen.setIcon(new ImageIcon(sPath+"\\img\\치킨.jpg"));
      panel_1.add(btn_chichen);
      
      JButton btnNewButton_8 = new JButton("\uCC1C,\uD0D5");
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_fastfood, -23, SpringLayout.NORTH, btnNewButton_8);
      sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_8, 331, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_8, 8, SpringLayout.EAST, btn_chichen);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, btnNewButton_8, 0, SpringLayout.SOUTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_8, -10, SpringLayout.EAST, panel_1);
      btnNewButton_8.setIcon(new ImageIcon(sPath+"\\img\\찜탕.jpg"));
      btn_korea.setBorderPainted(false);
      btn_china.setBorderPainted(false);
      btn_school.setBorderPainted(false);
      btn_japan.setBorderPainted(false);
      btn_amarican.setBorderPainted(false);
      btn_pizza.setBorderPainted(false);
      btn_chichen.setBorderPainted(false);
      btn_fastfood.setBorderPainted(false);
      btnNewButton_8.setBorderPainted(false);
      btn_info.setBorderPainted(false);
      btn_logout.setBorderPainted(false);
      btn_manager.setBorderPainted(false);
      
      JLabel lblNewLabel = new JLabel("");
      sl_panel.putConstraint(SpringLayout.WEST, btn_info, 6, SpringLayout.EAST, lblNewLabel);
      sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, btn_logout);
      lblNewLabel.setIcon(new ImageIcon(sPath+"\\img\\label.jpg"));
      panel.add(lblNewLabel);
      btnNewButton_8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      panel_1.add(btnNewButton_8);
      Pick.setResizable(false);  //크기변경불가
   }

private static void setResizable(boolean b) {
	// TODO Auto-generated method stub
	
}
}