package sections;

import java.util.Scanner;

public class MainMenu {

    public static int printMenu(String[] menuItems, Scanner input){

        for(String menuItem: menuItems){
            System.out.println(menuItem);
        }

        int selectedNumber = input.nextInt();

        if(selectedNumber <= 0){
            System.out.println("Sorry Wrong input");
            System.exit(0);
        }

        return selectedNumber - 1;

    }

}
