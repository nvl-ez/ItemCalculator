/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itemcalculator;

/**
 *
 * @author nahu
 */
public class Summary {
    private int amount;
    private double pricePerUnit;
    private int orders;

    public Summary(int amount, double pricePerUnit, int orders) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
        this.orders = orders;
    }

    // Getters
    public int getAmount() {
        return amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getOrders() {
        return orders;
    }

    // Setters
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
}