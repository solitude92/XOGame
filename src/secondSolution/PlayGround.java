package secondSolution;


import java.util.Scanner;


public class PlayGround {
    public static void main(String[] args) {

        Player player1 = new Player("First Player");
        Player player2 = new Player("Second Player");
        boolean playerTurn = true;
        boolean isChanged = false;
        secondSolution.Marble xMarble = new secondSolution.Marble("X");
        secondSolution.Marble oMarble = new secondSolution.Marble("O");
        String firstMarble;
        System.out.println("\n:-:-:-:-:-:-:WELCOME TO THE GAME:) GET READY AND CHOOSE YOUR MARBLE:-:-:-:-:-:-:\n");

        do {//loop to start the game
            do {//Choose the marble by first player
                Scanner input = new Scanner(System.in);
                System.out.println("Enter X or O to select your own marbles as first player:");
                firstMarble = input.next();
                if (firstMarble.equals("X") || firstMarble.equals("x")) {
                    player1.type = xMarble;
                    player2.type = oMarble;
                    System.out.println("\nSo second player get 'O' marbles automatically:)");
                    break;
                } else if (firstMarble.equals("O") || firstMarble.equals("o")) {
                    player2.type = xMarble;
                    player1.type = oMarble;
                    System.out.println("\nSo second player get 'X' marbles automatically:)");
                    break;
                } else
                    System.out.println("ENTER A VALID INPUT!!");
            } while (true);


            do {//Toggle between players and inserting the moves
                if (playerTurn) {
                    isChanged = playGame(player1, isChanged);
                    if (PlaygroundXOGame.winner(player1))
                        break;
                    playerTurn = false;

                } else {
                    isChanged = playGame(player2, isChanged);
                    if (PlaygroundXOGame.winner(player2))
                        break;
                    playerTurn = true;
                }
                if (!isChanged)
                    break;


            } while (true);
            System.out.println("Game was ended, do you wanna play again?(y/n):");
            Scanner input = new Scanner(System.in);
            String continuing = input.next();
            if (continuing.equals("n"))
                break;
            else {
                System.out.println("Fine, keep calm and enjoy another game :D");
                PlaygroundXOGame.reset();
            }
        } while (true);
    }


    private static boolean playGame(Player player, boolean isChanged) {
        int row;
        if (!PlaygroundXOGame.isFull()) {
            System.out.println("<-----  IT'S " + player.name + " TURN WITH MARBLE " + player.type.type + "  ----->");
            System.out.println("Enter your move number from below diagram: ");
            PlaygroundXOGame.print();


            do {//Get moves and modify the playground
                System.out.println("ENTER ROW & COLUMN");
                Scanner input = new Scanner(System.in);
                row = input.nextInt();
                if (row <= 9 && row > 0) {
                    isChanged = PlaygroundXOGame.insert(row - 1, player);
                    if (!isChanged) {
                        System.out.println("NOT EMPTY, ENTER A PROPER NUMBER: ");
                    } else {
                        PlaygroundXOGame.print(1);
                    }
                } else
                    System.out.println("Enter valid number : ");

            } while (!isChanged);
            return true;
        } else
            return false;
    }

}
