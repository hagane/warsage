package io.buckwheat.warsage.combat

import io.buckwheat.warsage.combat.DamageType.DamageType
import io.buckwheat.warsage.dice.Roll
import io.buckwheat.warsage.dice.RollHelpers._

class Attack(attackMod: Int, damage: Roll, damageType: DamageType) extends Action {
  private val damageRolls = damage.rolls
  private val zeroes = List.fill(damageRolls.length)(0)

  def performAction(targets: Seq[Entity]): Seq[ActionCase] = {
    targets.map({target => ActionCase(this, Seq(target))})
  }

  override def resolveFor(target: Entity): Seq[Outcome] = {
    (1 d 20).rolls.flatMap(attackCase(target.armorClass)).map({Damage(damageType, _)})
  }

  private def attackCase(ac: Int)(roll: Int) =
    if (roll + attackMod >= ac) damageRolls else zeroes
}
