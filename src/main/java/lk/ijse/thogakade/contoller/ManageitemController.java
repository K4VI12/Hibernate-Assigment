package lk.ijse.thogakade.contoller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.repository.CustomerRepository;
import lk.ijse.thogakade.repository.ItemRepository;

public class ManageitemController {
    public TextField codetxt;
    public TextField descriptiontxt;
    public TextField unitpricetxt;
    public TextField qtyonhandtxt;
    public Button savebtn;
    public Button updatebtn;
    public Button deletebtn;
    public Button searchbtn;

    public void savebtnonaction(ActionEvent actionEvent)throws Exception {
        if(checkNull()==true){

            Item item = new Item();
            item.setCode(codetxt.getText());
            item.setDescription(descriptiontxt.getText());
            item.setUnitPrice(Double.parseDouble(unitpricetxt.getText()));
            item.setQtyOnHand(Integer.parseInt(qtyonhandtxt.getText()));

            ItemRepository itmRepository = new ItemRepository();
            boolean saved = itmRepository.saveItem(item);
            System.out.println("item: " + saved);

            clear();
        }
    }

    public void updatebtnonaction(ActionEvent actionEvent) {
        Item updateitem = new Item();
        ItemRepository itmRepository = new ItemRepository();
        updateitem.setCode(codetxt.getText());
        updateitem.setDescription(descriptiontxt.getText());
        updateitem.setUnitPrice(Double.parseDouble(unitpricetxt.getText()));
        updateitem.setQtyOnHand(Integer.parseInt(qtyonhandtxt.getText()));
        boolean isUpdated = itmRepository.updateItem(updateitem);
        if (isUpdated) {
            System.out.println("Item Updated!");
            clear();
        } else {
            System.out.println("Item Update Failed!");
        }
    }

    public void deletebtnonaction(ActionEvent actionEvent) {
        if(codetxt.getText()!=null){
            Item item = new Item();
            item.setCode(codetxt.getText());
            item.setDescription(descriptiontxt.getText());
            item.setUnitPrice(Double.parseDouble(unitpricetxt.getText()));
            item.setQtyOnHand(Integer.parseInt(qtyonhandtxt.getText()));
            ItemRepository itmRepository = new ItemRepository();
            boolean isDeleted = itmRepository.deleteItem(item);
            if (isDeleted) {
                System.out.println("Item Deleted!");
                clear();
            } else {
                System.out.println("Item Deletion Failed!");
            }
        }
    }

    public void searchbtnonaction(ActionEvent actionEvent) {
        ItemRepository itmRepository = new ItemRepository();
        Item itm = itmRepository.getItem(codetxt.getText());
        descriptiontxt.setText(itm.getDescription());
        unitpricetxt.setText(String.valueOf(itm.getUnitPrice()));
        qtyonhandtxt.setText(String.valueOf(itm.getQtyOnHand()));
    }

    private boolean checkNull(){
        if(codetxt.getText()!=null&descriptiontxt.getText()!=null&unitpricetxt.getText()!=null&qtyonhandtxt.getText()!=null){
            return true;
        }else{
            return false;
        }
    }

    private void clear(){
        codetxt.clear();
        descriptiontxt.clear();
        unitpricetxt.clear();
        qtyonhandtxt.clear();
    }
}
