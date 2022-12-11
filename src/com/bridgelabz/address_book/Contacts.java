package com.bridgelabz.address_book;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Contacts {
	static Scanner sc = new Scanner(System.in);
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phoneNumber;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void editingContact() {
		try {
			System.out.println("Please enter the first name: ");
			setFirstName(sc.next());
			System.out.println("Please enter the last name: ");
			setLastName(sc.next());
			System.out.println("Please enter the Address: ");
			setAddress(sc.next());
			System.out.println("Please enter the city: ");
			setCity(sc.next());
			System.out.println("Please enter the state: ");
			setState(sc.next());
			System.out.println("Please enter the zip: ");
			setZip(sc.nextInt());
			System.out.println("Please enter the Phone Number: ");
			setPhoneNumber(sc.nextInt());
			System.out.println("Please enter the email: ");
			setEmail(sc.next());
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(address, city, email, firstName, lastName, phoneNumber, state, zip);
	}

	//UC7: Overriding equals method to check the obj details
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && phoneNumber == other.phoneNumber
				&& Objects.equals(state, other.state) && zip == other.zip;
	}

	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
