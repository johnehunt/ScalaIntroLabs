package com.jjh.bowling

import scala.annotation.tailrec

class BowlingGame {

  var frames: List[Frame] = List[Frame]()

  def roll(pins: Int) {
    if (frames.nonEmpty && !frames.last.frameFinished) {
      frames.last.roll2 = pins
      frames.last.frameFinished = true
    } else {
      frames = frames :+ Frame(pins)
    }
  }

  def score: Int = {

    if (frames.isEmpty)
      0
    else {
      @tailrec
      def sumScore(framesLeft: List[Frame], total: Int): Int = {
        var tempTotal = framesLeft.head.sum
        if (framesLeft.tail != Nil && framesLeft.head.sum == 10) {
          tempTotal += framesLeft(1).roll1
          if (framesLeft.head.strike) {
            if (!framesLeft(1).strike) tempTotal += framesLeft(1).roll2
            else tempTotal += framesLeft(2).roll1
          }
        }
        if (framesLeft.tail.nonEmpty && (frames.size - framesLeft.tail.size) < 10) sumScore(framesLeft.tail, total + tempTotal)
        else total + tempTotal
      }

      sumScore(frames, 0)
    }
  }

  case class Frame(roll1: Int, var roll2: Int = 0) {
    def strike: Boolean = roll1 == 10

    var frameFinished: Boolean = false
    if (strike) frameFinished = true

    def sum: Int = roll1 + roll2
  }

}