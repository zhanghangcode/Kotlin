package com.example.app.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.app.R

private val IMAGE_SIZE=150.dp
private var IMAGE_PADDING=50.dp

class MultilineTextView(context: Context,attrs: AttributeSet):
        View(context,attrs) {
    val text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla iaculis nec urna id dignissim. " +
            "Vivamus tempus justo ac urna maximus egestas. Nulla commodo dui lorem, ut hendrerit mi elementum at. " +
            "Aliquam ac auctor velit. Phasellus in blandit arcu. Nam a vehicula nunc, a eleifend elit. " +
            "Mauris gravida at risus eget dictum. Donec lorem lectus, laoreet quis iaculis vel, lacinia et libero." +
            " Proin suscipit felis et enim faucibus semper. In luctus enim vel volutpat suscipit. " +
            "Duis laoreet ipsum sit amet nulla mollis auctor. Ut vitae risus leo." +
            " Morbi dapibus erat vitae commodo fermentum. Etiam dignissim tempor vulputate. Mauris tempus feugiat dolor at dignissim."

    private val textPaint=TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize=16.dp
    }
    private val paint=Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize=16.dp
    }

    private val bitmap=getAvatarView(IMAGE_SIZE.toInt())
    private val fontMetrics=Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
//        val staticLayout=StaticLayout(text,textPaint,width,Layout.Alignment.ALIGN_NORMAL,1f,0f,false)
//        staticLayout.draw(canvas)
        canvas.drawBitmap(bitmap,width-IMAGE_SIZE,IMAGE_PADDING,paint)

        paint.getFontMetrics(fontMetrics)
        val measuredWidth= floatArrayOf(0f)
//        var count = paint.breakText(text, true, width.toFloat(), measuredWidth)
//        canvas.drawText(text,0,count,0f,-fontMetrics.top,paint)
//        var oldCount=count
//        count = paint.breakText(text, count,text.length,true, width.toFloat(), measuredWidth)
//        canvas.drawText(text,oldCount,oldCount+count,0f,-fontMetrics.top+paint.fontSpacing,paint)

        var start=0
        var count=0
        var verticalOffset=-fontMetrics.top
        var maxWith:Float
        while (start < text.length){
             if (verticalOffset+fontMetrics.bottom< IMAGE_PADDING ||verticalOffset+fontMetrics.top> IMAGE_SIZE){
                 maxWith= width.toFloat()
            }else{
                 maxWith=width.toFloat()-IMAGE_SIZE
            }
            count = paint.breakText(text, start,text.length,true, maxWith, measuredWidth)
            canvas.drawText(text,start,start+count,0f,verticalOffset,paint)
            start += count
            verticalOffset += paint.fontSpacing
        }
    }

    fun getAvatarView(width:Int): Bitmap {
        val options= BitmapFactory.Options()
        options.inJustDecodeBounds=true
        BitmapFactory.decodeResource(resources, R.drawable.avatar,options)
        options.inJustDecodeBounds=false
        options.inDensity=options.outWidth
        options.inTargetDensity=width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar,options)

    }
}