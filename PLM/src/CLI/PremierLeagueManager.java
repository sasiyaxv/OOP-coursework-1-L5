package CLI;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;


public class PremierLeagueManager implements LeagueManager {

    //maximum no of teams allowed to play in premiere league manager
    public static final int MAX_TEAMS = 20;

    //currently available space
    private int availableSpace = 20;

    CommandLineInterface commandLineInterface = new CommandLineInterface();

    //method to update available clubs
    public void updateSpace(){
        availableSpace = availableSpace - commandLineInterface.getCurrentValue();
    }

    // to add a football club
    @Override
    public void addFootballClub(FootballClub footballClub) {

        for (FootballClub f : commandLineInterface.getList()) {

            if (footballClub.equals(f)) {
                System.out.println("Football club " + footballClub.getRegNo() + " already exists.");
                return;
            }
        }

        if (commandLineInterface.getList().size() < MAX_TEAMS) {
            updateSpace();
            commandLineInterface.getList().add(footballClub);
            availableSpace = availableSpace - 1;
            System.out.println("Football club added successfully." + availableSpace + " more clubs can be added.");

        } else {
            System.out.println("No more football teams can be added to the Premiere League.");
        }
    }

    //to delete a football club
    @Override
    public void deleteFootballClub(String regNo) {

        //boolean is used  to identify whether football club is found or not
        boolean footBallClubFound = false;

        //for loop to traverse through football club list
        for (FootballClub footballClub : commandLineInterface.getList()) {

            if (footballClub.getRegNo().equals(regNo)) {
                updateSpace();
                commandLineInterface.getList().remove(footballClub);
                footBallClubFound = true;
                availableSpace += 1;
                System.out.println("Football club was deleted successfully. " + availableSpace + " football clubs can be added.");
                break;
            }
        }
        //foot ball club was not found
        if (!footBallClubFound) {
            System.out.println("Football club " + regNo + " not found.");
        }

    }

    //to view a data of a selected club
    @Override
    public void viewClubData(String regNo) {

        boolean footballClubAvailable = false;

        for (FootballClub footballClub : commandLineInterface.getList()) {
            if (footballClub.getRegNo().equals(regNo)) {
                footballClubAvailable = true;
                System.out.println(footballClub);
            }
        }
        if (!footballClubAvailable) {
            System.out.println("Football club " + regNo + " is not available.");
        }
    }

    //displaying the premiere league table
    @Override
    public void displayPremiereLeagueTable() {

        if (commandLineInterface.getList().isEmpty()) {
            System.out.println("No football club was found in the Premiere league table..");
        } else {
            System.out.println("\t\t--------------+----------+--------------+----------------+------+-------+-------+--------+--------------+");
            System.out.println("\t\t|<Register No>|<Name>    |<Location>    |<Matches Played>|<Wins>|<Loses>|<Draws>|<Points>|<Goals Scored>|");
            System.out.println("\t\t--------------+----------+--------------+----------------+------+-------+-------+--------+--------------+");

//            Collections.sort(footballClubList);
            for (FootballClub footballClub : commandLineInterface.getList()) {
                System.out.println("\t\t|" + footballClub.getRegNo() + "\t\t  |" + footballClub.getNameOfClub() + "\t     |" + footballClub.getLocationOfClub() + "\t\t\t|\t\t" + footballClub.getMatchesPlayed() + "\t\t |  " + footballClub.getMatchesWin() + "\t|  " + footballClub.getMatchesLost() + "\t|  " + footballClub.getMatchesDraw() + "\t|  " + footballClub.getNoOfPoints() + "\t |\t   " + footballClub.getNoOfGoalsScored() + "\t    |");
                System.out.println("\t\t--------------+----------+--------------+----------------+------+-------+-------+--------+--------------+");

            }
        }
    }

    //to add a played match
    @Override
    public void addPlayedMatch(Match playedMatch) {

        for (FootballClub f : commandLineInterface.getList()) {

            //checking if team one exists in list.
            if (playedMatch.getTeamOne().equals(f.getRegNo())) {
                int matchesPlayed = f.getMatchesPlayed() + 1;
                f.setMatchesPlayed(matchesPlayed);

                //checking which team has most goals
                if (playedMatch.getTeamOneGoals() > playedMatch.getTeamTwoGoals()) {
                    int teamOneGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamOneGoal);
                    int teamOnePoint = f.getNoOfPoints() + 3;
                    int teamOneWon = f.getMatchesWin() + 1;
                    f.setMatchesWin(teamOneWon);
                    f.setNoOfPoints(teamOnePoint);

                    //checking which team has most goals
                } else if (playedMatch.getTeamOneGoals() < playedMatch.getTeamTwoGoals()) {

                    int teamOneGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamOneGoal);
                    int teamOneLost = f.getMatchesLost() + 1;
                    f.setMatchesLost(teamOneLost);
                }
                //if both teams have equal goals
                else {
                    int teamOneGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamOneGoal);
                    int drawPoint = f.getNoOfPoints() + 1;
                    int matchDraw = f.getMatchesDraw() + 1;
                    f.setMatchesDraw(matchDraw);
                    f.setNoOfPoints(drawPoint);
                }
            }
            //checking if team two exists
            if (playedMatch.getTeamTwo().equals(f.getRegNo())) {
                int matchesPlayed = f.getMatchesPlayed() + 1;
                f.setMatchesPlayed(matchesPlayed);

                if (playedMatch.getTeamOneGoals() < playedMatch.getTeamTwoGoals()) {
                    int teamTwoGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamTwoGoal);
                    int teamTwoPoint = f.getNoOfPoints() + 3;
                    int teamTwoWon = f.getMatchesWin() + 1;
                    f.setMatchesWin(teamTwoWon);
                    f.setNoOfPoints(teamTwoPoint);

                } else if (playedMatch.getTeamOneGoals() > playedMatch.getTeamTwoGoals()) {
                    int teamTwoGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamTwoGoal);
                    int teamTwoLost = f.getMatchesLost() + 1;
                    f.setMatchesLost(teamTwoLost);
                } else {
                    int teamTwoGoal = f.getNoOfGoalsScored() + playedMatch.getTeamOneGoals();
                    f.setNoOfGoalsScored(teamTwoGoal);
                    int matchDraw = f.getMatchesDraw() + 1;
                    int drawPoint = f.getMatchesDraw() + 1;
                    f.setNoOfPoints(drawPoint);
                    f.setMatchesDraw(matchDraw);
                }
            }
        }
    }

    //to pass the list to a another class
    public List<FootballClub> getList() {
        return commandLineInterface.getList();
    }

    //class to save data to a file after serialization
    public void saveDetailsToFile() {
        System.out.println(commandLineInterface.getList());
        if (commandLineInterface.getList().isEmpty()) {
            System.out.println("No football club was found.");
        } else {
            Collections.sort(commandLineInterface.getList());
            try (
                    FileOutputStream fileOutputStream = new FileOutputStream("footballClubDetails.txt");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            ) {

                objectOutputStream.writeObject(commandLineInterface.getList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


