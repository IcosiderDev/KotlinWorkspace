package kwork.common.init

import kwork.common.blocks.StarBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.ObjectHolder

@Mod.EventBusSubscriber
object BlocksRegistry {
    @JvmStatic
    @ObjectHolder("kwork:star")
    lateinit var star: StarBlock

    @JvmStatic
    @SubscribeEvent
    fun onRegistryItem(e: RegistryEvent.Register<Item>) {
        e.registry.register(BlockItem(star, Item.Properties()).setRegistryName(star.registryName))
    }

    @JvmStatic
    @SubscribeEvent
    fun onRegistryBlock(e: RegistryEvent.Register<Block>) {
        e.registry.register(StarBlock())
    }
}