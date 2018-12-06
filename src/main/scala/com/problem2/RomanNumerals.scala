package com.problem2

object RomanNumerals extends Enumeration {
  type RomanNumerals = Value
  val M = Value(1000, "M")
  val D = Value(500, "D")
  val C = Value(100, "C")
  val L = Value(50, "L")
  val X = Value(10, "X")
  val V = Value(5, "V")
  val I = Value(1, "I")
}
