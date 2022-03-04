package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String name = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, name, balance, withdrawLimit);
		
		System.out.print("Enter value to withdraw: ");
		double value = sc.nextDouble();
		
		try {
			account.withdraw(value);
		}
		catch (BusinessException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		sc.close();
		
	}

}
