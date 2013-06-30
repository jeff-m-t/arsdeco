package bliter8.arsdeco.block

import net.minecraft.block.material.Material
import net.minecraftforge.common.ForgeDirection
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import bliter8.arsdeco.core.util.Spatial
import bliter8.arsdeco.core.Logging

abstract class OrientedBlock(blockId: Int, material: Material) extends BlockArsDeco(blockId, material) with Logging {

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z:Int , player: EntityLiving, stack: ItemStack) {
        val playerFacing = Spatial.facing(player)
        val blockFacing = placedBlockFacing(player)
        
        info(if(world.isRemote) "Client Side" else "Server Side")
        info(s"Block Placed - Location: ($x,$y,$z)")
        info(s"Block Placed - Stack: $stack")
        info(s"Block Placed - Player Facing: ${Spatial.orientationNames(playerFacing)} ($playerFacing)")
        info(s"Block Placed - Block Facing: ${Spatial.orientationNames(blockFacing)} ($blockFacing)")

        val tileEntity = world.getBlockTileEntity(x,y,z)
        if(tileEntity != null) {
          info(s"Tile Entity: $tileEntity")
        }

        world.setBlockMetadataWithNotify(x,y,z,blockFacing,2)
    }

    override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, pickX: Float, pickY: Float, pickZ: Float) = {
        val metadata = world.getBlockMetadata(x, y, z)
        info(if(world.isRemote) "Client Side" else "Server Side")
        info(s"Block Activated - Location: ($x,$y,$z)")
        info(s"Block Activated - side: ${Spatial.sideNames(side)}")
        info(s"Block Activated - pick: : ($pickX,$pickY,$pickZ)")
        info(s"Block Activated - Tool: ${player.getItemInUse()}")
        info(s"Block Activated - Metadata: $metadata")
        
        val tileEntity = world.getBlockTileEntity(x,y,z)
        if(tileEntity != null) info(s"Tile Entity: $tileEntity")
        
        player.swingItem()
        false;
    }

    override def rotateBlock(world: World, x: Int, y: Int, z: Int, axis: ForgeDirection) = {
        val metadata = world.getBlockMetadata(x, y, z)
        world.setBlockMetadataWithNotify(x,y,z,metadata+1,2) 
    }
    
    def placedBlockFacing(playerWhoPlacedIt: EntityLiving) = (Spatial.facing(playerWhoPlacedIt) + 2) % 4
    
    def getOrientation(metadata: Int) = metadata & 3
    
    def getFaceName(side: Int, orientation: Int) = Spatial.faceNumbersByOrientation(orientation)(side)

  
}