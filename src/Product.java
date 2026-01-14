/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ishar
 */
public abstract class Product {
    protected String name;
    protected int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public abstract String getType();

    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public int getQuantity() {
        return quantity;
    }
}

