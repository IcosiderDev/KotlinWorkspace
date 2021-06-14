package kwork.api

import kwork.KWork
import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.common.util.LazyOptional

class ManaProvider : ICapabilitySerializable<CompoundNBT> {
    private val holder = LazyOptional.of {
        KWork.manaCap.defaultInstance!!
    }

    override fun <T : Any?> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> =
        if (cap === KWork.manaCap) holder.cast() else LazyOptional.empty()

    override fun deserializeNBT(nbt: CompoundNBT) =
        KWork.manaCap.storage.readNBT(KWork.manaCap, getCapOrThrow(), Direction.DOWN, nbt)

    override fun serializeNBT() =
        KWork.manaCap.storage.writeNBT(KWork.manaCap, getCapOrThrow(), Direction.DOWN) as CompoundNBT

    private fun getCapOrThrow() = holder.orElseThrow {
        NullPointerException("Mana Capability was empty")
    }
}