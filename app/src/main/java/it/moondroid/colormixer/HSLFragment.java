package it.moondroid.colormixer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link it.moondroid.colormixer.HSLFragment.OnColorChangeListener} interface
 * to handle interaction events.
 *
 */
public class HSLFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private HSLColor mHSL = new HSLColor(0.0f, 100.0f, 50.0f); //Default color

    private HueSeekBar mHueSeekBar;
    private LightnessSeekBar mLightnessSeekBar;
    private SaturationSeekBar mSaturationSeekBar;

    private View mPreviousColor;
    private View mNextColor;

    private OnColorChangeListener mListener;

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnColorChangeListener {

        public void onColorChange(int color);
    }

    public HSLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hsl, container, false);

        mHueSeekBar = (HueSeekBar)rootView.findViewById(R.id.hue_seekbar);
        mHueSeekBar.initWithColor(mHSL.getRGB());
        mHueSeekBar.setOnSeekBarChangeListener(this);
        mLightnessSeekBar = (LightnessSeekBar)rootView.findViewById(R.id.lightness_seekbar);
        mLightnessSeekBar.initWithColor(mHSL.getRGB());
        mLightnessSeekBar.setOnSeekBarChangeListener(this);
        mSaturationSeekBar = (SaturationSeekBar)rootView.findViewById(R.id.saturation_seekbar);
        mSaturationSeekBar.initWithColor(mHSL.getRGB());
        mSaturationSeekBar.setOnSeekBarChangeListener(this);


        mPreviousColor = rootView.findViewById(R.id.previous_color);
        mPreviousColor.setBackgroundColor(mHSL.getRGB());
        mNextColor = rootView.findViewById(R.id.next_color);
        mNextColor.setBackgroundColor(mHSL.getRGB());

        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnColorChangeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnColorChangeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

        mListener.onColorChange(mHSL.getRGB());
    }

}
