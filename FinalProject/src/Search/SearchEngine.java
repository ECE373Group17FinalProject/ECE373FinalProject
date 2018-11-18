package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

import Person.Volunteer;
import Person.ConvictUser;
import Person.Organization;
import Person.ProbationOfficer;
import Person.User;
import Thing.Court;
import Thing.Event;


public class SearchEngine {

	//Fields for a Person
	// public Department[] departmentList;
	public static ArrayList<Organization> organizationList = new ArrayList<Organization>(10000);
	public ArrayList<Volunteer> volunteerList = new ArrayList<Volunteer>(10000);
	public ArrayList<ConvictUser> convictUserList = new ArrayList<ConvictUser>(10000);
	public ArrayList<ProbationOfficer> probationOfficerList = new ArrayList<ProbationOfficer>(10000);
	
	
	//Constructors
	public SearchEngine() {

	}
	
	public ArrayList<Event> searchEvents (String dateString, User u ) {          // 
		ArrayList<Event> searchResults = new ArrayList<Event>(1000);
		for(int i = 0; i < organizationList.size(); i++) {
			for(int j = 0; j < organizationList.get(i).getEvents().size(); j++) {
					//	ok, here check time slots
					//	and add if they share time slots
					for(int k = 0; k < organizationList.get(i).getEvents().get(j).getTimeSlots().size(); k++) {
						if (u.getAvailability().contains(organizationList.get(i).getEvents().get(j).getTimeSlots().get(k)) &&
								(calculateDistance(u, organizationList.get(i).getEvents().get(j)) < u.getTravelRadius())) {
							searchResults.add(organizationList.get(i).getEvents().get(j));
						}
					}
							
				
			}
		}
		
		for(int l = 0; l < searchResults.size(); l++) {
			System.out.println("	  Event: " +searchResults.get(l).getName()); 
			System.out.println("      Organization: " + searchResults.get(l).getOrganization().getName());
			System.out.println("      Time: " + formatEventTimeSlot(searchResults.get(l)));
			System.out.println("      Distance: " + calculateDistance(u, searchResults.get(l)));
			System.out.println("      Eligible for Community Service? " + determineCSH(searchResults.get(l)));
			System.out.println("      Equipment Requested: " + formatEventEquipment(searchResults.get(l)));
		}
		
		return searchResults;
		
	}
	
	public ArrayList<Event> convictSearch (String dateString, User u , Court c) {
		ArrayList<Event> searchResults = new ArrayList<Event>(1000);
		String workNotAllowed = "";
		for(int z = 0; z < c.getRecords().size(); z++) {
			if (c.getRecords().get(z).getName() == u.getName()){
				workNotAllowed = c.getRecords().get(z).getWorkAllowed();
			}
		}
		
		for(int i = 0; i < organizationList.size(); i++) {
			for(int j = 0; j < organizationList.get(i).getEvents().size(); j++) {
					//	ok, here check time slots
					//	and add if they share time slots
					for(int k = 0; k < organizationList.get(i).getEvents().get(j).getTimeSlots().size(); k++) {
						if (u.getAvailability().contains(organizationList.get(i).getEvents().get(j).getTimeSlots().get(k)) && 
								(calculateDistance(u, organizationList.get(i).getEvents().get(j)) < u.getTravelRadius()) && 
								!(organizationList.get(i).getEvents().get(j).getWorkType() == workNotAllowed)) {							
								searchResults.add(organizationList.get(i).getEvents().get(j));
						}
					}
							
				
			}
		}
		
		for(int l = 0; l < searchResults.size(); l++) {
			System.out.println("	  Event: " + searchResults.get(l).getName()); 
			System.out.println("      Organization: " + searchResults.get(l).getOrganization().getName());
			System.out.println("      Time: " + formatEventTimeSlot(searchResults.get(l)));
			System.out.println("      Distance: " + calculateDistance(u, searchResults.get(l)));
			System.out.println("      Eligible for Community Service? " + determineCSH(searchResults.get(l)));
			System.out.println("      Equipment Requested: " + formatEventEquipment(searchResults.get(l)));
		}
		
		return searchResults;
		
	}
	
	public String formatEventTimeSlot(Event e) {
		String formattedTime = null;
		String beginTime = null;
		String endTime = null;
		int timeSlotSize = 0;
		
		
		if(e.getTimeSlots().size() == 1) {
			formattedTime = (e.convertScheduleCodeDay(e.getTimeSlots().get(0)) + e.convertScheduleCodeTime(e.getTimeSlots().get(0)));
		}
		
		else {
			String[] timeParts = e.convertScheduleCodeTime(e.getTimeSlots().get(0)).split(" ");
			beginTime = timeParts[0]; 
			
			timeSlotSize = e.getTimeSlots().size();
			String[] timeParts1 = e.convertScheduleCodeTime(e.getTimeSlots().get(timeSlotSize - 1)).split(" ");
			endTime = timeParts1[2];

			formattedTime = (e.convertScheduleCodeDay(e.getTimeSlots().get(0)) + beginTime + " - " + endTime);
		}
		
		return formattedTime;
	}
	
	public String formatEventEquipment(Event e) {
		String formattedEquipment = null;
		for(int i = 0; i < e.getEquipmentsList().size(); i++) {
			formattedEquipment = formattedEquipment + e.getEquipmentsList().get(i);
		}
		return formattedEquipment;
	}
	
	public double calculateDistance(User u, Event e) {
		double distanceFromUser = -1;
		distanceFromUser = Math.sqrt((u.getLocX() - e.getLocX())*(u.getLocX() - e.getLocX()) + (u.getLocY() - e.getLocY())*(u.getLocY() - e.getLocY()));
		return distanceFromUser;
	}
	
	public static int getOrgListSize() {
		
		return organizationList.size();
	}
	
	public String determineCSH(Event e) {
		String csh = null;
		if(e.isCshEligible()) {
			csh = "Yes";
		}
		else {
			csh = "No";
		}
		return csh;
	}
	
	

	
}

