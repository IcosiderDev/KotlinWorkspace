package kwork.common.init

import kwork.common.items.ItemStarStick
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.ObjectHolder

@Mod.EventBusSubscriber
object ItemsRegistry {
    @JvmStatic
    @ObjectHolder("kwork:starStick")
    lateinit var starStick: ItemStarStick

    @JvmStatic
    @SubscribeEvent
    fun onRegistryItem(e: RegistryEvent.Register<Item>) {
        e.registry.register(ItemStarStick())
    }
}