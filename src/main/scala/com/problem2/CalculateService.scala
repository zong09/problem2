package com.problem2

trait CalculateService {
  val romanNumerals = List(("M", 1000),
                           ("CM", 900),
                           ("D", 500),
                           ("CD", 400),
                           ("C", 100),
                           ("XC", 90),
                           ("L", 50),
                           ("XL", 40),
                           ("X", 10),
                           ("IX", 9),
                           ("V", 5),
                           ("IV", 4),
                           ("I", 1))

  def calculator(input: String): String = {
    val plusNumber = input.trim.split('+')
    val result = plusNumber.map { x =>
      x.trim.split('-').map(convertRomanToNumber).reduce(_ - _)
    }.sum
    if (result > 3999) { throw new Exception("value shouldn't more than 3999") }
    convertNumberToRoman(result, romanNumerals)
  }

  private def convertRomanToNumber(romanNumber: String): Int = {
    romanNumber.toUpperCase
      .map(x => RomanNumerals.withName(x.toString).id)
      .foldLeft((0, 0)) {
        case ((sum, last), current) => (sum + current + (if (last < current) -2 * last else 0), current)
      }
      ._1
  }

  private def convertNumberToRoman(number: Int, romanNumerals: List[(String, Int)]): String = {
    romanNumerals match {
      case Nil          => ""
      case head :: tail => head._1 * (number / head._2) + convertNumberToRoman(number % head._2, tail)
    }
  }
}
