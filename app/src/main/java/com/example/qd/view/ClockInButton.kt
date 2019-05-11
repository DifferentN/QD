package com.example.qd.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import com.example.qd.R

class ClockInButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint:Paint = Paint()
    var myWidth:Int = 0;
    var myHeight:Int = 0;
    var radius:Int = 0
    var waveRadius = 0
    var myColor:Int = 0
    var wavePaint = Paint()
    var alpha  = 0
    var touchX :Float= 0f
    var touchY :Float= 0f
    var writerPaint:Paint = Paint()
    var textSize = 0
    init {

        attrs?.let{
            val arrayType = context.obtainStyledAttributes(attrs, R.styleable.circleBt,defStyleAttr,0)
            myColor = arrayType.getColor(R.styleable.circleBt_circleColor,Color.BLUE)
            textSize = arrayType.getInt(R.styleable.circleBt_centerTextSize,12)
            arrayType.recycle()
        }
        paint.color = myColor
        paint.isAntiAlias = true

        wavePaint.color = Color.WHITE
        wavePaint.alpha = 80

        writerPaint.color = Color.BLACK
        writerPaint.textSize = textSize.toFloat()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        myWidth = MeasureSpec.getSize(widthMeasureSpec)
        myHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
        radius = reckonRadius(myHeight,myWidth)


//        canvas？.drawText("签到",myWidth/2f,myHeight/2f)
        canvas?.drawCircle(myWidth/2f,myHeight/2f,radius.toFloat(),paint)
//        wavePaint.alpha = alpha
        canvas?.drawText("签到",myWidth/2f,myHeight/2f,writerPaint)

        canvas?.drawCircle(touchX,touchY,waveRadius.toFloat(),wavePaint)



    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        touchX = event!!.x
        touchY = event!!.y
        return super.onTouchEvent(event)
    }

    var reckonRadius = { myHeight:Int, myWidth:Int->if(myHeight>myWidth)
        myWidth/2
        else myHeight/2
    }
}