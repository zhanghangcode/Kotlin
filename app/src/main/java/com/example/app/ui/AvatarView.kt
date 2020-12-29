package com.example.app.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.app.R

private val IMAGE_WIDTH=200f.px
private val BACK_WIDTH=140f.px
private val IMAGE_PADDING=20f.px
private val XF=PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
class AvatarView(context: Context,attrs:AttributeSet):
        View(context,attrs) {

    private val paint=Paint(Paint.ANTI_ALIAS_FLAG).apply {

    }
    private val bounds=RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING+ BACK_WIDTH, IMAGE_PADDING+ BACK_WIDTH)
//    private val bounds=RectF(150f.px, 50f.px, 300f.px, 200f.px)
//    private val circleBitmap=Bitmap.createBitmap(150f.px.toInt(),150f.px.toInt(),Bitmap.Config.ARGB_8888)
//    private val squareBitmap=Bitmap.createBitmap(150f.px.toInt(),150f.px.toInt(),Bitmap.Config.ARGB_8888)

    init {
//        val canvas=Canvas(circleBitmap)
//        paint.color=Color.parseColor("#D81B60")
//        canvas.drawOval(50f.px,0f.px,150f.px,100f.px,paint)
//        paint.color=Color.parseColor("#2196F3")
//        canvas.setBitmap(squareBitmap)
//        canvas.drawRect(0f.px,50f.px,100f.px,150f.px,paint)
    }
    override fun onDraw(canvas: Canvas) {
//        val count=canvas.saveLayer(bounds,null)
//        paint.color=Color.parseColor("#D81B60")
//        canvas.drawBitmap(circleBitmap,150f.px,50f.px,paint)
//        paint.xfermode = XF
//        canvas.drawBitmap(squareBitmap,150f.px,50f.px,paint)
//        paint.xfermode=null
//        canvas.restoreToCount(count)

        val count=canvas.saveLayer(bounds,null)
        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING+ BACK_WIDTH, IMAGE_PADDING+ BACK_WIDTH,paint)
        paint.xfermode = XF
        canvas.drawBitmap(getAvatarView(IMAGE_WIDTH.toInt()),IMAGE_PADDING,IMAGE_PADDING,paint)
        paint.xfermode=null
        canvas.restoreToCount(count)
    }

    fun getAvatarView(width:Int):Bitmap{
       val options= BitmapFactory.Options()
        options.inJustDecodeBounds=true
        BitmapFactory.decodeResource(resources, R.drawable.avatar,options)
        options.inJustDecodeBounds=false
        options.inDensity=options.outWidth
        options.inTargetDensity=width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar,options)

    }
}