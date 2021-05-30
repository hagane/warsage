package io.buckwheat.warsage.combat

trait Action {
  def performAction(targets: Seq[Entity]): Seq[ActionCase]

  def resolveFor(target: Entity): Seq[Outcome]
}
