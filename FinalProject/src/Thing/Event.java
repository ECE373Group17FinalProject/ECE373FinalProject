package Thing;

import java.util.ArrayList;

import Person.User;
import Person.Organization;

public class Event {
	
	
	private String name;
	private String workType;
	private double locX;
	private double locY;
	private int eventCode;
	private int maxUsers;
	private boolean cshEligible;
	private ArrayList<Integer> timeSlots = new ArrayList<Integer>(150);  // corrected declaration and changed to ints
	private ArrayList<User> volunteers = new ArrayList<User>(100);
	private ArrayList<String> equipments = new ArrayList<String>(100);
	private Organization o = new Organization();
	
	
	public Organization getOrganization() {
		return o;
	}
	public void setMaxUsers(int i) {
		maxUsers = i;
	}
	public void setEventCode(int e) {
		this.eventCode = e;
	}
	public int getEventCode() {
		return eventCode;
	}
	public void setOrganization(Organization q) {
		o = q;
	}	

	public String getName() {
		return name;
	}
	public void setName(String d) {
		name = d;
	}
	public double getLocX() {
		return locX;
	}
	public void setLocX(double locationX) {
		this.locX = locationX;
	}
	public double getLocY() {
		return locY;
	}
	public void setLocY(double locationY) {
		this.locY = locationY;
	}
	public ArrayList<Integer> getTimeSlots() {
		return timeSlots;
	}
	public void addTimeSlot(Integer timeSlot) {
		if(!this.timeSlots.isEmpty() && (this.timeSlots.get(this.timeSlots.size()-1) == (timeSlot-1))) {
			this.timeSlots.add(timeSlot);
		}
		else if(this.timeSlots.isEmpty()) {
			this.timeSlots.add(timeSlot);
		}
		else {
			System.out.println("Invalid time Slot Entry");
		}
	}
	public void deleteTimeSlot(Integer timeSlot) {
		this.timeSlots.remove(timeSlot);
	}
	public boolean isCshEligible() {
		return cshEligible;
	}
	public void setCshEligible(boolean cshEligible) {
		this.cshEligible = cshEligible;
	}
	public ArrayList<String> getEquipmentsList() {
		return equipments;
	}
	public void addEquipments(String equipment) {
		this.equipments.add(equipment);
	}
	public ArrayList<User> getVolunteersList() {//Switch to type Users
		return volunteers;
	}
	public void addVolunteer(User volunteer) {//Switch to type Users
		if (volunteers.size() >= maxUsers) {
			System.out.println("This event cannot handle any more users");
			return;
		}
		this.volunteers.add(volunteer);
	}
	public String convertScheduleCodeDay(int scheduleCode) {
		
		int day = scheduleCode / 100;
		
		String dayString = null;
		
		// divide schedule number by 100 to get day
		// and schedule number % 100 to get time slot
		
		switch (day) {
        case 1: 
            dayString = "Mon "; 
            break; 
        case 2: 
            dayString = "Tue "; 
            break; 
        case 3: 
            dayString = "Wed "; 
            break; 
        case 4: 
            dayString = "Thu "; 
            break; 
        case 5: 
            dayString = "Fri "; 
            break; 
		case 6: 
	         dayString = "Sat "; 
	         break; 
		case 7: 
		    dayString = "Sun "; 
		    break; 
		}	
		
		return dayString;
	} 
	public String convertScheduleCodeTime(int scheduleCode) {
		
		int timeSlot = scheduleCode % 100;
		
		String timeSlotString = null;
		
		// divide schedule number by 100 to get day
		// and schedule number % 100 to get time slot

		switch (timeSlot) {
        case 0: 
        	timeSlotString = "midnight to 1:00am"; 
            break; 
        case 1: 
        	timeSlotString = "1:00am to 2:00am"; 
            break; 
        case 2: 
        	timeSlotString = "2:00am to 3:00am"; 
            break; 
        case 3: 
        	timeSlotString = "3:00am to 4:00am"; 
            break; 
        case 4: 
        	timeSlotString = "4:00am to 5:00am"; 
            break; 
        case 5: 
        	timeSlotString = "5:00am to 6:00am"; 
            break; 
        case 6:
        	timeSlotString = "6:00am to 7:00am";
        	break;
        case 7: 
        	timeSlotString = "7:00am to 8:00am"; 
            break; 
        case 8: 
        	timeSlotString = "8:00am to 9:00am"; 
            break; 
        case 9: 
        	timeSlotString = "9:00am to 10:00am"; 
            break; 
        case 10: 
        	timeSlotString = "10:00am to 11:00am"; 
            break; 
        case 11: 
        	timeSlotString = "11:00am to noon"; 
            break; 
        case 12:
        	timeSlotString = "noon to 1:00pm";
        	break;
        case 13: 
        	timeSlotString = "1:00pm to 2:00pm"; 
            break; 
        case 14: 
        	timeSlotString = "2:00pm to 3:00pm"; 
            break; 
        case 15: 
        	timeSlotString = "3:00pm to 4:00pm"; 
            break; 
        case 16: 
        	timeSlotString = "4:00pm to 5:00pm"; 
            break; 
        case 17: 
        	timeSlotString = "5:00pm to 6:00pm"; 
            break; 
        case 18:
        	timeSlotString = "6:00pm to 7:00pm";
        	break;
        case 19: 
        	timeSlotString = "7:00pm to 8:00pm"; 
            break; 
        case 20: 
        	timeSlotString = "8:00pm to 9:00pm"; 
            break; 
        case 21: 
        	timeSlotString = "9:00pm to 10:00pm"; 
            break; 
        case 22: 
        	timeSlotString = "10:00pm to 11:00pm"; 
            break; 
        case 23: 
        	timeSlotString = "11:00pm to midnight"; 
            break; 
		}	
		
		return timeSlotString;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	} 
	public boolean checkBlacklistForUser(User u) {
		return o.checkBlacklistForUser(u);
	}
	
}
