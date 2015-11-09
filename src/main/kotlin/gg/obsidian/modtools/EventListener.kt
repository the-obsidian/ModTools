package gg.obsidian.modtools

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent

class EventListener(val plugin: ModTools): Listener {

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        if (Permissions.spyAuto.has(e.player)) {
            plugin.enableSpy(e.player)
        }
    }

    @EventHandler
    fun onCommandPreprocess(e: PlayerCommandPreprocessEvent) {
        plugin.logger.info("Got a command event")
        try {
            var message = e.message
            if (message.startsWith("/")) {
                message = message.substring(1)
            }
            message = message.replace("([ ]+)", "$1")

            val args = message.split(" ")

            plugin.logger.info("command was " + args)

            if (!plugin.config.WATCHED_COMMANDS.contains(args[0].toLowerCase())) {
                return
            }

            if (args[0].equals("r", ignoreCase = true) || args[0].equals("reply", ignoreCase = true)) {
                if (args.size <= 1) return

                val from = e.player
                val to = Bukkit.getPlayer(MsgHistory.getTo(from))

                MsgHistory.reportMessage(from, to)
                plugin.utils.sendSpyMessage(from, to, args.subList(1, args.size).joinToString(" "))
            } else if (args.size > 2) {
                val from = e.player
                val to = from.server.getPlayer(args[1])

                MsgHistory.reportMessage(from, to)
                plugin.utils.sendSpyMessage(from, to, args.subList(2, args.size).joinToString(" "))
            }
        } catch (e: Exception) {
            plugin.logger.severe(e.message)
            // Ignore errors
        }
    }
}