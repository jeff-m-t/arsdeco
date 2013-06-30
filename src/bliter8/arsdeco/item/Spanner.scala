package bliter8.arsdeco.item

import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.block.Block
import net.minecraftforge.common.ForgeDirection

class Spanner(blockId: Int) extends ItemArsDeco(blockId) {
  setUnlocalizedName("spanner")

  override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float) = {
    val blockId = world.getBlockId(x, y, z);
    if (Block.blocksList(blockId).rotateBlock(world, x, y, z, ForgeDirection.getOrientation(side))) {
      player.swingItem();
      !world.isRemote;
    } else {
      false;
    }
  }
}