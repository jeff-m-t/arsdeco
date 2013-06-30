package bliter8.arsdeco.core.proxy

import bliter8.arsdeco.core.RenderIds
import bliter8.arsdeco.block.PrintedBlockTileEntity
import cpw.mods.fml.client.registry.RenderingRegistry
import cpw.mods.fml.client.registry.ClientRegistry
import bliter8.arsdeco.client.render.tileentity.PrintedBlockTileEntityRenderer
import net.minecraftforge.client.MinecraftForgeClient
import bliter8.arsdeco.ArsDeco
import bliter8.arsdeco.client.render.item.PrintedBlockItemRenderer

class ClientProxy extends CommonProxy {
  override def initRenderingAndTextures() {
    RenderIds.printedBlock = RenderingRegistry.getNextAvailableRenderId()

    MinecraftForgeClient.registerItemRenderer(ArsDeco.printedBlock.blockID, new PrintedBlockItemRenderer());

  }

  override def registerTileEntities() {
    super.registerTileEntities()

    ClientRegistry.bindTileEntitySpecialRenderer(classOf[PrintedBlockTileEntity], new PrintedBlockTileEntityRenderer())
  }
}