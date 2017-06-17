package com.example.dil.implicitintents;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ImplicitIntents extends AppCompatActivity {

    EditText ed, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
        ed = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        String fontPath = "fonts/DS-DIGIT.TTF";

        // text view label
        TextView txt = (TextView) findViewById(R.id.textView);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txt.setTypeface(tf);
    }

    public void callme(View v) {
        String num = ed.getText().toString();
        //Universal Resource Identifier
        Uri uri = Uri.parse("tel:" + num);

        //Action_dial no need permissions declared explicitly
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        /*
        Action_call needs permissions declared

        Intent i = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        */

        startActivity(i);
    }
    public void search(View v)
    {
        String data = ed2.getText().toString();

        //to use default browser
                    //Intent i = new Intent(Intent.ACTION_WEB_SEARCH);

        //Ask the browser

        Intent i = new Intent(Intent.ACTION_SEARCH);
        i.putExtra(SearchManager.QUERY,data);
        startActivity(i);
    }
}
