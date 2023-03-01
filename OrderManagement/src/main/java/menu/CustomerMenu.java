/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.Scanner;
import global.Global;
import dao.CustomerDAOImplements;
import io.CustomerReader;
/**
 *
 * @author apple
 */
public class CustomerMenu implements Menu {

    private Menu parent;
    CustomerReader read = new CustomerReader();
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public Menu run() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----------Customer Menu----------");
        System.out.println("1. List all Customers");
        System.out.println("2. Search a Customer based on ID");
        System.out.println("3. Add a Customer");
        System.out.println("4. Update a Customer");
        System.out.println("5. Save Customers to file");
        System.out.println("9. Back to main menu");
        System.out.println("0. Exit the program");
        System.out.println("---------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Global.customerDao.printAllCustomers();
                return this;
            case 2:
                System.out.print("Input customer's ID: ");
                String customerID = sc1.nextLine();
                Global.customerDao.searchCustomer(customerID);
                return this;
            case 3:
                Global.customerDao.addCustomer();
                return this;
            case 4:
                Global.customerDao.updateCustomer();
                return this;
            case 5:
                Global.customerDao.saveCustomer();
                return this;
            case 9:
                return parent;
            case 0:
                return null;
            default:
                System.out.println("Wrong input, please try again!");
                return this;
        }
    }

}
