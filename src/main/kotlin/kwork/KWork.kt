package kwork

import kwork.KWork.modId
import kwork.api.Mana
import kwork.api.ManaImpl
import kwork.api.ManaStorage
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

@Mod(modId)
@Mod.EventBusSubscriber(modid = modId, bus = Mod.EventBusSubscriber.Bus.MOD)
object KWork {
    @JvmStatic
    @CapabilityInject(Mana::class)
    lateinit var manaCap: Capability<Mana>

    const val modId = "kwork"

    val manaCapName = ResourceLocation(modId, "mana")

    @SubscribeEvent
    fun setup(e: FMLCommonSetupEvent) {
        CapabilityManager.INSTANCE.register(Mana::class.java, ManaStorage()) { ManaImpl() }
    }
}