package advanced_challenge

import java.util.*

/**
 * Translated to Kotlin by Kevin Germain & also made some minor changes
 * Original author in Java
 * @author Alex Lee
 * His Youtube channel: https://www.youtube.com/channel/UC_fFL5jgoCOrwAVoM_fBYwA
 *  */

object TicTacToeGameKotlin {
    private val playerPositions = ArrayList<Int>()
    private val cpuPositions = ArrayList<Int>()
    private val gameBoard = arrayOf(
        charArrayOf(' ', '|', ' ', '|', ' '),
        charArrayOf('-', '+', '-', '+', '-'),
        charArrayOf(' ', '|', ' ', '|', ' '),
        charArrayOf('-', '+', '-', '+', '-'),
        charArrayOf(' ', '|', ' ', '|', ' ')
    )

    private fun printGameBoard() {
        for (row in gameBoard) {
            for (el in row) {
                print(el)
            }
            println()
        }
    }

    private fun placeInputInGameBoard(placement: Int, user: String) {
        var symbol = ' '
        if (user == "cpu") {
            symbol = 'O'
            cpuPositions.add(placement)
        } else if (user == "player") {
            symbol = 'X'
            playerPositions.add(placement)
        }
        when (placement) {
            1 -> gameBoard[0][0] = symbol
            2 -> gameBoard[0][2] = symbol
            3 -> gameBoard[0][4] = symbol
            4 -> gameBoard[2][0] = symbol
            5 -> gameBoard[2][2] = symbol
            6 -> gameBoard[2][4] = symbol
            7 -> gameBoard[4][0] = symbol
            8 -> gameBoard[4][2] = symbol
            9 -> gameBoard[4][4] = symbol
        }
    }

    private fun checkIfThereIsAWinner(): String {
        val topRowOf2dArray = listOf(1, 2, 3)
        val middleRowOf2dArray = listOf(4, 5, 6)
        val bottomRowOf2dArray = listOf(7, 8, 9)
        val topColumnOf2dArray = listOf(1, 4, 7)
        val middleColumnOf2dArray = listOf(2, 5, 8)
        val bottomColumnOf2dArray = listOf(3, 6, 9)
        val midCrossingOf2dArray1 = listOf(1, 5, 9)
        val midCrossingOf2dArray2 = listOf(7, 5, 3)
        val winningConditions: MutableList<List<Int>> = ArrayList()
        winningConditions.add(topRowOf2dArray)
        winningConditions.add(middleRowOf2dArray)
        winningConditions.add(bottomRowOf2dArray)
        winningConditions.add(topColumnOf2dArray)
        winningConditions.add(middleColumnOf2dArray)
        winningConditions.add(bottomColumnOf2dArray)
        winningConditions.add(midCrossingOf2dArray1)
        winningConditions.add(midCrossingOf2dArray2)
        for (aWinCondition in winningConditions) {
            when {
                playerPositions.containsAll(aWinCondition) -> {
                    return "Congratulations, you won !"
                }
                cpuPositions.containsAll(aWinCondition) -> {
                    return "CPU wins! Next time !"
                }
                playerPositions.size + cpuPositions.size == 9 -> {
                    return "CAT!"
                }
            }
        }
        return ""
    }

    @JvmStatic
    fun main(args: Array<String>) {
        printGameBoard()
        while (true) {
            val scanner = Scanner(System.`in`)
            print("Enter your placement (1-9) : ")
            var playerPlacement = scanner.nextInt()
            while (playerPositions.contains(playerPlacement) || cpuPositions.contains(playerPlacement)) {
                println("Position taken! Please enter one that isn't taken")
                playerPlacement = scanner.nextInt()
            }
            placeInputInGameBoard(playerPlacement, "player")
            var result = checkIfThereIsAWinner()
            if (result.isNotEmpty()) {
                println(result)
                break
            }
            val random = Random()
            var cpuPlacement = random.nextInt(9) + 1
            while (cpuPositions.contains(cpuPlacement) || playerPositions.contains(cpuPlacement)) {
                println("Cpu thinking to add a valid position")
                cpuPlacement = random.nextInt(9) + 1
            }
            placeInputInGameBoard(cpuPlacement, "cpu")
            printGameBoard()
            result = checkIfThereIsAWinner()
            if (result.isNotEmpty()) {
                println(result)
                break
            }
        }
    }
}
