package kwork.common.init

import kwork.common.items.ItemStarStick
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry

@Mod.EventBusSubscriber
object ItemsRegistry {
    @JvmStatic
    @GameRegistry.ObjectHolder("kwork:starStick")
    lateinit var starStick: ItemStarStick

    @JvmStatic
    @SubscribeEvent
    fun onRegistryItem(e: RegistryEvent.Register<Item>) {
        e.registry.register(ItemStarStick())
    }
}