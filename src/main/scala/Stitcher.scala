trait Square
trait Color
object Red extends Color
object Blue extends Color

trait Orientation

class Horizontal(horizontalLocation: HorizontalLocation) extends Orientation
class Vertical(verticalLocation: VerticalLocation) extends Orientation
class Diagonal(diagonalLocation: DiagonalLocation) extends Orientation
class QuarterDiagonal(diagonalQuarterLocation: DiagonalQuarterLocation)
    extends Orientation

trait Location

trait VerticalLocation extends Location
object L extends VerticalLocation
object R extends VerticalLocation

trait HorizontalLocation extends Location
object T extends HorizontalLocation
object B extends HorizontalLocation

trait DiagonalLocation extends Location
object TLtoBR extends DiagonalLocation
object TRtoBL extends DiagonalLocation

trait DiagonalQuarterLocation extends Location
object TLtoM extends DiagonalQuarterLocation
object TRtoM extends DiagonalQuarterLocation
object BLtoM extends DiagonalQuarterLocation
object BRtoM extends DiagonalQuarterLocation

trait Stitch
class CrossStitch(color: Color) extends Stitch

class BackStitch(
    color: Color,
    orientation: Orientation
) extends Stitch

object SandBox {
  val firstBackStitch = new BackStitch(Red, new Horizontal(B))
//  val secondBackStitch = new BackStitch(Red, new Diagonal(B)) // Should NOT be allowed!

  val firstHalfStitch = new HalfStitch(Red, new Diagonal(TLtoBR))
  val firstQuarterStich = new QuarterStitch(Red, new QuarterDiagonal(BLtoM))

  val firstThreeQuarterStitch = ???
}

class HalfStitch(color: Color, diagonal: Diagonal) extends Stitch
class QuarterStitch(color: Color, quarterDiagonal: QuarterDiagonal)
    extends Stitch

// Make sure the 2 component stitches don't have the same orientation
class ThreeQuarter(halfStitch: HalfStitch, quarterStitch: QuarterStitch)
    extends Stitch

class ComplexStitch(halfStitch: HalfStitch, quarterStitch: QuarterStitch)

trait Grid {
  def colorize(square: Square, crossStitch: CrossStitch) = ???

  def backstitch(square: Square, backStitch: BackStitch) = ???

}
