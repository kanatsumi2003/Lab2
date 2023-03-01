/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author apple
 */
public class MainMenu implements Menu{
    private Menu parent;
    private Menu customerMenu;
    private Menu productMenu;
    private Menu orderMenu;

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Menu getCustomerMenu() {
        return customerMenu;
    }

    public void setCustomerMenu(Menu customerMenu) {
        this.customerMenu = customerMenu;
    }

    public Menu getProductMenu() {
        return productMenu;
    }

    public void setProductMenu(Menu productMenu) {
        this.productMenu = productMenu;
    }

    public Menu getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(Menu orderMenu) {
        this.orderMenu = orderMenu;
    }
    @Override
    public Menu run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----------Main Menu----------");
        System.out.println("1: Customer menu");
        System.out.println("2: Product menu");
        System.out.println("3: Order menu");
        System.out.println("9: Exit program");
        System.out.println("------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return this.customerMenu;
            case 2:
                return this.productMenu;
            case 3:
                return this.orderMenu;
            case 9:
                return null;
            default:
                System.out.println("Wrong input, please try again!");
                return this;
        }
    }
            
}
