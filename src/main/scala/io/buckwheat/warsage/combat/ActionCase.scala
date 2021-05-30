package io.buckwheat.warsage.combat

case class ActionCase(action: Action, targets: Seq[Entity]) {

  override def toString: String = s"${action.toString} => ${targets.toString}"
}
