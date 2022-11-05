package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	static List<Contacts> a1 = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		// Adding new contacts to address book

		System.out.println("Enter the number of contacts you would like to enter?");
		int numberOfContacts = sc.nextInt();
		addingContacts(numberOfContacts);
		System.out.println("All the contacts are added sucessfully!");
		// Displaying added contacts
		for (Object object : a1) {
			System.out.println(object);
		}
		// editing the contacts which you have added
		System.out.println("Please enter the first name of the added contact to edit: ");
		String firstNameToEdit = sc.next();
		editContacts(firstNameToEdit);
		System.out.println();
		// Displaying added contacts
		for (Object object : a1) {
			System.out.println(object);
		}
		System.out.println("Thank you for using Address Book Program!");

		sc.close();
	}

	private static void addingContacts(int numberOfContacts) {
		for (int i = 1; i <= numberOfContacts; i++) {
			Contacts contactObj = new Contacts();
			try {
				System.out.println("Please enter the first name: ");
				contactObj.setFirstName(sc.next());
				System.out.println("Please enter the last name: ");
				contactObj.setLastName(sc.next());
				System.out.println("Please enter the Address: ");
				contactObj.setAddress(sc.next());
				System.out.println("Please enter the city: ");
				contactObj.setCity(sc.next());
				System.out.println("Please enter the state: ");
				contactObj.setState(sc.next());
				System.out.println("Please enter the zip: ");
				contactObj.setZip(sc.nextInt());
				System.out.println("Please enter the Phone Number: ");
				contactObj.setPhoneNumber(sc.nextInt());
				System.out.println("Please enter the email: ");
				contactObj.setEmail(sc.next());
			} catch (InputMismatchException e) {
				System.out.println(e);

			}
			// adding the contact in the array list
			a1.add(contactObj);
			System.out.println(i + " contact are added sucessfully!");
		}

	}

	// I/P:First Name
	// O/P: editing all the details of the contact

	private static void editContacts(String firstNameToEdit) {
		boolean isContactFound = true;
		for (Contacts object : a1) {
			if (firstNameToEdit.equals(object.getFirstName())) {
				System.out.println("Lets edit the contacts: ");
				object.editingContact();
				isContactFound = false;
				break;
			}
		}
		if (isContactFound) {
			System.out.println("Sorry there is no contact with this first name");
		}

	}

}
