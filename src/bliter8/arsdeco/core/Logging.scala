package bliter8.arsdeco.core

import java.util.logging.Logger
import cpw.mods.fml.common.FMLLog
import java.util.logging.Level

trait Logging {

  def debug(message: => String) = Logging.logger.log(Level.FINE, message)
  def info(message: => String) = Logging.logger.log(Level.INFO, message)
  def warn(message: => String) = Logging.logger.log(Level.WARNING, message)
  def error(message: => String) = Logging.logger.log(Level.SEVERE, message)
}

object Logging {
  val logger = {
    val l = Logger.getLogger(Constants.MOD_ID)
    l.setParent(FMLLog.getLogger())
    l.setLevel(Level.FINE)
    l
  }
}