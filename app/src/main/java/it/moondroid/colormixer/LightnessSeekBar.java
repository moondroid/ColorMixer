package it.moondroid.colormixer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by marco.granatiero on 05/08/2014.
 */
public class LightnessSeekBar extends ColorSeekBar {

    private HSLColor mHSL = new HSLColor(0.0f, 100.0f, 50.0f); //Default color
    private int width, height;

    public LightnessSeekBar(Context context) {
        super(context);
    }

    public LightnessSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LightnessSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);

        setProgressDrawable(ColorUtils.getLightnessBar(mHSL, width, height));
        setMax(HSLColor.LIGHTNESS_MAX);

    }

    @Override
    public float getHue() {
        return mHSL.getHue();
    }

    @Override
    public float getSaturation() {
        return mHSL.getSaturation();
    }

    @Override
    public float getLightness(){
        mHSL.setLuminance(getProgress());
        return mHSL.getLuminance();
    }

    @Override
    public void initWithColor(int color){
        setColor(color);
        setProgress((int) mHSL.getLuminance());
    }

    @Override
    public void setColor(int color){
        mHSL = new HSLColor(HSLColor.fromRGB(color));
        setProgressDrawable(ColorUtils.getLightnessBar(mHSL, getWidth(), getHeight()));
    }

    @Override
    public int getColor(){
        mHSL.setLuminance(getProgress());
        return mHSL.getRGB();
    }
}
