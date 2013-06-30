package bliter8.arsdeco.client.model

import bliter8.arsdeco.block.PrintedBlockTileEntity
import net.minecraft.client.model.ModelBase
import net.minecraft.client.model.ModelRenderer
import org.lwjgl.opengl.GL11
import bliter8.arsdeco.core.Logging

class PrintedBlockModel extends Logging {

  def render(tileEntity: PrintedBlockTileEntity) {
    val baseModel = new ModelBase {}

    val block = new ModelRenderer(baseModel, 0, 0);
    block.addBox(-4f, -4f, -4f, 8, 8, 8)
    block.addBox(-2f, -2f, -8f, 4, 4, 4)
    //  block.addBox(  6f,  6f, 12f, 4, 4, 4)
    //  block.addBox(  6f,  0f,  6f, 4, 4, 4)
    //  block.addBox(  6f, 12f,  6f, 4, 4, 4)
    //  block.addBox(  0f,  6f,  6f, 4, 4, 4)
    //  block.addBox( 12f,  6f,  6f, 4, 4, 4)

    block.rotationPointX = 0;
    block.rotationPointY = 0;
    block.rotationPointZ = 0;
    
    GL11.glPushMatrix()
    GL11.glTranslatef(0.5f, 0.5f, 0.5f)
    GL11.glRotatef(-tileEntity.facing * 90f, 0f, 1f, 0f)
    
    block.render((1.0 / 16.0).toFloat)
    
    GL11.glPopMatrix()
  }

}