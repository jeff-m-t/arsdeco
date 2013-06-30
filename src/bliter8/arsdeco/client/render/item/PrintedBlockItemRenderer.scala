package bliter8.arsdeco.client.render.item

import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper
import net.minecraft.item.ItemStack
import net.minecraftforge.client.IItemRenderer.ItemRenderType
import net.minecraftforge.client.IItemRenderer.ItemRenderType._
import cpw.mods.fml.client.FMLClientHandler
import bliter8.arsdeco.client.model.PrintedBlockModel
import org.lwjgl.opengl.GL11
import bliter8.arsdeco.block.PrintedBlockTileEntity
import bliter8.arsdeco.core.Logging

class PrintedBlockItemRenderer extends IItemRenderer with Logging {
    override def handleRenderType(item: ItemStack, renderType: ItemRenderType) = true
    
    override def shouldUseRenderHelper(renderType: ItemRenderType, item: ItemStack, helper: ItemRendererHelper) = true

    override def renderItem(renderType:ItemRenderType, item: ItemStack, data: AnyRef* ) {

    	renderType match {
    	  case ENTITY =>
//                renderGlassBell(-0.5F, -1.2F, 0.5F, 1.4F);
                renderPrintedBlock(0.0F, 0.0F, 0.0F, 1.4F);
    	  case EQUIPPED =>
//                renderGlassBell(-0.2F, -0.85F, 0.8F, 1.4F);
                renderPrintedBlock(0.0F, 0.0F, 0.0F, 1.4F);
    	  case EQUIPPED_FIRST_PERSON =>
//                renderGlassBell(-0.2F, -0.85F, 0.8F, 1.4F);
                renderPrintedBlock(0.0F, 0.0F, 0.0F, 1.4F);
    	  case INVENTORY =>
//                renderGlassBell(-1.0F, -1.0F, 0.0F, 1.4F);
                renderPrintedBlock(0.0F, -0.125F, 0.0F, 1.4F);
    	  case _ =>
    	}
    }

    private[this] def renderPrintedBlock(x: Float, y: Float, z: Float, scale: Float) {      
      	val model: PrintedBlockModel = new PrintedBlockModel

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
//        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
      	FMLClientHandler.instance.getClient.renderEngine.bindTexture("/mods/arsdeco/textures/models/printedBlock.png")

        // Render
        model.render(new PrintedBlockTileEntity())

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}