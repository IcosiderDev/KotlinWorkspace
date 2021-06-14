package kwork.server

import kwork.KWork
import kwork.api.ManaProvider
import net.minecraft.util.Util
import net.minecraft.util.text.Color
import net.minecraft.util.text.StringTextComponent
import net.minecraft.world.chunk.Chunk
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object Events {
    @JvmStatic
    @SubscribeEvent
    fun onLoggedIn(e: PlayerEvent.PlayerLoggedInEvent) {
        e.player.sendMessage(StringTextComponent("Hello, ${e.player.name}!").apply {
            this.style.withColor(Color.fromRgb(0x00FF00))
        }, Util.NIL_UUID)
    }

    @JvmStatic
    @SubscribeEvent
    fun onAttachCapToChunk(e: AttachCapabilitiesEvent<Chunk>) {
        e.addCapability(KWork.manaCapName, ManaProvider())
    }
}