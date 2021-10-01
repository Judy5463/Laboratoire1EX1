package com.example.laboratoire1

import androidx.core.graphics.rotationMatrix
import kotlin.math.pow

open class Circle (_radius:Double,_color:String) {
    constructor() : this(1.0, "red")
    constructor(color: String) : this(1.0, color)//secondaire #2
    constructor(radius: Double) : this(radius, "red")//equ secondaire #3 kotlin

    private var color: String
    private var radius: Double


    init {
        this.color = _color
        this.radius = _radius
    }

    //get/set pour color
   open fun getColor() = this.color



    //get/set pour radius
    fun getRadius() = this.radius
    fun setRadius(r: Double) {
        this.radius = r
    }

    //get aera
 open  fun getAera() = 3.1415 * Math.pow(this.radius,2.0)




}