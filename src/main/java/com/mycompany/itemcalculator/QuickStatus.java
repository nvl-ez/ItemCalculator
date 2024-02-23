/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itemcalculator;

/**
 *
 * @author nahu
 */
public class QuickStatus {

    private String productId;
    private double sellPrice;
    private int sellVolume;
    private int sellMovingWeek;
    private int sellOrders;
    private double buyPrice;
    private int buyVolume;
    private int buyMovingWeek;
    private int buyOrders;

    public QuickStatus(String productId, double sellPrice, int sellVolume, int sellMovingWeek, int sellOrders,
            double buyPrice, int buyVolume, int buyMovingWeek, int buyOrders) {
        this.productId = productId;
        this.sellPrice = sellPrice;
        this.sellVolume = sellVolume;
        this.sellMovingWeek = sellMovingWeek;
        this.sellOrders = sellOrders;
        this.buyPrice = buyPrice;
        this.buyVolume = buyVolume;
        this.buyMovingWeek = buyMovingWeek;
        this.buyOrders = buyOrders;
        //System.out.println("QUICK_STATS: prodctID "+productId+" | sellPrice "+sellPrice+" | sellVolume "+sellVolume
        //+" | sellMovingWeek "+sellMovingWeek+" | sellOrders "+sellOrders+" | buyPrice "+buyPrice
        //+" | buyVolume "+buyVolume+" | buyMovingWeek "+buyMovingWeek+" | buyOrders "+buyOrders);
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getSellVolume() {
        return sellVolume;
    }

    public int getSellMovingWeek() {
        return sellMovingWeek;
    }

    public int getSellOrders() {
        return sellOrders;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public int getBuyVolume() {
        return buyVolume;
    }

    public int getBuyMovingWeek() {
        return buyMovingWeek;
    }

    public int getBuyOrders() {
        return buyOrders;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setSellVolume(int sellVolume) {
        this.sellVolume = sellVolume;
    }

    public void setSellMovingWeek(int sellMovingWeek) {
        this.sellMovingWeek = sellMovingWeek;
    }

    public void setSellOrders(int sellOrders) {
        this.sellOrders = sellOrders;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setBuyVolume(int buyVolume) {
        this.buyVolume = buyVolume;
    }

    public void setBuyMovingWeek(int buyMovingWeek) {
        this.buyMovingWeek = buyMovingWeek;
    }

    public void setBuyOrders(int buyOrders) {
        this.buyOrders = buyOrders;
    }
}
