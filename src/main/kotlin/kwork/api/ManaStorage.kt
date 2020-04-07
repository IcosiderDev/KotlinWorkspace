package kwork.api

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability

class ManaStorage : Capability.IStorage<Mana> {
    override fun readNBT(cap: Capability<Mana>, instance: Mana, side: EnumFacing, nbt: NBTBase) {
        val compound = nbt as? NBTTagCompound ?: return
        (instance as ManaImpl).mana = compound.getDouble("Mana")
    }

    override fun writeNBT(cap: Capability<Mana>, instance: Mana, side: EnumFacing?) = NBTTagCompound().apply {
        this.setDouble("Mana", (instance as ManaImpl).mana)
    }
}