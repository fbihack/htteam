package it.unibz.view;


import it.unibz.model.Follower;
import it.unibz.model.User;
import it.unibz.utils.CallInvoker;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.JList;

/**
 * This class is the initialization of our program. It is in great part
 * generated by Eclipse's Visual Editor, therefore it is quite messy. It is
 * responsible for creating all the GUI objects and attaching them behaviors.
 */
public class MainGUI {

	private JFrame jFrame = null; // @jve:decl-index=0:visual-constraint="10,10"

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu fileMenu = null;
	public static final String NUMERIC = "0123456789";

	private JMenu helpMenu = null;

	private JMenuItem exitMenuItem = null;

	private JMenuItem aboutMenuItem = null;

	public JMenuItem loginMenuItem = null;

	private JDialog aboutDialog = null;

	private JPanel aboutContentPane = null;

	private JLabel aboutVersionLabel = null;

	private JTextField jEpsilonTextField = null;

	/**
	 * This method initializes the jFrame, the general graphical container of
	 * our window.
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(344, 500);
			jFrame.setResizable(false);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Twitter Client");
			UpdateControls(false);

		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane, the second container of our GUI
	 * (the zone below the menu bar)
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJFollowerList(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar, the container of our Menu.
	 * It contains the File and the Help voices.
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu for "File"
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getLoginMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu for "Help"
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem for exiting the program
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem for the About window
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("Authors");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog
	 * 
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("Authors");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Daniel Hanspeter, Thomas Schievenin");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getLoginMenuItem() {
		if (loginMenuItem == null) {
			loginMenuItem = new JMenuItem();
			loginMenuItem.setText("Login");
			loginMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
					Event.CTRL_MASK, true));
			loginMenuItem.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
Loginout();				}
			
			});
		}
		return loginMenuItem;
	}



	/**
	 * This method initializes jFollowerList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJFollowerList() {
		if (jFollowerList == null) {
			DefaultListModel model = new DefaultListModel();

			jFollowerList = new JList(model);
		}
		return jFollowerList;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {

				MainGUI application = new MainGUI();
				application.getJFrame().setVisible(true);
				application.Loginout();

	}


	private User loggeduser =null;
	
	private void Loginout() {
		if(loginMenuItem.getText().equals("Login")){
			loggeduser = OAuthProducer.getOAuthAccessToken();
			if(loggeduser==null){
				//Start pin procedure
				try {
					//loggeduser=OAuthProducer.getFirstTimeAcessCode();
				} catch (Exception e) {
					
				}
				if(loggeduser!=null){
					 loginMenuItem.setText("Logout");
						jFollowerList.setVisible(true);

				}
			}
			else
			{				 loginMenuItem.setText("Logout");
			RefreshFollowing();
			}	
		}
		else{
			OAuthProducer.removeAccess();
			loginMenuItem.setText("Login");
RefreshFollowing();			
		}
		
		
	}

	private void RefreshFollowing() {
		if(loggeduser!=null){
		jFollowerList.setVisible(true);
		ArrayList<Follower> follower = CallInvoker.getFollowing(loggeduser);
		for(int i=0;i<follower.size();i++){
		((DefaultListModel)jFollowerList.getModel()).add(i, follower.get(i).getScreenName());
		}
		}
		else{
			jFollowerList.setVisible(false);
		}
	}

	/**
	 * Method used to update the visual controls
	 */
	private void UpdateControls(boolean iskmeans) {

		
		
	}

	private JComponent newContentPane = null;

	public JList jFollowerList = null;
}
