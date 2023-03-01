/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;

import information.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import io.CustomerReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ResourceBundle;

/**
 *
 * @author apple
 */
public class CustomerDAOImplements implements CustomerDAO {

    public ArrayList<Customer> customer;
    private static final String customerFile = "customers.txt";

    public CustomerDAOImplements() {
        this.customer = load();
    }

    @Override
    public void printAllCustomers() {
        for (Customer c : customer) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void searchCustomer(String customerID) {
        Boolean check = false;
        for (int index = 0; index < customer.size(); index++) {
            if (customerID.equals(customer.get(index).getCustomerID())) {
                System.out.println(customer.get(index).toString());
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Customer not found");
        }
    }

    @Override
    public void addCustomer() {
        CustomerReader c = new CustomerReader();
        customer.add(c.inputCustomer());
    }

    @Override
    public void updateCustomer() {
        try {
            CustomerReader c = new CustomerReader();
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Customer's ID to update: ");
            String customerID = sc.nextLine();
            int index = c.indexOfUpdateCustomer(customerID);
            if (index == -1) {
                System.out.println("This Customer is not exist!");
            } else {
                System.out.println("\n");
                System.out.println("1. Update Customer's Name");
                System.out.println("2. Update Customer's Address");
                System.out.println("3. Update Customer's Phone number");
                System.out.println("4. Update all Customer's information");
                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        customer.get(index).setCustomerName(c.updateCustomerName(index));
                        System.out.println("Updated successfully!");
                        break;
                    case 2:
                        customer.get(index).setCustomerAddress(c.updateCustomerAddress(index));
                        System.out.println("Updated successfully!");
                        break;
                    case 3:
                        customer.get(index).setCustomerPhoneNumber(c.updateCustomerPhonenumber(index));
                        System.out.println("Updated successfully!");
                        break;
                    case 4:
                        customer.get(index).setCustomerName(c.updateCustomerName(index));
                        customer.get(index).setCustomerAddress(c.updateCustomerAddress(index));
                        customer.get(index).setCustomerPhoneNumber(c.updateCustomerPhonenumber(index));
                        System.out.println("Updated successfully!");
                        break;
                    case 5:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCustomer() {
        saveCustomerToFile();
        System.out.println("Saved successfully!");
    }

    private ArrayList<Customer> load() {
        ArrayList<Customer> tmpCustomer = new ArrayList<>();
        try {
            FileReader fr = new FileReader(customerFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String tmp[] = line.split(",");
                String customerID = tmp[0];
                String custoemrName = tmp[1];
                String customerAddress = tmp[2];
                String customerPhone = tmp[3];
                tmpCustomer.add(new Customer(customerID, custoemrName, customerAddress, customerPhone));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpCustomer;
    }

    private void saveCustomerToFile() {
        try {
            FileWriter fw = new FileWriter(customerFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Customer c : customer) {
                    bw.write(c.getCustomerID() + "," + c.getCustomerName() + ',' + c.getCustomerAddress() + ',' + c.getCustomerPhoneNumber());
                    bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
