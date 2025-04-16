package xyz.lncvrt.galaxylobby.command

import org.incendo.cloud.kotlin.MutableCommandBuilder
import org.sayandev.stickynote.bukkit.command.BukkitCommand
import org.sayandev.stickynote.bukkit.command.BukkitSender
import org.sayandev.stickynote.bukkit.extension.sendComponent
import xyz.lncvrt.galaxyapi.utils.MessageFormat

object WebsiteCommand : BukkitCommand("website") {
    override fun rootBuilder(builder: MutableCommandBuilder<BukkitSender>) {
        builder.handler { context ->
            val player = context.sender().player() ?: return@handler
            player.sendComponent(MessageFormat.setPrefix(MessageFormat.setPrimaryColor("Click ${MessageFormat.setSecondaryColor("<u><click:open_url:'https://galaxy.lncvrt.xyz'>HERE</click></u>")} to view our Website!")))
        }
    }
}
