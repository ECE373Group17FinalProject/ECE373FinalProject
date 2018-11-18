package Search;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



import Person.ConvictUser;
import Person.Organization;
import Person.ProbationOfficer;
import Person.Volunteer;
import Thing.Court;
import Thing.Event;
import Thing.Offense;
import Thing.Records;



public class SearchEngineGUI extends JFrame {
	private SearchEngine search;
	private JMenuBar menuBar;		//the horizontal container
	private JMenu searchEventsMenu;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenu searchUsersMenu;
	private ArrayList<Volunteer> volunteerList;
	
	
	// File submenus
    
	
	
	// Admin 
	
	private JMenuItem adminPrintAll; 		//JMenuItem objects are added to JMenu objects as the drop down selections.
	private JMenuItem adminSetPayRate; 
	private JMenuItem fileSave; 
	private JMenuItem fileLoad; 

	public SearchEngineGUI(String windowTitle) 
	{
		
		super(windowTitle);
		volunteerList = new ArrayList<Volunteer>();
		//Instantiate Search Engine
		search = new SearchEngine();
		//Instantiate Court Class
		Court c1 = new Court();
		//Instantiate Probation Officer Class
		ProbationOfficer po1 = new ProbationOfficer();
		//Instantiate Organization
		Organization org1 = new Organization();
		//Instantiate Event
		Event e1 = new Event();
		//Instantiate Volunteers
		Volunteer v1 = new Volunteer();
		Volunteer v2 = new Volunteer();
		Volunteer v3 = new Volunteer();
		volunteerList.add(v1);
		volunteerList.add(v2);
		volunteerList.add(v3);
		//Instantiate ConvictUsers
		ConvictUser cu1 = new ConvictUser();
		ConvictUser cu2 = new ConvictUser();
		//Instantiate Records
		Records r1 = new Records();
		Records r2 = new Records();
		//Instantiate Offenses
		Offense o1 = new Offense();
		Offense o2 = new Offense();
		Offense o3 = new Offense();
		Offense o4 = new Offense();

		
		//Populate info
		v1.setName("Jesse");
		v1.setLocX(1.0);
		v1.setLocY(1.0);
		v1.setTravelRadius(2.0);
		v1.setEquipment("shovel");
		v1.addAvailability(111);
		
		v2.setName("Emiliano");
		v2.setLocX(2.0);
		v2.setLocY(2.0);
		v2.setTravelRadius(4.0);
		v2.setEquipment("mule");
		
		v3.setName("Abdi");
		v3.setLocX(3.0);
		v3.setLocY(3.0);
		v3.setTravelRadius(6.0);
		v3.setEquipment("hammer");
		
		po1.setName("Wyatt Earp");
		po1.setPhoneNumber("520.867.5309");
		po1.addConvict(cu1);
		po1.addConvict(cu2);
		
		cu1.setName("Billy Kid");
		cu1.setHoursRequired(20);
		cu1.setLocX(1.0);
		cu1.setLocY(1.0);
		cu1.setTravelRadius(2.0);
		cu1.setEquipment("watergun");
		cu1.addAvailability(111);
		
		cu2.setName("John Marston");
		cu2.setHoursRequired(10);
		cu2.setLocX(2.0);
		cu2.setLocY(2.0);
		cu2.setTravelRadius(4.0);
		cu2.addAvailability(111);
		
		r1.setName("Billy Kid");
		r1.setWorkNotAllowed("Fundraising");
		r1.addOffense(o1);
		r1.addOffense(o2);
		
		o1.setNatureOfCrime("Bank Robbery");
		o1.setArrestingOfficer("Bill Hickock");
		o1.setDate("11/11/2011");
		o1.setDateOfConviction("7/27/2012");
		o1.setCommunityHoursRequired(10);
		o1.setPoliceReport("Suspect arrested outside of local saloon.");
		
		o2.setNatureOfCrime("Rustling");
		o2.setArrestingOfficer("John Henry Holliday");
		o2.setDate("6/5/2006");
		o2.setDateOfConviction("8/25/2007");
		o2.setCommunityHoursRequired(10);
		o2.setPoliceReport("Suspect apprehended in field near Oakley Ranch.");
		
		r2.setName("John Marston");
		r2.setWorkNotAllowed("Youth");
		r2.addOffense(o3);
		r2.addOffense(o4);
		
		o3.setNatureOfCrime("Kidnapping");
		o3.setArrestingOfficer("Booker Dewitt");
		o3.setDate("11/8/2008");
		o3.setDateOfConviction("4/9/2009");
		o3.setCommunityHoursRequired(3);
		o3.setPoliceReport("Suspect arrested on Insterstate 10.");
		
		o4.setNatureOfCrime("Horse Theft");
		o4.setArrestingOfficer("Bill Buffalo");
		o4.setDate("12/25/2001");
		o4.setDateOfConviction("5/5/2002");
		o4.setCommunityHoursRequired(7);
		o4.setPoliceReport("Suspect found outside of corral with hoofprint on chest near open corral.");
		
		c1.addRecord(r1);
		c1.addRecord(r2);
		c1.addConvicts(cu1);
		c1.addConvicts(cu2);

		//populating event
		org1.createEvent(e1);
		org1.setName("Swimmers Club");
		org1.createEvent(e1);
		e1.setName("Pool Party");
		e1.setCshEligible(true);
		e1.setWorkType("Youth");
		e1.setDateString("10/31/2018");
		e1.setLocX(1.0);
		e1.setLocY(1.0);
		e1.setMaxUsers(1);
		e1.addTimeSlot(111);
		e1.addTimeSlot(112);
		e1.addTimeSlot(114);
		e1.setOrganization(org1);
		
		//create an Organization and add it to search Engine;
		search.organizationList.add(org1);
		

		setSize(300, 150);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Welcome to Our Search Engine" +
				"<BR>Choose to search for Events at the top to get started.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	public void buildGUI() 
	{
		menuBar = new JMenuBar();
     	
		// Employee Student Menu
		
		searchEventsMenu = new JMenu("Search For Events");
		//fileMenu = new JMenu("File");
		
		//adminSetPayRate = new JMenuItem ("Set PayRate" );
		//adminPrintAll = new JMenuItem("Print Employee Info");
		
		//fileSave = new JMenuItem("Save");
		//fileLoad = new JMenuItem("Load");
		
		//adminSetPayRate.addActionListener(new MenuListener());		//JMenuItem's, via AbstractButton, have a method addActionListener(ActionListener)
		//adminPrintAll.addActionListener(new MenuListener());		//The innerclass is implementing ActionListener, so it can take action when the JMenuItem is clicked.
		
		//fileSave.addActionListener(new MenuListener());
		//fileLoad.addActionListener(new MenuListener());
	    
		//adminMenu.add(adminSetPayRate);
		//adminMenu.add(adminPrintAll);
		
		//fileMenu.add(fileSave);	
		//fileMenu.add(fileLoad);
		
		menuBar.add(searchEventsMenu);
		//menuBar.add(adminMenu);
	    
	
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(searchEventsMenu))
			{
				handleSearchEvents();	
			}
	
		}
		
		private void handleSearchEvents()
		{
			Volunteer volunteer = new Volunteer();
			 String  vName = JOptionPane.showInputDialog(null, "What is thename of the Volunteer who is search ", JOptionPane.QUESTION_MESSAGE);
			
			if(vName != null)
			{
				if(vName.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, 
												"Please enter correct Volunteer name", 
												"Error Volunteer doesn't exist in the System", 
												JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					if(!containsVolunteer(vName,volunteer))
					{
						JOptionPane.showMessageDialog(null,
													"Volunteer Name  \""+vName+"\" doesn't exist in the System.",
													"Error ",
													JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						String shift = JOptionPane.showInputDialog("Please Enter day andtime of the week you are available in the form: dtt\n"+" 1-7 for week days(Mon-Sun) and 0-23 for hourly timshifts (12am-11:59pm)");
						if(shift != null)
						{
							search.searchEvents(shift , volunteer);
						}
					}
				}
			}
		}
		
//		private void handleAdminPrint() 
//		{
//			if( emp1!=null)
//			{
//				emp1.Print();
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null, 
//						"No Employee", 
//						"Error", 
//						JOptionPane.PLAIN_MESSAGE);
//			}
//		}
		
//		private void handleFileSave()
//		{
//			
//						Employee.saveData(emp1);
//		}
//		private void handleFileLoad()
//		{
//			
//						emp1 = Employee.loadData();
//		}
		public boolean containsVolunteer(String name,Volunteer v)
		{		
			for(int n = 0; n < volunteerList.size(); n++) 
			{
				if ((volunteerList.get(n).getName().equals( name)))
				{
					v= volunteerList.get(n);
					return true;
				}
			}
			return false;	
	    }
	}
	
}
