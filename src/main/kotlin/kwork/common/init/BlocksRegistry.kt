package kwork.common.init

import kwork.common.blocks.BlockStar
import kwork.common.items.ItemStarStick
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry

@Mod.EventBusSubscriber
object BlocksRegistry {
    @JvmStatic
    @GameRegistry.ObjectHolder("kwork:star")
    lateinit var star: BlockStar

    @JvmStatic
    @SubscribeEvent
    fun onRegistryItem(e: RegistryEvent.Register<Item>) {
        e.registry.register(ItemBlock(star).setRegistryName(star.registryName))
    }

    @JvmStatic
    @SubscribeEvent
    fun onRegistryBlock(e: RegistryEvent.Register<Block>) {
        e.registry.register(BlockStar())
    }
}