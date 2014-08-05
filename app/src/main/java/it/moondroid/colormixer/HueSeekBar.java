package it.moondroid.colormixer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by marco.granatiero on 05/08/2014.
 */
public class HueSeekBar extends ColorSeekBar {

    public HueSeekBar(Context context) {
        super(context);
    }

    public HueSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HueSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);

        setProgressDrawable(ColorUtils.getHueBar(width, height));

        setMax(HSLColor.HUE_MAX);

    }

    @Override
    public float getHue(){
        mHSL.setHue(getProgress());
        return mHSL.getHue();
    }

    @Override
    public float getSaturation() {
        return mHSL.getSaturation();
    }

    @Override
    public float getLightness() {
        return mHSL.getLuminance();
    }

    @Override
    public void initWithColor(int color){
        setColor(color);
        setProgress((int) mHSL.getHue());
    }

    @Override
    public void setColor(int color){
        mHSL = new HSLColor(HSLColor.fromRGB(color));
    }

    @Override
    public int getColor(){
        mHSL.setHue(getProgress());
        return mHSL.getRGB();
    }
}
