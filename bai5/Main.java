package baitapcolection.bai5;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 8, 15);
        LocalDate date2 = LocalDate.of(2023, 7, 15);
        LocalDate date3 = LocalDate.of(2024, 8, 15);
        Purchase purchases1 = new Purchase(1,"Iphone",100000,date1);
        Purchase purchases2 = new Purchase(2,"Laptop",100000, date2);
        Purchase purchases3 = new Purchase(3,"Laptop",20000,date3);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchases1);
        purchases.add(purchases2);
        List<Purchase> purchasesList = new ArrayList<>();
        purchasesList.add(purchases3);
        Customer customer1 = new Customer(1,"Minh","minhokmen1@gmail.com",purchases);
        Customer customer2 = new Customer(2,"Minh","minhokmen2@gmail.com",purchasesList);
        Customer customers = new Customer();
        customers.addKh(customer1);
        customers.addKh(customer2);
        Set<Customer> customerList = new HashSet<>();
        customerList = customers.listCustomer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id cần tìm kiếm");
        int id = sc.nextInt();
        customers.searchForId(id);
        System.out.println("Nhập id khách hàng");
        int idKh= sc.nextInt();
        System.out.println("Giao dịch của khách hàng là");
        customers.giaoDich(idKh);
        System.out.println("Nhập năm start");
        int namStart = sc.nextInt();
        System.out.println("Nhập tháng start");
        int thangStart = sc.nextInt();
        System.out.println("Nhập ngày start");
        int dayStart = sc.nextInt();
        System.out.println("Nhập năm kết thúc");
        int namEnd = sc.nextInt();
        System.out.println("Nhập tháng kết thúc");
        int thangEnd = sc.nextInt();
        System.out.println("Nhập ngày kết thúc");
        int ngayEnd = sc.nextInt();
        LocalDate startDate = LocalDate.of(namStart,thangStart,dayStart);
        LocalDate endDate = LocalDate.of(namEnd,thangEnd,ngayEnd);
        Set<Purchase> listPur = new HashSet<>();
        for(Customer customer:customerList){
            for(Purchase purchase:customer.getPurchaseHistory()){
                listPur.add(purchase);
            }
        }
          Purchase purchase = new Purchase();
        System.out.println("Trong khoảng thời gian gồm các sản phẩm là ");
        purchase.filterDate(listPur,startDate,endDate);
    }
}
