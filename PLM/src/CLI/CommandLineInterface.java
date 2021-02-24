package CLI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    public static List readList = new ArrayList();
    public static int counter = 0;

    public static void main(String[] args) {

        File file = new File("footballClubDetails.txt");
        if (file.length()==0){
            System.out.println("No save data was found in the save file. ");

        }else {
//            try (
//                    FileInputStream fileInputStream = new FileInputStream("footballClubDetails.txt");
//                    ObjectInputStream objectinputstream = new ObjectInputStream(fileInputStream);
//            ) {
//
//                readList = (List) objectinputstream.readObject();
//                System.out.println(readList);
//
//                for (Object f: readList){
//                    counter++;
//                }
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
            try {

                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object footballClubArray = objectInputStream.readObject();
                readList = (ArrayList<FootballClub>) footballClubArray;
                System.out.println(readList);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Do nothing");
            }
        }
        Main main = new Main();
        main.mainMenu();
    }

    public int getCurrentValue(){return counter;  }
    public List<FootballClub> getList() {
        return readList;
    }
}
