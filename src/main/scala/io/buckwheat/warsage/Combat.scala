package io.buckwheat.warsage

import io.buckwheat.warsage.combat._
import io.buckwheat.warsage.dice.RollHelpers._

object Combat {

  def run(): Unit = {
    val lvl1Fighter = new Entity("lvl1 Fighter", 18, Seq(new Attack(5, 1 d 8 mod 3, DamageType.Slashing)))
    val lvl1Warlock = new Entity("lvl1 Warlock", 15, Seq(new Attack(5, 1 d 10, DamageType.Force)))
    val goblin1 = new Entity("goblin 1", 15, Seq(new Attack(4, 1 d 6 mod 2, DamageType.Slashing)))
    val goblin2 = new Entity("goblin 2", 15, Seq(new Attack(4, 1 d 6 mod 2, DamageType.Slashing)))

    val (sideAresult, sideBresult) = new Turn(Seq(lvl1Fighter, lvl1Warlock), Seq(goblin1, goblin2)).run()
    Console.println("Side A results:")
    sideAresult.foreach(outputResult)

    Console.println("Side B results:")
    sideBresult.foreach(outputResult)
  }

  private def outputResult(result: Tuple2[Entity, Seq[RoundOutcome]]): Unit = {
    val (entity, outcomes) = result
    val occurences = outcomes.groupBy(identity).view.mapValues(_.length)
    Console.println(s"--- ${entity.name}:")
    occurences.toList.sortBy({
      _._1.totalDamage
    })
      .foreach(entry => Console.println(s"${entry._1}: ${entry._2}/${outcomes.length} (${entry._2.toDouble * 100 / outcomes.length} %)"))
    Console.println()
  }
}
