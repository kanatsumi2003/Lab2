package dao;

import information.Order;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import io.OrderReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class OrderDAOImplements implements OrderDAO {

    public static ArrayList<Order> order = new ArrayList<>();
    public static final String orderFile = "orders.txt";

    public OrderDAOImplements() {
        this.order = load();
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    @Override
    public void printAllOrder() {
        OrderReader function = new OrderReader();
        function.ascendingSort();
    }

    @Override
    public void printAllPendingOrder() {
        OrderReader read = new OrderReader();
        for (Order o : order) {
            if (o.getStatus() == false) {
                System.out.println(o.toString());
            }
        }
    }

    @Override
    public void addOrder() {
        OrderReader reader = new OrderReader();
        this.order.add(reader.inputAnOrder());
        System.out.println("Added!");
    }

    @Override
    public void updateOrder() {
        Scanner sc = new Scanner(System.in);//number
        Scanner sc1 = new Scanner(System.in);//string
        OrderReader read = new OrderReader();
        System.out.println("1. Update an Order based on ID");
        System.out.println("2. Delete an Order based on ID");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Input OrderID: ");
                String orderID = sc1.nextLine();
                int index = read.indexOfOrder(orderID);
                if (index == -1) {
                    System.out.println("Order ID not found!");
                } else {
                    System.out.println("\n");
                    System.out.println("1. Update Order's CustomerID");
                    System.out.println("2. Update Order's ProductID");
                    System.out.println("3. Update Order's Quantity");
                    System.out.println("4. Update Order's Date");
                    System.out.println("5. Update Order's Status");
                    System.out.println("6. Update all Order's information");
                    System.out.print("Your choice: ");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            order.get(index).setCustomerID(read.updateCustomerID(index));
                            System.out.println("Updated successfully");
                            break;
                        case 2:
                            order.get(index).setProductID(read.updateProductID(index));
                            System.out.println("Updated successfully");
                            break;
                        case 3:
                            order.get(index).setOrderQuantity(read.updateOrderQuantity(index));
                            System.out.println("Updated successfully");
                            break;
                        case 4:
                            order.get(index).setOrderDate(read.updateOrderDate(index));
                            System.out.println("Updated successfully");
                            break;
                        case 5:
                            order.get(index).setStatus(read.updateOrderStatus(index));
                            System.out.println("Updated successfully");
                            break;
                        case 6:
                            order.get(index).setCustomerID(read.updateCustomerID(index));
                            order.get(index).setProductID(read.updateProductID(index));
                            order.get(index).setOrderQuantity(read.updateOrderQuantity(index));
                            order.get(index).setOrderDate(read.updateOrderDate(index));
                            order.get(index).setStatus(read.updateOrderStatus(index));
                            System.out.println("Updated successfully");
                    }
                }
                break;
            case 2:
                read.deleteAnOrder();
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void saveOrder() {
        saveOrderToFilE();
        System.out.println("Wrote successfully");
    }

    private ArrayList<Order> load() {
        ArrayList<Order> tmpOrder = new ArrayList<>();
        try {
            FileReader fr = new FileReader(orderFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String tmp[] = line.split(",");
                String orderID = tmp[0];
                String customerID = tmp[1];
                String productID = tmp[2];
                int orderQuantity = Integer.parseInt(tmp[3]);
                String orderDate = tmp[4];
                Boolean status = Boolean.parseBoolean(tmp[5]);
                tmpOrder.add(new Order(orderID, customerID, productID, orderQuantity, orderDate, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpOrder;
    }

    public void saveOrderToFilE() {
        try {
            FileWriter fw = new FileWriter(orderFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Order o : order) {
                bw.write(o.getOrderID() + "," + o.getCustomerID() + "," + o.getProductID() + "," + o.getOrderQuantity() + "," + o.getOrderDate() + "," + o.getStatus());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
