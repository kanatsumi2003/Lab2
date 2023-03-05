package ordermanagement;

import menu.*;
import dao.*;
import global.Global;

public class OrderManagement {

    public static void main(String[] args) {
        CustomerDAO customerDAO = null;
        OrderDAO orderDAO = null;
        ProductDAO productDAO = null;
        try {
            customerDAO = new CustomerDAOImplements();
            productDAO = new ProductDAOImplements();
            orderDAO = new OrderDAOImplements();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Global.customerDao = customerDAO;
        Global.productDao = productDAO;
        Global.orderDao = orderDAO;
        MainMenu mainMenu = new MainMenu();
        CustomerMenu customerMenu = new CustomerMenu();
        OrderMenu orderMenu = new OrderMenu();
        ProductMenu productMenu = new ProductMenu();
        mainMenu.setCustomerMenu(customerMenu);
        mainMenu.setOrderMenu(orderMenu);
        mainMenu.setProductMenu(productMenu);
        customerMenu.setParent(mainMenu);
        orderMenu.setParent(mainMenu);
        productMenu.setParent(mainMenu);

        Menu menu = mainMenu;
        while (menu != null) {
            menu = menu.run();
        }
    }
}
