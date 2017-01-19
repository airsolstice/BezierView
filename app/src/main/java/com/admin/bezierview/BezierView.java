package com.admin.bezierview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/8/30 0030.
 */
public class BezierView extends View {


    private int px1 = 290;
    private int py1 = 330;

    private int px2 = 430;
    private int py2 = 330;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);

        int width = getMeasuredWidth() / 3;
        int height = getMeasuredHeight() ;
        canvas.drawCircle(width, height, 3, paint);
        canvas.drawCircle(width*2,height,3,paint);
        canvas.drawCircle(px1, py1,3,paint);
        canvas.drawCircle(px2, py2, 3, paint);
        Path path = new Path();
        path.moveTo(width, height);
        path.cubicTo(px1, py1, px2, py2, width * 2, height);
        //path.quadTo(px1, py1, width * 2, height);
        canvas.drawPath(path,paint);


        path.addCircle(getMeasuredWidth()/2,height,width/2, Path.Direction.CW);
        canvas.drawPath(path,paint);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            return true;
        }
        if(action == MotionEvent.ACTION_MOVE){
            if(py1>0&&py2 >0)
            {
                py1 = py1 - 20;
                py2 = px2 - 20;
                System.out.println("-->>wid = "+ getMeasuredWidth());
                System.out.println("-->>hei = "+ getMeasuredHeight());
                invalidate();
            }
        }
        if(action == MotionEvent.ACTION_UP){

        }

        return super.onTouchEvent(event);
    }
}
