GameBoard gb1 = new GameBoard()
println gb1.toString()
def cross = new Random().nextBoolean()
while (!gb1.isGameEnded){

    def reader = System.in.newReader()
    if (cross) {
        println("enter position player X")
    } else {
        println("enter pisition player ${Values.ZERO.value}")
    }

    switch (cross) {
        case true:
            cross = false
            def position = reader.readLine().toInteger() - 1
            while (!(gb1.isNotOccupied(position))) {
                println("Occupied, enter again")
                position = reader.readLine().toInteger() - 1
            }
            gb1.setElement(position, Values.CROSS)
            break
        case false:
            gb1.setElement(ArtificialInt.doMove(gb1),Values.ZERO)
            cross = true
            break
    }
    println (gb1.toString())
    println((Values.NO in gb1.gameBoard))
    gb1.victoryCheck()
}

