package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrepareOrder {
    @Id
    private String pName;
    private String quantity;
    private String tableId;
    private double price;


    public PrepareOrder() {

    }


    public PrepareOrder(String name, String quantity, String tableId,double price) {
        this.pName = name;
        this.quantity = quantity;
        this.tableId = tableId;
        this.price=price;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTable() {
        return tableId;
    }

    public void setTable(String tableId) {
        this.tableId = tableId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PrepareOrder{" +
                "pName='" + pName + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
