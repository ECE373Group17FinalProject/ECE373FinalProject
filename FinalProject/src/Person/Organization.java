package Person;

import java.util.ArrayList;
import Search.SearchEngine;

import Thing.Event;

public class Organization {
	private String name;
	protected ArrayList<Event> events = new ArrayList<Event>(300);
	protected ArrayList<User> blacklist = new ArrayList<User>(150);
	protected int orgCode;
	
	public Organization (){
		name = "null";
		orgCode = SearchEngine.getOrgListSize();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void createEvent(Event event) {
		if(this.name == "null") {
			System.out.println("Organization Incomplete, cannot add or manage events.");
			System.out.println("");
			return;
		}
		this.events.add(event);
		int i = events.size();
		events.get(i-1).setEventCode((orgCode * 100) + i);
	}
	
	public void addUserToBlacklist(User u) {
		blacklist.add(u);
	}
	public void removeUserFromBlacklist(User u) {
		blacklist.remove(u);
	}
	public boolean checkBlacklistForUser (User u) {
		if (blacklist.contains(u)) {
			return true;
		}
		else {
			return false;
		}
	}

}
