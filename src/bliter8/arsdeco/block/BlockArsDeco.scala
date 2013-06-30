package bliter8.arsdeco.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IconRegister
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side

abstract class BlockArsDeco(blockId: Int, material: Material) extends Block(blockId, material) {

  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IconRegister) {
    val name = "arsdeco" + ":" + this.getUnlocalizedName2();
    blockIcon = iconRegister.registerIcon(name);
  }

}