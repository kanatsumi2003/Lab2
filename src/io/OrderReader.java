package io;

import dao.*;
import information.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OrderReader {

    OrderDAOImplements orderFunction;
    CustomerDAOImplements customerFunction;
    ProductDAOImplements productFunction;
    ArrayList<Order> tmpOrder = orderFunction.order;

    public void ascendingSort() {
        for (int i = 0; i < customerFunction.customer.size(); i++) {
            for (int j = i + 1; j < customerFunction.customer.size(); j++) {
                String s1 = customerFunction.customer.get(i).getCustomerName().toUpperCase();
                String s2 = customerFunction.customer.get(j).getCustomerName().toUpperCase();
                if (s2.compareTo(s1) < 0) {
                    Customer temp = customerFunction.customer.get(j);
                    customerFunction.customer.set(j, customerFunction.customer.get(i));
                    customerFunction.customer.set(i, temp);
                }
            }
        }
        System.out.println("Result:\n");
        for (int i = 0; i < customerFunction.customer.size(); i++) {
            for (int j = 0; j < orderFunction.order.size(); j++) {
                if (customerFunction.customer.get(i).getCustomerID().equals(orderFunction.order.get(j).getCustomerID())) {
                    System.out.println(orderFunction.order.get(j).toString());
                }
            }
        }
    }
    // Order id

    public boolean checkDuplicated(String id) {
        Boolean check = false;
        for (int index = 0; index < orderFunction.order.size(); index++) {
            if (id.equals(orderFunction.order.get(index).getOrderID())) {
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
        Pattern patternID = Pattern.compile("^[D]+[0-9]{3}$");
        if (patternID.matcher(id).find()) {
            check = true;
        }
        return check; // true if match with pattern
    }
    // Order quantity

    public int addQuantity() {
        Scanner sc = new Scanner(System.in);
        int orderQuantity = -1;
        try {
            orderQuantity = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Number only!");
        }
        return orderQuantity;
    }
    // Order date

    public String addDate() {
        Scanner sc = new Scanner(System.in);
        String orderDate = sc.nextLine();
        return orderDate.trim();
    }

    public Boolean checkDate(String date) {
        Boolean check = false;
        Pattern patternDate = Pattern.compile("^[^00][0-9]{1,2}[/]+[^00][0-9]{1,2}[/]+[0-9]{1,4}$");
        if (patternDate.matcher(date).find()) {
            check = true;
        }
        return check;
    }
    // Order status

    public Boolean addStatus() {
        Scanner sc = new Scanner(System.in);
        Boolean orderStatus = false;
        try {
            orderStatus = sc.nextBoolean();
        } catch (Exception e) {
            System.out.println("Default status: false");
        }
        return orderStatus;
    }
    // Order CustomerID

    public String addCustomerID() {
        Scanner sc = new Scanner(System.in);
        String customerID = sc.nextLine();
        for (int index = 0; index < customerFunction.customer.size(); index++) {
            if (customerFunction.customer.get(index).getCustomerID().equals(customerID)) {
                return customerID;
            }
        }
        return null;
    }

    // Order ProductId
    public String addProductID() {
        Scanner sc = new Scanner(System.in);
        String productID = sc.nextLine();
        for (int index = 0; index < productFunction.product.size(); index++) {
            if (productFunction.product.get(index).getProductID().equals(productID)) {
                return productID;
            }
        }
        return null;
    }

    // Add an order
    public Order inputAnOrder() {
        Scanner sc = new Scanner(System.in);
        Order tmp = null;
        Boolean check = true;

        while (tmp == null) {
            // OrderID
            String orderID = null;
            while (orderID == null) {
                System.out.print("Input Order's ID: ");
                orderID = addID();
                if (!checkID(orderID)) {
                    System.out.println("ID Format: Dxxx (x are numbers)");
                    orderID = null;
                }
            }

            // Order CustomerID
            String orderCustomerID = null;
            do {
                System.out.println("\n1. Add CustomerID to an order");
                System.out.println("2. View all existed Customer");
                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        do {
                            System.out.print("Input Order's CustomerID: ");
                            orderCustomerID = addCustomerID();
                            if (orderCustomerID == null) {
                                System.out.println("CustomerID not found!");
                            }
                        } while (orderCustomerID == null);
                        check = false;
                        break;
                    case 2:
                        for (int i = 0; i < customerFunction.customer.size(); i++) {
                            System.out.println(customerFunction.customer.get(i).toString());
                        }
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
            } while (check == true);

            // Order Product
            String orderProductID = null;
            check = true;
            do {
                System.out.println("\n1. Add ProductID to an order");
                System.out.println("2. View all existed Product");
                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        do {
                            System.out.print("Input Order's ProductID: ");
                            orderProductID = addProductID();
                            if (orderProductID == null) {
                                System.out.println("ProductID not found!");
                            }
                        } while (orderProductID == null);
                        check = false;
                        break;
                    case 2:
                        for (int i = 0; i < productFunction.product.size(); i++) {
                            System.out.println(productFunction.product.get(i).toString());
                        }
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
            } while (check == true);

            // Order quantity
            System.out.print("Input Order's quantity: ");
            int orderQuantity = addQuantity();

            // Order date
            System.out.print("Input Order's date: ");
            String orderDate = addDate();
            if (!checkDate(orderDate)) {
                System.out.println("format: dd/mm/yyyy");
            }

            // Order status
            System.out.print("Input Order's status: ");
            Boolean status = addStatus();
            if (checkID(orderID) && checkDate(orderDate)) {
                tmp = new Order(orderID, orderCustomerID, orderProductID, orderQuantity, orderDate, status);
            }
        }
        return tmp;
    }

    public void deleteAnOrder() {
        Scanner sc = new Scanner(System.in);
        Boolean check = false;
        System.out.print("Input OrderID: ");
        String orderID = sc.nextLine();
        for (int i = 0; i < orderFunction.order.size(); i++) {
            if (orderFunction.order.get(i).getOrderID().equals(orderID)) {
                orderFunction.order.remove(i);
                check = true;
                System.out.println("Deleted!");
            }
        }
        if (check == false) {
            System.out.println("OrderID not found");
        }
    }

    public String updateCustomerID(int index) {
        String customerID = null;
        while (customerID == null) {
            System.out.print("Input new CustomerID: ");
            customerID = addCustomerID();
            if (customerID == null) {
                System.out.println("Customer ID not found!");
            }
        }
        return customerID;
    }

    public String updateProductID(int index) {
        String productID = null;
        while (productID == null) {
            System.out.print("Input new ProductID: ");
            productID = addProductID();
            if (productID == null) {
                System.out.println("Product ID not found!");
            }
        }
        return productID;
    }

    public int updateOrderQuantity(int index) {
        int orderQuantity = -1;
        while (orderQuantity == -1) {
            System.out.print("Input new Order Quantity: ");
            orderQuantity = addQuantity();
        }
        return orderQuantity;
    }

    public String updateOrderDate(int index) {
        String orderDate = null;
        while (orderDate == null) {
            System.out.print("Input new Order Date: ");
            orderDate = addDate();
            if (!checkDate(orderDate)) {
                orderDate = null;
                System.out.println("format: dd/mm/yyyy");
            }
        }
        return orderDate;
    }

    public Boolean updateOrderStatus(int index) {
        Boolean orderStatus = null;
        while(orderStatus == null){
            System.out.print("Input new Order Status: ");
            orderStatus = addStatus();
        }
        return orderStatus;
    }
    public int indexOfOrder(String id){
        int pos = -1;
        for(int index = 0; index < orderFunction.order.size(); index++){
            if(orderFunction.order.get(index).getOrderID().equals(id)){
                pos = index;
            }
        }
        return pos;
    }
}
