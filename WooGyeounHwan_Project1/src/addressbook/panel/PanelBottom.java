package addressbook.panel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import addressbook.AddressBookLogic;

public class PanelBottom extends JPanel{
	
	private JButton btnSave;
	private JButton btnExit;
	private JButton btnAdd;
	private Image img;
	
	AddressBookLogic logic = AddressBookLogic.getInstance();
	
	ActionListener handler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSave) {
				try {
					logic.saveAddressBook();
					logic.printAddr();
				} catch (Exception e1) {
					System.out.println("저장 완료 실패");
				}
			}else if(e.getSource()==btnExit) {
				logic.exitAddrBook();
			}
		}
	};
	
	public PanelBottom() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		img = 
			Toolkit
				.getDefaultToolkit()
					.createImage("src/addressbook/image/P0i72.gif");
		btnSave = new JButton("Save");
		btnExit = new JButton("Exit");
		btnAdd = new JButton("Add");
		this.add(btnSave);
		this.add(btnExit);
		btnSave.addActionListener(handler);
		btnExit.addActionListener(handler);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) { 
			g.drawImage(img, 0, 0, this); 
		}

	}
	
}
