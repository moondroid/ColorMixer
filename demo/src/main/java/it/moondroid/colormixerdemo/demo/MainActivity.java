package it.moondroid.colormixerdemo.demo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import it.moondroid.colormixer.ColorFragment;
import it.moondroid.colormixer.HSLFragment;
import it.moondroid.colormixer.VennColorsWidget;


public class MainActivity extends ActionBarActivity implements HSLFragment.OnColorChangeListener {

    private VennColorsWidget mVennColorsWidget;
    private int mWhichCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mVennColorsWidget = (VennColorsWidget)findViewById(R.id.colors_widget);
        mVennColorsWidget.setOnCircleClickListener(new VennColorsWidget.ColorsInterface(){

            @Override
            public void onCircleClick(int which, int color) {
                if (which== VennColorsWidget.ColorsInterface.CIRCLE1 ||
                        which== VennColorsWidget.ColorsInterface.CIRCLE2 ||
                        which== VennColorsWidget.ColorsInterface.CIRCLE3){

                    mWhichCircle = which;

                    HSLFragment fragment = HSLFragment.newInstance(color);
                    fragment.show(getFragmentManager(), "dialog");
                }else{
                    ColorFragment fragment = ColorFragment.newInstance(color);
                    fragment.show(getFragmentManager(), "dialog");
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_mode_darken:
                mVennColorsWidget.setPorterDuffXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
                return true;

            case R.id.action_mode_add:
                mVennColorsWidget.setPorterDuffXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onColorChange(int color) {

    }

    @Override
    public void onColorConfirmed(int color) {

        mVennColorsWidget.setColor(mWhichCircle, color);
    }

    @Override
    public void onColorCancel() {

    }
}
