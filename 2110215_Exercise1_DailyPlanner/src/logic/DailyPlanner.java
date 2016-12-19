package logic;

import utility.Utility;
import java.util.ArrayList;
import java.util.Scanner;


public class DailyPlanner {

	public static Scanner in;
	public static String[] monthLists = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
	public static int[] totalDayLists = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static ArrayList<Task> tasks = new ArrayList<Task>();
	
	public static void main(String[] args){

		String inputCommand;
		in = new Scanner(System.in);

		while (true)
		{
			showMenu();
			inputCommand = in.next();
			switch(inputCommand)
			{
				case "V" :
					viewCalendarMenu();
					break;
				case "A" :
					addTaskMenu();
					break;
				case "E" :
					System.exit(0);
					break;
				default :
					System.out.println("Invalid input command. Program terminated.");
					System.exit(0);
					break;
			}
		}
	}
	
	public static void showMenu(){

		System.out.println("------------------------------");
		System.out.println("Main Menu");
		System.out.println("------------------------------");
		System.out.println("V )     View calendar");
		System.out.println("A )     Add task to calendar");
		System.out.println("E )     Exit program");
		System.out.println("------------------------------");
		System.out.print("Enter input command : ");
	}
	
	public static void viewCalendarMenu(){

		int month, year;
		System.out.println("------------------------------");
		System.out.println("View calendar");
		System.out.println("------------------------------");
		System.out.print("Enter Month (Number) : ");
		month = in.nextInt();
		System.out.print("Enter Year : ");
		year = in.nextInt();
		System.out.println(getCalendarString(month, year));
	}
	
	public static String getCalendarString(int month,int year){
		
		String calendarString = "";
		if(year < 1) return "Invalid Year. Unable to view";
		if(month < 1 || month > 12) return "Invalid Month. Unable to view";
		
		calendarString += "                "+monthLists[month-1]+" "+year+"\n";
		calendarString += "Sun     Mon     Tues    Wed     Thurs   Fri     Sat\n";
		
		int totalDay = totalDayLists[month-1];
		if(month == 2 && isLeapYear(year)) totalDay++;
		int startDate = Utility.dayOfWeek(1,month,year);
		for(int i = 1; i < startDate; i++) calendarString += "        ";
		for(int i = 1; i <= totalDay; i++, startDate++){
			boolean found = false;
			calendarString += i;
			for(int j=0; j < tasks.size(); j++){
				Task A = new Task(i, month, year);
				if(tasks.get(j).compare(A)){
					calendarString += "*";
					found = true;
					break;
				}
			}
			if(startDate == 7){
				startDate = 0;
				calendarString += "\n";
			}
			else{
				if(i < 10) calendarString += "      ";
				else calendarString += "     ";
				if(!found) calendarString +=" ";
			}
		}

		return calendarString;
	}
	
	public static void addTaskMenu(){
		int dateOfTask,monthOfTask,yearOfTask;
		System.out.println("------------------------------");
		System.out.println("Add task");
		System.out.println("------------------------------");
		System.out.print("Enter Date : ");
		dateOfTask = in.nextInt();
		System.out.print("Enter Month (Number) : ");
		monthOfTask = in.nextInt();
		System.out.print("Enter Year : ");
		yearOfTask = in.nextInt();
		
		System.out.println(addTask(dateOfTask,monthOfTask,yearOfTask));
		
	}
	
	public static String addTask(int date,int month,int year){
		if(year < 1) return "Invalid Year. Unable to add";
		if(month < 1 || month > 12) return "Invalid Month. Unable to add";
		int totalDay = totalDayLists[month-1];
		if(month == 2 && isLeapYear(year)) totalDay++;
		if(date < 1  || date > totalDay) return "Invalid Date. Unable to add";
		
		Task A = new Task(date, month, year);
		for(int i=0; i < tasks.size(); i++){
			if(tasks.get(i).compare(A)){
				return "Unable to add. There is already a task on that day.";
			}
		}
		
		tasks.add(A);
		return "Task is successfully added";
	}
	
	public static boolean isLeapYear(int year){
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
        	return true;
        else
            return false;
	}

}
