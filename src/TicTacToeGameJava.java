import java.util.*;

public class TicTacToeGameJava {
    private static final ArrayList<Integer> playerPositions = new ArrayList<>();
    private static final ArrayList<Integer> cpuPositions = new ArrayList<>();

    private static final char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
    };

    private static void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char el : row) {
                System.out.print(el);
            }
            System.out.println();
        }
    }

    private static void placeInputInGameBoard(int placement, String user) {
        char symbol = ' ';
        if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(placement);
        } else if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(placement);
        }

        switch (placement) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    private static String checkIfThereIsAWinner() {
        var topRowOf2dArray = Arrays.asList(1, 2, 3);
        var middleRowOf2dArray = Arrays.asList(4, 5, 6);
        var bottomRowOf2dArray = Arrays.asList(7, 8, 9);

        var topColumnOf2dArray = Arrays.asList(1, 4, 7);
        var middleColumnOf2dArray = Arrays.asList(2, 5, 8);
        var bottomColumnOf2dArray = Arrays.asList(3, 6, 9);

        var midCrossingOf2dArray1 = Arrays.asList(1, 5, 9);
        var midCrossingOf2dArray2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> winningConditions = new ArrayList<>();
        winningConditions.add(topRowOf2dArray);
        winningConditions.add(middleRowOf2dArray);
        winningConditions.add(bottomRowOf2dArray);
        winningConditions.add(topColumnOf2dArray);
        winningConditions.add(middleColumnOf2dArray);
        winningConditions.add(bottomColumnOf2dArray);
        winningConditions.add(midCrossingOf2dArray1);
        winningConditions.add(midCrossingOf2dArray2);

        for (var aWinCondition : winningConditions) {
            if (playerPositions.containsAll(aWinCondition)) {
                return "Congratulations, you won !";
            } else if (cpuPositions.containsAll(aWinCondition)) {
                return "CPU wins! Next time !";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        printGameBoard();
        while (true) {
            var scanner = new Scanner(System.in);
            System.out.print("Enter your placement (1-9) : ");
            var playerPlacement = scanner.nextInt();
            while (playerPositions.contains(playerPlacement) || cpuPositions.contains(playerPlacement)) {
                System.out.println("Position taken! Please enter one that isn't taken");
                playerPlacement = scanner.nextInt();
            }
            placeInputInGameBoard(playerPlacement, "player");
            var result = checkIfThereIsAWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            var random = new Random();
            var cpuPlacement = random.nextInt(9) + 1;
            while (cpuPositions.contains(cpuPlacement) || playerPositions.contains(cpuPlacement)) {
                System.out.println("Cpu thinking to add a valid position");
                cpuPlacement = random.nextInt(9) + 1;
            }
            placeInputInGameBoard(cpuPlacement, "cpu");
            printGameBoard();
            result = checkIfThereIsAWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
