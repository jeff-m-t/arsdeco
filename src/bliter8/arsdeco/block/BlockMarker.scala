package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

class BlockMarker(blockId: Int, material: Material) extends BlockArsDeco(blockId, material) {
  this.setUnlocalizedName("marker");
  this.setCreativeTab(CreativeTabs.tabBlock);
}