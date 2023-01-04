package com.brigelabz;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static HashMap<String, AddressBook> addressBookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    public ArrayList addContact(ArrayList<Contact> contactList1) {
        Contact contactPerson = new Contact();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of contact person");
        System.out.print("Enter first name:");
        String name = (sc.next());
        if (findDuplicates(name) == true) {
            System.out.println("This Name is already present in your dictionary. please add Another name \n");
        } else {
            contactPerson.setName(name);
            System.out.print("Enter Last name:");
            contactPerson.setSurName(sc.next());
            System.out.print("Enter the Address : ");
            contactPerson.setAddress(sc.next());
            System.out.print("Enter the City : ");
            contactPerson.setCity(sc.next());
            System.out.print("Enter the State : ");
            contactPerson.setState(sc.next());
            System.out.print("Enter the ZipCode : ");
            contactPerson.setZip(sc.next());
            System.out.print("Enter the Mobile no : ");
            contactPerson.setContactNumber(sc.next());

            contactList.add(contactPerson);
            contactList1.add(contactPerson);
        }
        return contactList1;
    }
    private static boolean findDuplicates(String name) {

        return contactList.stream().anyMatch(contact ->contact.getName().equals(name));
    }
    @Override
    public String toString() {
        return "AddressBook{" + "contactList=" + contactList + '}';
    }
    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (Contact contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                System.out.println("What you want to edit for the contact");
                System.out.println("1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7."
                        + "Mobile Number\n8.Email id");
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
    public void addAddressBookMap(AddressBook ad) {
        System.out.println("Enter your Addres Book name ");
        String name = sc.nextLine();
        addressBookMap.put(name, ad);
    }
    public void displayMyAddressBook(ArrayList<Contact> arrayList) {
        System.out.println("My Address Books");
        System.out.println(addressBookMap.keySet());
        for (Contact key : arrayList) {
            System.out.println(key);
        }
    }
    public ArrayList crateNewAddressBook() {
        ArrayList addressBookName = new ArrayList();
        return addressBookName;
    }

    public void searchPerson(HashMap<String, ArrayList<Contact>> addressBookNames) {
        int operation;
        do {
            System.out.println("1.Search in city");
            System.out.println("2.Search in state");
            System.out.println("3.Exit");
            System.out.println();
            System.out.print("Enter option : ");
            Scanner input = new Scanner(System.in);
            operation = input.nextInt();
            switch (operation) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter City ! ");
                    String cityName = scanner.nextLine();
                    System.out.println("using this city and  below records are found ");
                    for (String addressBookName : addressBookNames.keySet()) {
                        System.out.println(addressBookName);
                        ArrayList<Contact> con = addressBookNames.get(addressBookName);
                        con.stream().filter(city -> city.getCity().equalsIgnoreCase(cityName))
                                .forEach(x -> System.out.println(x));
                    }
                    break;
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Enter State ! ");
                    String stateName = scanner1.nextLine();
                    System.out.println("using this state and  below records are found ");
                    for (String addressBookName : addressBookNames.keySet()) {
                        System.out.println(addressBookName);
                        ArrayList<Contact> contact1 = addressBookNames.get(addressBookName);
                        contact1.stream().filter(state -> state.getState().equalsIgnoreCase(stateName))
                                .forEach(x -> System.out.println(x));
                    }
                    break;
                case 3:
                    System.out.println("Exist");
                    break;

            }
        }
        while (operation != 3) ;
    }
}