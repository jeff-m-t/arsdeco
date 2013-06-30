package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

class Scanner(blockId: Int) extends Machine(blockId, Material.rock) {
  setUnlocalizedName("Scanner")
  setCreativeTab(CreativeTabs.tabBlock)
}