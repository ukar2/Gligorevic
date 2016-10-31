package gui;

import java.awt.event.*;

import javax.swing.*;


public class SettingBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	MenuSetting menu_einstellungen = null;
	MenuSetting komprim_method_menu = null;
	MenuSetting zusatzinfo_menu = null;
	
	RadionButtonforMenu huffmann = null;
	RadionButtonforMenu hoffmann = null;
	RadionButtonforMenu buffmann = null;
	
	RadionButtonforMenu ein = null;
	RadionButtonforMenu aus = null;
	
	ButtonGroup group1 = null;
	ButtonGroup group2 = null;
	
	public SettingBar(){
		super();
		initializeComponents();
		prepareComponents();
		create_menu();
		this.add(menu_einstellungen);
	}
	
	
	void initializeComponents(){
		menu_einstellungen = new MenuSetting("Einstellungen");
		
		komprim_method_menu = new MenuSetting("Komprimierungsmethode");
		zusatzinfo_menu = new MenuSetting("Zustzinformation");
		
		huffmann = new RadionButtonforMenu("Huffmann", true);
		hoffmann = new RadionButtonforMenu("Hoffmann", false);
		buffmann = new RadionButtonforMenu("Buffmann", false);
		
		ein = new RadionButtonforMenu("Ein", false);
		aus = new RadionButtonforMenu("Aus", true);
		
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		
	}
	
	void prepareComponents(){
		this.huffmann.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Huffmann gewaehlt");
			}
		});
		
		
		this.hoffmann.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Hoffffmannn");
			}
		});
		
		
		this.buffmann.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Bufmann");
			}
		});
		
		
		this.ein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Ein");
			}
		});
		
		
		this.aus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Aus");
			}
		});
	}
	
	void create_menu(){
		group1.add(huffmann);
		group1.add(hoffmann);
		group1.add(buffmann);
		group2.add(ein);
		group2.add(aus);
		
		this.zusatzinfo_menu.add(ein);
		this.zusatzinfo_menu.add(aus);
		this.komprim_method_menu.add(huffmann);
		this.komprim_method_menu.add(hoffmann);
		this.komprim_method_menu.add(buffmann);
		this.menu_einstellungen.add(komprim_method_menu);
		this.menu_einstellungen.add(zusatzinfo_menu);
		
	}

}
