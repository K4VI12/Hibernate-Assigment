package lk.ijse.thogakade.contoller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadFile {

    static String path;

    private  LoadFile(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        /*Stage currentStage = (Stage) loginbtn.getScene().getWindow();
        currentStage.close();*/
    }

    public static void setPath(){
        new LoadFile();
    }

}
