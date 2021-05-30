package io.buckwheat.warsage.combat

trait Outcome {
  def addTo(roundOutcome: RoundOutcome): RoundOutcome
}
