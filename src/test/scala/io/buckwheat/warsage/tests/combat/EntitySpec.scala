package io.buckwheat.warsage.tests.combat

import io.buckwheat.warsage.combat.{ActionCase, Attack, DamageType, Entity}
import io.buckwheat.warsage.dice.RollHelpers._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class EntitySpec extends AnyFlatSpec with should.Matchers {
  "Entity" should "produce a seq of all possible outcomes of its actions" in {
    val target1 = new Entity("t1",11, List.empty)
    val target2 = new Entity("t2",13, List.empty)

    val attack1 = new Attack(0, 1 d 2, DamageType.Psychic)
    val attack2 = new Attack(3, 1 d 3, DamageType.Psychic)

    val expected1 = ActionCase(attack1, Seq(target1))
    val expected2 = ActionCase(attack1, Seq(target2))
    val expected3 = ActionCase(attack2, Seq(target1))
    val expected4 = ActionCase(attack2, Seq(target2))

    val entity = new Entity("e1",10, Seq(attack1, attack2))

    entity.performAction(Seq(target1, target2)).toList should
      contain theSameElementsAs List(expected1, expected2, expected3, expected4)
  }
}
