package JAVAPROJECT;
import java.util.Scanner;
public class OnlineResumeBuilder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Personal Information
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		
		System.out.println("Enter your phone number: ");
		String phone = scanner.nextLine();
		
		System.out.println("Enter your address: ");
		String address = scanner.nextLine();
		
		//Education
		System.out.println("Enter your highest qualification: ");
		String qualification = scanner.nextLine();
		
		System.out.println("Enter your university/college: ");
		String university = scanner.nextLine();
		
		System.out.println("Enter your graduation year: ");
		String gradYear = scanner.nextLine();
		
		//Work Experience
		System.out.println("Enter your last job title: ");
		String jobTitle = scanner.nextLine();
		
		System.out.println("Enter your company name: ");
		String company = scanner.nextLine();
		
		System.out.println("Enter your work duration  (e.g., 2020-2023): ");
		String duration = scanner.nextLine();
		
		//Skills
		System.out.println("Enter your skills (comma separated): ");
		String skills = scanner.nextLine();
		
		//Display Resume
		System.out.println("\n********** YOUR RESUME **********");
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		System.out.println("Address: " + address);
		System.out.println("\n--- Education ---");
		System.out.println(qualification + " from " + university + " ( " + gradYear + " ) ");
		System.out.println("\n--- Work Experience ---");
		System.out.println(jobTitle + " at " + company + " ( " + duration + " ) ");
		System.out.println("\n--- Skills ----");
		System.out.println(skills);
		System.out.println("***************************");
		scanner.close();
		
	}

}
