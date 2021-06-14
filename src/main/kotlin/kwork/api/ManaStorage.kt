package kwork.api

import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability

class ManaStorage : Capability.IStorage<Mana> {
    override fun readNBT(cap: Capability<Mana>, instance: Mana, side: Direction, nbt: INBT) {
        val compound = nbt as? CompoundNBT ?: return
        (instance as ManaImpl).mana = compound.getDouble("Mana")
    }

    override fun writeNBT(cap: Capability<Mana>, instance: Mana, side: Direction?) = CompoundNBT().apply {
        this.putDouble("Mana", (instance as ManaImpl).mana)
    }
}