package io.buckwheat.warsage.encounters

import scala.annotation.tailrec
import scala.util.Random

class EncounterPlan(levels: Seq[Int]) {
  val xpBudget: Int = levels.map(ExperienceTables.xp_per_day).sum
  private val easyEncXp = levels.map(ExperienceTables.easy_encounter).sum
  private val mediumEncXp = levels.map(ExperienceTables.medium_encounter).sum
  private val hardEncXp = levels.map(ExperienceTables.hard_encounter).sum
  private val deadlyEncXp = levels.map(ExperienceTables.deadly_encounter).sum
  private val shortRestThreshold = (easyEncXp + mediumEncXp + hardEncXp + deadlyEncXp) / 2
  private val random = new Random()

  @tailrec
  final def plan_encounters(encounters: List[Encounter] = List(), totalXp: Int = 0, xpToShortRest: Int = shortRestThreshold): List[Encounter] = {
    if (totalXp + easyEncXp >= xpBudget ) {
      encounters.reverse
    } else if (xpToShortRest <= easyEncXp) {
      plan_encounters(Encounter("Short Rest") :: encounters, totalXp, shortRestThreshold)
    } else {
      val encounter = new_encounter(xpBudget - totalXp, xpToShortRest)
      plan_encounters(encounter :: encounters, totalXp + encounter.xpBudget, xpToShortRest - encounter.xpBudget)
    }
  }

  private def new_encounter(dailyXpLeft: Int, xpToShortRest: Int): Encounter = {
    if (dailyXpLeft >= deadlyEncXp && xpToShortRest >= hardEncXp) {
      t1_encounter()
    } else if (dailyXpLeft >= hardEncXp && xpToShortRest >= mediumEncXp) {
      t2_encounter()
    } else {
      t3_encounter()
    }
  }

  private def t1_encounter() = {
    List(
      Encounter("Easy", easyEncXp),
      Encounter("Medium", mediumEncXp),
      Encounter("Hard", hardEncXp),
      Encounter("Deadly", deadlyEncXp)
    )(random.nextInt(4))
  }

  private def t2_encounter() = {
    List(
      Encounter("Easy", easyEncXp),
      Encounter("Medium", mediumEncXp),
      Encounter("Hard", hardEncXp)
    )(random.nextInt(3))
  }

  private def t3_encounter() = {
    List(
      Encounter("Easy", easyEncXp),
      Encounter("Medium", mediumEncXp)
    )(random.nextInt(2))
  }
}
