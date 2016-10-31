package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainWorkingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JButton btn_enter = null;
	JButton btn_komprim = null;
	JButton btn_delete = null;
	
	JLabel lbl_info_up = null;
	JLabel lbl_zusatzinfo_down = null;
	JTextArea txt_area_input = null;
	JTextArea txt_area_output = null;

	JPanel panel_for_input;
	JPanel panel_for_button_eingabe;
	JPanel panel_for_button_komprim;
	JPanel panel_for_button_delete;
	JPanel panel_for_output;

	// Panels for BorderLayout
	JPanel panel_for_label_oben;
	JPanel panel_for_label_unten;
	JScrollPane scroll_panel_for_input;
	JScrollPane scroll_panel_for_output;
	JPanel panel_midle;

	JPanel haupt_panel;
	
	SettingBar main_menu_bar = null;

	public MainWorkingFrame() {
		createFrame();
		initializeComponents();
		prepareComponents();
		prepareFrame();
		this.setJMenuBar(main_menu_bar);
		this.add(haupt_panel);
	}
	
	void createFrame(){
		
		this.setName("Informationstheorie");
		this.setTitle("Informationstheorie");
		this.setSize(680, 420);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void initializeComponents() {
		this.main_menu_bar = new SettingBar();
		
		// Bedienelemente
		lbl_info_up = new JLabel();
		lbl_zusatzinfo_down = new JLabel();
		txt_area_input = new JTextArea(20, 20);
		txt_area_output = new JTextArea(20, 20);
		btn_enter = new JButton();
		btn_komprim = new JButton();
		btn_delete = new JButton();

		panel_for_input = new JPanel();
		panel_for_button_eingabe = new JPanel();
		panel_for_button_komprim = new JPanel();
		panel_for_button_delete = new JPanel();
		panel_for_output = new JPanel();

		// Panels for BorderLayout
		panel_for_label_unten = new JPanel();
		panel_for_label_oben = new JPanel();
		scroll_panel_for_input = new JScrollPane(txt_area_input, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_panel_for_output = new JScrollPane(txt_area_output, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_midle = new JPanel();

		haupt_panel = new JPanel(); // BorderLayout Panel

	}
	
	void prepareComponents(){
		this.btn_delete.setName("Delete");
		this.btn_enter.setName("Enter");
		this.btn_komprim.setName("Komprim");
		
		this.btn_delete.setText("Löschen");
		this.btn_enter.setText("Eingabe");
		this.btn_komprim.setText("Komprimieren");
		
		this.btn_delete.setFont(new Font("Arial", 0, 12));
		this.btn_enter.setFont(new Font("Arial", 0, 12));
		this.btn_komprim.setFont(new Font("Arial", 0, 12));
		
		this.btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Button delete");
			}
		});
		
		
		this.btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Button Eingabe");
			}
		});
		
		
		this.btn_komprim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Button Komprimieren");
			}
		});
	}

	void prepareFrame() {
		panel_for_input.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_for_button_eingabe.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_for_button_komprim.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_for_button_delete.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_for_output.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Panels for BorderLayout
		panel_for_label_unten.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_for_label_oben.setLayout(new FlowLayout(FlowLayout.CENTER));
		scroll_panel_for_input.setLayout(new ScrollPaneLayout());
		scroll_panel_for_output.setLayout(new ScrollPaneLayout());
		panel_midle.setLayout(new BoxLayout(panel_midle, BoxLayout.Y_AXIS));

		haupt_panel.setLayout(new BorderLayout());

		
		
		panel_for_button_eingabe.add(btn_enter);
		panel_for_button_komprim.add(btn_komprim);
		panel_for_button_delete.add(btn_delete);
		

		panel_for_label_oben.add(lbl_info_up);
		panel_for_input.add(scroll_panel_for_input);
		panel_midle.add(panel_for_button_eingabe);
		panel_midle.add(panel_for_button_komprim);
		panel_midle.add(panel_for_button_delete);
		panel_for_output.add(scroll_panel_for_output);
		panel_for_label_unten.add(lbl_zusatzinfo_down);

		haupt_panel.add(panel_for_label_oben, BorderLayout.PAGE_START);
		haupt_panel.add(panel_for_label_unten, BorderLayout.PAGE_END);
		haupt_panel.add(panel_for_input, BorderLayout.LINE_START);
		haupt_panel.add(panel_midle, BorderLayout.CENTER);
		haupt_panel.add(panel_for_output, BorderLayout.LINE_END);

	}

}
