package JAVAPROJECT;
import java.util.Scanner;
import java.util.Random;
public class PasswordGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Ask user for desired password length
		System.out.println("Enter the desired password length: ");
		int  length = scanner.nextInt();
		
		//Characters to use in password
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String special = "!@#$%^&*()_-=+<>?";
		String allChars = upper + lower + digits + special;
		
		Random random = new Random();
		StringBuilder password = new StringBuilder();
		
		//Generate password
		for (int i=0;i<length;i++) {
			int index = random.nextInt(allChars.length());
			password.append(allChars.charAt(index));
		}
		
		//Display the generator password
		System.out.println("Generated Password: "   + password.toString());
		scanner.close();
	}

}
