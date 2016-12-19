package logic;

public class Task {
	int date, month, year;

	public Task(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public boolean compare(Task A) {
		if(this.date == A.date && this.month == A.month && this.year == A.year)
			return true;
		else return false;
	}
}
