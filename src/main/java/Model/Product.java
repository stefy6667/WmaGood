package Model;



import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String pId;
    @Column
    private String pName;
    private String category;
    @Column
    private String quantity;
    private double pPrice;

    public Product(int id, String pId, String pName, String category, String quantity, double pPrice) {
        this.id = id;
        this.pId = pId;
        this.pName = pName;
        this.category = category;
        this.quantity=quantity;
        this.pPrice = pPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(String pName) {
        this.pName = pName;
        //this.quantity = quantity;
    }

    public Product() {

    }

    public Product(String pId, String pName, String category, Double pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.category = category;

        this.pPrice = pPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product(String pId, String pName, String category,String quantity,double pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.category = category;
        this.quantity=quantity;
        this.pPrice = pPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return  pName +  quantity ;
    }


}
