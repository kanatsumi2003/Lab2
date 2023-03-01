/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author apple
 */
public interface CustomerDAO {
    void printAllCustomers();
    void searchCustomer(String customerID);
    void addCustomer();
    void updateCustomer();
    void saveCustomer();
}
