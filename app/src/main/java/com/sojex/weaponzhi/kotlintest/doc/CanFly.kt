package com.sojex.weaponzhi.kotlintest.doc

/**
 * Created by admin on 2017/6/23.
 */
interface CanFly {
    fun fly()
}

class Bird(f:CanFly):CanFly by f
class Wings{
    fun move() = println("move by wings")
}
class AnimalWithWings : CanFly{
    val wings : Wings = Wings()
    override fun fly() = wings.move()
}

class Bat : CanFly by AnimalWithWings()

fun main(args: Array<String>) {
    val birdWithWings = Bird(AnimalWithWings())
    birdWithWings.fly()
    val bat = Bat()
    bat.fly()
}
