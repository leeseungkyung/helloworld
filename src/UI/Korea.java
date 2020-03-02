package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

import DAO.MemberDAO;
import DAO.RestaurantDAO;
import DTO.MemberDTO;
import DTO.RestaurantDTO;
import FOOD.A001;
import FOOD.A002;
import FOOD.A003;

public class Korea {

	private JFrame frame;
	String sPath = new File("").getAbsolutePath();
	Login login;
	public static String id;
	public static MemberDTO member;
	
	ArrayList<String> RNameL;							//�Ĵ� �̸� ����Ʈ
	RestaurantDAO rdao = new RestaurantDAO();			// DAO
	RestaurantDTO rdto;									// DTO
	
	/**
	 * Create the application.
	 */
	public Korea(String id) {
		this.id = id;
		System.out.println("id:"+ id);
		initialize();
	}

	
	public Korea() {
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Korea window = new Korea(id);
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
		panel_1.setLayout(null);							//Panel_1 �ʱ�ȭ
		panel_1.setSize(700, 500);							//Panel_1�� ���� ����
		panel_1.setBackground(Color.LIGHT_GRAY);
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
		btn_logout.setFont(new Font("a��Ÿ��", Font.PLAIN, 16));
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �α׾ƿ� ��ư ������ �� �ٽ� �α��� ������ ����ֱ�
				frame.dispose();
				new Login(); // �α��� ������ �޴�ȭ�� �߱�
				login.main(null);
//				Login login = new Login(); // phoneDial ����ֱ����ؼ� �ҷ����°�
//				login.setVisible(true);// ����ִ�
//				frame.setVisible(false); // ���°� ��ü���� GUI ��ü�� Frame���� ������ �ֱ� ������ frame�� Ű�� ���� �ؾ���.

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
		btn_manager.setFont(new Font("a��Ÿ��", Font.PLAIN, 16));
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
		btn_info.setFont(new Font("a��Ÿ��", Font.PLAIN, 16));
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
		lbl_Name.setFont(new Font("����", Font.BOLD, 15));
		lbl_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Name.setBackground(Color.WHITE);
		System.out.println("main_id:"+ this.id);
		lbl_Name.setText(this.id+"��");
		panel.add(lbl_Name);

		JLabel lbl_Welcome = new JLabel("\uD658\uC601\uD569\uB2C8\uB2E4!!!");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_Welcome, 49, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_Name, -6, SpringLayout.NORTH, lbl_Welcome);
		lbl_Welcome.setBackground(Color.GREEN);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_Welcome, 0, SpringLayout.WEST, btn_logout);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_Welcome, 0, SpringLayout.EAST, btn_logout);
		panel.add(lbl_Welcome);
		Korea.setResizable(false); // ũ�⺯��Ұ�
		
		
		
		
		
		//�ѽ� �з�ü�踸 Label�� �ѷ��ֱ�								by �¿�
		// A : �ѽ�, B : �н�ƮǪ��	C : ġŲ,	 D : ����
		String setCat = "A";
		RNameL = new ArrayList<String>();
		RNameL = rdao.getSelectRestaurantName(setCat);
		

		JLabel restaurant[] = new JLabel[RNameL.size()];			// �ѽĺз��� �����ŭ
		JPanel panelCol[] = new JPanel[RNameL.size()];			// �ѽĺз��� �����ŭ
		int increate= 10;											// label ���� �ʱ� ��ġ
		for (int i = 0; i < RNameL.size(); i++) {
			restaurant[i] = new JLabel(RNameL.get(i));
			panelCol[i] = new JPanel();
			panelCol[i].setSize(200, 400);							//panelCol[i]�� ���� ����
			

			sl_panel_1.putConstraint(SpringLayout.NORTH,  panelCol[i], increate, SpringLayout.NORTH, panel_1);
			sl_panel_1.putConstraint(SpringLayout.WEST,  panelCol[i], 10, SpringLayout.WEST, panel_1);
			sl_panel_1.putConstraint(SpringLayout.EAST,  panelCol[i], 720, SpringLayout.WEST, panel_1);
			if((i+1) % 2 == 0) {	
				panelCol[i].setBackground(Color.white);
			} else {
				panelCol[i].setBackground(SystemColor.control);
			}
			
			

			restaurant[i].setFont(new Font("�������", Font.PLAIN, 20));
			sl_panel_1.putConstraint(SpringLayout.NORTH, restaurant[i], increate, SpringLayout.WEST, panel_1);
			sl_panel_1.putConstraint(SpringLayout.WEST, restaurant[i], 10, SpringLayout.WEST, panel_1);

			String rid = rdao.getRID(RNameL.get(i));
			//Ŭ���� �� ����
			restaurant[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
						if(rid.equals("A001")) {
							frame.dispose();
							A001 gui = new A001();
							gui.main(null);
						} else if (rid.equals("A002")) {
							frame.dispose();
							A002 gui = new A002();	
							gui.main(null);
						} else if (rid.equals("A003")) {
							frame.dispose();
							A003 gui = new A003();
							gui.main(null);
						} 
				}
			});
			//Ŭ���� �� ����
			panel_1.add(panelCol[i]);
			panelCol[i].add(restaurant[i]);
			//panel_1.add(restaurant[i]);
			increate += 30;
		}
		//�ѽ� �з�ü�踸 Label�� �ѷ��ֱ� ��.
	}

	private static void setResizable(boolean b) {
		// TODO Auto-generated method stub

	}
}
