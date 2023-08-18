package lk.ijse.thogakade.contoller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        /*File fileToDelete = new File("src/main/java/shs");
        if (fileToDelete.exists()) {
            boolean deleted = fileToDelete.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        }*/

            Parent parent =  FXMLLoader.load(getClass().getResource("/view/firstpage.fxml"));
            stage.setScene(new Scene(parent));
            stage.setTitle("Loginpage");
            stage.centerOnScreen();
            stage.show();
            new SavecustomerFormController();
    }
}
