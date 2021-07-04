abstract class Score(
    protected val player1: Player,
    protected val player2: Player
) {

    abstract fun isAvailable(): Boolean

    abstract fun getScore(): String
}