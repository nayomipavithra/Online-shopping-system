/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ishar
 */
public class Grocery extends Product {
    public Grocery(String name, int quantity) {
        super(name, quantity);
    }
    @Override
    public String getType() {
        return "Grocery";
    }
}

