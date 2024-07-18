package commandlineprogramming;
import java.util.Scanner;

public class CliProgram {
	
	public static void main(String[] args) {
		
		System.out.println(" Student Registration Form");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" Enter your first name : ");
		String firstName = sc.nextLine();
		System.out.println();
		
		System.out.println(" Enter your last name : ");
		String lastName = sc.nextLine();
		System.out.println();
		
		System.out.println(" Select your gender :Male -->Enter 'M' OR Female-->Enter 'F' ");
		char gender = sc.next().charAt(0);
		System.out.println();
		
		System.out.println(" Enter your age : ");
		int age = sc.nextInt();
		System.out.println();
		
		System.out.println(" Enter your mobile number : ");
		long mobile = sc.nextLong();
		System.out.println();
		
		System.out.println(" Enter your weight : ");
		double weight = sc.nextDouble();
		System.out.println();
		
		System.out.println("Check your registration details");
		System.out.println(" Welcome "+firstName+" "+lastName);
		System.out.println(" Your gender is  "+ gender +"Your age is "+age);
		System.out.println(" Mobile Number is "+mobile);
		System.out.println(" Your weight is "+weight);
		System.out.println();
		
		sc.close();
		
	}
}
