package bliter8.arsdeco

import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.Instance
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.Mod.ServerStarting
import cpw.mods.fml.common.event.FMLServerStartingEvent
import cpw.mods.fml.common.Mod.PreInit
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.Mod.Init
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.Mod.PostInit
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import bliter8.arsdeco.core.Logging
import bliter8.arsdeco.core.Constants._
import bliter8.arsdeco.core.proxy.CommonProxy
import bliter8.arsdeco.block.BlockMarker
import net.minecraft.block.material.Material
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.registry.LanguageRegistry
import net.minecraft.item.ItemStack
import net.minecraft.block.Block
import bliter8.arsdeco.block.ColoredGlass
import bliter8.arsdeco.item.ItemColoredGlass
import bliter8.arsdeco.core.Reference
import net.minecraft.item.Item
import bliter8.arsdeco.item.Spanner
import bliter8.arsdeco.block.Scanner
import bliter8.arsdeco.block.PrintedBlock
import bliter8.arsdeco.block.PrintedBlockTileEntity

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, modLanguage="scala")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
class ArsDeco extends Logging {

}

object ArsDeco extends Logging {
  @Instance("scalamod")
  var instance: ArsDeco = _

  @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
  var proxy: CommonProxy = _

  var scanner: Block = _
  var marker: Block = _
  var coloredGlass: Block = _
  var printedBlock: Block = _

  var spanner: Item = _

  @ServerStarting
  def serverStarting(event: FMLServerStartingEvent) {
    info("=======================================> Server Starting")
  }

  @PreInit
  def preInit(event: FMLPreInitializationEvent) {
    info("=======================================> Pre-initialization")

    // Blocks
    ArsDeco.coloredGlass = new ColoredGlass(500);
    ArsDeco.marker = new BlockMarker(501, Material.rock)
    ArsDeco.scanner = new Scanner(502)
    ArsDeco.printedBlock = new PrintedBlock(503, Material.rock)

    GameRegistry.registerBlock(ArsDeco.coloredGlass, classOf[ItemColoredGlass], ArsDeco.coloredGlass.getUnlocalizedName2())
    GameRegistry.registerBlock(ArsDeco.marker, ArsDeco.marker.getUnlocalizedName2())
    GameRegistry.registerBlock(ArsDeco.scanner, ArsDeco.scanner.getUnlocalizedName2())
    GameRegistry.registerBlock(ArsDeco.printedBlock, ArsDeco.printedBlock.getUnlocalizedName2())

    for (ix <- 0 until 16) {
      val coloredGlassStack = new ItemStack(ArsDeco.coloredGlass, 1, ix);
      LanguageRegistry.addName(coloredGlassStack, Reference.colorDisplayNames(ix) + " Colored Glass");
    }
    LanguageRegistry.addName(new ItemStack(ArsDeco.marker, 1), "Marker Block")
    LanguageRegistry.addName(new ItemStack(ArsDeco.scanner, 1), "Scanner Block")
    LanguageRegistry.addName(new ItemStack(ArsDeco.printedBlock, 1), "PrintedBlock")

    //Items
    ArsDeco.spanner = new Spanner(503);
    GameRegistry.registerItem(ArsDeco.spanner, ArsDeco.spanner.getUnlocalizedName());
    LanguageRegistry.addName(new ItemStack(ArsDeco.spanner, 1), "Spanner");

  }

  @Init
  def load(event: FMLInitializationEvent) {
    info("=======================================> Initialization")
    ArsDeco.proxy.registerTileEntities();
    ArsDeco.proxy.initRenderingAndTextures();
  }

  @PostInit
  def modsLoaded(event: FMLPostInitializationEvent) {
    info("=======================================> Post-initialization")
  }
}