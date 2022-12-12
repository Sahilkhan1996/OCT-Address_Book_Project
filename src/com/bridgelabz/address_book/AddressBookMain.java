package com.bridgelabz.address_book;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBookMain {

	static HashMap<String, AddressBook> mapAddressBook = new HashMap<String, AddressBook>();
	static Scanner sc = new Scanner(System.in);
	static {
		System.out.println("Welcome to Address Book Program");
	}

	public static void main(String[] args) {
		AddressBook addressBookObj = new AddressBook();
		// UC6: Adding Multiple AddressBook of contacts
		boolean stopper = true;
		while (stopper) {
			System.out.println("Please select any number from the below Main Menu");
			System.out.println(
					"1. Add AddressBook \n2. View AddressBook \n3. View the Person in the City or State \n4. Exit from the Address Book program");
			int selection = sc.nextInt();
			switch (selection) {
			case 1: {
				System.out.println("Please enter the Name of the AddressBook");
				String addressBookName = sc.next();
				System.out.println(addressBookName);
				mapAddressBook.put(addressBookName, addressBookObj);
				for (Map.Entry<String, AddressBook> m : mapAddressBook.entrySet()) {
					System.out.println(m.getKey() + " is Address book Elements are " + m.getValue().contactsList);
				}
				addressBookObj.Contactlist(addressBookName, addressBookObj);
			}
			case 2: {
				for (Entry<String, AddressBook> m : mapAddressBook.entrySet()) {
					System.out.println(m.getKey() + " Elements are" + m.getValue().contactsList);
				}
			}
				break;
			case 3: {
				/* Ability to search Person in a City or State across the multipleAddressBook */
				System.out.println("Please enter the Name of the City or State from AddressBook");
				String name = sc.next();

			mapAddressBook.values().stream().forEach((i1) -> {
					i1.contactsList.stream()
							.filter(i2 -> i2.getCity().equalsIgnoreCase(name) || i2.getState().equalsIgnoreCase(name))
							.forEach(System.out::println);
				});

				// Without Stream
				/*
				 * 
				 * for (Entry<String, AddressBook> m : mapAddressBook.entrySet()) {
				 * System.out.println(m.getKey() + " Elements are" + m.getValue().contactsList);
				 * for (Contacts contacts : m.getValue().contactsList) {
				 * System.out.println("Checking contacts"); if
				 * (contacts.getCity().equalsIgnoreCase(name)) {
				 * System.out.println("Retrieved the city from contact list is: " +
				 * contacts.getCity()); System.out.println(contacts); } } }
				 */
			}
				break;

			case 4: {
				System.out.println("Thank you for using Address Book");
				sc.close();
				System.exit(selection);
			}
			default:
				stopper = false;
				throw new IllegalArgumentException("Unexpected value: " + selection);
			}
		}

	}

}