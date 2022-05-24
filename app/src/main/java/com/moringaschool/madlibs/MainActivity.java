package com.moringaschool.madlibs;


import java.io.IOException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
public class MainActivity extends Activity {
    int inLayout; // will hold the id number for layout file main_class_activity_in.xml.
    int outLayout; // will hold the id number for layout file main_class_activity_out.xml.
    int outviewid;   // will hold the id number for the textview found in main_class_activity_out.xml
    Activity activity = this;
    String test;
    AutoCompleteTextView autoview;
    StringBuffer stringbuffer = new StringBuffer();
    String[] stringviews = new String[16];
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_class_activity_in);
        outLayout = (R.layout.main_class_activity_out);
        inLayout = (R.layout.main_class_activity_in);
        outviewid = (R.id.outview14);

    }


    public void gather(){

        ViewGroup layout = (ViewGroup)findViewById(R.id.anskey_clover);
        View[] views = new View[layout.getChildCount()];
        int[] ids = new int[layout.getChildCount()];

        for (int i = 0; i < layout.getChildCount(); i++){
            ids[i] = layout.getChildAt(i).getId();
        }

        for (int i =0; i < layout.getChildCount(); i++){
            AutoCompleteTextView au =(AutoCompleteTextView)findViewById(ids[i]);
            stringbuffer.append(au.getText().toString() + "\n");


        }
        setContentView(outLayout);
        TextView outview = (TextView)findViewById(outviewid);
        outview.setText(stringbuffer.toString());

    }

    public void postIt(){
        String str = "let's go to the park";
        String str2;
        String newstr = null;

        setContentView(outLayout);
        TextView outview = (TextView)findViewById(outviewid);
        str = (String) outview.getText();
        stringviews = stringbuffer.toString().split("\n"); // turns the stringbuffer from getAllXml() into an array and assigns to stringviews.

        for (int i=0;i<stringviews.length;i++){
            str2 = stringviews[i];
            newstr = str.replaceFirst("wx",str2); // replaces all the "wx"s in the main_class_activity_out textview with values from strinvgviews.
            str = newstr;
        }
        outview.setText(newstr);
        stringbuffer.delete(0,stringbuffer.length());
    }


    public void onClick(View view) {
        gather();
        postIt();


    }
}