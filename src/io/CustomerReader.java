package io;

import java.util.Scanner;
import dao.CustomerDAOImplements;
import information.Customer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerReader {
    private CustomerDAOImplements function;
    // Name

    public String addName() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return name.trim();
    }

    public Boolean checkName(String name) {
        Boolean check = false;
        Pattern patternName = Pattern.compile("^[a-zA-Z ]{5,32}$");
        if (patternName.matcher(name).find()) {
            check = true;
        }
        return check; // true if name matched
    }

    // ID
    public boolean checkDuplicated(String id) {
        Boolean check = false;
        for (int index = 0; index < function.customer.size(); index++) {
            if (id.equals(function.customer.get(index).getCustomerID())) {
                check = true;
            }
        }
        return check; // true if duplicate
    }

    public String addID() {
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        if (checkDuplicated(id)) {
            System.out.println("This ID is already existed!");
        }
        if (!checkDuplicated(id)) {
            return id.trim();
        }
        return null;
    }

    public Boolean checkID(String id) {
        Boolean check = false;
        Pattern patternID = Pattern.compile("^[C]+[0-9]{3}$");
        if (patternID.matcher(id).find()) {
            check = true;
        }
        return check; // true if match with pattern
    }

    // Address
    public String addAddress() {
        Scanner sc = new Scanner(System.in);
        String address = sc.nextLine();
        return address.trim();
    }

    public Boolean checkAddress(String address) {
        Boolean check = false;
        Pattern patternAddress = Pattern.compile("^[a-zA-z ]+[0-9]*{1,}$");
        if (patternAddress.matcher(address).find()) {
            check = true;
        }
        return check;
    }
    // Phone number

    public String addPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = sc.nextLine();
        return phoneNumber.trim();
    }

    public Boolean checkPhone(String phoneNumber) {
        Boolean check = false;
        Pattern patternPhone = Pattern.compile("^[0-9]{10,12}+$");
        if (patternPhone.matcher(phoneNumber).find()) {
            check = true;
        }
        return check;
    }
    // Add customer

    public Customer inputCustomer() {
        Customer tmp = null;
        while (tmp == null) {
            String customerID = null;
            while (customerID == null) {
                System.out.print("Input customer's ID: ");
                customerID = addID();
            }
            if (!checkID(customerID)) {
                System.out.println("ID Format: Cxxx (x are numbers)");
            }

            System.out.print("Input customer's Name:");
            String customerName = addName();
            if (!checkName(customerName)) {
                System.out.println("(5-32) length of digits without numbers!");
            }

            System.out.print("Input customer's Address: ");
            String customerAddress = addAddress();
            if (!checkAddress(customerAddress)) {
                System.out.println("Do not let address null");
            }

            System.out.print("Input customer's Phone number:");
            String customerPhone = addPhoneNumber();
            if (!checkPhone(customerPhone)) {
                System.out.println("Phone nunber in range [10,12]");
            }

            if (checkID(customerID) && checkName(customerName) && checkAddress(customerAddress)
                    && checkPhone(customerPhone)) {
                tmp = new Customer(customerID, customerName, customerAddress, customerPhone);
                System.out.println("Added successfully");
            } else {
                System.out.println("Failed in adding new customer\n");
            }
        }
        return tmp;
    }

//  
    public String updateCustomerName(int index) {
        String customerName = null;
        while (customerName == null) {
            System.out.print("Input new Customer's name: ");
            customerName = addName();
            if (!checkName(customerName)) {
                customerName = null;
                System.out.println("(5-32) length of digits without numbers!");
                System.out.println("Fail in updating!");
            }
        }
        return customerName;
    }

    public String updateCustomerAddress(int index) {
        String customerAddress = null;
        while (customerAddress == null) {
            System.out.print("Input new Customer's Address: ");
            customerAddress = addAddress();
            if (!checkAddress(customerAddress)) {
                customerAddress = null;
                System.out.println("Do not let address null");
                System.out.println("Fail in updating!");
            }
        }
        return customerAddress;
    }

    public String updateCustomerPhonenumber(int index) {
        String customerPhoneNumber = null;
        while (customerPhoneNumber == null) {
            System.out.print("Input new Customer's Phone number: ");
            customerPhoneNumber = addPhoneNumber();
            if (!checkPhone(customerPhoneNumber)) {
                customerPhoneNumber = null;
                System.out.println("Phone nunber in range [10,12]");
                System.out.println("Fail in updating!");
            }
        }
        return customerPhoneNumber;
    }

    public int indexOfUpdateCustomer(String id) {
        int pos = -1;
        for (int index = 0; index < function.customer.size(); index++) {
            if (function.customer.get(index).getCustomerID().equals(id)) {
                pos = index;
            }
        }
        return pos;
    }

}
