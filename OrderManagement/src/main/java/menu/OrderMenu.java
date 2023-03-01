/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.Scanner;
import global.Global;
/**
 *
 * @author apple
 */
public class OrderMenu implements Menu {

    private Menu parent;

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public Menu run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----------Order Menu----------");
        System.out.println("1. List all Orders in ascending order of Customer name");
        System.out.println("2. List all pending Orders");
        System.out.println("3. Add an Order");
        System.out.println("4. Update an Order");
        System.out.println("5. Save Order to file");
        System.out.println("9. Back to main menu");
        System.out.println("------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Global.orderDao.printAllOrder();
                return this;
            case 2:
                Global.orderDao.printAllPendingOrder();
                return this;
            case 3:
                Global.orderDao.addOrder();
                return this;
            case 4:
                System.out.println("1. Update an Order based on ID");
                System.out.println("2. Delete an Order based on ID");
                int choice2 = sc.nextInt();
                switch (choice2) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    default:
                        throw new AssertionError();
                }
                return this;
            case 5:
                
                return this;
            case 9:
                return parent;
            default:
                return this;
        }
    }

}
