package gg.obsidian.modtools

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Utils(val plugin: ModTools) {

    fun getPrefix(): String {
        return "[ModTools] "
    }

    fun sendSpyMessage(from: Player, to: Player, msg: String) {
        plugin.logger.info("sending spy message")
        plugin.server.scheduler.runTaskAsynchronously(plugin, {
            plugin.logger.info("running spy message")
            for (player in Bukkit.getOnlinePlayers()) {
                if (plugin.hasSpyEnabled(player)) {
                    val formattedMessage = plugin.config.SPY_FORMAT.
                            replace("%from%", from.name).
                            replace("%to%", to.name).
                            replace("%msg%", msg)
                    sendMsg(player, formattedMessage)
                }
            }
        })
    }

    fun sendPrefixedMessage(player: CommandSender, msg: String) {
        sendMsg(player, getPrefix() + msg)
    }

    fun sendMsg(player: CommandSender, msg: String) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg))
    }
}