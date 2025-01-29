import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class rockPaperScissor {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            // Initialise user_menu_choice to None
            int user_menu_choice;
            OUTER:
            while (true) {
                System.out.println("1 to play the game");
                System.out.println("2 to exit the game");
                if(scan.hasNextInt()){
                    user_menu_choice = scan.nextInt();
                } else{
                    user_menu_choice = 0;
                }
                    scan.nextLine();
                switch (user_menu_choice) {
                    case 1 -> play_user(scan);
                    case 2 -> {
                        // Break the while loop to exit out of the program
                        System.out.println("Exiting program...");
                        break OUTER;
                    }
                    // I'm surprised that this line of code works even for invalid integer inputs and also string inputs.
                    // I wonder if python also does the same. Never used the default case in python
                    default -> System.out.println("Please enter a valid integer between 1 or 2");
                }
            }
        }
    }
    public static void play_user(Scanner scan){
        String user_choice;
        System.out.println("What would you like to play?");
        System.out.println("(rock, paper, scissors)");
        user_choice = scan.nextLine().toLowerCase();
        // If I was using a number option system like the main menu then I could use a switch-case statement but
        // Since the inputs are strings, it is kinda hard. I wonder how you could make this work
        check_winner(user_choice);
    }
    public static void check_winner(String user_choice){
        // Making the computer choose between 0-2 (inclusive) to determine whether the computer chose paper, scissors, or rock
        Random random = new Random();
        int computer_choice = random.nextInt(3);
        // Making a list to put the items in
        List<String> p = new ArrayList<>();
        p.add("scissor");
        p.add("paper");
        p.add("rock");
        // Getting the computer choice by indexing the list
        // The other option before this was 3 switch-cases which I didn't like
        String k = p.get(computer_choice);

        System.out.printf("You chose %s and the computer chose %s", user_choice, k);
        // Checking each game-state
        // I could do this an easier way in python but idk how to in java.
        if(user_choice.equals(k)){
            System.out.println("\nIt's a draw!!!");
        } else if("paper".equals(user_choice) && "rock".equals(k)){
            System.out.println("\nYou win!!!");
        } else if("paper".equals(user_choice) && "scissor".equals(k)){
            System.out.println("\nYou lose!!!");
        } else if("scissor".equals(user_choice) && "rock".equals(k)){
            System.out.println("\nYou lose!!!");
        } else if("rock".equals(user_choice) && "scissor".equals(k)){
            System.out.println("\nYou win!!!");
        } else if("rock".equals(user_choice) && "paper".equals(k)){
            System.out.println("\nYou lose!!!");
        } else if("scissor".equals(user_choice) && "paper".equals(k)){
            System.out.println("\nYou win!!!");
        }
    }
}