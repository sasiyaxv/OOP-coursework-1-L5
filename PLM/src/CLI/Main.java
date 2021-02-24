package CLI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main implements Serializable {

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    List<Match> matchData = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    Scanner scannerTwo = new Scanner(System.in);

    DateTime dateTime = new DateTime();

    //main menu of the implementation. Menu is divided into two parts.
    public void mainMenu() {
        System.out.println("==== Welcome to Premiere League Manager ====\n");
        System.out.println("Please note that using this manager you can add, delete or view data of a football club.\nAdded data also can be saved to a file. Begin by selecting your option below.\n");

        int userChoice;
        while (true) {
            try {
                System.out.println("1. Add football club. ");
                System.out.println("2. Delete football club. ");
                System.out.println("3. View football club. ");
                System.out.println("4. Display premiere league table.");
                System.out.println("5. Add played match. ");
                System.out.println("6. Quit. ");
                System.out.print("Enter option : ");

                userChoice = Integer.parseInt(scanner.next());

                //users first option will be passed to submenu method
                subMenu(userChoice);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Number format exception occurred.");
            }
        }
    }

    public void subMenu(int userChoice) throws IOException {

        switch (userChoice) {
            //user selects add football club option. extracting information
            case 1: {

                System.out.print("Club registration number : ");
                String clubRegNo = scanner.next();

                System.out.print("Club name : ");
                String clubName = scannerTwo.next();

                System.out.print("Club location : ");
                String clubLocation = scanner.next();

                System.out.println("Enter created date details.");

                System.out.println("Year : ");
                int year = scannerTwo.nextInt();

                System.out.println("Month : ");
                int month = scanner.nextInt();
                dateTime.setMonth(month);

                System.out.println("Day : ");
                int day = scannerTwo.nextInt();
                dateTime.setDay(day);

                System.out.print("Club contact no : ");
                int contactNo = scanner.nextInt();

                System.out.print("Matched played  : ");
                int matchesPlayed = scannerTwo.nextInt();

                System.out.print("Matched won  : ");
                int matchesWin = scanner.nextInt();

                System.out.print("Matched draw  : ");
                int matchesDraw = scannerTwo.nextInt();

                System.out.print("Matched lost  : ");
                int matchesLost = scanner.nextInt();

                System.out.print("No of goals received  : ");
                int noOfGoalsReceived = scannerTwo.nextInt();

                System.out.print("No of goals scored : ");
                int noOfGoalsScored = scanner.nextInt();

                System.out.print("No of points : ");
                int noOfPoints = scannerTwo.nextInt();

                premierLeagueManager.addFootballClub(new FootballClub(clubRegNo, clubName, clubLocation, new DateTime(year, month, day), contactNo, matchesWin, matchesDraw, matchesLost, noOfGoalsReceived, noOfGoalsScored, noOfPoints, matchesPlayed));
                mainMenu();
                break;
            }


            case 2: {
                System.out.print("Enter the registration no of club you want to delete : ");
                String removeClub = scannerTwo.next();
                premierLeagueManager.deleteFootballClub(removeClub);
                mainMenu();
                break;
            }
            //viewing a football club option
            case 3: {
                System.out.print("Enter the name of club you want to view : ");
                String regNo = scanner.next();
                premierLeagueManager.viewClubData(regNo);
                mainMenu();
                break;
            }
            //displaying premiere league table
            case 4: {
                   premierLeagueManager.displayPremiereLeagueTable();
                   mainMenu();
                break;
            }
            //adding a played match
            case 5: {
                System.out.println("Enter the played match details below.");
                System.out.print("Team one register number :  ");
                String teamOneReg = scanner.next();
                System.out.print("Team two register number :  ");
                String teamTwoReg = scannerTwo.next();
                System.out.print("Team one Goals :  ");
                int teamOneGoals = scanner.nextInt();
                System.out.print("Team Two Goals :  ");
                int teamTwoGoals = scannerTwo.nextInt();
                System.out.println("Enter match date/time details below.");

                System.out.println("Year : ");
                int year = scannerTwo.nextInt();

                System.out.println("Month : ");
                int month = scanner.nextInt();
                dateTime.setMonth(month);

                System.out.println("Day : ");
                int day = scannerTwo.nextInt();
                dateTime.setDay(day);

                System.out.println("Hour : ");
                int hour = scanner.nextInt();
                dateTime.setHour(hour);

                System.out.println("Minute : ");
                int minute = scannerTwo.nextInt();
                dateTime.setMinute(minute);

                premierLeagueManager.addPlayedMatch(new Match(teamOneReg,teamTwoReg,teamOneGoals,teamTwoGoals,new DateTime(year,month,day,hour,minute)));
                //adding data to the list to save
                matchData.add(new Match(teamOneReg,teamTwoReg,teamOneGoals,teamTwoGoals,new DateTime(year,month,day,hour,minute)));
                System.out.println("Played match has been added successfully.");
                mainMenu();
                break;
            }
            //quit
            case 6: {
                System.out.println("---- Are you sure you want to exit ('y','n') ----");
                System.out.print("Exit : ");
                String confirmExit = scannerTwo.next();
                confirmExit = confirmExit.toLowerCase();

                if (confirmExit.equals("y")) {
                    //writing match data to a file--------------

                    try (
                            FileOutputStream fileOutputStream = new FileOutputStream("matchDetails.txt");
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    ) {

                        objectOutputStream.writeObject(matchData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //writing club data to a file--------------
                    Collections.sort(premierLeagueManager.getList());
                    premierLeagueManager.saveDetailsToFile();

                    System.out.println("All data has been written to a file successfully.");
                    System.exit(0);
                } else {
                    mainMenu();
                }

                break;
            }
            default:
                System.out.println("Invalid choice. Please enter again.");
                break;
        }
    }

//    public void readFile(File file) {
//
////        ArrayList<FootballClub> readList = new ArrayList();
//        if (file.length() == 0) {
//            System.out.println("No data was found in the save file.");
//        } else {
//            boolean flag = true;
//            try {
//                FileInputStream fileInputStream = new FileInputStream(file);
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//                List readList = (ArrayList) objectInputStream.readObject();
//                objectInputStream.close();
//                flag = false;
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

}



