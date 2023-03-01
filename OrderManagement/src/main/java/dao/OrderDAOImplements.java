/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;

import information.Order;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import io.OrderReader;
/**
 *
 * @author apple
 */
public class OrderDAOImplements implements OrderDAO {

    public ArrayList<Order> order = new ArrayList<>();
    public static final String orderFile = "orders.txt";

    public OrderDAOImplements() {
        this.order = load();
    }

    @Override
    public void printAllOrder() {
        OrderReader function = new OrderReader();
        function.ascendingSort();
    }

    @Override
    public void printAllPendingOrder() {
        for(Order o : order){
            if(o.getStatus() == false){
                System.out.println(o.toString());
            }
        }
    }

    @Override
    public void addOrder() {
        OrderReader reader = new OrderReader();
        this.order.add(reader.inputAnOrder());
        for(int i = 0; i < order.size(); i++){
            System.out.println(order.get(i).toString());
        }
    }

    @Override
    public void updateOrder() {
    }

    @Override
    public void saveOrder() {
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
}
