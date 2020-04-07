package kwork

import kwork.api.Mana
import kwork.common.CommonProxy
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = "kwork", name = "KWork", version = "1.0")
object KWork {
    val manaCapName = ResourceLocation("kwork", "mana")

    @JvmStatic
    @CapabilityInject(Mana::class)
    lateinit var manaCap: Capability<Mana>

    @JvmStatic
    @SidedProxy(clientSide = "kwork.client.ClientProxy", serverSide = "kwork.common.CommonProxy")
    lateinit var proxy: CommonProxy

    @JvmStatic
    @Mod.InstanceFactory
    fun instance() = KWork

    @Mod.EventHandler
    fun pre(e: FMLPreInitializationEvent) {
        proxy.pre(e)
    }

    @Mod.EventHandler
    fun init(e: FMLInitializationEvent) {
        proxy.init(e)
    }

    @Mod.EventHandler
    fun post(e: FMLPostInitializationEvent) {
        proxy.post(e)
    }
}