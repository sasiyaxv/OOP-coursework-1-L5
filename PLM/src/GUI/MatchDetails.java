package GUI;

import CLI.DateTime;
import CLI.FootballClub;
import CLI.Match;
import CLI.PremierLeagueManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Arrays.parallelPrefix;
import static java.util.Arrays.stream;

public class MatchDetails {



    public static List readMatchData = new ArrayList();

    public static List clubData = new ArrayList();


    public static void display(){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();


        Random rand = new Random();

        ObservableList<Match> matchDataList = FXCollections.observableArrayList();

//        read the text file and add objects to the observable list
//        ----------------------------------------------------------------------------------------------------------
        try (
                FileInputStream fileInputStream = new FileInputStream("matchDetails.txt");
                ObjectInputStream objectinputstream = new ObjectInputStream(fileInputStream);
        ) {
            readMatchData = (List) objectinputstream.readObject();
            matchDataList.addAll(readMatchData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        ----------------------------------------------------------------------------------------------------------


//        try (
//                FileInputStream fileInputStream = new FileInputStream("footballClubDetails.txt");
//                ObjectInputStream objectinputstream = new ObjectInputStream(fileInputStream);
//        ) {
//            clubData = (List) objectinputstream.readObject();
//            if (objectinputstream.equals())
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        //        ----------------------------------------------------------------------------------------------------------


        //UI elements
        Button backBtn = new Button("Back");
        backBtn.setId("backBtn");
        Button generateMatchBtn = new Button("Generate Match");
        Button sortToDate = new Button("Sort To Date");
        TextField searchMatch = new TextField();
        searchMatch.setId("searchField");
        Button searchBtn = new Button("Search");
        Button saveDetails = new Button("Save Data");


        TableView tableView = new TableView();
        tableView.setId("tableView");

        TableColumn<FootballClub,String> teamOneColumn = new TableColumn<>("Team One");
        teamOneColumn.setCellValueFactory(new PropertyValueFactory<>("teamOne"));
        teamOneColumn.setMinWidth(200);

        TableColumn<FootballClub, String> teamTwoColumn = new TableColumn<>("Team Two");
        teamTwoColumn.setCellValueFactory(new PropertyValueFactory<>("teamTwo"));
        teamTwoColumn.setMinWidth(200);


        TableColumn<FootballClub, Integer> teamOneScore = new TableColumn<>("Team One Score");
        teamOneScore.setCellValueFactory(new PropertyValueFactory<>("teamOneGoals"));
        teamOneScore.setMinWidth(150);


        TableColumn<FootballClub, Integer> teamTwoScore = new TableColumn<>("Team Two Score");
        teamTwoScore.setCellValueFactory(new PropertyValueFactory<>("teamTwoGoals"));
        teamTwoScore.setMinWidth(150);


        TableColumn<FootballClub, DateTime> playedDate = new TableColumn<>("Played Date");
        playedDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        playedDate.setMinWidth(250);


        tableView.getColumns().addAll(teamOneColumn,teamTwoColumn,teamOneScore,teamTwoScore,playedDate);
        tableView.setItems(matchDataList);


        //Organizing elements
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1920,1080);

        VBox vBoxSearch = new VBox(searchMatch,searchBtn);
        VBox vBoxBtns = new VBox(backBtn,generateMatchBtn,sortToDate,saveDetails);
        borderPane.setRight(vBoxSearch);
        borderPane.setLeft(vBoxBtns);
        borderPane.setCenter(tableView);

        //Vbox margin set up
        VBox.setMargin(generateMatchBtn, new Insets(20, 10, 30, 20));
        VBox.setMargin(backBtn, new Insets(30, 20, 30, 20));
        VBox.setMargin(sortToDate, new Insets(10, 20, 30, 20));
        VBox.setMargin(searchMatch, new Insets(10, 20, 30, 20));
        VBox.setMargin(searchBtn, new Insets(10, 20, 30, 20));
        VBox.setMargin(saveDetails, new Insets(10, 20, 30, 20));



        Stage matchDetailsStage= new Stage();

        Scene matchStage = new Scene(borderPane);
        matchDetailsStage.setScene(matchStage);
        matchDetailsStage.show();

//        ----------------------------------------------------------

//        -----------------------------------------------------------


        //------------Button onclick actions ---------------
        backBtn.setOnAction(e->{
            matchDetailsStage.close();
            HomeScreen.display();
        });

        generateMatchBtn.setOnAction(e->{


            int teamOneGoals = rand.nextInt(20);
            int teamTwoGoals = rand.nextInt(20);
            int year = rand.nextInt(20);
            int month =1 + rand.nextInt(12);
            int day = 1 + rand.nextInt(31);

            DateTime dateTime = new DateTime(year,month,day);

            /*
            * To get a number between 200 and 500, try the following:
                Random random = new Random(); // or new Random(someSeed);
              int value = 200 + random.nextInt(300);
* */


            //int date =
           matchDataList.add(new Match("0001","0002",teamOneGoals,teamTwoGoals,dateTime));
           premierLeagueManager.addPlayedMatch(new Match("0001","0002",teamOneGoals,teamTwoGoals,dateTime));
           premierLeagueManager.saveDetailsToFile();


           tableView.setItems(matchDataList);
        });

        saveDetails.setOnAction(e->{
            try (
                    FileOutputStream fileOutputStream = new FileOutputStream("matchDetails.txt");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            ) {
                List matches =  new ArrayList();
                matches.addAll(matchDataList);
                objectOutputStream.writeObject(matches);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            AlertsUsed.confirmationUser("All data have been saved successfully.");

        });

        //---------stylesheets--------------------
        matchStage.getStylesheets().add(HomeScreen.class.getResource("Stylesheets/styleSheet.css").toExternalForm());
//        matchStage.getStylesheets().add(HomeScreen.class.getResource("Stylesheets/matchDetails.css").toExternalForm());

    }

}
