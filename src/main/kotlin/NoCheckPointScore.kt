class NoCheckPointScore(
    player1: Player,
    player2: Player
) : Score(player1, player2) {

    override fun isAvailable(): Boolean {
        return player1.score <= 3 && player2.score <= 3
    }

    override fun getScore(): String {
        val score1 = SpecialScore.getScore(player1.score)
        val score2 = SpecialScore.getScore(player2.score)
        return score1.displayName + "-" + score2.displayName
    }
}
