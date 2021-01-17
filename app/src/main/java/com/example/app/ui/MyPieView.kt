package com.example.app.ui

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 * @Date 執筆時間 2021/01/17 21:16
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
//丸のredius
private val RADIUS=150f.px
private val OFFSET_LENGTH=20.dp
//角度の設定
private val ANGLES= floatArrayOf(60f,90f,150f,60f)
//色の設定
private val COLORS= listOf(Color.parseColor("#C21858"), Color.parseColor("#00ACC1")
        , Color.parseColor("#558B2F"), Color.parseColor("#5D4037"))
class MyPieView(context: Context?, attrs: AttributeSet?):
View(context,attrs){

    private val paint= Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {

        //開始角度　startAngle
        //完了角度 sweepAngle
        var startAngle=0f

        for((index,angle) in ANGLES.withIndex()){
            //ペンのカラーの設定
            paint.color= COLORS[index]
            if (index==1){
                //canvasの移動の距離計算　三角関数
                canvas.save()
                canvas.translate(OFFSET_LENGTH* cos(Math.toRadians(startAngle+angle/2f.toDouble())).toFloat(),
                        OFFSET_LENGTH* sin(Math.toRadians(startAngle+angle/2f.toDouble())).toFloat()
                )
            }
            canvas.drawArc(width/2f- RADIUS,height/2f- RADIUS,width/2f+ RADIUS,height/2f+ RADIUS
                    ,startAngle,angle,true,paint)
            //開始角度の増加
            startAngle+=angle
            if (index==1){
                canvas.restore()
            }
        }


    }
}
