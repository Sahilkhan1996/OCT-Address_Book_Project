package com.bridgelabz.address_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBookMain {

	static HashMap<String, AddressBook> a2 = new HashMap<String, AddressBook>();
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
			System.out.println("1. Add AddressBook \n2. View AddressBook \n3. Exit from the Address Book program");
			int selection = sc.nextInt();
			switch (selection) {
			case 1: {
				System.out.println("Please enter the Name of the AddressBook");
				String addressBookName = sc.next();
				System.out.println(addressBookName);
				a2.put(addressBookName, addressBookObj);
				for (Map.Entry<String, AddressBook> m : a2.entrySet()) {
					System.out.println(m.getKey() + " is Address book Elements are " + m.getValue().contactsList);
				}
				addressBookObj.Contactlist(addressBookName,addressBookObj );
			}
			case 2: {
				for (Entry<String, AddressBook> m : a2.entrySet()) {
					System.out.println(m.getKey() + " Elements are" + m.getValue().contactsList);
				}
			}
				break;
			case 3: {
				System.out.println("Thank you for using Address Book");
				System.exit(selection);
			}
			default:
				stopper = false;
				throw new IllegalArgumentException("Unexpected value: " + selection);
			}
		}

	}
	
}