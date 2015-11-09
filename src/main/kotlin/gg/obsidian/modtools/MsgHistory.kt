package gg.obsidian.modtools

import org.bukkit.entity.Player
import java.util.*

object MsgHistory {
    val history = HashMap<UUID, UUID>()

    fun getTo(player: Player): UUID? {
        if (history.containsKey(player.uniqueId)) {
            return history[player.uniqueId]
        }

        return null
    }

    fun reportMessage(from: Player, to: Player) {
        history.put(from.uniqueId, to.uniqueId)
        history.put(to.uniqueId, from.uniqueId)
    }
}