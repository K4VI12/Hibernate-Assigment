package lk.ijse.thogakade.contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ZoomEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstpageController {
    public Button savebtn;
    public TextField txtfield;
    public Text code;
    public static String Hcode;
    public static int count;
    public Button manageItembtn;
    public Button manageOrderbtn;
    public Button orderdetailbtn;

    public void savebtnonAction(ActionEvent actionEvent) {

        LoadFile.path = "/view/savecustomerForm.fxml";
        LoadFile.setPath();

        count+=1;
        if(count==10){
            code.setVisible(true);
        }
    }

    public void manageItembtnonAction(ActionEvent actionEvent) {
        LoadFile.path = "/view/manageitem.fxml";
        LoadFile.setPath();
    }

    public void manageOrderbtnonAction(ActionEvent actionEvent) {
        LoadFile.path = "/view/manageorder.fxml";
        LoadFile.setPath();
    }

    public void orderdetailbtnonaction(ActionEvent actionEvent) {
        LoadFile.path = "/view/manageorderdetails.fxml";
        LoadFile.setPath();
    }

    public void txtfieldonaction(ActionEvent actionEvent) {
        if(txtfield.getText().equals(Hcode)){
            code.setVisible(true);
        }else if(txtfield.getText().equals("#o")){
            code.setVisible(false);
        }else{
            txtfield.clear();
            savebtn.requestFocus();
        }
    }

}
