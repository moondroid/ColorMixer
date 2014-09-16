package it.moondroid.colormixerdemo.demo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import it.moondroid.colormixer.HSLColor;
import it.moondroid.colormixer.HSLFragment;


public class MainActivity extends ActionBarActivity implements HSLFragment.OnColorChangeListener {

    private int mColor = Color.RED;
    private View mColorView;
    private TextView mColorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorView = findViewById(R.id.view_color);
        mColorTextView = (TextView)findViewById(R.id.text_color);
        setColor(mColor);

        mColorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HSLFragment fragment = HSLFragment.newInstance(mColor);
                fragment.show(getFragmentManager(), "dialog");
            }
        });

    }

    private void setColor(int color){
        mColor = color;
        String hexColor = String.format("#%06X", (0xFFFFFF & mColor));
        mColorView.setBackgroundColor(color);
        mColorTextView.setText(hexColor);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onColorChange(int color) {

    }

    @Override
    public void onColorConfirmed(int color) {

        setColor(color);
    }

    @Override
    public void onColorCancel() {

    }
}
