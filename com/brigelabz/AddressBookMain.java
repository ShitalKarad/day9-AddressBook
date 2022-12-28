package com.brigelabz;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome in AddressBook system");
        AddressBook familyBook = new AddressBook();
        familyBook.addContact();
        System.out.println(familyBook);

    }

}
