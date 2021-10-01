package com.example.laboratoire1

import android.app.backup.BackupAgentHelper
import kotlin.math.pow

class Cylinder(_radius:Double,_color:String,_height:Double):Circle(_radius, _color)
{
    constructor() : this(1.0,"red",1.0)
    constructor(_radius: Double):this(_radius,"red",1.0)
    constructor(_radius: Double,_height: Double):this(_radius,"red",_height )

    private var height:Double;


    init
    {
        this.height = _height
    }

    //get/set pour radius
    fun getHeight() = this.height
    fun setHeight(r: Double) {
        this.height = r
    }

    //get volume
    open fun getvolume() = this.height * super.getAera()

    override fun getAera():Double{
        return (2 * 3.1415 * super.getRadius() * this.height + (2 * super.getAera()))
    }
}