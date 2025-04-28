-	MainActivity.java
package com.ad.homepageusinggridlayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }
}


-	ImageAdapter.java
package com.ad.homepageusinggridlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return mThumbIds.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(100, 50, 50, 50);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,
            R.drawable.apps, R.drawable.whatsapp,
            R.drawable.caps, R.drawable.camera,
            R.drawable.calc, R.drawable.capss,
            R.drawable.loca, R.drawable.location,
            R.drawable.baseline_location_on_24, R.drawable.voice,
            R.drawable.voiceass,
            // adding all the images
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,
            R.drawable.apps, R.drawable.whatsapp,
            R.drawable.caps, R.drawable.camera,
            R.drawable.calc, R.drawable.capss,
            R.drawable.loca, R.drawable.location,
            R.drawable.baseline_location_on_24, R.drawable.voice,
            R.drawable.voiceass,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,

    };
}


-	activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <GridView
        android:id="@+id/gridview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:horizontalSpacing="6dp"
        android:numColumns="2"
        android:verticalSpacing="6dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
