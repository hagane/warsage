package io.buckwheat.warsage

import io.buckwheat.warsage.encounters.EncounterPlan

import scala.annotation.tailrec

object Encounters {

  def run(params: Seq[String]): Unit = {
    val paramsMap = readParams(params)
    //TODO validate params
    val levels = paramsMap("levels").split(',').map(_.toInt)
    val encounterPlan = new EncounterPlan(levels)
    println(s"Party levels: ${levels.toList}")
    println(s"Total XP Budget: ${encounterPlan.xpBudget}")
    encounterPlan.plan_encounters().foreach(enc => println(s"Encounter: ${enc.difficulty}/${enc.xpBudget} XP"))
  }

  @tailrec
  private def readParams(params: Seq[String], paramsMap: Map[String, String] = Map.empty): Map[String, String] = {
    params match {
      case Seq("--levels" | "-l", levels, rest@_*) => readParams(rest, paramsMap + ("levels" -> levels))
      case Seq() => paramsMap
      case Seq(unknown, _*) => throw new IllegalArgumentException(s"Unknown arg: $unknown")
    }
  }
}
