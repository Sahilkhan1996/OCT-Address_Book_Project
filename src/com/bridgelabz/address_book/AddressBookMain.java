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
					"1. Add AddressBook \n2. View AddressBook \n3. View the Person in the City or State \n4. View the Person by City and State \n5. Exit from the Address Book program");
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
				break;
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
				/* Ability to view Persons by City or State - Maintain Dictionary of City and */

				System.out.println("Enter option to view by city or state: ");
				String searchChoice = sc.next();

				if (searchChoice.equalsIgnoreCase("City")) {

					System.out.print(" Enter city : ");
					String city = sc.next();

					mapAddressBook.values().stream().forEach((addressBook) -> {

						addressBook.cityPersonMap.entrySet().stream().filter((searchCity) ->

						searchCity.getKey().equalsIgnoreCase(city)

						).forEach((filteredCity) -> System.out.println(filteredCity));

					}

					);

				} else if (searchChoice.equalsIgnoreCase("State")) {

					System.out.print(" Enter state : ");
					String state = sc.next();

					mapAddressBook.values().stream().forEach((addressBook) -> {

						addressBook.statePersonMap.entrySet().stream().filter((searchState) ->

						searchState.getKey().equalsIgnoreCase(state)

						).forEach((filteredState) -> System.out.println(filteredState));

					}

					);

				} else {
					System.out.println("Incorrect selection. Please select City or State");
				}

			}
				/* Ability to view Persons by City or State - Maintain Dictionary of City and */
				/*
				 * System.out.println("Persons According to Name and City: ");
				 * 
				 * mapAddressBook.values().stream().forEach(i1 -> { i1.contactsList.stream()
				 * .forEach(i2 -> System.out.println("Name: " + i2.getFirstName() + " City: " +
				 * i2.getCity())); });
				 * 
				 * System.out.println("Persons According to Name and State: ");
				 * mapAddressBook.values().stream().forEach(i1 -> {
				 * i1.contactsList.stream().forEach( i2 -> System.out.println("Name: " +
				 * i2.getFirstName() + " State: " + i2.getState())); });
				 * 
				 * /* Ability to get number of contact persons i.e. count by City or State
				 */

				/*
				 * System.out.println("Ent"); mapAddressBook.values().stream().forEach(i1 -> {
				 * i1.contactsList.stream() .forEach(i2 -> System.out.println("Name: " +
				 * i2.getFirstName() + " City: " + i2.getCity())); });
				 * 
				 * }
				 */

				break;
			case 5: {
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