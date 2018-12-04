package Search;

import Person.ConvictUser;
import Person.Organization;
import Person.ProbationOfficer;
import Person.Volunteer;
import Thing.Court;
import Thing.Event;
import Thing.Offense;
import Thing.Records;

public class Driver{
	public static void main(String[] args) {
		//Instantiate Search Engine
		//categories of event = cleaning, labor, enviro, animals, kitchen, youth
		SearchEngine s1 = new SearchEngine();
		LoginGUI newGUI;
		//Instantiate Court Class
		Court c1 = new Court();
		//Instantiate Probation Officer Class
		ProbationOfficer po1 = new ProbationOfficer();
		s1.probationOfficerList.add(po1);
		//Instantiate Organization
		Organization org1 = new Organization();
		s1.organizationList.add(org1);
		Organization org2 = new Organization();
		s1.organizationList.add(org2);
		Organization org3 = new Organization();
		s1.organizationList.add(org3);
		Organization org4 = new Organization();
		s1.organizationList.add(org4);
		Organization org5 = new Organization();
		s1.organizationList.add(org5);
		//Instantiate Event
		Event e1 = new Event();
		Event e2 = new Event();
		Event e3 = new Event();
		Event e4 = new Event();
		Event e5 = new Event();
		Event e6 = new Event();
		Event e7 = new Event();
		Event e8 = new Event();
		Event e9 = new Event();
		Event e10 = new Event();
		Event e11 = new Event();
		Event e12 = new Event();
		
		//Instantiate Volunteers
		Volunteer v1 = new Volunteer();
		s1.volunteerList.add(v1);
		Volunteer v2 = new Volunteer();
		s1.volunteerList.add(v2);
		Volunteer v3 = new Volunteer();
		s1.volunteerList.add(v3);
		//Instantiate ConvictUsers
		ConvictUser cu1 = new ConvictUser();
		s1.convictUserList.add(cu1);
		ConvictUser cu2 = new ConvictUser();
		s1.convictUserList.add(cu2);

		//Instantiate Records
		Records r1 = new Records();
		Records r2 = new Records();
		//Instantiate Offenses
		Offense o1 = new Offense();
		Offense o2 = new Offense();
		Offense o3 = new Offense();
		Offense o4 = new Offense();
		
		//Populate info
		v1.setName("Jesse Gilmer");
		v1.setUsername("jessegilmer");
		v1.setPassword("password");
		v1.setLocX(1.0);
		v1.setLocY(1.0);
		v1.setTravelRadius(30);
		v1.setEquipment("shovel");
		int av = 0;
		for(int i = 1; i < 8; i++) {
			av = i*100;
			for(int j = 0; j < 24; j++) {
				av = i*100 + j;
				v1.addAvailability(av);
			}		
		}
		
		v2.setName("Emiliano");
		v2.setUsername("emiliano");
		v2.setPassword("password");
		v2.setLocX(2.0);
		v2.setLocY(2.0);
		v2.setTravelRadius(4.0);
		v2.setEquipment("mule");
		
		v3.setName("Abdi Tasir");
		v3.setUsername("atasir");
		v3.setPassword("password");
		v3.setLocX(3.0);
		v3.setLocY(3.0);
		v3.setTravelRadius(6.0);
		v3.setEquipment("hammer");
		
		po1.setName("Wyatt Earp");
		po1.setUsername("wearp");
		po1.setPassword("password");
		po1.setPhoneNumber("520.867.5309");
		po1.addConvict(cu1);
		po1.addConvict(cu2);
		
		cu1.setName("Billy Kid");
		cu1.setUsername("bkid");
		cu1.setPassword("password");
		cu1.setHoursRequired(20);
		cu1.setLocX(1.0);
		cu1.setLocY(1.0);
		cu1.setTravelRadius(2.0);
		cu1.setEquipment("watergun");
		cu1.addAvailability(111);
		
		org1.addUserToBlacklist(cu1);
		
		cu2.setName("John Marston");
		cu1.setUsername("johnmarston");
		cu1.setPassword("password");
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
		
		//Utilizing Court class functions to print offenses
		c1.retrieveRecord(cu1.getName()).printOffenses();
		c1.displayPOInfo(cu1);

		c1.retrieveRecord(cu2.getName()).printOffenses();
		c1.displayPOInfo(cu2);
	
		org1.setName("Swimmers Club");
		org2.setName("Puppy Shelter");
		org3.setName("Earth Friends");
		org4.setName("Community Culinary Institute");
		org5.setName("Library");
		
		//populating event
		org1.createEvent(e1);
		e1.setName("Pool Party");
		e1.setCshEligible(true);
		e1.setWorkType(6);
		e1.setLocX(1.0);
		e1.setLocY(1.0);
		e1.setMaxUsers(1);
		e1.addTimeSlot(111);
		e1.addTimeSlot(112);
		e1.addTimeSlot(113);		
		e1.addTimeSlot(114);
		e1.setOrganization(org1);
		
		org1.createEvent(e2);
		e2.setName("Cleaning out the warehouse");
		e2.setCshEligible(true);
		e2.setWorkType(1);
		e2.setLocX(2.5);
		e2.setLocY(2.5);
		e2.setMaxUsers(15);
		e2.addTimeSlot(211);
		e2.addTimeSlot(212);
		e2.addTimeSlot(213);
		e2.addTimeSlot(214);
		e2.addTimeSlot(215);
		e2.setOrganization(org1);
		
		org2.createEvent(e3);
		e3.setName("Bathing the dogs and cleaning the kennels");
		e3.setCshEligible(true);
		e3.setWorkType(1);
		e3.setLocX(8.5);
		e3.setLocY(2.5);
		e3.setMaxUsers(15);
		e3.addTimeSlot(111);
		e3.addTimeSlot(112);
		e3.addTimeSlot(113);
		e3.addTimeSlot(114);
		e3.addTimeSlot(115);
		e3.setOrganization(org2);
		
		org2.createEvent(e4);
		e4.setName("Teaching kids about dogs");
		e4.setCshEligible(true);
		e4.setWorkType(6);
		e4.setLocX(-3.0);
		e4.setLocY(-1.0);
		e4.setMaxUsers(15);
		e4.addTimeSlot(414);
		e4.addTimeSlot(415);
		e4.addTimeSlot(416);
		e4.setOrganization(org2);
		
		org3.createEvent(e5);
		e5.setName("Picking up highway trash");
		e5.setCshEligible(true);
		e5.setWorkType(1);
		e5.setLocX(9.0);
		e5.setLocY(-7.0);
		e5.setMaxUsers(15);
		e5.addTimeSlot(107);
		e5.addTimeSlot(108);
		e5.addTimeSlot(109);
		e5.addTimeSlot(110);
		e5.addTimeSlot(111);
		e5.setOrganization(org3);
		
		org3.createEvent(e6);
		e6.setName("Planting trees");
		e6.setCshEligible(true);
		e6.setWorkType(2);
		e6.setLocX(0.0);
		e6.setLocY(5.0);
		e6.setMaxUsers(15);
		e6.addTimeSlot(611);
		e6.addTimeSlot(612);
		e6.addTimeSlot(613);
		e6.addTimeSlot(614);
		e6.addTimeSlot(615);
		e6.addTimeSlot(616);
		e6.addTimeSlot(617);
		e6.setOrganization(org3);
		
		org4.createEvent(e7);
		e7.setName("Teaching refugees to cook");
		e7.setCshEligible(true);
		e7.setWorkType(5);
		e7.setLocX(3.0);
		e7.setLocY(-6.0);
		e7.setMaxUsers(15);
		e7.addTimeSlot(312);
		e7.addTimeSlot(313);
		e7.addTimeSlot(314);
		e7.addTimeSlot(315);
		e7.addTimeSlot(316);
		e7.setOrganization(org4);
		
		org4.createEvent(e8);
		e8.setName("Deep clean of the kitchens");
		e8.setCshEligible(true);
		e8.setWorkType(1);
		e8.setLocX(6.3);
		e8.setLocY(0.0);
		e8.setMaxUsers(15);
		e8.addTimeSlot(708);
		e8.addTimeSlot(709);
		e8.addTimeSlot(710);
		e8.addTimeSlot(711);
		e8.addTimeSlot(712);
		e8.setOrganization(org4);
		
		org5.createEvent(e9);
		e9.setName("Games with the kids");
		e9.setCshEligible(true);
		e9.setWorkType(6);
		e9.setLocX(1.2);
		e9.setLocY(-2.5);
		e9.setMaxUsers(15);
		e9.addTimeSlot(111);
		e9.addTimeSlot(112);
		e9.addTimeSlot(113);
		e9.addTimeSlot(114);
		e9.addTimeSlot(115);
		e9.setOrganization(org5);
		
		org5.createEvent(e10);
		e10.setName("Sweeping the courtyard");
		e10.setCshEligible(true);
		e10.setWorkType(1);
		e10.setLocX(1.2);
		e10.setLocY(-2.5);
		e10.setMaxUsers(15);
		e10.addTimeSlot(313);
		e10.addTimeSlot(314);
		e10.addTimeSlot(315);
		e10.setOrganization(org5);
		
		org5.createEvent(e11);
		e11.setName("Stocking the shelves");
		e11.setCshEligible(true);
		e11.setWorkType(2);
		e11.setLocX(1.2);
		e11.setLocY(-2.5);
		e11.setMaxUsers(15);
		e11.addTimeSlot(208);
		e11.addTimeSlot(209);
		e11.addTimeSlot(210);
		e11.addTimeSlot(211);
		e11.addTimeSlot(212);
		e11.addTimeSlot(213);
		e11.addTimeSlot(214);
		e11.addTimeSlot(215);
		e11.addTimeSlot(216);
		e11.setOrganization(org5);
		
		org5.createEvent(e12);
		e12.setName("Tutoring high schoolers");
		e12.setCshEligible(true);
		e12.setWorkType(6);
		e12.setLocX(1.2);
		e12.setLocY(-2.5);
		e12.setMaxUsers(15);
		e12.addTimeSlot(415);
		e12.addTimeSlot(416);
		e12.addTimeSlot(417);
		e12.setOrganization(org5);
		
		cu1.addEvent(e1);
		org1.removeUserFromBlacklist(cu1);
		cu1.addEvent(e2);
		cu1.printSchedule();

		
		//adding event to org and initiating search
		String dateString = "10/31/2018";
		SearchEngine.organizationList.add(org1);
		s1.searchEvents(v1, 4);
		e1.addVolunteer(v1);
		
		//Checking for volunteer Limit
		e1.addVolunteer(v2);
		
		//Checking for hidden Event data is convict is not allowed the work type
		s1.convictSearch(dateString, cu2, c1);
		
		//Checking for Event data if convict IS allowed the work type
		s1.convictSearch(dateString, cu1, c1);
		
		//Instantiate GUI
        newGUI = new LoginGUI("LoginGUI", s1);	
		
		
	}
}