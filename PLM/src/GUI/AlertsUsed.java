package GUI;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertsUsed {

//    custom confirmation alert to display a relevant message (Reusable)
    public static void confirmationUser(String message){

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(message);
        a.setHeaderText("CONFIRMATION");
        a.showAndWait();


    }

    public static void confirmationUserExit(){

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Are you sure you want to exit ?");
        a.setHeaderText("CONFIRMATION");
        a.showAndWait();
        if (a.getResult() == ButtonType.OK){
            System.exit(0);
        }else {
            return;
        }



    }
}
