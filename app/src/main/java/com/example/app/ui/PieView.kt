package com.example.app.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes
import javax.xml.namespace.NamespaceContext
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS=150f.px
private val ANGLES= floatArrayOf(60f,90f,150f,60f)
private val OFFSET_LENGTH=20f.px
private val COLORS= listOf(Color.parseColor("#C21858"),Color.parseColor("#00ACC1")
        ,Color.parseColor("#558B2F"),Color.parseColor("#5D4037"))
class PieView(context: Context?,attrs: AttributeSet?):
        View(context,attrs){

    private val paint=Paint(Paint.ANTI_ALIAS_FLAG)


    init {
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }


    override fun onDraw(canvas: Canvas) {

        var startAngle=0f
        for ((index,angle)in ANGLES.withIndex()){
            paint.color= COLORS[index]
           if (index==2){
               canvas.save()
               canvas.translate(OFFSET_LENGTH*cos(Math.toRadians(startAngle+angle/2f.toDouble())).toFloat(),
                       OFFSET_LENGTH* sin(Math.toRadians(startAngle+angle/2f.toDouble())).toFloat()
                       )
           }
            canvas.drawArc(width/2f- RADIUS,height/2f- RADIUS,width/2f+ RADIUS,height/2f+ RADIUS
                    ,startAngle,angle,true,paint)
            startAngle+=angle
            if (index==2){
                canvas.restore()
            }

        }

    }



}