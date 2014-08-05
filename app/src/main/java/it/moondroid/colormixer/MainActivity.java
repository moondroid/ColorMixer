package it.moondroid.colormixer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {

    private HSLColor mHSL = new HSLColor(0.0f, 100.0f, 50.0f); //Default color

    private HueSeekBar mHueSeekBar;
    private LightnessSeekBar mLightnessSeekBar;
    private SaturationSeekBar mSaturationSeekBar;

    private View mPreviousColor;
    private View mNextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHueSeekBar = (HueSeekBar)findViewById(R.id.hue_seekbar);
        mHueSeekBar.initWithColor(mHSL.getRGB());
        mHueSeekBar.setOnSeekBarChangeListener(this);
        mLightnessSeekBar = (LightnessSeekBar)findViewById(R.id.lightness_seekbar);
        mLightnessSeekBar.initWithColor(mHSL.getRGB());
        mLightnessSeekBar.setOnSeekBarChangeListener(this);
        mSaturationSeekBar = (SaturationSeekBar)findViewById(R.id.saturation_seekbar);
        mSaturationSeekBar.initWithColor(mHSL.getRGB());
        mSaturationSeekBar.setOnSeekBarChangeListener(this);


        mPreviousColor = findViewById(R.id.previous_color);
        mPreviousColor.setBackgroundColor(mHSL.getRGB());
        mNextColor = findViewById(R.id.next_color);
        mNextColor.setBackgroundColor(mHSL.getRGB());
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(seekBar instanceof HueSeekBar){
            mHSL.setHue(mHueSeekBar.getHue());
        }
        if(seekBar instanceof LightnessSeekBar){
            mHSL.setLuminance(mLightnessSeekBar.getLightness());
        }
        if(seekBar instanceof SaturationSeekBar){
            mHSL.setSaturation(mSaturationSeekBar.getSaturation());
        }

        mLightnessSeekBar.setColor(mHSL.getRGB());
        mSaturationSeekBar.setColor(mHSL.getRGB());

        mNextColor.setBackgroundColor(mHSL.getRGB());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

            mLightnessSeekBar.setColor(mHSL.getRGB());
            mSaturationSeekBar.setColor(mHSL.getRGB());

    }
}
