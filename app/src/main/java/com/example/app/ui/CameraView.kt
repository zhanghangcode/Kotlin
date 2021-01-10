package com.example.app.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.app.R

/**
 * @Date 執筆時間 2021/01/10 14:49
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */

private val BITMAP_SIZE=200.dp
private val BITMAP_PADDING=100.dp
class CameraView(context: Context,attrs:AttributeSet):View(context,attrs) {

    private val paint=Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap=getAvatar(BITMAP_SIZE.toInt())
    private val camera=Camera()

    init {

       camera.rotateX(30f)
        //例外zはdpではなくて、insです。
        camera.setLocation(0f,0f,-6 * resources.displayMetrics.density)
    }
    override fun onDraw(canvas: Canvas) {
        canvas.translate(BITMAP_PADDING+ BITMAP_SIZE/2,BITMAP_PADDING+ BITMAP_SIZE/2)
        camera.applyToCanvas(canvas)
        canvas.translate(-(BITMAP_PADDING+ BITMAP_SIZE/2),-(BITMAP_PADDING+ BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
    }
    private fun getAvatar(width:Int):Bitmap{
       val options=BitmapFactory.Options()
       options.inJustDecodeBounds=true
       BitmapFactory.decodeResource(resources, R.drawable.avatar,options)
       options.inJustDecodeBounds=false
        options.inDensity=options.outWidth
        options.inTargetDensity=width
        return BitmapFactory.decodeResource(resources,R.drawable.avatar,options)
    }
}