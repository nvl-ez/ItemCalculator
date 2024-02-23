/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itemcalculator;

import java.util.List;

/**
 *
 * @author nahu
 */
public class Product {

    private String productId;
    private List<Summary> sellSummary;
    private List<Summary> buySummary;
    private QuickStatus quickStatus;
    private double score;

    public Product(String productId, List<Summary> sellSummary, List<Summary> buySummary, QuickStatus quickStatus) {
        this.productId = productId;
        this.sellSummary = sellSummary;
        this.buySummary = buySummary;
        this.quickStatus = quickStatus;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public List<Summary> getSellSummary() {
        return sellSummary;
    }

    public List<Summary> getBuySummary() {
        return buySummary;
    }

    public QuickStatus getQuickStatus() {
        return quickStatus;
    }


    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSellSummary(List<Summary> sellSummary) {
        this.sellSummary = sellSummary;
    }

    public void setBuySummary(List<Summary> buySummary) {
        this.buySummary = buySummary;
    }

    public void setQuickStatus(QuickStatus quickStatus) {
        this.quickStatus = quickStatus;
    }
}
