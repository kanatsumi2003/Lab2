/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author apple
 */
public interface OrderDAO {
    void printAllOrder();
    void printAllPendingOrder();
    void addOrder();
    void updateOrder();
    void saveOrder();
}
