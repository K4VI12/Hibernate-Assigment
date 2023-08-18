package lk.ijse.thogakade.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
public class orderdetail {

    @Id
    @JoinColumn(name = "orderid")
    private Orders orders;

    @JoinColumn(name = "itemCode")
    private Item item;
    @Column(name = "qty")
    private int qty;
    @Column(name = "UnitPrice",length = 8)
    private double unitprice;

    public orderdetail() {
    }

    public orderdetail(Orders orders, Item item, int qty, double unitprice) {
        this.orders = orders;
        this.item = item;
        this.qty = qty;
        this.unitprice = unitprice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "orderdetail{" +
                "orders=" + orders +
                ", item=" + item +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                '}';
    }
}
