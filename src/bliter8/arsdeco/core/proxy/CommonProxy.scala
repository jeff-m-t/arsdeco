package bliter8.arsdeco.core.proxy

import cpw.mods.fml.common.registry.GameRegistry
import bliter8.arsdeco.block.PrintedBlockTileEntity

class CommonProxy {
    def initRenderingAndTextures() { }
    
   def registerTileEntities() { 
     GameRegistry.registerTileEntity(classOf[PrintedBlockTileEntity], "printedBlockTileEntity")
   }
}