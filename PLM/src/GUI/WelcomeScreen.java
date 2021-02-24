package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // primaryStage.setScene(new Scene(root, 300, 275));
        // primaryStage.show();

        //Welcome label
        Label headingText = new Label("Premiere League Manager");
        headingText.setId("firstHeader");

        //button to start the manager
        Button startButton = new Button("Start");
        startButton.setId("startBtn");

        Pane welcomePane = new Pane();
        welcomePane.setId("welcomePane");

        //Setting size for the welcomePane

        welcomePane.setPrefSize(1920,1080);

        headingText.setLayoutX(700);
        headingText.setLayoutY(50);

        startButton.setLayoutX(760);
        startButton.setLayoutY(420);

        welcomePane.getChildren().addAll(headingText,startButton);

        Scene welcomeScene = new Scene(welcomePane);
        Stage welcomeStage = new Stage();

        //Setting title to the Stage
        welcomeStage.setTitle("WELCOME");

        //Adding welcomeScene to the welcomeStage
        welcomeStage.setScene(welcomeScene);
        welcomeStage.setResizable(false);

        //Displaying the contents of the welcomeStage
        welcomeStage.show();


        //-------------------------Stylesheets---------------------------------------
        welcomeScene.getStylesheets().add(this.getClass().getResource("Stylesheets/styleSheet.css").toExternalForm());

        startButton.setOnAction(e ->{
            welcomeStage.close();
            HomeScreen.display();
        });
        startButton.setStyle("-fx-max-width: 200px;-fx-max-height: 50px");


    }

    public static void main(String[] args) {
        launch(args);
    }
}
