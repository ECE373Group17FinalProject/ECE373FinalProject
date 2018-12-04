package Search;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import Person.User;
import Person.ConvictUser;
import Person.Organization;
import Person.ProbationOfficer;
import Person.Volunteer;
import Thing.Court;
import Thing.Event;
import Thing.Offense;
import Thing.Records;




import javax.swing.*;


/* Demo by Lahiru Ariyananda and Peter Hall
   Note :  this is very simple program  used as a  demo on  Serilizing and GUIs. 
   It does not test for faults or errors (  which needs to be implemented) 
 */


public class SearchGUI extends JFrame 
{ 
	//private Employee  emp1;
	private User user;
	private SearchEngine search;
	ArrayList<Event> results = new ArrayList<Event>();
	private JMenuBar menuBar;		//the horizontal container
	private JMenu adminMenu;
	private JMenu adminMenu1; 
	private JMenu adminMenu2; //JMenu objects are added to JMenuBar objects as the "tabs"
	//private ArrayList<Employee> empList;

	// File submenus
    
	// Admin 
	
	//JMenuItem objects are added to JMenu objects as the drop down selections. 
	private JMenuItem adminAddEvent;

	
	public SearchGUI(SearchEngine s, User u, int workType, boolean csh) {
		super("Search Results");
		
		setSize(750, 750);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Search Results" +
				"<BR>To join event, click File, Add Event, and enter the Event's index</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI( s,  u,  workType,  csh);	
		setVisible(true);   // mandatory
		
		
		
	}
	
	
	public void buildGUI(SearchEngine s, User u, int workType, boolean csh) 
	{
		menuBar = new JMenuBar();
     	
		// Employee Student Menu
		
	//	adminMenu = new JMenu("Administrators");
		adminMenu2 = new JMenu("File");
		
		adminAddEvent = new JMenuItem("Add Event");

		adminAddEvent.addActionListener(new MenuListener());

		adminMenu2.add(adminAddEvent);

	    menuBar.add(adminMenu2);
	//    menuBar.add(adminMenu1);
	
		setJMenuBar(menuBar);
		
		JFrame frame = new JFrame("My JFrame Example");
		/*	String longMessage = "Come and listen to a story about a man named Jed\n"
		    + "A poor mountaineer, barely kept his family fed,\n"
		    + "Then one day he was shootin at some food,\n"
		    + "And up through the ground came a bubblin crude.\n"
		    + "Oil that is, black gold, Texas tea.\n"
		    + "Well the first thing you know ol Jed\'s a millionaire ...\n";  */
			
			String longMessage = "";
			search = s;
			user = u;
			results = search.searchEvents(u, 4);
			longMessage = longMessage + search.printResults(user, results);
		
	      // create a JTextArea
	      JTextArea textArea = new JTextArea(15, 40);
	      textArea.setText(longMessage);
	      textArea.setEditable(false);
	      
	      // wrap a scrollpane around it
	      JScrollPane scrollPane = new JScrollPane(textArea);
	      
	      add(scrollPane);
	      
	      // display them in a message dialog
	     // JOptionPane.showMessageDialog(frame, scrollPane);
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			
		/*	if(source.equals(adminSave)) {
				handleAdminSave(search);
			}
			
			else if(source.equals(adminLoad)) {
				handleAdminLoad();
			} */
			
//			else 
			if (source.equals(adminAddEvent)) {
				handleAddEvent();
			}
	
			
		}
		
	/*	private void handleAdminSave(University u) {
			University.saveData(u);
		}
		
		private void handleAdminLoad() {
			university =  University.loadData();
		} */
		private void handleAddEvent(){
			
			int count = -1;
			JTextField eventNo = new JTextField(7);
		    JPanel myPanel = new JPanel();
		    
		    myPanel.setLayout(new GridLayout(8, 8));
		    
		    myPanel.add(new JLabel("Event #:"));
		    myPanel.add(eventNo);
		    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		
		    
		    int result = JOptionPane.showConfirmDialog(null, myPanel,
		        "Add Event to your schedule", JOptionPane.OK_CANCEL_OPTION);
		  if (result == JOptionPane.OK_OPTION) {
		      
		    String s = "";
		    int index = Integer.parseInt(eventNo.getText()); //user choice
		    // create a JTextArea
		    JTextArea textArea = new JTextArea(15, 40);
		    textArea.setText(s);
		    textArea.setEditable(false);			      
		    JFrame frame = new JFrame(); 
		      
			// Go to Event GUI for particular event from results
		
			
		  
		  	//correct input
			if (index <= results.size() && index >= 1) {
				
				if(user.getScheduledEvents().contains(results.get(index-1)))  {  //user already has event
					JOptionPane.showMessageDialog(frame, "You already have this event.", "User error", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				else {
					user.addEvent(results.get(index-1));
					JOptionPane.showMessageDialog(frame, "Event " + Integer.toString(index) + " added to your schedule. ", "Success", JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "Event number out of bounds. Try again. ", "User error", JOptionPane.PLAIN_MESSAGE);
				return;
			}
		      
		  }
		}
	

		
	}
	
}
