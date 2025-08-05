package xyz.lncvrt.galaxylobby.event

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerGameModeChangeEvent

class PlayerGameModeChangeListener() : Listener {
    @EventHandler
    fun onPlayerGameModeChangeEvent(event: PlayerGameModeChangeEvent) {
        val player = event.getPlayer()
        if (event.newGameMode === GameMode.CREATIVE) {
            player.inventory.clear()
        } else if (event.newGameMode === GameMode.ADVENTURE) {
            return
        } else {
            event.isCancelled = true
            player.gameMode = GameMode.ADVENTURE
        }
    }
}