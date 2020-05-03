package eip.fileintegration.mom;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernestoexposito
 */
public class Product implements Serializable {

    private int productId;
    private String productDescription;
    private float productPrice;
    private int productAmount;
    // a delimiter to be used to export of products within a String
    private final static String DELIMITER = ",";

    public Product(int productId, String productDescription, float productPrice, int productAmount) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    // a new method creating a String with the product attributes
    public String productToString() {
        return this.getProductId() + DELIMITER
                + this.getProductDescription() + DELIMITER
                + this.getProductAmount() + DELIMITER
                + this.getProductPrice();
    }

    // a new static method creating and returning a product from a String
    public static Product stringToProduct(String line) {
        String[] results = line.split(DELIMITER);
        return new Product(Integer.parseInt(results[0]),
                results[1],
                Float.parseFloat(results[2]),
                Integer.parseInt(results[2]));
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the productPrice
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productAmount
     */
    public int getProductAmount() {
        return productAmount;
    }

    /**
     * @param productAmount the productAmount to set
     */
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

}
