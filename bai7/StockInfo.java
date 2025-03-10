package baitapcolection.bai7;

public class StockInfo {
    private int quantity;
    private int price;

    public StockInfo() {
    }

    public StockInfo(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
