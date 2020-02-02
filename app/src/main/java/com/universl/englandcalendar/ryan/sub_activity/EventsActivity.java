package com.universl.englandcalendar.ryan.sub_activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universl.englandcalendar.ryan.MainActivity;
import com.universl.englandcalendar.ryan.R;

import java.util.Objects;

public class EventsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    RelativeLayout main;
    LinearLayout all_event,england,wales,scotland,north_ireland;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        main = findViewById(R.id.main);all_event = findViewById(R.id.all_event);england = findViewById(R.id.england_event);north_ireland = findViewById(R.id.north_ireland_event);
        Toolbar toolbar = findViewById(R.id.search_bar);wales = findViewById(R.id.wales_event);scotland = findViewById(R.id.scotland_event);
        setSupportActionBar(toolbar);
        if (getIntent().getStringExtra("event").equalsIgnoreCase("all_event")){
            Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>Public Events</font>"));
            all_event.setVisibility(View.VISIBLE);
            england.setVisibility(View.GONE);
            wales.setVisibility(View.GONE);
            scotland.setVisibility(View.GONE);
            north_ireland.setVisibility(View.GONE);
        }else if (getIntent().getStringExtra("event").equalsIgnoreCase("england")){
            Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>England Events</font>"));
            all_event.setVisibility(View.GONE);
            england.setVisibility(View.VISIBLE);
            wales.setVisibility(View.GONE);
            scotland.setVisibility(View.GONE);
            north_ireland.setVisibility(View.GONE);
        }else if (getIntent().getStringExtra("event").equalsIgnoreCase("wales")){
            Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>Wales Events</font>"));
            all_event.setVisibility(View.GONE);
            england.setVisibility(View.GONE);
            wales.setVisibility(View.VISIBLE);
            scotland.setVisibility(View.GONE);
            north_ireland.setVisibility(View.GONE);
        }else if (getIntent().getStringExtra("event").equalsIgnoreCase("scotland")){
            Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>Scotland Events</font>"));
            all_event.setVisibility(View.GONE);
            england.setVisibility(View.GONE);
            wales.setVisibility(View.GONE);
            scotland.setVisibility(View.VISIBLE);
            north_ireland.setVisibility(View.GONE);
        }else if (getIntent().getStringExtra("event").equalsIgnoreCase("north_ireland")){
            Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>North Ireland Events</font>"));
            all_event.setVisibility(View.GONE);
            england.setVisibility(View.GONE);
            wales.setVisibility(View.GONE);
            scotland.setVisibility(View.GONE);
            north_ireland.setVisibility(View.VISIBLE);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(EventsActivity.this);
        dialogs.setContentView(R.layout.theme_popup);
        TextView imgCross = dialogs.findViewById(R.id.close);

        blue = dialogs.findViewById(R.id.blue_ray);
        blue.setOnCheckedChangeListener(this);

        red = dialogs.findViewById(R.id.red_ray);
        red.setOnCheckedChangeListener(this);

        green = dialogs.findViewById(R.id.green_ray);
        green.setOnCheckedChangeListener(this);

        purple = dialogs.findViewById(R.id.purple_ray);
        purple.setOnCheckedChangeListener(this);

        pink = dialogs.findViewById(R.id.pink_ray);
        pink.setOnCheckedChangeListener(this);

        default_color = dialogs.findViewById(R.id.default_ray);
        default_color.setOnCheckedChangeListener(this);

        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogs.dismiss();
            }
        });
        dialogs.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent intent = new Intent(EventsActivity.this, AllEventActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.power) {
            logout();
            return true;
        }
        if (id == R.id.theme){
            //open_popup_window();
            popupWindow();
        }
        if (id == R.id.reminder){
            Intent intent = new Intent(EventsActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(EventsActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_event){
            Intent intent = new Intent(EventsActivity.this, AllEventActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(EventsActivity.this, AllEventActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.blue_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = true;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.blue_theme);
            }
            if (buttonView.getId() == R.id.red_ray) {
                blue.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = true;isGreen = false;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.red_theme);
            }
            if (buttonView.getId() == R.id.green_ray) {
                red.setChecked(false);
                blue.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = true;isPurple = false;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.green_theme);
            }
            if (buttonView.getId() == R.id.purple_ray) {
                red.setChecked(false);
                green.setChecked(false);
                blue.setChecked(false);
                pink.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = true;isPink = false;isNormal = false;
                main.setBackgroundResource(R.drawable.purple_theme);
            }
            if (buttonView.getId() == R.id.pink_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                blue.setChecked(false);
                default_color.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = true;isNormal = false;
                main.setBackgroundResource(R.drawable.rose_theme);
            }
            if (buttonView.getId() == R.id.default_ray) {
                red.setChecked(false);
                green.setChecked(false);
                purple.setChecked(false);
                pink.setChecked(false);
                blue.setChecked(false);

                isBlue = false;isRed = false;isGreen = false;isPurple = false;isPink = false;isNormal = true;
                main.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
    }
}
