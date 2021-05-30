package io.buckwheat.warsage.encounters

object ExperienceTables {

  def xp_per_day(level: Int): Int = {
    level match {
      case 1 => 300
      case 2 => 600
      case 3 => 1200
      case 4 => 1700
      case 5 => 3500
      case 6 => 4000
      case 7 => 5000
      case 8 => 6000
      case 9 => 7500
      case 10 => 9000
      case 11 => 10500
      case 12 => 11500
      case 13 => 13500
      case 14 => 15000
      case 15 => 18000
      case 16 => 20000
      case 17 => 25000
      case 18 => 27000
      case 19 => 30000
      case 20 => 40000
      case invalid => throw new IllegalArgumentException(s"invalid character level: $invalid")
    }
  }

  def easy_encounter(level: Int): Int = {
    level match {
      case 1 => 25
      case 2 => 50
      case 3 => 75
      case 4 => 125
      case 5 => 250
      case 6 => 300
      case 7 => 350
      case 8 => 450
      case 9 => 550
      case 10 => 600
      case 11 => 800
      case 12 => 1000
      case 13 => 1100
      case 14 => 1250
      case 15 => 1400
      case 16 => 1600
      case 17 => 2000
      case 18 => 2100
      case 19 => 2400
      case 20 => 2800
      case invalid => throw new IllegalArgumentException(s"invalid character level: $invalid")
    }
  }

  def medium_encounter(level: Int): Int = {
    level match {
      case 1 => 50
      case 2 => 100
      case 3 => 150
      case 4 => 250
      case 5 => 500
      case 6 => 600
      case 7 => 750
      case 8 => 900
      case 9 => 1100
      case 10 => 1200
      case 11 => 1600
      case 12 => 2000
      case 13 => 2200
      case 14 => 2500
      case 15 => 2800
      case 16 => 3200
      case 17 => 3900
      case 18 => 4200
      case 19 => 4900
      case 20 => 5700
      case invalid => throw new IllegalArgumentException(s"invalid character level: $invalid")
    }
  }

  def hard_encounter(level: Int): Int = {
    level match {
      case 1 => 75
      case 2 => 150
      case 3 => 225
      case 4 => 375
      case 5 => 750
      case 6 => 900
      case 7 => 1100
      case 8 => 1400
      case 9 => 1600
      case 10 => 1900
      case 11 => 2400
      case 12 => 3000
      case 13 => 3400
      case 14 => 3800
      case 15 => 4300
      case 16 => 4800
      case 17 => 5900
      case 18 => 6300
      case 19 => 7300
      case 20 => 8500
      case invalid => throw new IllegalArgumentException(s"invalid character level: $invalid")
    }
  }

  def deadly_encounter(level: Int): Int = {
    level match {
      case 1 => 100
      case 2 => 200
      case 3 => 400
      case 4 => 500
      case 5 => 1100
      case 6 => 1400
      case 7 => 1700
      case 8 => 2100
      case 9 => 2400
      case 10 => 2800
      case 11 => 3600
      case 12 => 4500
      case 13 => 5100
      case 14 => 5700
      case 15 => 6400
      case 16 => 7200
      case 17 => 8800
      case 18 => 9500
      case 19 => 10900
      case 20 => 12700
      case invalid => throw new IllegalArgumentException(s"invalid character level: $invalid")
    }
  }
}
