package bliter8.arsdeco.core.util

import net.minecraft.util.MathHelper
import net.minecraft.entity.EntityLiving

object Spatial {
  // Facing: 0=S, 1=E, 2=N, 3=W
  def facing(entity: EntityLiving) = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

  val SOUTH = 0;
  val WEST = 1;
  val NORTH = 2;
  val EAST = 3;

  // Side: 0="bottom", 1="top", 2="south", 3="north", 4="east",  5="west"
  // Face: 0="bottom", 1="top", 2="back",  3="front", 4="right", 5="left"
  val faceNumbersByOrientation = Array(
    Array(0, 1, 2, 3, 4, 5),
    Array(0, 1, 4, 5, 3, 2),
    Array(0, 1, 3, 2, 5, 4),
    Array(0, 1, 5, 4, 2, 3))

  val sideNames = Array("bottom", "top", "south", "north", "east", "west")
  val faceNames = Array("bottom", "top", "back", "front", "right", "left")
  val orientationNames = Array("South", "West", "North", "East")
}