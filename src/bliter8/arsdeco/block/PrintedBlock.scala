package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.world.World
import net.minecraft.tileentity.TileEntity
import net.minecraft.block.ITileEntityProvider
import bliter8.arsdeco.core.Logging
import bliter8.arsdeco.core.RenderIds
import net.minecraft.item.ItemStack
import net.minecraft.entity.EntityLiving
import bliter8.arsdeco.core.util.Spatial

class PrintedBlock(blockId: Int, material: Material) extends OrientedBlock(blockId, material) with ITileEntityProvider with Logging {
  setUnlocalizedName("printedBlock")
  setCreativeTab(CreativeTabs.tabBlock)

  override def createNewTileEntity(world: World) = {
    info("Creating Tile Entity")
    new PrintedBlockTileEntity()
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, player: EntityLiving, stack: ItemStack) {
    super.onBlockPlacedBy(world, x, y, z, player, stack)

    val tileEntity = world.getBlockTileEntity(x, y, z)
    if (tileEntity != null) {
      tileEntity match {
        case pb: PrintedBlockTileEntity =>
          pb.facing = placedBlockFacing(player).toByte
        case _ =>
      }
    }
  }

  override def renderAsNormalBlock = false

  override def isOpaqueCube() = false

  override def getRenderType = RenderIds.printedBlock
}