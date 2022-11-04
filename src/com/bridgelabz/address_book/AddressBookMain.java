package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		// Adding new contacts to address book
		List<Object> a1 = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of contacts you would like to enter?");
		int numberOfContacts = sc.nextInt();
		for (int i = 1; i <= numberOfContacts; i++) {
			Contacts cs1 = new Contacts();
			try{System.out.println("Please enter the first name: ");
			cs1.setFirstName(sc.next());
			System.out.println("Please enter the last name: ");
			cs1.setLastName(sc.next());
			System.out.println("Please enter the Address: ");
			cs1.setAddress(sc.next());
			System.out.println("Please enter the city: ");
			cs1.setCity(sc.next());
			System.out.println("Please enter the state: ");
			cs1.setState(sc.next());
			System.out.println("Please enter the zip: ");
			cs1.setZip(sc.nextInt());
			System.out.println("Please enter the Phone Number: ");
			cs1.setPhoneNumber(sc.nextInt());
			System.out.println("Please enter the email: ");
			cs1.setEmail(sc.next());}
			catch(InputMismatchException e) {
				System.out.println(e);
				
			}
			// adding the contact in the array list
			a1.add(cs1);
			System.out.println(i + " contact are added sucessfully!");
		}
		System.out.println("All the contacts are added sucessfully!");
		for (Object object : a1) {
			System.out.println(object);
		}
		sc.close();
	}
}
