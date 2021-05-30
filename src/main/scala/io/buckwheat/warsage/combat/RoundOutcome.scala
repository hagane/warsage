package io.buckwheat.warsage.combat

import io.buckwheat.warsage.combat.DamageType.DamageType

case class RoundOutcome(damage: Map[DamageType, Int]) extends Equals {
  override def canEqual(other: Any): Boolean = other.isInstanceOf[RoundOutcome]

  override def equals(other: Any): Boolean = other match {
    case that: RoundOutcome => this.damage == that.damage
    case _ => false
  }

  override def toString: String = {
    damage.map({ kv => s"${kv._2} ${kv._1}" }).mkString(", ")
  }

  def totalDamage: Int = damage.values.sum
}
