package kwork.server

import net.minecraft.util.text.TextComponentString
import net.minecraft.util.text.TextFormatting
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.PlayerEvent

@Mod.EventBusSubscriber
object Events {
    @JvmStatic
    @SubscribeEvent
    fun onLoggedIn(e: PlayerEvent.PlayerLoggedInEvent) {
        e.player.sendMessage(TextComponentString("Hello, ${e.player.name}!").apply {
            this.style.color = TextFormatting.GREEN
        })
    }
}