package xyz.lncvrt.galaxylobby.event

import org.bukkit.Material
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.inventory.ItemStack
import xyz.lncvrt.galaxyapi.utils.MessageFormat
import xyz.lncvrt.galaxylobby.GalaxyLobbyPlugin

class ProjectileLaunchListener(val plugin: GalaxyLobbyPlugin) : Listener {
    @EventHandler
    fun onProjectileLaunchEvent(event: ProjectileLaunchEvent) {
        val firework = event.getEntity()
        val player = firework.shooter
        if (firework is Firework) {
            if (player is Player) {
                val fireworkItem = ItemStack(Material.FIREWORK_ROCKET)
                val fireworkMeta = fireworkItem.itemMeta
                fireworkMeta.displayName(plugin.miniMessage.deserialize(MessageFormat.setPrimaryColor("<italic:false>Elytra ${MessageFormat.setSecondaryColor("(Fly around the lobby!)")}</italic>")))
                fireworkItem.setItemMeta(fireworkMeta)
                player.inventory.setItem(7, fireworkItem)
                player.setCooldown(fireworkItem.type, 20)
            }
        }
    }
}