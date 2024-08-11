package baitapcolection.bai7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Product,StockInfo> products = new HashMap<>();
        boolean isStop = true;
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (isStop) {
            System.out.println("Nhập id sản phầm thứ " + count);
            int id = sc.nextInt();
            System.out.println("Nhập tên sản phẩm thứ " + count);
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Nhập chi tiết sản phẩm thứ " + count);
            String category = sc.nextLine();
            System.out.println("Nhập số lượng sản phẩm thứ " + count);
            int quantity = sc.nextInt();
            System.out.println("Nhập số tiền sp thứ " + count);
            sc.nextLine();
            int price = sc.nextInt();
            if (id > 0 && !name.isEmpty() && !category.isEmpty()) {
                Product product = new Product(id, name, category);
                StockInfo stockInfo = new StockInfo(quantity, price);
                products.put(product, stockInfo);
                count++;
            }
            System.out.println("Nhấn 1 để thoát hoặc enter để tiếp tục");
            sc.nextLine();
            String input = sc.nextLine();
            if (input.equals("1")) {
                break;
            }
        }
        // end while

        System.out.println("Nhập id cần update");
        int id = sc.nextInt();
        if(isId(products,id)){
            System.out.println("Nhập số lượng update");
            sc.nextLine();
            String soLuong = sc.nextLine();
            Integer quanlity = null;
            System.out.println("Nhập số tiền update");
            String gia = sc.nextLine();
            Integer price = null;
            if(!soLuong.isEmpty()&&!gia.isEmpty()){
                 quanlity = Integer.parseInt(soLuong);
                 price = Integer.parseInt(gia);
            }
            System.out.println("Sau khi update");
            System.out.println(updateForId(products,id,quanlity,price));
        }
        else {
            System.out.println("id ko tồn tại");
        }
        System.out.println("Nhập id tìm kiếm");
        int idSp = sc.nextInt();
        if(isId(products,idSp)){
            System.out.println(disPlayForId(products,idSp));
        }
        else {
            System.out.println("Không tìm thấy id");
        }
        System.out.println("Nhập danh muc");
        sc.nextLine();
        String category = sc.nextLine();
        if(isCategory(products,category)){
            System.out.println(searchForCategory(products,category));
        }
        else {
            System.out.println("Không tìm thấy danh muc");
        }
        int sum=0;
        for(Product product:products.keySet()){
            sum+=products.get(product).getPrice();
        }
        System.out.println("tổng giá trị của tất cả sản phẩm trong kho");
        System.out.println(sum);

    }
    public static boolean isId(Map<Product,StockInfo> products,int id){
        boolean isTrue = false;
        for (Product product : products.keySet()) {
            if(product.getProductId() == id){
                isTrue=true;
            }
        }
        return isTrue;
    }
    public static boolean isCategory(Map<Product,StockInfo> products,String category){
        boolean isTrue = false;
        for (Product product : products.keySet()) {
            if(product.getCategory() == category){
                isTrue=true;
            }
        }
        return isTrue;
    }
    public static Map<Product,StockInfo> updateForId (Map<Product,StockInfo> products,int id,Integer quantity,Integer price){
        for (Product product : products.keySet()) {
             if(product.getProductId() == id){
                 if(quantity!=null){
                     products.get(product).setQuantity(quantity);
                 }
                if(price!=null){
                    products.get(product).setPrice(price);
                }
             }
        }
        return products;
    }
    public static Map<Product,StockInfo> disPlayForId(Map<Product,StockInfo> products,int id){
        Map<Product,StockInfo> productStockInfoMap = new HashMap<>();
        for(Product product:products.keySet()){
            if(product.getProductId() == id){
                productStockInfoMap.put(product,products.get(product));
            }
        }
        return productStockInfoMap;
    }
    public static Map<Product,StockInfo> searchForCategory(Map<Product,StockInfo> products,String category){
        Map<Product,StockInfo> productStockInfoMap = new HashMap<>();
        for(Product product:products.keySet()){
            if(product.getCategory() == category){
                productStockInfoMap.put(product,products.get(product));
            }
        }
        return productStockInfoMap;
    }
}
