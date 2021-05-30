package io.buckwheat.warsage.combat

class Turn(sideA: Seq[Entity], sideB: Seq[Entity]) {

  def run(): Tuple2[Seq[Tuple2[Entity, Seq[RoundOutcome]]], Seq[Tuple2[Entity, Seq[RoundOutcome]]]] = {
    val sideAOutcomes = runSide(sideA, sideB)
    val sideBOutcomes = runSide(sideB, sideA)

    (sideAOutcomes, sideBOutcomes)
  }

  def runSide(actors: Seq[Entity], targets: Seq[Entity]): Seq[Tuple2[Entity, Seq[RoundOutcome]]] = {
    val actionCases = actors.map({actor => actor.performAction(targets)})
    val roundCases = buildRoundCases(actionCases)
    for {target <- targets} yield outcomes(target, roundCases)
  }

  private def buildRoundCases(actionCases: Seq[Seq[ActionCase]]): Seq[Seq[ActionCase]] = {
    val entityActionCases = actionCases.head
    val restActionCases = actionCases.tail
    if (restActionCases.isEmpty) entityActionCases.map({Seq(_)})
    else for {ea <- entityActionCases; roundActions <- buildRoundCases(restActionCases)} yield roundActions.appended(ea)
  }

  private def outcomes(target: Entity, roundCases: Seq[Seq[ActionCase]]) = {
    (target, roundCases.flatMap(outcome(target, _)))
  }

  private def outcome(target: Entity, roundCase: Seq[ActionCase]): Seq[RoundOutcome] = {
    val action = roundCase.head
    val rest = roundCase.tail
    if (rest.isEmpty) action.action.resolveFor(target).map(_.addTo(RoundOutcome(Map.empty)))
    else for {a <- action.action.resolveFor(target); r <- outcome(target, rest)} yield a.addTo(r)
  }
}
