class TieScore(
    player1: Player,
    player2: Player
) : Score(player1, player2) {
    override fun isAvailable(): Boolean {
        return player1.score == player2.score
    }

    override fun getScore(): String {
        return if (player1.score >= 3) {
            DEUCE
        } else {
            SpecialScore.getScore(player1.score).displayName + "-All"
        }
    }

    companion object {
        const val DEUCE = "Deuce"
    }
}