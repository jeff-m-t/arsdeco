package bliter8.arsdeco.item

import bliter8.arsdeco.block.ColoredGlass
import net.minecraft.item.ItemStack
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.item.ItemBlock

class ItemColoredGlass(itemId: Int) extends ItemBlock(itemId) {
  setHasSubtypes(true)
  setUnlocalizedName("ColoredGlass")

  override def getMetadata(damageValue: Int) = damageValue;

  override def getUnlocalizedName(stack: ItemStack) =
    getUnlocalizedName() + "." + ColoredGlass.colorNames(stack.getItemDamage() % ColoredGlass.colorNames.length);

  @SideOnly(Side.CLIENT)
  override def requiresMultipleRenderPasses = true

}