package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String companySuffix = "acompany.com";
	private String email;
	private int mailboxCapacity = 500;
	private int passwordLength = 10;
	private String altEmail;
	
	//Constructor to receive first and last name
	public Email(String fn, String ln)
	{
		firstName = fn;
		lastName = ln;
		
		//Call a method asking for a department and returns the department
		department = setDepartment();
		
		//Call a method that returns a random password
		password = randomPassword(passwordLength);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
		
	}
	//Ask for department
	private String setDepartment() 
	{
		System.out.println("Enter Department \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if (depChoice == 1) return "Sales";
		else if (depChoice == 2) return "Development";
		else if (depChoice == 3) return "Accounting";
		else return "";
	}
	//Generate a random password
	private String randomPassword(int length) 
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890/?;[]-+=";
		char[] password = new char[length];
		for (int i = 0;i<length;i++) 
		{
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {mailboxCapacity = capacity;}
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {this.altEmail = altEmail;}
	//Change the password
	public void changePassword(String password) {this.password = password;}
		
	public String getName() {return firstName + " " + lastName;}
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getEmail() {return email;}
	public String getPassword() {return password;}
	public String getAlternateEmail() {return altEmail;}
	
	public void showInfo() 
	{
		System.out.println("NAME: "+firstName + ' ' +lastName);
		System.out.println("COMPANY EMAIL: "+email);
		System.out.println("MAILBOX CAPACITY: "+mailboxCapacity +"mb");
	}
}
