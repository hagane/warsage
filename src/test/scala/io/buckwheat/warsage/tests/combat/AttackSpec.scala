package io.buckwheat.warsage.tests.combat

import io.buckwheat.warsage.combat._
import io.buckwheat.warsage.dice.RollHelpers._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class AttackSpec extends AnyFlatSpec with should.Matchers {
  "Attack" should "produce a seq of all possible action applications" in {
    val target1 = new Entity("e1",11, List.empty)
    val target2 = new Entity("e2",13, List.empty)

    val attack = new Attack(0, 1 d 2, DamageType.Psychic)

    attack.performAction(Seq(target1, target2)).toList should
      equal(List(ActionCase(attack, Seq(target1)), ActionCase(attack, Seq(target2))))
  }

  "Attack" should "resolve to a seq of possible damage outputs" in {
    val attack = new Attack(0, 1 d 2, DamageType.Psychic)
    val target = new Entity("e1",11, List.empty)

    attack.resolveFor(target) should equal((List.fill(10)(List(0, 0)) ++ List.fill(10)(List(1, 2))).flatten.map(Damage(DamageType.Psychic, _)))
  }
}
