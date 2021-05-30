package io.buckwheat.warsage.dice

class Roll(n: Int = 1, die: Int, mod: Int = 0) {
  private val possibilities = 1 to die

  def rolls: Seq[Int] = {
    if (n <= 1) possibilities.map({_ + mod})
    else for {p <- possibilities; prev <- new Roll(n - 1, die).rolls} yield p + prev
  }

  def mod(mod: Int): Roll = new Roll(n, die, mod)

  override def toString: String = s"${n}d$die+$mod"
}

object RollHelpers {
  implicit class Rollable(n: Int) {
    def d(die: Int): Roll = new Roll(n, die)
  }

  def d(die: Int): Roll = 1 d die
}