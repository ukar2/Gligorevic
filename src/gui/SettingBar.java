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
	RadionButtonforMenu shannon = null;
	RadionButtonforMenu fano = null;
	
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
		shannon = new RadionButtonforMenu("Shannon", false);
		fano = new RadionButtonforMenu("Fano", false);
		
		ein = new RadionButtonforMenu("Ein", false);
		aus = new RadionButtonforMenu("Aus", true);
		
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		
	}
	
	void initializeComponents(){
		this.shannon.setName("Shannon");
		this.huffman.setName("Huffman");
		this.fano.setName("Fano");
		
		
		this.huffman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				control.setMenuItemActionEvent(e);
			}
		});
		
		
		this.shannon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				control.setMenuItemActionEvent(e);
			}
		});
		
		
		this.fano.addActionListener(new ActionListener() {
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
		group1.add(shannon);
		group1.add(fano);
		group2.add(ein);
		group2.add(aus);
		
		this.zusatzinfo_menu.add(ein);
		this.zusatzinfo_menu.add(aus);
		this.komprim_method_menu.add(huffman);
		this.komprim_method_menu.add(shannon);
		this.komprim_method_menu.add(fano);
		this.menu_einstellungen.add(komprim_method_menu);
		this.menu_einstellungen.add(zusatzinfo_menu);
		
	}

}
