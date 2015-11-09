package gg.obsidian.modtools

import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

val SPY_METADATA_KEY = "MODTOOLS_SPY_ENABLED"

class ModTools : JavaPlugin() {

    val config = Configuration(this)
    val utils = Utils(this)

    override fun onEnable() {
        val configFile = File(dataFolder, "config.yml")
        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true)
            saveConfig()
        }

        config.load()

        server.pluginManager.registerEvents(EventListener(this), this)
        getCommand("spy").executor = CommandHandler(this)
    }

    fun enableSpy(player: Player) {
        player.setMetadata(SPY_METADATA_KEY, FixedMetadataValue(this, true))
    }

    fun disableSpy(player: Player) {
        player.setMetadata(SPY_METADATA_KEY, FixedMetadataValue(this, false))
    }

    fun hasSpyEnabled(player: Player): Boolean {
        logger.info("checking spy for player " + player.name)
        if (!player.hasMetadata(SPY_METADATA_KEY)) {
            return false
        }

        val meta = player.getMetadata(SPY_METADATA_KEY)
        if (meta.size == 0) {
            return false
        }

        return meta[0].asBoolean()
    }
}
