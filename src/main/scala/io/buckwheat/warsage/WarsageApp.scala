package io.buckwheat.warsage

object WarsageApp {

  def main(args: Array[String]): Unit = {
    args match {
      case Array("combat", _*) => Combat.run()
      case Array("encounters", params @ _*) => Encounters.run(params)
      case _ => Usage.run(args)
    }
  }
}
