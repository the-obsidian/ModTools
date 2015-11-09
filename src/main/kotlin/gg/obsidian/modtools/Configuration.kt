package gg.obsidian.modtools

import java.util.*

class Configuration(val plugin: ModTools) {

    var PREFIX = ""
    var SPY_FORMAT = ""
    var WATCHED_COMMANDS = ArrayList<String>()

    fun load() {
        plugin.reloadConfig()

        SPY_FORMAT = plugin.getConfig().getString("spy-format")
        PREFIX = plugin.getConfig().getString("prefix")
        WATCHED_COMMANDS = plugin.getConfig().getStringList("watched-commands") as ArrayList<String>
    }
}
