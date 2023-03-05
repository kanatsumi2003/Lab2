
package menu;

import java.util.Scanner;
import global.Global;
import dao.ProductDAOImplements;

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
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Global.productDao.printAllProduct();
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

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

}
