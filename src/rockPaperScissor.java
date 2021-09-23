import java.util.Scanner;

public class rockPaperScissor {

    //Starting variabler og kommandoer for spillet selv
    public static void main(String[] args) {

        //Starting variabler som bliver brugt i forhold til hvilken mode man gerne vil spille
        int rounds = 4;
        boolean vsBot = false;
        boolean vsPlayer = false;

        //Brugeren fortæller hvilken mode de gerne vil spille
        Scanner scanner = new Scanner(System.in);
        System.out.println("Multiplayer or Offline? ");
        String userInput = scanner.nextLine();

        //If kommandoer som vælger gamemode ud fra userInput
        if (userInput.equals("Multiplayer")) {
            vsPlayer = true;
            System.out.println("You have chosen to play against a Player 2");
        } else if (userInput.equals("Offline")) {
            vsBot = true;
            System.out.println("You have chosen to play against a bot");
        } else {
            System.out.println("I couldnt make out what you were saying, soo i will assume you want to play offline");
            vsBot = true;
        }

        if (vsBot == true) {
            playBot(rounds);
        } else if (vsPlayer == true)
            playPlayer(rounds);

    }

    //Mod bot som er en smule bugged hvis man ikke spiller i debug mode
    //Læs mere om det på bunden af programmet
    public static void playBot(int rounds) {
        //Starting booleans for at programmet ikke går i stå til at begynde med
        boolean playerWin = false;
        boolean botWin = false;

        //En for loop som spiller spillet
        for (int i = 0; i < rounds; i++) {
            //Først brugerens valg a move
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Player 1 choose a move between rock, paper or scissor: ");
            String player1Move = scanner1.nextLine();

            //Bottens valg af move ud fra en rng rand kommando
            System.out.println("We will now use our toaster IQ ai pick a random move: ");
            int rand = (int) (Math.random() * 3);
            String botMove = "";
            if (rand == 0) {
                botMove = "rock";
            } else if (rand == 1) {
                botMove = "paper";
            } else if (rand == 2) {
                botMove = "scissor";

            }

            //Her kommer den store if kommando liste over forskellige resultater ud fra spillerens og bottens move
            //Den beslutter sig så for med booleans fra før hvem der vandt ved at sætte dem true
            if (player1Move.equals(botMove)) {
                System.out.println("Its a draw");
                playerWin = false;
                botWin = false;
            } else if (player1Move.equals("rock") && botMove.equals("scissor")) {
                playerWin = true;
                botWin = false;
            } else if (player1Move.equals("paper") && botMove.equals("rock")) {
                playerWin = true;
                botWin = false;
            } else if (player1Move.equals("scissor") && botMove.equals("paper")) {
                playerWin = true;
                botWin = false;
            } else if (player1Move.equals("rocks") && botMove.equals("paper")) {
                botWin = true;
                playerWin = false;
            } else if (player1Move.equals("paper") && botMove.equals("scissor")) {
                botWin = true;
                playerWin = false;
            } else if (player1Move.equals("scissor") && botMove.equals("rock")) {
                botWin = true;
                playerWin = false;
            }

            //Der kommer svarene til hvem der vandt
            if (playerWin == true) {
                System.out.println("Player 1 has won");
            } else if (botWin == true) {
                System.out.println("The bot wins");
            }


        }
    }

    //Mod weak ass spiller 2
    public static void playPlayer(int rounds) {

        //Begyndelse booleans for programmer ikke cocker i det
        boolean player1Win = false;
        boolean player2Win = false;
        int endingRound = 1;

        //Scanner der tjekker for navne af spiller 1 og 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 tell me your name");
        String player1Name = scanner.nextLine();
        System.out.println("And since we have a player 2, please tell me your name");
        String player2Name = scanner.nextLine();

        //Spillet begynder her
        for (int j = 0; j < rounds; j++) {

            //Spiller 1 sætter deres move ind
            Scanner scanner1 = new Scanner(System.in);
            System.out.println(player1Name + " choose a move between rock, paper or scissor: ");
            String player1Move = scanner1.nextLine();

            //Anti cheat system
            System.out.println("//////////////////////////////////////////////");
            System.out.println("//////////////////////////////////////////////");
            System.out.println("//////////////////////////////////////////////");
            System.out.println("//////////////////////////////////////////////");

            //Spiller 2 sætter deres move ind
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Now look away gay ass " + player1Name + " and let " + player2Name + " pick now: ");
            String player2Move = scanner2.nextLine();

            //Det samme som i vsBot har jeg bare sammenlignet alle de forskellige resultater, til hvem der vinder
            if (player1Move.equals(player2Move)) {
                System.out.println("Its a draw");
                player1Win = false;
                player2Win = false;
            } else if (player1Move.equals("rock") && player2Move.equals("scissor")) {
                player1Win = true;
                player2Win = false;
            } else if (player1Move.equals("paper") && player2Move.equals("rock")) {
                player1Win = true;
                player2Win = false;
            } else if (player1Move.equals("scissor") && player2Move.equals("paper")) {
                player1Win = true;
                player2Win = false;
            } else if (player1Move.equals("rock") && player2Move.equals("paper")) {
                player2Win = true;
                player1Win = false;
            } else if (player1Move.equals("paper") && player2Move.equals("scissor")) {
                player2Win = true;
                player1Win = false;
            } else if (player1Move.equals("scissor") && player2Move.equals("rock")) {
                player2Win = true;
                player1Win = false;
            }

            //Her kommer beskeden op hvem der har vandt ud fra hvilken boolean var true
            if (player1Win == true) {
                System.out.println(player1Name + " wins round " + endingRound);
                System.out.println(player2Name + " loses round " + endingRound);
            } else if (player2Win == true) {
                System.out.println(player2Name + " wins round " + endingRound);
                System.out.println(player1Name + " loses round " + endingRound);
            } else {
                System.out.println("ERROR NO WINNERS");
            }
            //Siden vi skulle have en bestemt mængde runder har vi en slut kommando som skal tælle et point op for hver loop af vores for loop
            endingRound += 1;
            System.out.println("Starting next round: ");
        }

    }
}
//Af en eller anden grund hvis man ikke spiller i debug mode og markere vsBot delen, så vil botten altid
//Vælge det første resultat de har fået for hver runde. Altså de altid vælger sten hvilket er ret
//underligt
