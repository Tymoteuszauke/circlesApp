package com.example.mateu_000.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {


    private MyDraw drawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawLayout = (MyDraw)this.findViewById(R.id.bojd);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN) {

            //Toast.makeText(this, "ACTION_DOWN AT COORDS "+"X: "+x+" Y: "+y, Toast.LENGTH_SHORT).show();
            drawLayout.makeCircle(x, y - 300);

        }



        return true;

        //return super.onTouchEvent(event);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Bundle b  = drawLayout.saveState();

        savedInstanceState.putAll(b);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        drawLayout.restoreState(savedInstanceState);


    }






}
