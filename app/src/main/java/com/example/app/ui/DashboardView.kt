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
private const val OPEN_ANGLE=120f
private val LENGTH=120f.px
private val DASH_WIDTH=2f.px
private val DASH_LENGTH=10f.px
class DashboardView(context: Context?,attrs: AttributeSet?):
        View(context,attrs){

    private val dash=Path()
    private val path=Path()
    private lateinit var pathEffect: PathEffect
    private val paint=Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style=Paint.Style.STROKE
            strokeWidth=3f.px
    }



    init {
        dash.addRect(0f,0f, DASH_WIDTH, DASH_LENGTH,Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

        path.reset()
        path.addArc(width/2f-RADIUS,height/2f-RADIUS,width/2f+RADIUS,height/2f+RADIUS,
                90+ OPEN_ANGLE/2f,360- OPEN_ANGLE)
        val pathMeasure=PathMeasure(path,false)
        pathEffect=PathDashPathEffect(dash,(pathMeasure.length- DASH_WIDTH)/20f,0f,PathDashPathEffect.Style.ROTATE)

    }


    override fun onDraw(canvas: Canvas) {
        //1 画弧
        canvas.drawPath(path,paint)
        //2画刻度
        paint.pathEffect=pathEffect
        canvas.drawPath(path,paint)
        paint.pathEffect=null

        canvas.drawLine(width/2f,height/2f,
                (width/2f+ LENGTH* cos(markToRadians(5))).toFloat(),
                (height/2f+ LENGTH* sin(markToRadians(5))).toFloat(),
                paint
        )

    }

    private fun markToRadians(mark:Int)= Math.toRadians((90+ OPEN_ANGLE/2f+(360- OPEN_ANGLE)/20f*mark).toDouble())


}