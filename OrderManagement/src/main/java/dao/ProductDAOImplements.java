/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import information.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**e
 *
 * @author apple
 */
public class ProductDAOImplements implements ProductDAO {

    public ArrayList<Product> product;
    private static final String productFile = "products.txt";

    public ProductDAOImplements() {
        this.product = load();
    }

    @Override
    public void printAllProduct() {
        for (Product p : product) {
            System.out.println(p.toString());
        }
    }

    private ArrayList<Product> load() {
        ArrayList<Product> tmpProduct = new ArrayList<>();
        try {
            FileReader fr = new FileReader(productFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String tmp[] = line.split(",");
                String productID = tmp[0];
                String productName = tmp[1];
                String unit = tmp[2];
                String origin = tmp[3];
                double price = Double.parseDouble(tmp[4]);
                tmpProduct.add(new Product(productID, productName, unit, origin, price));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpProduct;
    }
}
