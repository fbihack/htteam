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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JSplitPane;

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
			jContentPane.add(getJFollowerList(), BorderLayout.NORTH);
			jContentPane.add(getJTweetList(), BorderLayout.SOUTH);
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
			fileMenu.add(getJFollowMenuItem());
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
	private JList getJTweetList() {
		if (jTweetList == null) {

			jTweetList = new JList();
			jTweetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		}
		return jTweetList;
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
			jFollowerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jFollowerList.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					//mousePressed (arg0); // cheesy hack. 					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (arg0.getButton() == MouseEvent.BUTTON3) {
						int idx = jFollowerList.locationToIndex(arg0.getPoint());
						jFollowerList.setSelectedIndex(idx);
						
						JPopupMenu contextMenu = new JPopupMenu();
												
							//contextMenu.add("Unfollow User");
						JMenuItem mi = new JMenuItem("Unfollow User");
						mi.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								String name = (String)jFollowerList.getModel().getElementAt(jFollowerList.getSelectedIndex());
								if (CallInvoker.unfollowUser(loggeduser, name)){
								   JOptionPane.showMessageDialog(getJFrame(), "User " + name +" unfollowed");	
								} else {
									JOptionPane.showMessageDialog(getJFrame(), "There was an error...");		
								}
								RefreshFollowing();
								RefreshTweets();
							}
						});
						contextMenu.add(mi);
							contextMenu.show (arg0.getComponent(), arg0.getX (), arg0.getY ());
							
						//contextMenu.setVisible(true);
					}			
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return jFollowerList;
	}
	
	

	/**
	 * This method initializes jFollowMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJFollowMenuItem() {
		if (jFollowMenuItem == null) {
			jFollowMenuItem = new JMenuItem();
			jFollowMenuItem.setText("Follow User");
			jFollowMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String name = JOptionPane.showInputDialog("User to follow:");
					if (CallInvoker.followUser(loggeduser, name)){
					   JOptionPane.showMessageDialog(getJFrame(), "Following User " + name);	
					} else {
						JOptionPane.showMessageDialog(getJFrame(), "There was an error adding the user");		
					}
					RefreshFollowing();	
					RefreshTweets();}
			});
		}
		return jFollowMenuItem;
	}

	private JMenuItem getJTweetMenuItem() {
		if (jTweetMenuItem == null) {
			jTweetMenuItem = new JMenuItem();
			jTweetMenuItem.setText("Follow User");
			jTweetMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String name = JOptionPane.showInputDialog("Message to tweet:");
					if (CallInvoker.tweet(name)){
					   JOptionPane.showMessageDialog(getJFrame(), "Tweeted!");	
					} else {
						JOptionPane.showMessageDialog(getJFrame(), "There was an error while tweeting");		
					}
					RefreshFollowing();	
					RefreshTweets();}
			});
		}
		return jTweetMenuItem;
	}

	
	public class MyTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			RefreshFollowing();
			RefreshTweets();
		}
		
	}
	
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {

				MainGUI application = new MainGUI();
				application.getJFrame().setVisible(true);
				application.Loginout();
				Timer timer = new Timer();
				TimerTask task = application.new MyTask();

				// aspetta 100 secondi prima dell'esecuzione
				//timer.schedule( task, 100000 );

				// aspetta 5 secondi prima dell'esecuzione,poi
				// viene eseguita ogni 100 secondi
				timer.schedule( task, 100000, 100000 ); 
	}


	private User loggeduser =null;  //  @jve:decl-index=0:
	
	private void Loginout() {
		if(loginMenuItem.getText().equals("Login")){
			loggeduser = OAuthProducer.getOAuthAccessToken();
			if(loggeduser==null){
				//Start pin procedure
				try {
					loggeduser=OAuthProducer.getFirstTimeAccessCode(getJFrame());
				} catch (Exception e) {
					
				}
				if(loggeduser!=null){
					 loginMenuItem.setText("Logout");
				}
			}
			else
							 loginMenuItem.setText("Logout");
		}
		else{
			OAuthProducer.removeAccess();
			loggeduser=null;
			loginMenuItem.setText("Login");
		}
		
		RefreshFollowing();
		RefreshTweets();

	}

	private void RefreshFollowing() {
		((DefaultListModel)jFollowerList.getModel()).removeAllElements();

		if(loggeduser!=null){

		ArrayList<Follower> follower = CallInvoker.getFollowing(loggeduser);
		for(int i=0;i<follower.size();i++){
			((DefaultListModel)jFollowerList.getModel()).add(i, follower.get(i).getScreenName());
		}
		jFollowerList.setVisible(true);

		}
		else{
			jFollowerList.setVisible(false);
		}
	}

	private void RefreshTweets() {
		jTweetList.removeAll();
	jTweetList.setListData(new String[]{"a","b","c"});
		if(loggeduser!=null){

//		Vector<String> tweet = CallInvoker.getTweets(loggeduser);
//		if(tweet!=null)
//		jTweetList.setListData(tweet);

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

	public JList jTweetList = null;
	public JList jFollowerList = null;

	private JMenuItem jFollowMenuItem = null;
	private JMenuItem jTweetMenuItem = null;
}
