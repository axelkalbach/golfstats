import java.util.Scanner;
public class Input {
	static Scanner sc;
	static boolean start;
	public static String readString(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}
	public static int readInt(String prompt) {
		sc = new Scanner(System.in);
		int n = 0;
		boolean valid = true;
		while(valid) {
			System.out.print(prompt);
			while(!sc.hasNextInt()) {
				System.out.println("Not a valid Integer");
				valid = false;
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextInt();
		}
		return n;
	}
	public static double readDouble(String prompt) {
		sc = new Scanner(System.in);
		double n = 0;
		boolean valid = true;
		while(valid) {
			System.out.print(prompt);
			while(!sc.hasNextDouble()) {
				System.out.println("Not a valid Double");
				valid = false;
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextDouble();
		}
		return n;
	}
	public static int readNum(String prompt, int max) {
		sc = new Scanner(System.in);
		int n = max + 1;
		while(n > max) {
			System.out.print(prompt);
			while(!sc.hasNextInt()) {
				System.out.println("Not a valid Integer");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextInt();
			if(n > max) { 
				System.out.println("Not a valid integer greater than or equal to " + max);
			}
		}
		return n;
	}
	public static int readNum(int min, String prompt) {
		sc = new Scanner(System.in);
		int n = min - 1;
		while(n < min) {
			System.out.print(prompt);
			while(!sc.hasNextInt()) {
				System.out.println("Not a valid Integer");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextInt();
			if(n < min) { 
				System.out.println("Not a valid integer less than or equal to " + min);
			}
		}
		return n;
	}
	public static int readNum(String prompt, int min, int max) {
		sc = new Scanner(System.in);
		int n = min - 1;
		while(n < min || n > max) {
			System.out.print(prompt);
			while(!sc.hasNextInt()) {
				System.out.println("Not a valid Integer");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextInt();
			if(n < min || n > max) { 
				System.out.println("Not a valid integer between " + min + " and " + max);
			}
		}
		return n;
	}
	public static double readNum(String prompt, double max) {
		sc = new Scanner(System.in);
		double n = max + 1;
		while(n > max) {
			System.out.print(prompt);
			while(!sc.hasNextDouble()) {
				System.out.println("Not a valid Double");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextDouble();
			if(n > max) { 
				System.out.println("Not a valid double greater than or equal to " + max);
			}
		}
		return n;
	}
	public static double readNum(double min, String prompt) {
		sc = new Scanner(System.in);
		double n = min - 1;
		while(n < min) {
			System.out.print(prompt);
			while(!sc.hasNextDouble()) {
				System.out.println("Not a valid Double");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextDouble();
			if(n < min) { 
				System.out.println("Not a valid double less than or equal to " + min);
			}
		}
		return n;
	}
	public static double readNum(String prompt, double min, double max) {
		sc = new Scanner(System.in);
		double n = min - 1;
		while(n < min || n > max) {
			System.out.print(prompt);
			while(!sc.hasNextDouble()) {
				System.out.println("Not a valid Double");
				sc.next();
				System.out.print(prompt);
			}
			n = sc.nextInt();
			if(n < min || n > max) { 
				System.out.println("Not a valid double between " + min + " and " + max);
			}
		}
		return n;
	}
}
