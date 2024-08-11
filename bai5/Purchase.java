package baitapcolection.bai5;

import java.time.LocalDate;
import java.util.*;

public class Purchase {
    private int purchaseId;
    private String productName;
    private double price;
    private LocalDate date;

    public Purchase() {
    }

    public Purchase(int purchaseId, String productName, double price, LocalDate date) {
        this.purchaseId = purchaseId;
        this.productName = productName;
        this.price = price;
        this.date = date;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void filterDate(Set<Purchase> purchases,LocalDate startDate,LocalDate endDate){
       for(Purchase purchase:purchases){
           if(!purchase.getDate().isBefore(startDate)&&!purchase.getDate().isAfter(endDate)){
               System.out.println(purchase);
           }
       }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchaseId);
    }

    @Override
    public String toString() {
        return "" +
                "purchaseId=" + purchaseId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
