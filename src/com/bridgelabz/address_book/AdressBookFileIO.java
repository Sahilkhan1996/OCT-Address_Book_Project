package com.bridgelabz.address_book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class AdressBookFileIO {
	public static final String DIR_PATH = "AddressBookDirectory/";

	public static void writeAddressBookData(Map<String, AddressBook> map) {

		Path directoryPath = Paths.get(DIR_PATH);

		System.out.println("Does " + DIR_PATH + " exist ? " + Files.exists(directoryPath));

		if (Files.notExists(directoryPath)) {

			try {
				Files.createDirectories(directoryPath);

			} catch (IOException e) {
				e.printStackTrace();

			}

		} else {
			try {
				for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

					String fileName = pair.getKey() + ".txt";
					Path filePath = Paths.get(DIR_PATH + fileName);

					if (Files.notExists(filePath)) {

						Files.createFile(filePath);

						StringBuffer addressBookBuffer = new StringBuffer();

						for (Contacts contacts : pair.getValue().contactsList) {

							addressBookBuffer.append("First Name: "+contacts.getFirstName() + "\t Last Name: " + contacts.getLastName() + "\t Email Address:"
									+ contacts.getEmail() + "\t Mobile Number: " + contacts.getPhoneNumber() + "\t Zip: " + contacts.getZip()
									+ "\t City: " + contacts.getCity() + "\t State: " + contacts.getState() + "\t Address: "
									+ contacts.getAddress() + "\n");

						}

						Files.write(filePath, addressBookBuffer.toString().getBytes());

					}

				}

			} catch (IOException e) {
				e.printStackTrace();

			}

		}

	}

	public static void readAddressBookData(Map<String, AddressBook> map) {

		try {

			for (Map.Entry<String, AddressBook> pair : map.entrySet()) {

				String addressBookPath = DIR_PATH + pair.getKey() + ".txt";
				System.out
						.println("----------- Contacts under Address Book :" + pair.getKey() + " ------------" + "\n");
				Stream<String> arr = Files.lines(new File(addressBookPath).toPath());
				arr.forEach(System.out::println);
				arr.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
