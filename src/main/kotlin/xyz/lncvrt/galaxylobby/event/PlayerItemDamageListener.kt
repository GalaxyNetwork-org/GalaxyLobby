package xyz.lncvrt.galaxylobby.event

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemDamageEvent

class PlayerItemDamageListener : Listener {
    @EventHandler
    fun onItemDurabilityChange(event: PlayerItemDamageEvent) {
        event.isCancelled = true
    }
}