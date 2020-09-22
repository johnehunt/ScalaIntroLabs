package com.jjh.bowling

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class BowlingGameTest extends AnyFunSpec with BeforeAndAfter{

  var game: BowlingGame = new BowlingGame()

  before {
    game = new BowlingGame()
  }

  describe("When using a BowlingGame") {
    describe("a new game") {
      it("should initially have a score of zero") {
        assert(game.score == 0)
      }
      it ("should have a score of 0 if all rolls are zero") {
        for (_ <- 1 to 20) {
          game.roll(0)
        }
        assert(game.score == 0)
      }
      it ("should have a score of 20 if all rolls are 1") {
        for (_ <- 1 to 20) {
          game.roll(1)
        }
        assert(game.score == 20)
      }
      it ("should have a score of 24 when a strike followed by a 3 and a 4") {
        game.roll(10) // strike
        game.roll(3)
        game.roll(4)
        assert(game.score == 24)
      }
      it ("should include the next roll if a spare is thrown giving a score of 20") {
        game.roll(5)
        game.roll(5) // spare
        game.roll(5)
        assert(game.score == 20)
      }
      it ("should give a value of 30 for a perfect game") {
        for (_ <- 1 to 12) {
          game.roll(10)
        }
        assert(game.score == 300)
      }
    }
  }

}
