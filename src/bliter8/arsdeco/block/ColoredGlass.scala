package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.util.Icon
import net.minecraft.creativetab.CreativeTabs
import java.util.Random
import net.minecraft.item.ItemStack
import net.minecraft.client.renderer.texture.IconRegister

class ColoredGlass(blockId: Int) extends BlockArsDeco(blockId, Material.glass) {
  setUnlocalizedName("coloredGlass")
  setHardness(0.3F)
  setCreativeTab(CreativeTabs.tabBlock)

  @SideOnly(Side.CLIENT) var icons: Array[Icon] = _;

  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, metadata: Int) = icons(metadata % this.icons.length);

  override def quantityDropped(randon: Random) = 0

  override def damageDropped(metadata: Int) = metadata;

  @SideOnly(Side.CLIENT)
  override def getSubBlocks(itemId: Int, creativeTabs: CreativeTabs, itemStacks: java.util.List[_]) {
    val list = itemStacks.asInstanceOf[java.util.List[ItemStack]]
    for (i <- 0 until 16) list.add(new ItemStack(itemId, 1, i))
  }

  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IconRegister) {

    icons = ColoredGlass.colorNames.map { color =>
      val name = s"arsdeco:${this.getUnlocalizedName2}_$color"
      iconRegister.registerIcon(name)
    }
  }

  override def getRenderBlockPass = 1

  override def isOpaqueCube = false

  override def renderAsNormalBlock = false

  override protected def canSilkHarvest = true

}

object ColoredGlass {
  def getBlockFromDye(metadata: Int) = ~metadata & 15
  def getDyeFromBlock(metadata: Int) = ~metadata & 15

  val colorNames = Array(
    "white", "orange", "magenta", "lightBlue", "yellow", "lime",
    "pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
    "green", "red", "black")
}