package com.brigelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public void addContact(){
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
}
