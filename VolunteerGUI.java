package Person;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Thing.Court;
import Thing.Event;
import Thing.Offense;
import Thing.Records;
import Search.SearchGUI;
import Search.LoginGUI;
import Search.SearchEngine;



public class VolunteerGUI extends JFrame {
	private Volunteer vol;
	private SearchEngine search;
	private JMenuBar menuBar;		//the horizontal container
	private JMenuItem searchEvents;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenu manageAccountMenu;
	private JMenu searchMenu;
	private JMenuItem changeLoc;
	private JMenu eventsMenu;
	private JMenu availabilityMenu;
	private JMenuItem logOut;
	private JMenuItem viewAvailability;
	private JMenuItem addAvailability;
	private JMenuItem removeAvailability;
	private JMenuItem  viewEvent;
	private JMenuItem removeEvent;

	public VolunteerGUI(SearchEngine s, String windowTitle, Volunteer volunteer) {
		super(windowTitle);
		vol = volunteer;
		search = s;

		setSize(1000, 1000);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Welcome "+vol.getName()+
				"<BR>What would you like to do?"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	public void buildGUI() 
	{	//creats Volunteer homePage menu bar
		menuBar = new JMenuBar();
		//two items that will be in the menu bar
		manageAccountMenu = new JMenu("Manage Account Settings");
		searchMenu = new JMenu("Search");
		//creating search event which will be under Search option in the menu bar
		searchEvents = new JMenuItem("Search For Event");
		
		//creating two options under Manage Account settings option in the mennu bar
		changeLoc = new JMenuItem("Change Your Location");
		logOut = new JMenuItem ("Log Out" );
		
		viewAvailability = new JMenuItem("View Availability");
		addAvailability = new JMenuItem("Add Availability");
		removeAvailability= new JMenuItem("Remove Availability");
		viewEvent= new JMenuItem("View Event");
		removeEvent= new JMenuItem("Remove Event");
		
		eventsMenu = new JMenu("Edit Your Events");
		availabilityMenu = new JMenu("Edit Your availability");
		
		viewAvailability.addActionListener(new MenuListener());
		addAvailability.addActionListener(new MenuListener());
		removeAvailability.addActionListener(new MenuListener());
		viewEvent.addActionListener(new MenuListener());
		removeEvent.addActionListener(new MenuListener());
		
		
		
		changeLoc.addActionListener(new MenuListener());
		logOut.addActionListener(new MenuListener());
		searchEvents.addActionListener(new MenuListener());

		availabilityMenu.add(viewAvailability);
		availabilityMenu.add(addAvailability);
		availabilityMenu.add(removeAvailability);
		eventsMenu.add(viewEvent);
		eventsMenu.add(removeEvent);
	    
		manageAccountMenu.add(changeLoc);

		searchMenu.add(searchEvents);
		
		menuBar.add(manageAccountMenu);
		menuBar.add(eventsMenu);
		menuBar.add(availabilityMenu);
		menuBar.add(searchMenu);
		menuBar.add(logOut);
	    
	
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener
	{
		

		public void actionPerformed(ActionEvent e)
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(searchEvents))
			{
				handleSearchEvents();	
			}
			else if(source.equals(changeLoc))
			{
				handleChangeLoc();
			}
			else if(source.equals(editAvailability))
			{
				handleEditAvailability();
			}
			
			else if(source.equals(viewAvailability))
			{
				handleViewAvailability();	
			}
			else if(source.equals(addAvailability))
			{
				handleAddAvailability();
			}
			else if(source.equals(removeAvailability))
			{
				handleRemoveAvailability();
			}
			else if(source.equals(viewEvent))
			{
				handleViewEvent();
			}
			else if(source.equals(removeEvent))
			{
				handleRemoveEvent();
			}
			else if(source.equals(logOut))
			{
				setVisible(false);
				LoginGUI newGui = new LoginGUI("WELCOM",search);
			}
	
		}

		private void handleLogOut() {
			// TODO Auto-generated method stub
			setVisible(false);

		}
		
		
		private void handleAddAvailability() {
			
		}

		private void handleViewAvailability() {
			
		}
		
		private void handleRemoveAvailability() {
			
		}
		
		private void handleViewEvent() {
			
		}
		
		private void handleremoveEvent() {
			
		}
		
		private void handleChangeLoc() {
			Integer courseNumber = 0;
			JTextField locX = new JTextField(10); 
			JTextField travel = new JTextField(10);
			JTextField locY = new JTextField(10);  
			JPanel changLocationPanel = new JPanel();
			
			changLocationPanel.setLayout(new GridLayout(4,4)); 
			

			changLocationPanel.add(new JLabel("Location X:"));  
			changLocationPanel.add(locX);
			
			
			changLocationPanel.add(new JLabel("Location Y:"));
			changLocationPanel.add(locY);
			

			changLocationPanel.add(new JLabel("Travel Radius:"));
			changLocationPanel.add(travel);
			
			
			int result = JOptionPane.showConfirmDialog(null, changLocationPanel,"Change Location", JOptionPane.OK_CANCEL_OPTION);
			
			if(result == JOptionPane.OK_OPTION) {

				double x = Double.parseDouble(locX.getText());
				double y = Double.parseDouble(locY.getText());
				double t = Double.parseDouble(travel.getText());
				
				
				if( x >= -10 && x <= 10) {
					if( y >= -10 && y <= 10) {
						if( t >= 0 && t <= 30) {
							vol.setLocX(x);
							vol.setLocY(y);
							vol.setTravelRadius(t);
							
						}
						else {
							JOptionPane.showMessageDialog(null, 
									"invalid travel radius", 
									"Invalid Location", 
									JOptionPane.PLAIN_MESSAGE);
							handleChangeLoc();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, 
								"Invalid y", 
								"Invalid Location", 
								JOptionPane.PLAIN_MESSAGE);
						handleChangeLoc();
					}	
					
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Invalid x", 
							"Invalid Location", 
							JOptionPane.PLAIN_MESSAGE);
					handleChangeLoc();
				}
	
			}
			
		}

		private void handleSearchEvents() {
			//Integer day = 0;
			JTextField locX = new JTextField(10); 
			JTextField travel = new JTextField(10);
			JTextField locY = new JTextField(10);  
			JPanel searchEventsPanel = new JPanel();
			JPanel searchEventsPanel0 = new JPanel();
			JPanel searchEventsPanel1 = new JPanel();
			JPanel searchEventsPanel2 = new JPanel();
			JPanel searchEventsPanel3 = new JPanel();
			
//			String[]  stimes = { "start time","midnight", "1:00am","2:00am","3:00am","4:00am", 
//							    "5:00am","6:00am ","7:00am","8:00am ","9:00am",
//							    "10:00am", "11:00am","noon", "1:00pm", "2:00pm",
//							    "3:00pm","4:00pm","5:00pm","6:00pm","7:00pm", 
//							    "8:00pm", "9:00pm", "10:00pm","11:00pm","11:59pm"};	
//			String[]  etimes = { "end time","midnight", "1:00am","2:00am","3:00am","4:00am", 
//				    "5:00am","6:00am ","7:00am","8:00am ","9:00am",
//				    "10:00am", "11:00am","noon", "1:00pm", "2:00pm",
//				    "3:00pm","4:00pm","5:00pm","6:00pm","7:00pm", 
//				    "8:00pm", "9:00pm", "10:00pm","11:00pm","11:59pm"};	
			String[]  typeOfWork = {"Type Of Work", "Cleaning","Labor","Environment","Youth","Kitchen","Animals","All"};
			
			JComboBox workType = new JComboBox(typeOfWork);
			workType.setSize(100, 100);
			workType.setSelectedIndex(0);
			workType.addActionListener(this);
			
//			JComboBox shiftsStart = new JComboBox(stimes);
//			shiftsStart.setSelectedIndex(0);
//			shiftsStart.addActionListener(this);
//			
//			JComboBox shiftsEnd = new JComboBox(etimes);
//			shiftsEnd.setSelectedIndex(0);
//			shiftsEnd.addActionListener(this);

		   // The following variable will reference a
		   // ButtonGroup object to group the radio buttons.
		   ButtonGroup csh;
		   //ButtonGroup week= new ButtonGroup();;
		      // Create the radio buttons.
		   JRadioButton yes = new JRadioButton("yes", true);
		    JRadioButton no = new JRadioButton("no",false);

		      // Group the radio buttons.
		    csh = new ButtonGroup();
		    csh.add(yes);
		    csh.add(no);

	      // Add a border around the panel.
//	      searchEventsPanel.setBorder(BorderFactory.createTitledBorder(""));


//			JRadioButton 
//		    MonBox = new JRadioButton("Mon", true),
//		    TueBox = new JRadioButton("Tues", true),
//		    WedBox = new JRadioButton("Wed", true),
//		    ThuBox = new JRadioButton("Thurs", true),
//		    FriBox = new JRadioButton("Fri", true),
//		    SatBox = new JRadioButton("Sat", true),
//		    SunBox = new JRadioButton("Sun", true);
			
//		    week.add(MonBox);
//		    week.add(TueBox);
//		    week.add(WedBox);
//		    week.add(ThuBox);
//		    week.add(FriBox);
//		    week.add(SatBox);
//		    week.add(SunBox);
		    
			
//		      // Add an item listener to the check boxes.
//			MonBox.addItemListener(new CheckBoxListener());
//			TueBox.addItemListener(new CheckBoxListener());
//			WedBox.addItemListener(new CheckBoxListener());
//			ThuBox.addItemListener(new CheckBoxListener());
//			FriBox.addItemListener(new CheckBoxListener());
//			SatBox.addItemListener(new CheckBoxListener());
//			SunBox.addItemListener(new CheckBoxListener());

		      // Add the label and check boxes to the content pane.
			searchEventsPanel.setLayout(new GridLayout(4,3)); 
			
		
			searchEventsPanel0.add(workType);
//			searchEventsPanel2.add(new JLabel("select time range:"));  
//			searchEventsPanel2.add(shiftsStart);
//			searchEventsPanel2.add(shiftsEnd);

	        
			//System.out.println("this is IT: "+shiftsStart.getSelectedIndex());
			
//			searchEventsPanel1.add(new JLabel("select One day:"));
//			searchEventsPanel1.add(MonBox);
//			searchEventsPanel1.add(TueBox);
//			searchEventsPanel1.add(WedBox);
//			searchEventsPanel1.add(ThuBox);
//			searchEventsPanel1.add(FriBox);
//			searchEventsPanel1.add(SatBox);
//			searchEventsPanel1.add(SunBox);
			
		     
			searchEventsPanel3.add(new JLabel("Search CSH eligible Events:"));
		      // Add the radio buttons to this panel.
			searchEventsPanel3.add(yes);
			searchEventsPanel3.add(no);
			
			searchEventsPanel.add(searchEventsPanel0);
			searchEventsPanel.add(searchEventsPanel2);
			searchEventsPanel.add(searchEventsPanel1);
			searchEventsPanel.add(searchEventsPanel3);
			int result = JOptionPane.showConfirmDialog(null, searchEventsPanel,"Search For Event", JOptionPane.OK_CANCEL_OPTION);
			boolean cshO = false;
			if(result == JOptionPane.OK_OPTION) {
			      System.out.println("WorkType = "+ workType.getSelectedIndex());
//			      System.out.println("Start = "+ shiftsStart.getSelectedIndex());
//			      System.out.println("End = "+ shiftsEnd.getSelectedIndex());
//			      if (MonBox.isSelected()) {
//				         day = 0;}
//				      else if (TueBox.isSelected()) {
//				    	  day = 1;}
//				      else if (WedBox.isSelected()) {
//				    	  day = 2;}
//				      else if (ThuBox.isSelected()) {
//				    	  day = 3;}
//				      else if (FriBox.isSelected()) {
//				    	  day = 4;}
//				      else if (SatBox.isSelected()) {
//				    	  day = 5;}
//				      else if (SunBox.isSelected()) {
//				    	  day = 6;}
//			      System.out.println("day = "+day);
			      if (yes.isSelected()) {
			    	  cshO = true;}
			      else if (no.isSelected()) {
			    	  cshO = false;}
			      System.out.println("csh = "+cshO);
			      SearchGUI newSearchGUI = new SearchGUI(search, vol, 4, false );
			}
			
			
		}
	}

}