package kwork.common.items

import kwork.api.ManaImpl
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.text.TextComponentString
import net.minecraft.util.text.TextFormatting
import net.minecraft.world.World

class ItemStarStick(name: String = "starStick") : Item() {
    init {
        this.setRegistryName(name)
        this.unlocalizedName = name
    }

    override fun onItemRightClick(world: World, player: EntityPlayer, hand: EnumHand): ActionResult<ItemStack> {
        if (!world.isRemote) {
            val chunk = world.getChunkFromBlockCoords(player.position)
            val mana = ManaImpl.get(chunk) ?: return ActionResult(EnumActionResult.PASS, player.getHeldItem(hand))

            mana.fill(1.25)

            player.sendMessage(TextComponentString(mana.toString()).apply {
                this.style.color = TextFormatting.GOLD
            })
        }
        return super.onItemRightClick(world, player, hand)
    }
}