import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int mapSizeY = 10;
        int mapSizeX = 20;

        // USERS
        int playerXCoord = GenerateRandomCoordinates(random, mapSizeX);
        int playerYCoord = GenerateRandomCoordinates(random, mapSizeY);
        char playerSymbol = 'x';

        int dragonXCoord = GenerateRandomCoordinates(random, mapSizeX);
        int dragonYCoord = GenerateRandomCoordinates(random, mapSizeY);
        char dragonSymbol = 'd';

        int knightXCoord = GenerateRandomCoordinates(random, mapSizeX);
        int knightYCoord = GenerateRandomCoordinates(random, mapSizeY);
        char knightSymbol = 'k';


        String input;

        do{
            UpdateMap(mapSizeX, mapSizeY,
                    playerXCoord, playerYCoord, playerSymbol,
                    knightXCoord, knightYCoord, knightSymbol,
                    dragonXCoord, dragonYCoord, dragonSymbol);

            input = scanner.nextLine();

            switch (input){
                case "w":
                    playerYCoord--;
                    break;
                case "a":
                    playerXCoord--;
                    break;
                case "s":
                    playerYCoord++;
                    break;
                case "d":
                    playerXCoord++;
                    break;
                case "end":
                    System.out.println("Ending game!");
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }

            // CONSTRAINTS
            if (playerXCoord >= mapSizeX - 1){
                playerXCoord = mapSizeX - 2;
            } else if (playerXCoord <= 0) {
                playerXCoord = 1;
            }

            if (playerYCoord >= mapSizeY - 1){
                playerYCoord = mapSizeY - 2;
            } else if (playerYCoord <= 0) {
                playerYCoord = 1;
            }
            // =====

        }while (!input.equals("end"));
    }//med

    private static int GenerateRandomCoordinates(Random random, int mapBounds) {
        return random.nextInt(1, mapBounds - 2);
    }// func

    public static void UpdateMap(
            int xCord,
            int yCord,
            int userCordX,
            int userCordY,
            char userSymbol,
            int knightCordX,
            int knightCordY,
            char knightSymbol,
            int dragonCordX,
            int dragonCordY,
            char dragonSymbol){

        for (int y = 0; y < yCord; y++) {
            char symbol;
            for (int x = 0; x < xCord; x++) {
                if (y == 0 || y == yCord - 1) {
                    symbol = '-';
                } else if (x == 0 || x == xCord - 1) {
                    symbol = '|';
                } else {
                    if (x == userCordX && y == userCordY){
                        symbol = userSymbol;
                    }
                    else if (x == knightCordX && y == knightCordY){
                        symbol = knightSymbol;
                    }
                    else if (x == dragonCordX && y == dragonCordY){
                        symbol = dragonSymbol;
                    }
                    else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }//for x
            System.out.println();
        }//for y
    }//func
} //klass

