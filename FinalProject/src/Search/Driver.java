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
		SearchEngine s1 = new SearchEngine();
		//Instantiate Court Class
		Court c1 = new Court();
		//Instantiate Probation Officer Class
		ProbationOfficer po1 = new ProbationOfficer();
		//Instantiate Organization
		Organization org1 = new Organization();
		//Instantiate Event
		Event e1 = new Event();
		Event e2 = new Event();
		//Instantiate Volunteers
		Volunteer v1 = new Volunteer();
		Volunteer v2 = new Volunteer();
		Volunteer v3 = new Volunteer();
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
		
		//Populate enfo
		v1.setName("Jesse Gilmer");
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
		
		v3.setName("Abdi Tasir");
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
		
		org1.addUserToBlacklist(cu1);
		
		
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
		
		//Utilizing Court class functions to print offenses
		c1.retrieveRecord(cu1.getName()).printOffenses();
		c1.displayPOInfo(cu1);

		c1.retrieveRecord(cu2.getName()).printOffenses();
		c1.displayPOInfo(cu2);
		
		//populating event
		org1.createEvent(e1);
		org1.setName("Swimmers Club");
		org1.createEvent(e1);
		e1.setName("Pool Party");
		e1.setCshEligible(true);
		e1.setWorkType("Youth");
		e1.setLocX(1.0);
		e1.setLocY(1.0);
		e1.setMaxUsers(1);
		e1.addTimeSlot(111);
		e1.addTimeSlot(112);
		e1.addTimeSlot(114);
		e1.setOrganization(org1);
		
		e2.setName("Cleaning out the warehouse");
		e2.setCshEligible(true);
		e2.setWorkType("Cleaning");
		e2.setLocX(2.5);
		e2.setLocY(2.5);
		e2.setMaxUsers(15);
		e2.addTimeSlot(111);
		e2.addTimeSlot(112);
		e2.addTimeSlot(113);
		e2.addTimeSlot(114);
		e2.addTimeSlot(115);
		e2.setOrganization(org1);
		
		cu1.addEvent(e1);
		org1.removeUserFromBlacklist(cu1);
		cu1.addEvent(e2);
		cu1.printSchedule();

		
		//adding event to org and initiating search
		String dateString = "10/31/2018";
		SearchEngine.organizationList.add(org1);
		s1.searchEvents(dateString , v1);
		e1.addVolunteer(v1);
		
		//Checking for volunteer Limit
		e1.addVolunteer(v2);
		
		//Checking for hidden Event data is convict is not allowed the work type
		s1.convictSearch(dateString, cu2, c1);
		
		//Checking for Event data if convict IS allowed the work type
		s1.convictSearch(dateString, cu1, c1);
	}
}