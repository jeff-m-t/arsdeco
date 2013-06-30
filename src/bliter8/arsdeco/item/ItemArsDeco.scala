package bliter8.arsdeco.item

import net.minecraft.item.Item
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.client.renderer.texture.IconRegister
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side

class ItemArsDeco(itemId: Int) extends Item(itemId) {
  maxStackSize = 1;
  setNoRepair();
  setCreativeTab(CreativeTabs.tabTools);

  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IconRegister) {
    itemIcon = iconRegister.registerIcon(s"arsdeco:${this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)}");
  }

}