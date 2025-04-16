package xyz.lncvrt.galaxylobby.event

import org.bukkit.GameMode
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleFlightEvent

class PlayerToggleFlightListener : Listener {
    @EventHandler
    fun onPlayerToggleFlightEvent(event: PlayerToggleFlightEvent) {
        val player: Player = event.getPlayer()

        if (!player.isFlying && player.gameMode == GameMode.ADVENTURE && player.inventory.heldItemSlot != 7) {
            val direction = player.location.direction.normalize()

            event.isCancelled = true
            player.allowFlight = false
            direction.multiply(2.5f)
            direction.setY(1)
            player.velocity = direction
            player.playSound(player.location, Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0f, 1.0f)
        }
    }
}