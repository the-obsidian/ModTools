package gg.obsidian.modtools

import org.bukkit.entity.Player

enum class Permissions(val node: String) {
    modtools("modtools.use"),
    spy("modtools.spy"),
    spyAuto("modtools.spy.auto");

    fun has(player: Player): Boolean {
        return player.hasPermission(node)
    }
}
