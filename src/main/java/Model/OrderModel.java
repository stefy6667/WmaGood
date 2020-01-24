package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue
    private int id;
    private String WaiterId;
    private String orderNumber;
    private String readyBar;
    private String readyBuc;
    private String getReadyNar;
    private String deliver;
    private String date;
    private String tabel;
    private double total;

    public OrderModel(String WaiterId, String orderName, String table, String readyBar, String readyBuc, String getReadyNar, String deliver, String date, double total) {
        this.WaiterId = WaiterId;
        this.orderNumber = orderName;
        this.tabel = table;
        this.readyBar = readyBar;
        this.readyBuc = readyBuc;
        this.getReadyNar = getReadyNar;
        this.deliver = deliver;
        this.date = date;
        this.total = total;
    }


    public OrderModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaiterId() {
        return WaiterId;
    }

    public void setWaiterId(String waiterId) {
        WaiterId = waiterId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReady() {
        return readyBar;
    }

    public void setReady(String ready) {
        this.readyBar = ready;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public String getTabel() {
        return tabel;
    }

    public void setTabel(String tabel) {
        this.tabel = tabel;
    }

    public String getReadyBuc() {
        return readyBuc;
    }

    public void setReadyBuc(String readyBuc) {
        this.readyBuc = readyBuc;
    }

    public String getGetReadyNar() {
        return getReadyNar;
    }

    public void setGetReadyNar(String getReadyNar) {
        this.getReadyNar = getReadyNar;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", WaiterId='" + WaiterId + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", readyBar='" + readyBar + '\'' +
                ", readyBuc='" + readyBuc + '\'' +
                ", getReadyNar='" + getReadyNar + '\'' +
                ", deliver='" + deliver + '\'' +
                ", date='" + date + '\'' +
                ", tabel='" + tabel + '\'' +
                ", total=" + total +
                '}';
    }
}
