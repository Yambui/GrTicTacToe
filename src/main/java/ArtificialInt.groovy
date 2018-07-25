class ArtificialInt {
    static int doMove (GameBoard gboard){
        def pos = new Random().nextInt(8)
        if (gboard.isNotOccupied(4)) {
            return 4
        }
        while(!gboard.isNotOccupied(pos)) {
        pos = new Random().nextInt(9)
        }
        return pos
    }
}
