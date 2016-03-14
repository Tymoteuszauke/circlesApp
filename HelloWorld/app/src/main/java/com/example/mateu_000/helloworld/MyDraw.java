package com.example.mateu_000.helloworld;

import android.content.Context;
import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Paint;

//import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Matek on 2016-03-05.
 */
class MyDraw extends View {


    //Path path = new Path();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Random rand;


    ArrayList<Circle> circles;





    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);

        //rand = new Random();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);

        circles = new ArrayList<>();


        update();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Circle d : circles){

            paint.setColor(d.getColor());

            canvas.drawCircle(d.getX(), d.getY(), 50, paint);

        }

        //path.moveTo(0, -130);
        //path.lineTo(-50, 60);
        //path.lineTo(0, 30);
        //path.lineTo(50, 60);
        //path.close();
        //path.offset(550, 800);

       // canvas.drawPath(path, paint);
        //invalidate();
    }

    public void makeCircle(int x, int y) {

        circles.add(new Circle(x, y));

        invalidate();

    }


    public Bundle saveState() {

        Bundle b = new Bundle();

        //ArrayList<Circle> circleBundle = new ArrayList<>(circles);

        b.putSerializable("circles", circles);


        return b;

    }

    public void restoreState(Bundle state) {

        ArrayList<Circle> circleRestored =(ArrayList<Circle>) state.getSerializable("circles");

        circles = circleRestored;

        invalidate();

    }

    private RefreshHandler mRedrawHandler = new RefreshHandler();

    class RefreshHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            MyDraw.this.update();
            MyDraw.this.invalidate();
        }
        public void sleep(long delayMillis) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }

    private long mLastMove = 0;
    private long mMoveDelay = 10;

    private void update() {
        long now = System.currentTimeMillis();

        if (now - mLastMove > mMoveDelay) {

            if(circles.size() > 0) {
                updateCircles();
            }

            mLastMove = now;
        }

        mRedrawHandler.sleep(mMoveDelay);
    }

    private void updateCircles() {

        int i = 0;
        for (Circle lastCircle : circles) {

            lastCircle = circles.get(i);
            lastCircle.setX(lastCircle.getX() + lastCircle.getLeftRight());
            lastCircle.setY(lastCircle.getY() + lastCircle.getUpDown());

            if (lastCircle.getX() > this.getWidth() || lastCircle.getX() < 0) {
                lastCircle.setLeftRight(-1 * lastCircle.getLeftRight());
            }

            if (lastCircle.getY() > this.getHeight() || lastCircle.getY() < 0) {
                lastCircle.setUpDown(-1 * lastCircle.getUpDown());

            }

            i++;


        }
    }

}
