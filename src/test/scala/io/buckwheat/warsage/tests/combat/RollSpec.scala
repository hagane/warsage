package io.buckwheat.warsage.tests.combat

import io.buckwheat.warsage.dice.RollHelpers._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class RollSpec extends AnyFlatSpec with should.Matchers {
  "A Roll" should "produce a seq of all possibile outcomes" in {
    (1 d 6).rolls.toList should equal(List(1, 2, 3, 4, 5, 6))
    d(6).rolls.toList should equal(List(1, 2, 3, 4, 5, 6))
    (1 d 6 mod 1).rolls.toList should equal(List(2, 3, 4, 5, 6, 7))

    (2 d 4).rolls.toList should equal(List(2, 3, 4, 5, 3, 4, 5, 6, 4, 5, 6, 7, 5, 6, 7, 8))
  }
}
