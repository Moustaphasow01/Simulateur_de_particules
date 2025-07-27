//Main.scala
package app

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle
import scalafx.animation.{Timeline, KeyFrame}
import scalafx.util.Duration
import scala.util.Random
import scalafx.Includes._

object Main extends JFXApp3 {

  val windowSize = 600
  val nbPart = 50
  val stepSize = 4

  private var particles: List[Particule] = List.empty
  private var particleCircles: List[Circle] = List.empty

  override def start(): Unit = {
    val random = new Random()

    particles = List.fill(nbPart) {
      Particule(
        x = random.nextInt(windowSize),
        y = random.nextInt(windowSize),
        color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
        direction = Direction.values(random.nextInt(Direction.values.length))
      )
    }

    particleCircles = particles.map(_.draw)

    stage = new PrimaryStage {
      title = "Particules"
      scene = new Scene(windowSize, windowSize) {
        fill = Color.White
        content = particleCircles
      }
    }

new Timeline {
  keyFrames = Seq(
    KeyFrame(Duration(50), onFinished = _ => {
      val newParticles = particles.map { p =>
        val collision = particles.exists { other =>
          other != p && p.estVoisins(other, stepSize)
        }

        if (collision) p.copy(direction = p.invertDirection)
        else p
      }
      particles = newParticles.map(_.move(stepSize, windowSize))
      particleCircles.zip(particles).foreach { case (circle, part) =>
        circle.centerX = part.x
        circle.centerY = part.y
      }
    })
  )
  cycleCount = Timeline.Indefinite
}.play()

}
}


