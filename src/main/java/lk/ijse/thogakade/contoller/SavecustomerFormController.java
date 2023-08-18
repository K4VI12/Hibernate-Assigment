package lk.ijse.thogakade.contoller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.repository.CustomerRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class SavecustomerFormController implements Initializable {
    public TextField idtxt;
    public TextField nametxt;
    public TextField addresstxt;
    public TextField salarytxt;
    public Button savebtn;
    public Button updatebtn;
    public Button deletebtn;
    public Button searchbtn;


    public void savebtnonaction(ActionEvent actionEvent)throws Exception {
        if(checkNull()==true){

            Customer customer = new Customer();
            customer.setId(idtxt.getText());
            customer.setName(nametxt.getText());
            customer.setAddress(addresstxt.getText());
            customer.setSalary(Double.parseDouble(salarytxt.getText()));

            CustomerRepository cusRepository = new CustomerRepository();
            boolean savedCusId = cusRepository.saveCustomer(customer);
            System.out.println("Saved Cus Id: " + savedCusId);

            clear();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FirstpageController.Hcode = "#v";
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean checkNull(){
        if(idtxt.getText()!=null&nametxt.getText()!=null&addresstxt.getText()!=null&salarytxt.getText()!=null){
            return true;
        }else{
            return false;
        }
    }

    private void clear(){
        idtxt.clear();
        nametxt.clear();
        addresstxt.clear();
        salarytxt.clear();
    }

    public void updatebtnonaction(ActionEvent actionEvent)throws Exception {

        Customer updatecustomer = new Customer();
        CustomerRepository cusRepository = new CustomerRepository();
        updatecustomer.setId(idtxt.getText());
        updatecustomer.setName(nametxt.getText());
        updatecustomer.setAddress(addresstxt.getText());
        updatecustomer.setSalary(Double.parseDouble(salarytxt.getText()));
        boolean isUpdated = cusRepository.updateCustomer(updatecustomer);
        if (isUpdated) {
            System.out.println("Customer Updated!");
            clear();
        } else {
            System.out.println("Customer Update Failed!");
        }

    }

    public void deletebtnonaction(ActionEvent actionEvent)throws Exception {
        if(idtxt.getText()!=null){
            Customer customer = new Customer();
            customer.setId(idtxt.getText());
            customer.setName(nametxt.getText());
            customer.setAddress(addresstxt.getText());
            customer.setSalary(Double.parseDouble(salarytxt.getText()));
            CustomerRepository cusRepository = new CustomerRepository();
            boolean isDeleted = cusRepository.deleteCustomer(customer);
            if (isDeleted) {
                System.out.println("Customer Deleted!");
                clear();
            } else {
                System.out.println("Customer Deletion Failed!");
            }
        }
    }

    public void searchbtnonaction(ActionEvent actionEvent)throws Exception {
        CustomerRepository cusRepository = new CustomerRepository();
        Customer existingCustomer = cusRepository.getCustomer(idtxt.getText());
        nametxt.setText(existingCustomer.getName());
        addresstxt.setText(existingCustomer.getAddress());
        salarytxt.setText(String.valueOf(existingCustomer.getSalary()));
    }
}
