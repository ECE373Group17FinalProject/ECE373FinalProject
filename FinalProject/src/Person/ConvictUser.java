package Person;

import java.util.ArrayList;
import java.util.Collections;


public  class ConvictUser extends User{

	private int hoursRequired; //assigned number of community service hours
	private int hoursCompleted = 0;
	private ProbationOfficer po = new ProbationOfficer();
	
	public ConvictUser() {
		setName("No Name");
	}
	public int getHoursRequired(){
		return hoursRequired;
	}
	public void setHoursRequired(int h){
		hoursRequired = h;
	}
	
	public int getHoursCompleted () {
		return hoursCompleted;
	}
	public void addToHoursCompleted (int h) {
		hoursCompleted = hoursCompleted + h;
	}
	public int calculateHoursLeft() {
		int hoursLeft;
		hoursLeft = hoursRequired - hoursCompleted;
		return hoursLeft;
	}
	public ProbationOfficer getPo() {
		return po;
	}
	public void setPo(ProbationOfficer po) {
		this.po = po;
	}
	

	
}

