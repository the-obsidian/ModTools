package gg.obsidian.modtools

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandHandler(val plugin: ModTools): CommandExecutor {

    override fun onCommand(player: CommandSender, cmd: Command, alias: String?, args: Array<out String>?): Boolean {
        if (player !is Player) {
            plugin.utils.sendPrefixedMessage(player, "This command only works in-game")
            return true
        }

        if (!Permissions.modtools.has(player)) {
            plugin.utils.sendPrefixedMessage(player, "You do not have permission")
            return true
        }

        if (cmd.name == "spy") {
            if (!Permissions.spy.has(player)) {
                plugin.utils.sendPrefixedMessage(player, "You do not have permission")
                return true
            }

            if (plugin.hasSpyEnabled(player)) {
                plugin.disableSpy(player)
                plugin.utils.sendPrefixedMessage(player, "Spy disabled")
            } else {
                plugin.enableSpy(player)
                plugin.utils.sendPrefixedMessage(player, "Spy enabled")
            }
        }

        return true
    }
}