package io.buckwheat.warsage

object Usage {

  def run(args: Array[String]): Unit = {
    Console.println("Usage:")
    Console.println(s"${args(0)} combat\n\t* run combat simulation\n")
    Console.println(s"${args(0)} encounters\n\t* create encounter plan\n")
  }
}
