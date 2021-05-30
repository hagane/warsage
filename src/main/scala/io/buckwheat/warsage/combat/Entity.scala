package io.buckwheat.warsage.combat

class Entity(val name: String, val armorClass: Int, attacks: Seq[Attack]) {

  def performAction(targets: Seq[Entity]): Seq[ActionCase] = {
    attacks.flatMap(_.performAction(targets))
  }
}
