/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package information;

/**
 *
 * @author apple
 */
public class Product {

    private String productID;
    private String productName;
    private String unit;
    private String origin;
    private double price;

    public Product() {
    }

    public Product(String productID, String productName, String unit, String origin, double price) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.origin = origin;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", unit=" + unit + ", origin=" + origin + ", price=" + price + '}';
    }

}
