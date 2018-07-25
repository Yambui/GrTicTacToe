import static Values.*

class GameBoard{

    Values[] gameBoard
    boolean isGameEnded

    GameBoard(){
        this.gameBoard = new Values[9]
            for (int i = 0; i<9; i++){
                gameBoard[i] = Values.NO
            }
        this.isGameEnded = false
    }

    @Override
    String toString() {
        String result ="""Current game board:
${gameBoard[0].value}|${gameBoard[1].value}|${gameBoard[2].value}
${gameBoard[3].value}|${gameBoard[4].value}|${gameBoard[5].value}
${gameBoard[6].value}|${gameBoard[7].value}|${gameBoard[8].value}
_______"""
    }

    void setElement (int index, Values value){
        if (!isGameEnded) {
            this.gameBoard[index] = value
        } else {
            println("Game ended")
        }
    }

    void victoryCheck (){
        if (((gameBoard[0] == gameBoard[1]) && (gameBoard[0] == gameBoard[2]))
                || ((gameBoard[0] == gameBoard[3]) && (gameBoard[0] == gameBoard[6]))) {
            if (gameBoard[0] != Values.NO) {
                endGamePrintWinner(gameBoard[0])
                return
                }
        }
        if (((gameBoard[4] == gameBoard[3]) && (gameBoard[4] == gameBoard[5]))
                || ((gameBoard[4] == gameBoard[1]) && (gameBoard[4] == gameBoard[7]))
                || ((gameBoard[4] == gameBoard[0]) && (gameBoard[4] == gameBoard[8]))
                || ((gameBoard[4] == gameBoard[2]) && (gameBoard[4] == gameBoard[6]))) {
            if (gameBoard[4] != Values.NO) {
                endGamePrintWinner(gameBoard[4])
                return
            }
        }
        if (((gameBoard[8] == gameBoard[2]) && (gameBoard[8] == gameBoard[5]))
                || ((gameBoard[8] == gameBoard[6]) && (gameBoard[8] == gameBoard[7]))) {
            if (gameBoard[8] != Values.NO) {
                endGamePrintWinner(gameBoard[8])
                return
            }
        }
        if (!(Values.NO in gameBoard)){
            println("Draw")
            isGameEnded = true
            return
        }

    }
    void endGamePrintWinner(Values value){
        isGameEnded = true
        println "Game ended, winner is ${value.value}"
    }
    boolean isNotOccupied (int index){
        if (gameBoard[index] == Values.NO){
            return true
        }
        false
    }

}
