package io.buckwheat.warsage.combat

import io.buckwheat.warsage.combat.DamageType.DamageType

case class Damage(damageType: DamageType, amount: Int) extends Outcome {
  override def addTo(roundOutcome: RoundOutcome): RoundOutcome = {
    val updatedDamage = roundOutcome.damage.updatedWith(damageType) {
      case None => Some(amount)
      case Some(prevDamage) => Some(prevDamage + amount)
    }

    RoundOutcome(updatedDamage)
  }
}
