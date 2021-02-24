package GUI;

import CLI.FootballClub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ClubStats {

    public static List readClubsList = new ArrayList();

    public static void display(){

        ObservableList<FootballClub> footballClubs = FXCollections.observableArrayList();
//        read the text file and add objects to the observable list
        try (
                FileInputStream fileInputStream = new FileInputStream("footballClubDetails.txt");
                ObjectInputStream objectinputstream = new ObjectInputStream(fileInputStream);
        ) {
            readClubsList = (List) objectinputstream.readObject();
            footballClubs.addAll(readClubsList);
            System.out.println(readClubsList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        UI elements
       // Label headingLbl = new Label("Club Details");
        Button accToPointsBtn = new Button("Sort to Points");
        Button accToGoalsBtn = new Button("Sort to Goals");
        Button accToWins = new Button("Sort to Wins");
        Button backBtn = new Button("Back");
        backBtn.setId("backBtn");

        Stage clubDetailsStage = new Stage();
//        Scene detailsScene = new Scene(detailsGrid);
//        clubDetailsStage.setScene(detailsScene);

        //title
        clubDetailsStage.setTitle("Football club details");

        clubDetailsStage.show();

        //-------------Table-----------------
        TableView<FootballClub> tableView = new TableView();
        tableView.setId("tableView");

        TableColumn<FootballClub,String> idColumn = new TableColumn<>("Club ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        idColumn.setMinWidth(100);

        TableColumn<FootballClub, String> nameColumn = new TableColumn<>("Club Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfClub"));
        nameColumn.setMinWidth(200);


        TableColumn<FootballClub, Integer> matchesPlayedColumn = new TableColumn<>("Matches Played");
        matchesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));
        matchesPlayedColumn.setMinWidth(150);


        TableColumn<FootballClub, Integer> wonColumn = new TableColumn<>("Matches Won");
        wonColumn.setCellValueFactory(new PropertyValueFactory<>("matchesWin"));
        wonColumn.setMinWidth(150);


        TableColumn<FootballClub, Integer> lostColumn = new TableColumn<>("Matches Lost");
        lostColumn.setCellValueFactory(new PropertyValueFactory<>("matchesLost"));
        lostColumn.setMinWidth(100);


        TableColumn<FootballClub, Integer> drawColumn = new TableColumn<>("Matches Draw");
        drawColumn.setCellValueFactory(new PropertyValueFactory<>("matchesDraw"));
        drawColumn.setMinWidth(150);


        TableColumn<FootballClub, Integer> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("noOfPoints"));
        pointsColumn.setMinWidth(100);


        TableColumn<FootballClub, Integer> goalsScoredColumn = new TableColumn<>("Goals Scored");
        goalsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("noOfGoalsScored"));
        goalsScoredColumn.setMinWidth(100);


        tableView.setItems(footballClubs);

//        adding columns to the table
        tableView.getColumns().addAll(idColumn,nameColumn,matchesPlayedColumn,wonColumn,lostColumn,drawColumn,pointsColumn,goalsScoredColumn);


        //-----button on click actions -------
        accToPointsBtn.setOnAction(e ->{
            pointsColumn.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(pointsColumn);
        });

        accToGoalsBtn.setOnAction(e->{
            goalsScoredColumn.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(goalsScoredColumn);

        });
        accToWins.setOnAction(e->{
            wonColumn.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(wonColumn);
        });
        backBtn.setOnAction(e->{
            clubDetailsStage.close();
            HomeScreen.display();

        });

//        setting up the window
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1920,1080);
        borderPane.setCenter(tableView);
        VBox vBox = new VBox(backBtn,accToGoalsBtn,accToPointsBtn,accToWins);

        //Vbox margin set up
        VBox.setMargin(accToGoalsBtn, new Insets(10, 20, 30, 20));
        VBox.setMargin(backBtn, new Insets(30, 20, 30, 20));
        VBox.setMargin(accToPointsBtn, new Insets(10, 20, 30, 20));
        VBox.setMargin(accToWins, new Insets(10, 20, 30, 20));


        borderPane.setLeft(vBox);
        Scene detailsScene = new Scene(borderPane);
        clubDetailsStage.setScene(detailsScene);

        //---------stylesheets--------------------
        detailsScene.getStylesheets().add(HomeScreen.class.getResource("Stylesheets/styleSheet.css").toExternalForm());
    }
}
