package UI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import DAO.MemberDAO;

public class Login { //로그인 

	   private JFrame frame;
	   private JTextField txt_pw;
	   private JTextField txt_id;
	   MemberDAO mdao = new MemberDAO();
	   Search serachDL;
	   String sPath = new File("").getAbsolutePath();
	   JoinDial  joinDL = new JoinDial();
	   Pick pick;
       
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Login window = new Login();
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
   public Login() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(250, 235, 215));
      frame.setBounds(100, 100, 551, 413);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      frame.setResizable(false);
      
      JLabel label = new JLabel("\uC2DD\uC0AC\uD569\uC2DC\uB2E4");
      springLayout.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, label, 139, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, label, -292, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, label, -116, SpringLayout.EAST, frame.getContentPane());
      label.setBackground(new Color(255, 255, 255));
      label.setForeground(new Color(178, 34, 34));
      label.setFont(new Font("HS봄바람체 2.0", Font.BOLD, 55));
      frame.getContentPane().add(label);
      
      JPanel panel = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, label);
      springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
      panel.setForeground(new Color(194,187,153));
      panel.setBackground(new Color(250, 235, 215));
      frame.getContentPane().add(panel);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      
      txt_id = new JTextField();
      sl_panel.putConstraint(SpringLayout.EAST, txt_id, -371, SpringLayout.EAST, panel);
      panel.add(txt_id);
      txt_id.setColumns(10);
      
      txt_pw = new JTextField();
      sl_panel.putConstraint(SpringLayout.WEST, txt_id, 0, SpringLayout.WEST, txt_pw);
      sl_panel.putConstraint(SpringLayout.NORTH, txt_pw, 84, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, txt_pw, 79, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, txt_pw, -371, SpringLayout.EAST, panel);
      panel.add(txt_pw);
      txt_pw.setColumns(10);
      
      JButton btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_join, 16, SpringLayout.SOUTH, txt_pw);
      sl_panel.putConstraint(SpringLayout.WEST, btn_join, 23, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, btn_join, -406, SpringLayout.EAST, panel);
      btn_join.setForeground(new Color(255, 255, 255));
      btn_join.setBackground(new Color(205, 92, 92));
      btn_join.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         
   
          	 joinDL = new JoinDial();
             joinDL.setVisible(true);
            
            
            
         
         }
      });
      btn_join.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
      panel.add(btn_join);
      
      JButton btn_search = new JButton("ID/PW\uCC3E\uAE30");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_search, 0, SpringLayout.NORTH, btn_join);
      sl_panel.putConstraint(SpringLayout.WEST, btn_search, 10, SpringLayout.EAST, btn_join);
      btn_search.setForeground(new Color(255, 255, 255));
      btn_search.setBackground(new Color(205, 92, 92));
      btn_search.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 serachDL = new Search();
        	 serachDL.setVisible(true);
            
         
            
         }
      });
      btn_search.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 16));
      panel.add(btn_search);
      
      JButton btn_login = new JButton("\uB85C\uADF8\uC778");
      sl_panel.putConstraint(SpringLayout.NORTH, btn_login, 0, SpringLayout.NORTH, txt_id);
      sl_panel.putConstraint(SpringLayout.WEST, btn_login, 18, SpringLayout.EAST, txt_pw);
      sl_panel.putConstraint(SpringLayout.SOUTH, btn_login, 0, SpringLayout.SOUTH, txt_pw);
      sl_panel.putConstraint(SpringLayout.EAST, btn_login, 0, SpringLayout.EAST, btn_search);
      btn_login.setIcon(null);
      btn_login.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) { 
         
             boolean cnt = mdao.doubleCheck(txt_id.getText(),txt_pw.getText());
             
             
             if(cnt==true) {
                System.out.println("success");
                
                JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
                frame.dispose();
                new Pick(); // 로그인 성공시 메뉴화면 뜨기
                pick.main(null);
                

             } else {
                JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
             }         
          }
       });
      btn_login.setForeground(new Color(255, 255, 255));
      btn_login.setBackground(new Color(178, 34, 34));
      btn_login.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 20));
      panel.add(btn_login);
      
      JLabel lblNewLabel_1 = new JLabel("ID :");
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -11, SpringLayout.WEST, txt_id);
      sl_panel.putConstraint(SpringLayout.NORTH, txt_id, 0, SpringLayout.NORTH, lblNewLabel_1);
      sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -214, SpringLayout.SOUTH, panel);
      lblNewLabel_1.setForeground(new Color(205, 92, 92));
      lblNewLabel_1.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 18));
      panel.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("PW :");
      sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -171, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, btn_join);
      lblNewLabel_2.setForeground(new Color(205, 92, 92));
      lblNewLabel_2.setFont(new Font("HS봄바람체 2.0", Font.PLAIN, 18));
      panel.add(lblNewLabel_2);
      
      JPanel panel_1 = new JPanel();
      
      sl_panel.putConstraint(SpringLayout.EAST, btn_search, -19, SpringLayout.WEST, panel_1);
      sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, panel_1, 306, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
      panel.add(panel_1);
      SpringLayout sl_panel_1 = new SpringLayout();
      panel_1.setLayout(sl_panel_1);
      
      JLabel lblNewLabel = new JLabel("");
      sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel_1);
      sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, -7, SpringLayout.WEST, panel_1);
      sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel_1);
      lblNewLabel.setIcon(new ImageIcon(sPath+"\\img\\main.jpg"));
      panel_1.add(lblNewLabel);
   }
}