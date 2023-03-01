/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.Scanner;
import global.Global;
import dao.ProductDAOImplements;
/**
 *
 * @author apple
 */
public class ProductMenu implements Menu {

    private Menu parent;
    ProductDAOImplements p = new ProductDAOImplements();
    @Override
    public Menu run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("----------Product Menu----------");
        System.out.println("1. List all product");
        System.out.println("9. Back to main menu");
        System.out.println("--------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Global.productDao.printAllProduct();
                return this;
            case 9:
                return parent;
            default:
                System.out.println("Wrong input, please try again!");

                return this;
        }
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

}
