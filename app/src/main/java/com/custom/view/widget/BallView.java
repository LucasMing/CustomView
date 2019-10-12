package com.custom.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.custom.view.R;

/**
 * author : lcm
 * date   : 2019/10/11 17:51
 */
public class BallView extends View {
    private Paint paint=new Paint();;
    public float currentX=100;
    public float currentY=100;
    public int textColor;
    public float textSize;
    public BallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取资源文件里面的属性，由于这里只有一个属性值，不用遍历数组，直接通过R文件拿出color值
        //把属性放在资源文件里，方便设置和复用
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ball);
        textColor = array.getColor(R.styleable.ball_textColor,Color.BLACK);
        textSize = array.getDimension(R.styleable.ball_TextSize,40);
        //这里通过不断的更新当前位置坐标和重新绘制图形实现效果，要注意的是使用TypedArray后一定要记得recycle(). 否则会对下次调用产生影响。
        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画一个蓝色的圆形
        paint.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,100,paint);
        //设置文字和颜色，这里的颜色是资源文件values里面的值
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        canvas.drawText("拖动",currentX-50,currentY+150,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX=event.getX();
        currentY=event.getY();
        invalidate();//重新绘制图形
        return true;
    }
}
