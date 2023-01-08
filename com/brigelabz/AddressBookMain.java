package com.brigelabz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    static HashMap<String,AddressBook> addressBookMap=new HashMap<>();
    static HashMap<String,ArrayList<Contact>> addressBookNames= new HashMap<String,ArrayList<Contact>>();
    public static void main(String[] args) throws IOException {
        AddressBook familyBook = new AddressBook();
        System.out.println("Welcome in AddressBook system");
        Scanner scanner = new Scanner(System.in);
        int operation;
        do {
            System.out.println("1. ADD CONTACT " +
                    "\n2. DISPLAY All  AddressBooks  " +
                    "\n3 Search information of addressBook  " +
                    "\n4 delete contact in Address Books " +
                    "\n5 Display  Address Book"+
                    "\n6 Add new Address Book"+
                    "\n7. EXIT " );


            System.out.println("Enter the Operation Number");
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    scanner.nextLine();
                    if(addressBookNames.isEmpty()){
                        System.out.println("Creating your New Address Book ");
                        System.out.println("Enter a address book Name");
                        String name3 = scanner.nextLine();
                        addressBookNames.put(name3,familyBook.crateNewAddressBook());
                    }
                    System.out.println("your Address Book Names");
                    for (String addressBookName : addressBookNames.keySet()){
                        System.out.println(addressBookName);
                    }
                    System.out.println("Choice one upper address Book name");
                    String name = scanner.nextLine();
                    addressBookNames.put(name,familyBook.addContact(addressBookNames.get(name)));
                    break;
                case 2:
                    for (Map.Entry<String, AddressBook> set : addressBookMap.entrySet()) {
                        System.out.println(set.getKey() + "=" + set.getValue());
                    }
                    break;
                case 3:
                    familyBook.searchPerson(addressBookNames);
                    break;
                case 4:
                    String addressBook = scanner.nextLine();
                    //addressBookNames.put(name,familyBook.addContact(addressBookNames.get(name)));
                    familyBook.deleteContact();
                    break;
                case 5:
                    if(addressBookNames.isEmpty()){
                        System.out.println("Address Book is empty !");
                    }
                    System.out.println("Choice your Address Book Name you want to print ");
                    for (String addressBookName : addressBookNames.keySet()){
                        System.out.println(addressBookName);
                    }
                    scanner.nextLine();
                    String name1 = scanner.nextLine();
                    familyBook.displayMyAddressBook(addressBookNames.get(name1));
                    break;
                case 6:
                    System.out.println("Enter a address book Name");
                    scanner.nextLine();
                    String name2 = scanner.nextLine();
                    addressBookNames.put(name2,familyBook.crateNewAddressBook());
                    break;
                case 7:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Operation Number");
            }
        } while (operation != 7);
        familyBook.addAddressBookMap(familyBook);
        System.out.println("Before writing our file ");
        familyBook.writeAddressBookFile(addressBookNames);
        familyBook.readAddressBookFile();

    }
}

