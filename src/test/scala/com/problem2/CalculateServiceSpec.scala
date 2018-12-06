package com.problem2

import org.scalatest.{Matchers, WordSpec}

class CalculateServiceSpec extends WordSpec with Matchers {
  val calculateService = new CalculateService {}
  "Calculate Service" should {
    "calculate plus number correctly" in {
      calculateService.calculator("XX+II") should be("XXII")
      calculateService.calculator("II+II") should be("IV")
      calculateService.calculator("XIV+LX") should be("LXXIV")
      calculateService.calculator("V+V") should be("X")
      calculateService.calculator("MMCMXCIX+M") should be("MMMCMXCIX")
    }

    "calculate minus number correctly" in {
      calculateService.calculator("XX-II") should be("XVIII")
      calculateService.calculator("II-II") should be("")
      calculateService.calculator("XIV-X") should be("IV")
    }

    "calculate plus and minus number correctly" in {
      calculateService.calculator("XX-II+V") should be("XXIII")
      calculateService.calculator("II-II+X") should be("X")
      calculateService.calculator("XIV-X+M") should be("MIV")
    }

    "throw exception when value more than 3999" in {
      an[Exception] should be thrownBy {
        calculateService.calculator("MMCMXCIX+MM")
      }
    }
  }
}
