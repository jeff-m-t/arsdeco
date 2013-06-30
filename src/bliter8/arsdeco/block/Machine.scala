package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import net.minecraft.util.Icon
import bliter8.arsdeco.core.util.Spatial
import cpw.mods.fml.relauncher.SideOnly
import net.minecraft.client.renderer.texture.IconRegister
import cpw.mods.fml.relauncher.Side

abstract class Machine(blockId: Int, material: Material) extends OrientedBlock(blockId, material) {

  var icons: Array[Icon] = _

  @SideOnly(Side.CLIENT)
  override def getIcon(side: Int, metadata: Int) = icons(Spatial.faceNumbersByOrientation(getOrientation(metadata))(side));

  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IconRegister) {
    this.icons = (for (side <- 0 until 6) yield iconRegister.registerIcon("arsdeco" + ":" + "machine" + "_" + Spatial.faceNames(side))).toArray
  }

}