package baitapcolection.bai5;

import baitapcolection.bai3.Song;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private List<Purchase> purchaseHistory;
    private Set<Customer> customers = new HashSet<>();

    public Customer() {
    }

    public Customer(int customerId, String name, String email, List<Purchase> purchaseHistory) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.purchaseHistory = purchaseHistory;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public Set<Customer> addKh (Customer obj){
          for(Customer customer:customers){
              if(customer.getCustomerId() == obj.getCustomerId()|| Objects.equals(customer.getEmail(),obj.getEmail())){
                  return customers;
              }
          }
          customers.add(obj);
          return customers;
    }
    public Set<Customer> listCustomer(){
        Set<Customer> listCus = new HashSet<>();
            for(Customer cus:customers){
                listCus.add(cus);
            }
        return listCus;
    }
    public void searchForId(int id){
        boolean isId = false;
        for(Customer cus:listCustomer()){
            if(id == cus.getCustomerId()){
                System.out.println(cus);
                isId = true;
            }
        }
        if(!isId){
            System.out.println("Không tồn tại id");
        }
    }
    public void giaoDich(int id){
        boolean isId = false;
        double sum = 0;
        for(Customer cus:listCustomer()){
            if(id == cus.getCustomerId()){
              for(Purchase purchase:cus.getPurchaseHistory()){
                  System.out.println(purchase);
                  sum+=purchase.getPrice();
              }
                isId = true;
            }
        }
        System.out.println("Tổng số tiền giao dịch là: " + sum);
        if(!isId){
            System.out.println("Không tồn tại id");
        }
    }



    @Override
    public String toString() {
        return "{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", purchaseHistory=" + purchaseHistory +
                ", customers=" + customers +
                '}';
    }
}
