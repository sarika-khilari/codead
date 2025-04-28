MainActivity.java
package com.ad.clg.activitybyfragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ad.clg.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add fragments dynamically
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment1, new Fragment1());
        fragmentTransaction.replace(R.id.fragment2, new Fragment2());
        fragmentTransaction.replace(R.id.fragment3, new Fragment3());

        fragmentTransaction.commit();
    }
}

Fragment1.java
package com.ad.clg.activitybyfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ad.clg.R;

public class Fragment1 extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frag2_view = inflater.inflate(R.layout.fragment_1, container, false);
        Button button = frag2_view.findViewById(R.id.button);
        textView = frag2_view.findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // Get Fragment2 instance from FragmentManager
                Fragment2 fragment2 = (Fragment2) getParentFragmentManager().findFragmentById(R.id.fragment2);

                if (fragment2 != null) {
                    // Update text in Fragment2's TextView
                    fragment2.updateText("Press Below button to change text of Fragment-3");
                } else {
                    Toast.makeText(getActivity(), "Fragment 3 is not available", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return frag2_view;
    }

    // Method to update text in Fragment2
    public void updateText(String newText) {
        if (textView != null) {
            textView.setText(newText);
        }
    }
}

Fragment2.java
package com.ad.clg.activitybyfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ad.clg.R;

public class Fragment2 extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frag2_view = inflater.inflate(R.layout.fragment_2, container, false);
        Button button = frag2_view.findViewById(R.id.button);
        textView = frag2_view.findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // Get Fragment2 instance from FragmentManager
                Fragment3 fragment3 = (Fragment3) getParentFragmentManager().findFragmentById(R.id.fragment3);

                if (fragment3 != null) {
                    // Update text in Fragment2's TextView
                    fragment3.updateText("Press Below button to change text of Fragment-1");
                } else {
                    Toast.makeText(getActivity(), "Fragment 3 is not available", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return frag2_view;
    }

    // Method to update text in Fragment2
    public void updateText(String newText) {
        if (textView != null) {
            textView.setText(newText);
        }
    }
}

Fragment3.java
package com.ad.clg.activitybyfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ad.clg.R;

public class Fragment3 extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frag2_view = inflater.inflate(R.layout.fragment_3, container, false);
        Button button = frag2_view.findViewById(R.id.button);
        textView = frag2_view.findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // Get Fragment2 instance from FragmentManager
                Fragment1 fragment1 = (Fragment1) getParentFragmentManager().findFragmentById(R.id.fragment3);

                if (fragment1 != null) {
                    // Update text in Fragment2's TextView
                    fragment1.updateText("Press Below button to change text of Fragment-2");
                } else {
                    Toast.makeText(getActivity(), "Fragment 3 is not available", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return frag2_view;
    }

    // Method to update text in Fragment2
    public void updateText(String newText) {
        if (textView != null) {
            textView.setText(newText);
        }
    }
}

main_activity.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    tools:context="com.ad.clg.activitybyfragment.MainActivity">

    <fragment
        android:id="@+id/fragment1"
        android:name="com.ad.clg.activitybyfragment.Fragment1"
        android:layout_width="196dp"
        android:layout_height="246dp"
        android:layout_weight="1"
        app:layout_constraintBottom_toTopOf="@+id/fragment3"
        app:layout_constraintEnd_toStartOf="@+id/fragment2"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />

    <fragment
        android:id="@+id/fragment2"
        android:name="com.ad.clg.activitybyfragment.Fragment2"
        android:layout_width="0px"
        android:layout_height="246dp"
        android:layout_weight="1"
        app:layout_constraintBottom_toTopOf="@+id/fragment3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/fragment1"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />

    <fragment
        android:id="@+id/fragment3"
        android:name="com.ad.clg.activitybyfragment.Fragment3"
        android:layout_width="0px"
        android:layout_height="0dp"
        android:layout_weight="1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/fragment1"
        app:layout_constraintVertical_bias="0.5" />

</androidx.constraintlayout.widget.ConstraintLayout>

Fragment_1.xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/frag3"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#F5F5DC"
    tools:context="com.ad.clg.activitybyfragment.Fragment1">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:fontFamily="sans-serif"
        android:gravity="center"
        android:text="Press Below button to change text of Fragment-2"
        android:textSize="20dp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Frag1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        app:layout_constraintVertical_bias="0.5" />

</androidx.constraintlayout.widget.ConstraintLayout>

fragment_2.xml

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/frag2"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#E6E685"
    tools:context="com.ad.clg.activitybyfragment.Fragment1">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:fontFamily="sans-serif"
        android:gravity="center"
        android:text="Default"
        android:textSize="20dp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Frag2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        app:layout_constraintVertical_bias="0.5" />

</androidx.constraintlayout.widget.ConstraintLayout>

fragment_3.xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:id="@+id/frag3"
    android:layout_height="match_parent"
    android:background="#90CAF9"
    tools:context="com.ad.clg.activitybyfragment.Fragment1">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:fontFamily="sans-serif"
        android:gravity="center"
        android:text="Default"
        android:textSize="20dp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Fragment 3"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        app:layout_constraintVertical_bias="0.5" />

</androidx.constraintlayout.widget.ConstraintLayout>

 


