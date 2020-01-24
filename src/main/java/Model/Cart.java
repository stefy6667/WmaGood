package Model;

public class Cart {

    private String pID;
    private String pName;
    private String category;
    private Double pPrice;
    private int quantity;

    public Cart(String pID, String pName, String category, Double pPrice, int quantity) {
        this.pID = pID;
        this.pName = pName;
        this.category = category;
        this.pPrice = pPrice;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}




