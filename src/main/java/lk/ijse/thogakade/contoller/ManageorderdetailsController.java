package lk.ijse.thogakade.contoller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.Orders;
import lk.ijse.thogakade.entity.orderdetail;
import lk.ijse.thogakade.repository.ItemRepository;
import lk.ijse.thogakade.repository.OrderDetailsRepository;

public class ManageorderdetailsController {
    public Button savebtn;
    public TextField orderidtxt;
    public TextField itemcodetxt;
    public TextField qtytxt;
    public TextField unitpricetxt;
    public Button updatebtn;
    public Button deletebtn;
    public Button searchbtn;

    public void savebtnonaction(ActionEvent actionEvent) {

        orderdetail orderD = new orderdetail();
        Orders orders = new Orders();
        Item item = new Item();

        orders.setId(orderidtxt.getText());
        item.setCode(itemcodetxt.getText());

        orderD.setItem(item);
        orderD.setOrders(orders);
        orderD.setQty(Integer.parseInt(qtytxt.getText()));
        orderD.setUnitprice(Double.parseDouble(unitpricetxt.getText()));

        OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepository();
        boolean saved = orderDetailsRepository.saveOrderDetails(orderD);
        System.out.println("order details: " + saved);

        clear();
    }

    public void updatebtnonaction(ActionEvent actionEvent) {
    }

    public void deletebtnonaction(ActionEvent actionEvent) {

    }

    public void searchbtnonaction(ActionEvent actionEvent) {

    }

    private void clear(){
        orderidtxt.clear();
        itemcodetxt.clear();
        qtytxt.clear();
        unitpricetxt.clear();
    }
}
