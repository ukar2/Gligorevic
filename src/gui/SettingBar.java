package gui;

import controls.*;

import java.awt.event.*;

import javax.swing.*;


public class SettingBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	Orb control = null;
	
	MenuSetting menu_einstellungen = null;
	MenuSetting komprim_method_menu = null;
	MenuSetting zusatzinfo_menu = null;
	
	RadionButtonforMenu huffman = null;
	RadionButtonforMenu hoffmann = null;
	RadionButtonforMenu buffmann = null;
	
	RadionButtonforMenu ein = null;
	RadionButtonforMenu aus = null;
	
	ButtonGroup group1 = null;
	ButtonGroup group2 = null;
	
	public SettingBar(Orb control){
		super();
		this.control = control;
		createComponents();
		initializeComponents();
		prepareMenu();
		this.add(menu_einstellungen);
	}
	
	
	void createComponents(){
		menu_einstellungen = new MenuSetting("Einstellungen");
		
		komprim_method_menu = new MenuSetting("Komprimierungsmethode");
		zusatzinfo_menu = new MenuSetting("Zustzinformation");
		
		huffman = new RadionButtonforMenu("Huffman", true);
		hoffmann = new RadionButtonforMenu("Hoffmann", false);
		buffmann = new RadionButtonforMenu("Buffmann", false);
		
		ein = new RadionButtonforMenu("Ein", false);
		aus = new RadionButtonforMenu("Aus", true);
		
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		
	}
	
	void initializeComponents(){
		this.hoffmann.setName("Hoffmann");
		this.huffman.setName("Huffman");
		this.buffmann.setName("Buffmann");
		
		
		this.huffman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				control.setMenuItemActionEvent(e);
			}
		});
		
		
		this.hoffmann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				control.setMenuItemActionEvent(e);
			}
		});
		
		
		this.buffmann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				control.setMenuItemActionEvent(e);
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
	
	void prepareMenu(){
		group1.add(huffman);
		group1.add(hoffmann);
		group1.add(buffmann);
		group2.add(ein);
		group2.add(aus);
		
		this.zusatzinfo_menu.add(ein);
		this.zusatzinfo_menu.add(aus);
		this.komprim_method_menu.add(huffman);
		this.komprim_method_menu.add(hoffmann);
		this.komprim_method_menu.add(buffmann);
		this.menu_einstellungen.add(komprim_method_menu);
		this.menu_einstellungen.add(zusatzinfo_menu);
		
	}

}
