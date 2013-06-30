package bliter8.arsdeco.client.render.tileentity

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import bliter8.arsdeco.block.PrintedBlockTileEntity
import cpw.mods.fml.client.FMLClientHandler
import org.lwjgl.opengl.GL11
import bliter8.arsdeco.client.model.PrintedBlockModel
import bliter8.arsdeco.core.Logging

class PrintedBlockTileEntityRenderer extends TileEntitySpecialRenderer with Logging {
  
  override def renderTileEntityAt(tileEntity: TileEntity, x: Double, y: Double, z: Double, tick: Float) {
    tileEntity match {
      case pb: PrintedBlockTileEntity =>
      	val model: PrintedBlockModel = new PrintedBlockModel
      	val entity = tileEntity.asInstanceOf[PrintedBlockTileEntity]
      	
        GL11.glPushMatrix
      	GL11.glScalef(1.0f,1.0f,1.0f)
      	GL11.glTranslatef(x.toFloat, y.toFloat, z.toFloat)
      	FMLClientHandler.instance.getClient.renderEngine.bindTexture("/mods/arsdeco/textures/models/printedBlock.png")
      	
      	model.render(entity)
      	
      	GL11.glPopMatrix
      case te @ _ =>
        info("Strange Tile Entity Type: "+te.getClass.getSimpleName)
    }
  }

}