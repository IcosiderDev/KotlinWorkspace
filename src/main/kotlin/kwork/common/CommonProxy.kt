package kwork.common

import kwork.api.Mana
import kwork.api.ManaImpl
import kwork.api.ManaStorage
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy {
    fun pre(e: FMLPreInitializationEvent) {
        CapabilityManager.INSTANCE.register(Mana::class.java, ManaStorage()) { ManaImpl() }
    }

    fun init(e: FMLInitializationEvent) {

    }

    fun post(e: FMLPostInitializationEvent) {

    }
}