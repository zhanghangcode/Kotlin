package com.example.app.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @Date 執筆時間 2021/02/27 10:36
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
class CircleView(context: Context,attrs:AttributeSet):View(context,attrs) {

    private val paint=Paint(Paint.ANTI_ALIAS_FLAG)
    var radius=50.dp
    set(value) {
        field=value
        invalidate()
    }

//    public void setRadius(float value){
//        radius=values;
//        invalidate();
//    }

    init {
        paint.color=Color.parseColor("#00796B")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(width/2f,height/2f,radius,paint)
    }
}