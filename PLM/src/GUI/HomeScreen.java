package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HomeScreen {
    public static void display()
    {
        //elements in UI
        Label headingLbl = new Label("Select Option Below");
        headingLbl.setId("header");
        Button displayStatsBtn = new Button("Display Clubs");
        Button displayMatchesBtn = new Button("Display Matches");
        Button quitBtn = new Button("Quit");
        quitBtn.setId("quitBtn");

        //declaring the gridpane
        Pane homePane = new Pane();
        homePane.setId("homePane");
        homePane.setMinSize(1920,1080);

        //adding elements to gridpane
        homePane.getChildren().addAll(headingLbl,displayMatchesBtn,displayStatsBtn,quitBtn);

        headingLbl.setLayoutX(790);
        headingLbl.setLayoutY(120);

        displayStatsBtn.setLayoutX(810);
        displayStatsBtn.setLayoutY(340);

        displayMatchesBtn.setLayoutX(810);
        displayMatchesBtn.setLayoutY(480);

        quitBtn.setLayoutX(810);
        quitBtn.setLayoutY(620);

        //setting the stage
        Stage homeStage = new Stage();
        Scene homeScene = new Scene(homePane);
        homeStage.setScene(homeScene);

        //title
        homeStage.setTitle("Home");

        homeStage.show();

        //-----button on click actions -------
        displayStatsBtn.setOnAction(e ->{
            homeStage.close();
            ClubStats.display();
        });

        displayMatchesBtn.setOnAction(e->{
            homeStage.close();
            MatchDetails.display();

        });
        quitBtn.setOnAction(e->{
            AlertsUsed.confirmationUserExit();


        });
        //-------------------------Stylesheets---------------------------------------
      homeScene.getStylesheets().add(HomeScreen.class.getResource("Stylesheets/styleSheet.css").toExternalForm());
//        homeScene.getStylesheets().add(HomeScreen.class.getResource("homeCss.css").toExternalForm());
    }
}
