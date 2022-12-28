package com.brigelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
   
    public void addContact() {
        Contact contactPerson = new Contact();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of contact person");
        System.out.print("Enter first name:");
        contactPerson.setName(sc.next());
        System.out.print("Enter Last name:");
        contactPerson.setSurName(sc.next());
        System.out.print("Enter the Address : ");
        contactPerson.setAddress(sc.next());
        System.out.print("Enter the City : ");
        contactPerson.setCity(sc.next());
        System.out.print("Enter the State : ");
        System.out.println();
        contactPerson.setState(sc.next());
        System.out.print("Enter the ZipCode : ");
        contactPerson.setZip(sc.next());
        System.out.print("Enter the Mobile no : ");
        contactPerson.setContactNumber(sc.next());
        contactList.add(contactPerson);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contactList=" + contactList +
                '}';
    }

    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (Contact contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                System.out.println("What you want to edit for the contact");
                System.out.println("1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7." +
                        "Mobile Number\n8.Email id");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the First Name :");
                        contactPerson.setName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the Last Name :");
                        contactPerson.setSurName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the Address :");
                        contactPerson.setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the City :");
                        contactPerson.setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the State :");
                        contactPerson.setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter the Zip code :");
                        contactPerson.setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the Mobile Number :");
                        contactPerson.setContactNumber(sc.next());
                        break;
                }
            }
        }
    }

    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (Contact contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                contactList.remove(contactPerson);
                break;
            }
        }
    }
}
