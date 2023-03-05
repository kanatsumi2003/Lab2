
package menu;

import java.util.Scanner;
import global.Global;

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
        System.out.println("0. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choice: ");
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
                Global.orderDao.updateOrder();
                return this;
            case 5:
                Global.orderDao.saveOrder();
                return this;
            case 9:
                return parent;
            case 0:
                return null;
            default:
                return this;
        }
    }

}
