package app

import scalafx.scene.shape.Rectangle
import scalafx.scene.paint.Color

import scalafx.scene.shape.Circle
import scalafx.scene.paint.Color
import scala.util.Random
private val random = new Random()


case class Particule(
  x: Int,
  y: Int,
  color: Color,
  direction:Direction
) {
  def draw: Circle = new Circle {
    centerX = x
    centerY = y
    radius = 2
    fill = color
  }
  def move(step: Int = 2, windowSize: Int = 600): Particule = {
  val (dx, dy) = direction match {
    case Direction.NORTH        => (0, -step)
    case Direction.SOUTH        => (0, step)
    case Direction.EAST         => (step, 0)
    case Direction.WEST         => (-step, 0)
    case Direction.NORTH_EAST   => (step, -step)
    case Direction.NORTH_WEST   => (-step, -step)
    case Direction.SOUTH_EAST   => (step, step)
    case Direction.SOUTH_WEST   => (-step, step)
  }
  var newX = x + dx
  var newY = y + dy
  var newDir = direction

  def invertDirection(dir: Direction, invertX: Boolean, invertY: Boolean): Direction = (dir, invertX, invertY) match {
  
  case (Direction.EAST, false, false) => Direction.EAST
  case (Direction.EAST, false, true)  => Direction.EAST
  case (Direction.EAST, true, false)  => Direction.WEST
  case (Direction.EAST, true, true)   => Direction.WEST

  case (Direction.WEST, false, false) => Direction.WEST
  case (Direction.WEST, false, true)  => Direction.WEST
  case (Direction.WEST, true, false)  => Direction.EAST
  case (Direction.WEST, true, true)   => Direction.EAST

  case (Direction.NORTH, false, false) => Direction.NORTH
  case (Direction.NORTH, false, true)  => Direction.SOUTH
  case (Direction.NORTH, true, false)  => Direction.NORTH
  case (Direction.NORTH, true, true)   => Direction.SOUTH

  case (Direction.SOUTH, false, false) => Direction.SOUTH
  case (Direction.SOUTH, false, true)  => Direction.NORTH
  case (Direction.SOUTH, true, false)  => Direction.SOUTH
  case (Direction.SOUTH, true, true)   => Direction.NORTH

  case (Direction.NORTH_EAST, false, false) => Direction.NORTH_EAST
  case (Direction.NORTH_EAST, false, true)  => Direction.SOUTH_EAST
  case (Direction.NORTH_EAST, true, false)  => Direction.NORTH_WEST
  case (Direction.NORTH_EAST, true, true)   => Direction.SOUTH_WEST

  case (Direction.NORTH_WEST, false, false) => Direction.NORTH_WEST
  case (Direction.NORTH_WEST, false, true)  => Direction.SOUTH_WEST
  case (Direction.NORTH_WEST, true, false)  => Direction.NORTH_EAST
  case (Direction.NORTH_WEST, true, true)   => Direction.SOUTH_EAST

  case (Direction.SOUTH_EAST, false, false) => Direction.SOUTH_EAST
  case (Direction.SOUTH_EAST, false, true)  => Direction.NORTH_EAST
  case (Direction.SOUTH_EAST, true, false)  => Direction.SOUTH_WEST
  case (Direction.SOUTH_EAST, true, true)   => Direction.NORTH_WEST

  case (Direction.SOUTH_WEST, false, false) => Direction.SOUTH_WEST
  case (Direction.SOUTH_WEST, false, true)  => Direction.NORTH_WEST
  case (Direction.SOUTH_WEST, true, false)  => Direction.SOUTH_EAST
  case (Direction.SOUTH_WEST, true, true)   => Direction.NORTH_EAST

  }

  if ((newX <= 0||newX >= windowSize ) || (newY <= 0||newY >= windowSize )) {
    newDir = invertDirection(direction, (newX <= 0||newX >= windowSize ), (newY <= 0||newY >= windowSize ))
  }

  this.copy(x = newX, y = newY, direction = newDir)
}
def estVoisins(other: Particule, stepSize: Int): Boolean = {
  val dx = Math.abs(this.x - other.x)
  val dy = Math.abs(this.y - other.y)
  dx <= stepSize && dy <= stepSize && !(dx == 0 && dy == 0)
}

def invertDirection: Direction = {
  direction match {
    case Direction.NORTH      => Direction.SOUTH
    case Direction.SOUTH      => Direction.NORTH
    case Direction.EAST       => Direction.WEST
    case Direction.WEST       => Direction.EAST
    case Direction.NORTH_EAST => Direction.SOUTH_WEST
    case Direction.NORTH_WEST => Direction.SOUTH_EAST
    case Direction.SOUTH_EAST => Direction.NORTH_WEST
    case Direction.SOUTH_WEST => Direction.NORTH_EAST
  }
}
}