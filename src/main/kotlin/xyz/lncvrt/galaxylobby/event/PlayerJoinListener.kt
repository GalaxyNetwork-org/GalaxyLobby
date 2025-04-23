package xyz.lncvrt.galaxylobby.event

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.sayandev.stickynote.bukkit.extension.sendComponent
import xyz.lncvrt.galaxyapi.utils.MessageFormat
import xyz.lncvrt.galaxylobby.GalaxyLobbyPlugin

class PlayerJoinListener(val plugin: GalaxyLobbyPlugin) : Listener {
    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent) {
        val player = event.getPlayer()
        plugin.resetPlayer(player, true)
        player.gameMode = GameMode.ADVENTURE

        plugin.server.scheduler.runTaskLater(plugin, Runnable {
            player.sendComponent("<dark_gray><strikethrough>+---------------------***---------------------+")
            player.sendMessage("")
            player.sendComponent("<gray>Welcome to ${MessageFormat.name()}, ${MessageFormat.setPrimaryColor("<underlined>${player.name}</underlined>")}!</gray>")
            player.sendMessage("")
            player.sendComponent("${MessageFormat.setPrimaryColor("<bold>WEBSITE</bold><gray>:</gray>")} ${MessageFormat.setSecondaryColor("<click:open_url:'https://galaxy.lncvrt.xyz'>galaxy.lncvrt.xyz</click>")}")
            player.sendComponent("${MessageFormat.setPrimaryColor("<bold>DISCORD</bold><gray>:</gray>")} ${MessageFormat.setSecondaryColor("<click:open_url:'https://galaxy.lncvrt.xyz/discord'>galaxy.lncvrt.xyz/discord</click>")}")
            player.sendMessage("")
            player.sendComponent("<dark_gray><strikethrough>+---------------------***---------------------+")
        }, 5)
    }
}