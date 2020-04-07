package kwork.api

interface Mana {
    fun drain(value: Double): Mana
    fun fill(value: Double): Mana
}