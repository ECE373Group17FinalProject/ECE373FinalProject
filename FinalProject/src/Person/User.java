package Person;

//import java.awt.Event;
import java.util.ArrayList;
import java.util.Collections;
import Thing.Event;


public abstract class User {

	//Fields for a Student
	private String name;
	private double locX;
	private double locY;
	private double travelRadius;
	
	private ArrayList<Event> scheduledEvents = new ArrayList<Event>(300);   // not sure the purpose of this AL
	private ArrayList<Integer> eventCodes = new ArrayList<Integer>(300);
	public ArrayList<Integer> schedule = new ArrayList<Integer>(300);
	
	private ArrayList<String> equipment = new ArrayList<String>(300);
	public ArrayList<Integer> availability = new ArrayList<Integer>(300);
	/* we can use a scheduling code similar to the university assignment.
	 * -three digit numbers denoting day and hour-long time slot
	 * first digit: 1 = Monday ... 7 = Sunday
	 * last 2 digits: military hour -- 00 = midnight, 16 = 4:00pm 
	 * so 319 = Wednesday 7-8pm
	 * */
	
	public User() {
		name = "No Name";
	}
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	public double getLocX(){
		return locX;
	}
	public void setLocX(double x){
		locX = x;
	}
	public double getLocY(){
		return locY;
	}
	public void setLocY(double y){
		locY = y;
	}
	public double getTravelRadius(){
		return travelRadius;
	}
	public void setTravelRadius(double t){
		travelRadius = t;
	}
	public ArrayList<Integer> getAvailability() {
		return availability;
	}	
	public void printSchedule() {
		// like "Mon 9:30am to 10:45am"
		Collections.sort(schedule);
		System.out.println(this.name + "'s schedule: " );

		for(int i=0; i < schedule.size(); i++) {
			System.out.println("     " + scheduledEvents.get(i).getName() + " " + convertScheduleCodeDay(schedule.get(i)) + convertScheduleCodeTime(schedule.get(i)));
		}
			
	}
	public void addAvailability(int a1) {
		/*String[] dateParts = a1.split("/");
		if(dateParts.length != 3 ) {
			System.out.println("Invalid Format for availability date: " + a1);
			return;
		}*/
		if(a1 > 723 || a1 < 100) {
			System.out.println("Invalid availability code: " + a1);
			return;
		}
		else {
			this.availability.add(a1);
		}
		
	}
	public void removeAvailability(int a1) {
		if(a1 > 723 || a1 < 100) {
			System.out.println("Invalid availability code: " + a1);
			return;
		}
		else {
			this.availability.remove(a1);
		}
	}
	
	public void addToSchedule(int a1) {
		if(a1 > 723 || a1 < 100) {
			System.out.println("Invalid schedule code: " + a1);
			return;
		}
		else {
			this.schedule.add(a1);
		}
	}
	
	public void removeFromSchedule(int a1){
		if(a1 > 723 || a1 < 100) {
			System.out.println("Invalid schedule code: " + a1);
			return;
		}
		else {
			this.schedule.remove(a1);
		}
	}
	public void addEvent(Event e1) {
		if (e1.checkBlacklistForUser(this)) {
			System.out.println("User has been blacklisted by organization. Could not add event.");
			return;
		}
		this.eventCodes.add(e1.getEventCode());
		for (int i = 0; i < e1.getTimeSlots().size(); i++) {
			this.scheduledEvents.add(e1);

			addToSchedule(e1.getTimeSlots().get(i));
		}
		System.out.println(this.name + " has been added to " + e1.getName());
		return;
	}
	public void removeEvent(Event e1) {
		this.scheduledEvents.remove(e1);
	}
	public ArrayList<String> getEquipment(){
		return equipment;
	}
	public void setEquipment(String e){
		equipment.add(e);
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
	
	
}

