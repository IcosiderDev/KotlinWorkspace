package kwork.common.items

import net.minecraft.item.Item

class ItemStarStick(name: String = "starStick") : Item() {
    init {
        this.setRegistryName(name)
        this.unlocalizedName = name
    }
}