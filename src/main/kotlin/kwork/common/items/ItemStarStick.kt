package kwork.common.items

import kwork.api.ManaImpl
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.Util
import net.minecraft.util.text.Color
import net.minecraft.util.text.StringTextComponent
import net.minecraft.world.World
import net.minecraft.world.chunk.Chunk

class ItemStarStick(name: String = "starStick") : Item(Properties().tab(ItemGroup.TAB_MATERIALS)) {
    init {
        this.setRegistryName(name)
    }

    override fun use(world: World, player: PlayerEntity, hand: Hand): ActionResult<ItemStack> {
        if (!world.isClientSide) {
            val chunk = world.getChunk(player.blockPosition())
            ManaImpl.get(chunk as Chunk).ifPresent { mana ->
                mana.fill(1.25)

                player.sendMessage(StringTextComponent(mana.toString()).apply {
                    this.style.withColor(Color.fromRgb(0x55FF55))
                }, Util.NIL_UUID)
            }
            return ActionResult.success(player.getItemInHand(hand))
        }
        return ActionResult.pass(player.getItemInHand(hand))
    }
}