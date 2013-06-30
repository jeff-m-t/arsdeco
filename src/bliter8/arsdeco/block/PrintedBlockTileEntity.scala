package bliter8.arsdeco.block

import net.minecraft.tileentity.TileEntity
import net.minecraft.nbt.NBTTagCompound
import bliter8.arsdeco.core.Logging
import net.minecraft.network.packet.Packet
import net.minecraft.network.packet.Packet132TileEntityData
import net.minecraft.network.INetworkManager

class PrintedBlockTileEntity extends TileEntity with Logging {

  var timestamp = System.currentTimeMillis()
  var facing: Byte = 0
  
  override def writeToNBT(tag: NBTTagCompound) {
    super.writeToNBT(tag)
    tag.setLong("timestamp", timestamp)
    tag.setByte("facing", facing)
  }
  
  override def readFromNBT(tag: NBTTagCompound) {
	info("Reading from NBT")
    super.readFromNBT(tag)
    this.timestamp = tag.getLong("timestamp")
    this.facing = tag.getByte("facing")
    info("Facing: "+facing)
  }
  
  override def getDescriptionPacket(): Packet = {
    val tag = new NBTTagCompound()
    
    writeToNBT(tag)
    
    new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, tag)
  }
  
  override def onDataPacket(net: INetworkManager, pkt: Packet132TileEntityData) = {
    val tag = pkt.customParam1
    readFromNBT(tag)
  }
  
  override def toString = s"${getClass.getSimpleName}: timestamp=$timestamp, facing=$facing"
}