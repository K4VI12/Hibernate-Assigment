package lk.ijse.thogakade.contoller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.Orders;
import lk.ijse.thogakade.repository.ItemRepository;
import lk.ijse.thogakade.repository.OrderRepository;

public class ManageorderController {
    public Button savebtn;
    public TextField idtxt;
    public TextField customeridtxt;
    public Button updatebtn;
    public Button deletebtn;
    public Button searchbtn;
    public DatePicker datetxt;

    public void savebtnonaction(ActionEvent actionEvent) {
        if(checkNull()==true){

            Orders orders = new Orders();
            Customer customer = new Customer();
            orders.setId(idtxt.getText());
            customer.setId(customeridtxt.getText());
            orders.setCustomer(customer);

            OrderRepository orderRepository = new OrderRepository();
            boolean saved = orderRepository.saveOrders(orders);
            System.out.println("orders: " + saved);

            clear();
        }
    }

    public void updatebtnonaction(ActionEvent actionEvent) {
        Orders orders = new Orders();
        Customer customer = new Customer();
        OrderRepository orderRepository = new OrderRepository();
        orders.setId(idtxt.getText());
        customer.setId(customeridtxt.getText());
        orders.setCustomer(customer);
        boolean isUpdated = orderRepository.updateOrders(orders);
        if (isUpdated) {
            System.out.println("Orders Updated!");
            clear();
        } else {
            System.out.println("Orders Update Failed!");
        }
    }

    public void deletebtnonaction(ActionEvent actionEvent) {
        if(idtxt.getText()!=null){
            Orders orders = new Orders();
            Customer customer = new Customer();
            OrderRepository orderRepository = new OrderRepository();
            orders.setId(idtxt.getText());
            customer.setId(customeridtxt.getText());
            orders.setCustomer(customer);
            boolean isDeleted = orderRepository.deleteOrders(orders);
            if (isDeleted) {
                System.out.println("Orders Deleted!");
                clear();
            } else {
                System.out.println("Orders Deletion Failed!");
            }
        }
    }

    public void searchbtnonaction(ActionEvent actionEvent) {
        OrderRepository orderRepository = new OrderRepository();
        Orders orders = orderRepository.getOrders(idtxt.getText());
        Customer customer = orders.getCustomer();
        customeridtxt.setText(customer.getId());

    }

    private boolean checkNull(){
        if(idtxt.getText()!=null&customeridtxt.getText()!=null){
            return true;
        }else{
            return false;
        }
    }

    private void clear(){
        idtxt.clear();
        customeridtxt.clear();
    }
}
