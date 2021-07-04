class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1: Player = Player("player1")
    private var player2: Player = Player("player2")

    private val list by lazy {
        listOf(
            TieScore(player1, player2),
            NoCheckPointScore(player1, player2),
            NormalScore(player1, player2)
        )
    }

    override fun wonPoint(playerName: String) {
        if (player1.name == "player1")
            player1.score++
        else
            player2.score++
    }

    override fun getScore(): String {
        return list.first { it.isAvailable() }.getScore()
    }
}
