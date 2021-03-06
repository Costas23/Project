
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class CreateGroupScreen extends JFrame {

	private JPanel contentPane;
	
	private JFrame frame;

	private JTextField name;
	private JTextField info;

	private JButton GECK;
	private ButtonGroup buttongroup;
	private JRadioButton opengroup;
	private JRadioButton privategroup;
	public Group m_Group;
	public DataBase m_DataBase;

	public CreateGroupScreen() {
		
		super("Create Group Screen");
		
		contentPane = new JPanel();
		name = new JTextField("Group name",15);
		info = new JTextField("Write some info...",20);
		contentPane.add(name);
		contentPane.add(info);

		GECK = new JButton("Create Group");
		contentPane.add(GECK);
		GECK.addActionListener(new GECKActionListener());

		opengroup = new JRadioButton("Open Group", true);
		opengroup.setBackground(Color.cyan);
		privategroup = new JRadioButton("Private Group", false);
		privategroup.setBackground(Color.cyan);

		buttongroup = new ButtonGroup();
		buttongroup.add(opengroup);
		buttongroup.add(privategroup);

		contentPane.add(opengroup);
		contentPane.add(privategroup);
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		
		contentPane.setBackground(Color.cyan);
		this.setContentPane(contentPane);
		this.getContentPane().setSize(900, 900);
		pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	class GECKActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!DataBase.isGroup(name.getText())) {	//TODO change syso to popup window
				
				String groupname = name.getText();
				String groupinfo = info.getText();
				
				if(buttongroup.getSelection() == opengroup ) {
					if(!(DataBase.createGroup(groupname, groupinfo, true))) 
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
				}
				else {
					if(!(DataBase.createGroup(name.getText(), info.getText(), false)))
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
				}
			}
			else
				JOptionPane.showMessageDialog(frame, "Error-Group already exists!");
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> master
