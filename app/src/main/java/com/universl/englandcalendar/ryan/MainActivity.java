package com.universl.englandcalendar.ryan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universl.englandcalendar.ryan.internal_data.EnglandCalendar;
import com.universl.englandcalendar.ryan.internal_data.EventCollection;
import com.universl.englandcalendar.ryan.sub_activity.AllEventActivity;
import com.universl.englandcalendar.ryan.sub_activity.AllHolidayActivity;
import com.universl.englandcalendar.ryan.sub_activity.RemindTaskActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    public Calendar cal_month, cal_month_copy;
    private EnglandCalendar hwAdapter;
    private TextView tv_month;
    RelativeLayout main;
    LinearLayout date_layout;
    LinearLayout holiday_2,holiday,holiday_details;
    TextView month_1,month_2,month_3,month_4,month_5,month_6,month_7,month_8,month_9,month_10,month_11,month_12,month_13,month_14,month_15,month_16,month_17,month_18,month_19,title_1,title_2,title_3,title_4,title_5,title_6,title_7,title_8,title_9,title_10,title_11,title_12,title_13,title_14,title_15,title_16,title_17,title_18,title_19;
    CircleImageView red_1, red_2, red_3, red_4, red_5, red_6, red_7, red_8, red_9, red_10, red_11, red_12, red_13, red_14, red_15, red_16,red_17, red_18, red_19;
    CircleImageView blue_1, blue_2, blue_3, blue_4, blue_5, blue_6, blue_7, blue_8, blue_9, blue_10, blue_11, blue_12, blue_13, blue_14, blue_15, blue_16, blue_17, blue_18, blue_19;
    CircleImageView light_blue_1, light_blue_2, light_blue_3, light_blue_4, light_blue_5, light_blue_6, light_blue_7, light_blue_8, light_blue_9, light_blue_10, light_blue_11, light_blue_12, light_blue_13, light_blue_14, light_blue_15, light_blue_16, light_blue_17, light_blue_18, light_blue_19;
    CircleImageView light_green_1,light_green_2,light_green_3,light_green_4,light_green_5,light_green_6,light_green_7,light_green_8,light_green_9,light_green_10,light_green_11, light_green_12, light_green_13, light_green_14, light_green_15, light_green_16, light_green_17, light_green_18, light_green_19;
    CircleImageView orange_1, orange_2, orange_3, orange_4, orange_5, orange_6, orange_7, orange_8, orange_9, orange_10, orange_11, orange_12, orange_13, orange_14, orange_15, orange_16, orange_17, orange_18, orange_19;

    public Activity activity;
    RadioButton blue,red,green,purple,pink,default_color;
    Boolean isBlue = false,isRed = false,isGreen = false,isPurple = false,isPink = false,isNormal = true;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.search_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>UK Calendar 2020</font>"));


        activity = MainActivity.this;
        holiday_2 = findViewById(R.id.holiday_2);holiday = findViewById(R.id.holiday); holiday_details = findViewById(R.id.holiday_details);

        date_layout = findViewById(R.id.layout);
        main = findViewById(R.id.main); month_1 = findViewById(R.id.month_1); month_2 = findViewById(R.id.month_2); month_3 = findViewById(R.id.month_3); month_4 = findViewById(R.id.month_4);month_5 = findViewById(R.id.month_5); month_6 = findViewById(R.id.month_6); month_7 = findViewById(R.id.month_7); month_8 = findViewById(R.id.month_8);month_9 = findViewById(R.id.month_9); month_10 = findViewById(R.id.month_10); month_11 = findViewById(R.id.month_11); month_12 = findViewById(R.id.month_12); month_13 = findViewById(R.id.month_13); month_14 = findViewById(R.id.month_14); month_15 = findViewById(R.id.month_15); month_16 = findViewById(R.id.month_16); month_17 = findViewById(R.id.month_17); month_18 = findViewById(R.id.month_18); month_19 = findViewById(R.id.month_19);

        red_1 = findViewById(R.id.red_1); red_2 = findViewById(R.id.red_2); red_3 = findViewById(R.id.red_3); red_4 = findViewById(R.id.red_4); red_5 = findViewById(R.id.red_5); red_6 = findViewById(R.id.red_6); red_7 = findViewById(R.id.red_7); red_8 = findViewById(R.id.red_8);
        red_9 = findViewById(R.id.red_9); red_10 = findViewById(R.id.red_10); red_11 = findViewById(R.id.red_11); red_12 = findViewById(R.id.red_12); red_13 = findViewById(R.id.red_13); red_14 = findViewById(R.id.red_14); red_15 = findViewById(R.id.red_15); red_16 = findViewById(R.id.red_16); red_17 = findViewById(R.id.red_17); red_18 = findViewById(R.id.red_18); red_19 = findViewById(R.id.red_19);

        blue_1 = findViewById(R.id.blue_1); blue_2 = findViewById(R.id.blue_2); blue_3 = findViewById(R.id.blue_3); blue_4 = findViewById(R.id.blue_4); blue_5 = findViewById(R.id.blue_5); blue_6 = findViewById(R.id.blue_6); blue_7 = findViewById(R.id.blue_7); blue_8 = findViewById(R.id.blue_8);
        blue_9 = findViewById(R.id.blue_9); blue_10 = findViewById(R.id.blue_10); blue_11 = findViewById(R.id.blue_11); blue_12 = findViewById(R.id.blue_12); blue_13 = findViewById(R.id.blue_13); blue_14 = findViewById(R.id.blue_14); blue_15 = findViewById(R.id.blue_15); blue_16 = findViewById(R.id.blue_16); blue_17 = findViewById(R.id.blue_17); blue_18 = findViewById(R.id.blue_18); blue_19 = findViewById(R.id.blue_19);

        light_blue_1 = findViewById(R.id.light_blue_1); light_blue_2 = findViewById(R.id.light_blue_2); light_blue_3 = findViewById(R.id.light_blue_3); light_blue_4 = findViewById(R.id.light_blue_4); light_blue_5 = findViewById(R.id.light_blue_5); light_blue_6 = findViewById(R.id.light_blue_6); light_blue_7 = findViewById(R.id.light_blue_7); light_blue_8 = findViewById(R.id.light_blue_8);
        light_blue_9 = findViewById(R.id.light_blue_9); light_blue_10 = findViewById(R.id.light_blue_10); light_blue_11 = findViewById(R.id.light_blue_11); light_blue_12 = findViewById(R.id.light_blue_12); light_blue_13 = findViewById(R.id.light_blue_13); light_blue_14 = findViewById(R.id.light_blue_14); light_blue_15 = findViewById(R.id.light_blue_15); light_blue_16 = findViewById(R.id.light_blue_16); light_blue_17 = findViewById(R.id.light_blue_17); light_blue_18 = findViewById(R.id.light_blue_18); light_blue_19 = findViewById(R.id.light_blue_19);

        light_green_1 = findViewById(R.id.light_green_1); light_green_2 = findViewById(R.id.light_green_2); light_green_3 = findViewById(R.id.light_green_3); light_green_4 = findViewById(R.id.light_green_4); light_green_5 = findViewById(R.id.light_green_5); light_green_6 = findViewById(R.id.light_green_6); light_green_7 = findViewById(R.id.light_green_7); light_green_8 = findViewById(R.id.light_green_8);light_green_9 = findViewById(R.id.light_green_9); light_green_10 = findViewById(R.id.light_green_10); light_green_11 = findViewById(R.id.light_green_11); light_green_12 = findViewById(R.id.light_green_12); light_green_13 = findViewById(R.id.light_green_13); light_green_14 = findViewById(R.id.light_green_14); light_green_15 = findViewById(R.id.light_green_15); light_green_16 = findViewById(R.id.light_green_16); light_green_17 = findViewById(R.id.light_green_17); light_green_18 = findViewById(R.id.light_green_18); light_green_19 = findViewById(R.id.light_green_19);

        orange_1 = findViewById(R.id.orange_1); orange_2 = findViewById(R.id.orange_2); orange_3 = findViewById(R.id.orange_3); orange_4 = findViewById(R.id.orange_4); orange_5 = findViewById(R.id.orange_5); orange_6 = findViewById(R.id.orange_6); orange_7 = findViewById(R.id.orange_7); orange_8 = findViewById(R.id.orange_8);
        orange_9 = findViewById(R.id.orange_9); orange_10 = findViewById(R.id.orange_10); orange_11 = findViewById(R.id.orange_11);orange_12 = findViewById(R.id.orange_12);orange_13 = findViewById(R.id.orange_13);orange_14 = findViewById(R.id.orange_14);orange_15 = findViewById(R.id.orange_15);orange_16 = findViewById(R.id.orange_16); orange_17 = findViewById(R.id.orange_17); orange_18 = findViewById(R.id.orange_18); orange_19 = findViewById(R.id.orange_19);

        // 2019 Sri Lanka Calendar
        EventCollection.date_collection_arr=new ArrayList<>(); title_1 = findViewById(R.id.title_1); title_2 = findViewById(R.id.title_2); title_3 = findViewById(R.id.title_3); title_4 = findViewById(R.id.title_4);title_5 = findViewById(R.id.title_5); title_6 = findViewById(R.id.title_6); title_7 = findViewById(R.id.title_7); title_8 = findViewById(R.id.title_8);title_9 = findViewById(R.id.title_9); title_10 = findViewById(R.id.title_10); title_11 = findViewById(R.id.title_11); title_12 = findViewById(R.id.title_12); title_13 = findViewById(R.id.title_13); title_14 = findViewById(R.id.title_14); title_15 = findViewById(R.id.title_15); title_16 = findViewById(R.id.title_16); title_17 = findViewById(R.id.title_17); title_18 = findViewById(R.id.title_18); title_19 = findViewById(R.id.title_19);

        //2020 Sri Lanka Calendar
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-01" ,"01 - New Year's Day","Holiday","Jan."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-02" ,"02 - 2nd January","Holiday","Jan."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-06" ,"06 - Epiphany","Holiday","Jan."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-07" ,"07 - Orthodox Christmas Day","Holiday","Jan."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-14" ,"14 - Orthodox New Year","Holiday","Jan."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-01-25" ,"25 - Burns Night, Chinese New Year","Holiday","Jan."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-02-10" ,"10 - Tu B'Shevat (Arbor Day)","Holiday","Feb."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-14" ,"14 - Valentine's Day","Holiday","Feb."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-21" ,"21 - Maha Shivaratri","Holiday","Feb."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-25" ,"25 - Carnival / Shrove Tuesday","Holiday","Feb."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-02-26" ,"26 - Carnival / Ash Wednesday","Holiday","Feb."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-03-01" ,"01 - St. David's Day","Holiday","Mar."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-10" ,"10 - Holi, Purim","Holiday","Mar."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-17" ,"17 - St Patrick's Day","Holiday","Mar."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-20" ,"20 - March Equinox","Holiday","Mar."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-22" ,"22 - Isra and Mi'raj, Mothering Sunday","Holiday","Mar."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-03-29" ,"29 - Daylight Saving Time starts","Holiday","Mar."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-04-05" ,"05 - Palm Sunday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-09" ,"09 - Maundy Thursday, First day of Passover","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-10" ,"10 - Good Friday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-11" ,"11 - Holy Saturday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-12" ,"12 - Easter Sunday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-13" ,"13 - Easter Monday, Easter Monday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-16" ,"16 - Last day of Passover","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-17" ,"17 - Orthodox Good Friday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-18" ,"18 - Orthodox Holy Saturday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-19" ,"19 - Orthodox Easter","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-20" ,"20 - Orthodox Easter Monday","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-21" ,"21 - Yom HaShoah","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-22" ,"22 - Stephen Lawrence Day","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-23" ,"23 - St. George's Day, Shakespeare Day","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-24" ,"24 - Ramadan Start","Holiday","Apr."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-04-29" ,"29 - Yom HaAtzmaut","Holiday","Apr."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-05-08" ,"08 - Early May Bank Holiday","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-12" ,"12 - Lag B'Omer","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-19" ,"19 - Laylatul Qadr (Night of Power)","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-21" ,"21 - Ascension Day","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-24" ,"24 - Eid ul Fitr","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-25" ,"25 - Spring Bank Holiday","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-29" ,"29 - Shavuot","Holiday","May"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-05-31" ,"31 - Pentecost","Holiday","May"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-06-01" ,"01 - Whit Monday","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-07" ,"07 - Trinity Sunday","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-11" ,"11 - Corpus Christi","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-13" ,"13 - Queen's Birthday","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-20" ,"20 - June Solstice","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-21" ,"21 - Father's Day","Holiday","June"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-06-22" ,"22 - Windrush Day","Holiday","June"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-07-12" ,"12 - Battle of the Boyne","Holiday","July"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-13" ,"13 - Battle of the Boyne observed","Holiday","July"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-30" ,"30 - Tisha B'Av","Holiday","July"));
        EventCollection.date_collection_arr.add( new EventCollection("2020-07-31" ,"31 - Eid ul Adha","Holiday","July"));

        EventCollection.date_collection_arr.add( new EventCollection("2020-08-03" ,"03 - Raksha Bandhan, Summer Bank Holiday","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-11" ,"11 - Janmashtami","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-15" ,"15 - Assumption of Mary","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-20" ,"20 - Muharram/Islamic New Year","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-22" ,"22 - Ganesh Chaturthi","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-29" ,"29 - Ashura","Holiday","Aug."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-08-31" ,"31 - Summer Bank Holiday","Holiday","Aug."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-09-19" ,"19 - Rosh Hashana","Holiday","Sep."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-09-22" ,"22 - September Equinox","Holiday","Sep."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-09-28" ,"28 - Yom Kippur","Holiday","Sep."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-10-03" ,"03 - First day of Sukkot","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-04" ,"04 - Feast of St Francis of Assisi","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-09" ,"09 - Hoshana Rabbah","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-10" ,"10 - Shemini Atzeret","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-11" ,"11 - Simchat Torah","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-17" ,"17 - Navaratri","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-25" ,"25 - Dussehra, Daylight Saving Time ends","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-29" ,"29 - Milad un Nabi (Mawlid)","Holiday","Oct."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-10-31" ,"31 - Halloween","Holiday","Oct."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-11-01" ,"04 - All Saints' Day","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-02" ,"02 - All Souls' Day","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-05" ,"05 - Guy Fawkes Day","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-08" ,"08 - Remembrance Sunday","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-14" ,"14 - Diwali/Deepavali","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-29" ,"29 - First Sunday of Advent","Holiday","Nov."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-11-30" ,"30 - St Andrew's Day","Holiday","Nov."));

        EventCollection.date_collection_arr.add( new EventCollection("2020-12-08" ,"08 - Feast of the Immaculate Conception","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-11" ,"11 - First Day of Hanukkah","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-18" ,"18 - Last day of Hanukkah","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-21" ,"21 - December Solstice","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-24" ,"24 - Christmas Eve","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-25" ,"25 - Christmas Day","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-26" ,"26 - Boxing Day","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-28" ,"28 - Substitute Bank Holiday for Boxing Day","Holiday","Dec."));
        EventCollection.date_collection_arr.add( new EventCollection("2020-12-31" ,"31 - New Year's Eve","Holiday","Dec."));

        cal_month = GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new EnglandCalendar(this, cal_month,EventCollection.date_collection_arr);

        tv_month = findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

        if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
            main.setBackgroundResource(R.drawable.january);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
            main.setBackgroundResource(R.drawable.february);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
            main.setBackgroundResource(R.drawable.march);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
            main.setBackgroundResource(R.drawable.april);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
            main.setBackgroundResource(R.drawable.may);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
            main.setBackgroundResource(R.drawable.june);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
            main.setBackgroundResource(R.drawable.july);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
            main.setBackgroundResource(R.drawable.august);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
            main.setBackgroundResource(R.drawable.september);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
            main.setBackgroundResource(R.drawable.october);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
            main.setBackgroundResource(R.drawable.november);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
            main.setBackgroundResource(R.drawable.december);
            holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
        }
        else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.january);
            month_1.setText("Jan.");title_1.setText("01 - New Year's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Jan.");title_2.setText("02 - 2nd January");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Jan.");title_3.setText("06 - Epiphany");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Jan.");title_4.setText("07 - Orthodox Christmas Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Jan.");title_5.setText("14 - Orthodox New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Jan.");title_6.setText("25 - Burns Night");red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Jan.");title_7.setText("25 - Chinese New Year");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.february);
            month_1.setText("Feb.");title_1.setText("10 - Tu B'Shevat (Arbor Day)");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Feb.");title_2.setText("14 - Valentine's Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Feb.");title_3.setText("21 - Maha Shivaratri");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Feb.");title_4.setText("25 - Carnival / Shrove Tuesday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Feb.");title_5.setText("26 - Carnival / Ash Wednesday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.march);
            month_1.setText("Mar.");title_1.setText("01 - St. David's Day");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.VISIBLE);

            month_2.setText("Mar.");title_2.setText("10 - Holi");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Mar.");title_3.setText("10 - Purim");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Mar.");title_4.setText("17 - St Patrick's Day");red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);orange_4.setVisibility(View.GONE);

            month_5.setText("Mar.");title_5.setText("20 - March Equinox");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Mar.");title_6.setText("22 - Isra and Mi'raj");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Mar.");title_7.setText("22 - Mothering Sunday");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setText("Mar.");title_8.setText("29 - Daylight Saving Time starts");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.april);
            month_1.setText("Apr.");title_1.setText("05 - Palm Sunday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Apr.");title_2.setText("09 - Maundy Thursday");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Apr.");title_3.setText("09 - First day of Passover");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Apr.");title_4.setText("10 - Good Friday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Apr.");title_5.setText("11 - Holy Saturday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Apr.");title_6.setText("12 - Easter Sunday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Apr.");title_7.setText("13 - Easter Monday");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.VISIBLE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);orange_7.setVisibility(View.VISIBLE);

            month_8.setText("Apr.");title_8.setText("13 - Easter Monday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.VISIBLE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setText("Apr.");title_9.setText("16 - Last day of Passover");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setText("Apr.");title_10.setText("17 - Orthodox Good Friday");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setText("Apr.");title_11.setText("18 - Orthodox Holy Saturday");red_11.setVisibility(View.VISIBLE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setText("Apr.");title_12.setText("19 - Orthodox Easter");red_12.setVisibility(View.VISIBLE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setText("Apr.");title_13.setText("20 - Orthodox Easter Monday");red_13.setVisibility(View.VISIBLE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setText("Apr.");title_14.setText("21 - Yom HaShoah");red_14.setVisibility(View.VISIBLE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setText("Apr.");title_15.setText("22 - Stephen Lawrence Day");red_15.setVisibility(View.VISIBLE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setText("Apr.");title_16.setText("23 - St. George's Day");red_16.setVisibility(View.VISIBLE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setText("Apr.");title_17.setText("23 - Shakespeare Day");red_17.setVisibility(View.VISIBLE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setText("Apr.");title_18.setText("24 - Ramadan Start");red_18.setVisibility(View.VISIBLE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setText("Apr.");title_19.setText("29 - Yom HaAtzmaut");red_19.setVisibility(View.VISIBLE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.may);
            month_1.setText("May");title_1.setText("08 - Early May Bank Holiday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("May");title_2.setText("12 - Lag B'Omer");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("May");title_3.setText("19 - Laylatul Qadr (Night of Power)");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("May");title_4.setText("21 - Ascension Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("May");title_5.setText("24 - Eid ul Fitr");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("May");title_6.setText("25 - Spring Bank Holiday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("May");title_7.setText("29 - Shavuot");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setText("May");title_8.setText("31 - Pentecost");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.june);
            month_1.setText("Jun.");title_1.setText("01 - Whit Monday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Jun.");title_2.setText("07 - Trinity Sunday ");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Jun.");title_3.setText("11 - Corpus Christi");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Jun.");title_4.setText("13 - Queen's Birthday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Jun.");title_5.setText("20 - June Solstice");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Jun.");title_6.setText("21 - Father's Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Jun.");title_7.setText("22 - Windrush Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.july);
            month_1.setText("Jul.");title_1.setText("12 - Battle of the Boyne");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

            month_2.setText("Jul.");title_2.setText("13 - Battle of the Boyne observed");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

            month_3.setText("Jul.");title_3.setText("30 - Tisha B'Av");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Jul.");title_4.setText("31 - Eid ul Adha");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.august);
            month_1.setText("Aug.");title_1.setText("03 - Raksha Bandhan");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Aug.");title_2.setText("03 - Summer Bank Holiday");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Aug.");title_3.setText("11 - Janmashtami");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Aug.");title_4.setText("15 - Assumption of Mary");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Aug.");title_5.setText("20 - Muharram/Lslamic New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Aug.");title_6.setText("22 - Ganesh Chaturthi");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Aug.");title_7.setText("29 - Ashura");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setText("Aug.");title_8.setText("31 - Summer Bank Holiday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.september);
            month_1.setText("Sep.");title_1.setText("19 - Rosh Hashana");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

            month_2.setText("Sep.");title_2.setText("22 - September Equinox");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

            month_3.setText("Sep.");title_3.setText("28 - Yom Kippur");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.october);
            month_1.setText("Oct.");title_1.setText("03 - First day of Sukkot");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Oct.");title_2.setText("04 - Feast of St Francis of Assisi");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Oct.");title_3.setText("09 - Hoshana Rabbah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Oct.");title_4.setText("10 - Shemini Atzeret");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Oct.");title_5.setText("11 - Simchat Torah");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Oct.");title_6.setText("17 - Navaratri");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Oct.");title_7.setText("25 - Dussehra");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setText("Oct.");title_8.setText("25 - Daylight Saving Time ends");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

            month_9.setText("Oct.");title_9.setText("29 - Milad un Nabi (Mawlid)");red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setText("Oct.");title_10.setText("31 - Halloween");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.november);
            month_1.setText("Nov.");title_1.setText("01 - All Saints's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Nov.");title_2.setText("02 - All Souls' Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Nov.");title_3.setText("05 - Guy Fawkes Day");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Nov.");title_4.setText("08 - Remembrance Sunday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Nov.");title_5.setText("14 - Diwali/Deepavali");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Nov.");title_6.setText("29 - First Sunday of Advent");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Nov.");title_7.setText("30 - St Andrew's Day");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
            holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
            main.setBackgroundResource(R.drawable.december);
            month_1.setText("Dec.");title_1.setText("08 - Feast of the Immaculate Conception");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

            month_2.setText("Dec.");title_2.setText("11 - First Day of Hanukkah");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

            month_3.setText("Dec.");title_3.setText("18 - Last day of Hanukkah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

            month_4.setText("Dec.");title_4.setText("21 - December Solstice");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

            month_5.setText("Dec.");title_5.setText("24 - Christmas Eve");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

            month_6.setText("Dec.");title_6.setText("25 - Christmas Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

            month_7.setText("Dec.");title_7.setText("26 - Boxing Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

            month_8.setText("Dec.");title_8.setText("28 - Substitute Bank Holiday for Boxing Day");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

            month_9.setText("Dec.");title_9.setText("31 - New Year's Eve");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

            month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

            month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

            month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

            month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

            month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

            month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

            month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

            month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

            month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

            month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

        }
        ImageButton previous = findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.err.println("Month : " + GregorianCalendar.MONTH);
                System.err.println("Month : " + Calendar.MONTH);
                setPreviousMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("Jan.");title_1.setText("01 - New Year's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jan.");title_2.setText("02 - 2nd January");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jan.");title_3.setText("06 - Epiphany");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jan.");title_4.setText("07 - Orthodox Christmas Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Jan.");title_5.setText("14 - Orthodox New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Jan.");title_6.setVisibility(View.VISIBLE);title_6.setText("25 - Burns Night");red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Jan.");title_7.setVisibility(View.VISIBLE);title_7.setText("25 - Chinese New Year");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("Feb.");title_1.setText("10 - Tu B'Shevat (Arbor Day)");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Feb.");title_2.setText("14 - Valentine's Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Feb.");title_3.setText("21 - Maha Shivaratri");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Feb.");title_4.setText("25 - Carnival / Shrove Tuesday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Feb.");title_5.setText("26 - Carnival / Ash Wednesday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("Mar.");title_1.setText("01 - St. David's Day");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.VISIBLE);

                        month_2.setText("Mar.");title_2.setText("10 - Holi");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Mar.");title_3.setText("10 - Purim");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Mar.");title_4.setText("17 - St Patrick's Day");red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Mar.");title_5.setText("20 - March Equinox");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Mar.");title_6.setText("22 - Isra and Mi'raj");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Mar.");title_7.setText("22 - Mothering Sunday");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setText("Mar.");title_8.setText("29 - Daylight Saving Time starts");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("Apr.");title_1.setText("05 - Palm Sunday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Apr.");title_2.setText("09 - Maundy Thursday");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Apr.");title_3.setText("09 - First day of Passover");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Apr.");title_4.setText("10 - Good Friday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Apr.");title_5.setText("11 - Holy Saturday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Apr.");title_6.setText("12 - Easter Sunday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Apr.");title_7.setText("13 - Easter Monday");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.VISIBLE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);orange_7.setVisibility(View.VISIBLE);

                        month_8.setText("Apr.");title_8.setText("13 - Easter Monday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.VISIBLE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.VISIBLE);month_9.setText("Apr.");title_9.setVisibility(View.VISIBLE);title_9.setText("16 - Last day of Passover");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.VISIBLE);month_10.setText("Apr.");title_10.setVisibility(View.VISIBLE);title_10.setText("17 - Orthodox Good Friday");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.VISIBLE);month_11.setText("Apr.");title_11.setVisibility(View.VISIBLE);title_11.setText("18 - Orthodox Holy Saturday");red_11.setVisibility(View.VISIBLE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.VISIBLE);month_12.setText("Apr.");title_12.setVisibility(View.VISIBLE);title_12.setText("19 - Orthodox Easter");red_12.setVisibility(View.VISIBLE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.VISIBLE);month_13.setText("Apr.");title_13.setVisibility(View.VISIBLE);title_13.setText("20 - Orthodox Easter Monday");red_13.setVisibility(View.VISIBLE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.VISIBLE);month_14.setText("Apr.");title_14.setVisibility(View.VISIBLE);title_14.setText("21 - Yom HaShoah");red_14.setVisibility(View.VISIBLE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.VISIBLE);month_15.setText("Apr.");title_15.setVisibility(View.VISIBLE);title_15.setText("22 - Stephen Lawrence Day");red_15.setVisibility(View.VISIBLE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.VISIBLE);month_16.setText("Apr.");title_16.setVisibility(View.VISIBLE);title_16.setText("23 - St. George's Day");red_16.setVisibility(View.VISIBLE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.VISIBLE);month_17.setText("Apr.");title_17.setVisibility(View.VISIBLE);title_17.setText("23 - Shakespeare Day");red_17.setVisibility(View.VISIBLE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.VISIBLE);month_18.setText("Apr.");title_18.setVisibility(View.VISIBLE);title_18.setText("24 - Ramadan Start");red_18.setVisibility(View.VISIBLE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.VISIBLE);month_19.setText("Apr.");title_19.setVisibility(View.VISIBLE);title_19.setText("29 - Yom HaAtzmaut");red_19.setVisibility(View.VISIBLE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("May");title_1.setText("08 - Early May Bank Holiday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("May");title_2.setText("12 - Lag B'Omer");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("May");title_3.setText("19 - Laylatul Qadr (Night of Power)");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("May");title_4.setText("21 - Ascension Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("May");title_5.setText("24 - Eid ul Fitr");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("May");title_6.setText("25 - Spring Bank Holiday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("May");title_7.setText("29 - Shavuot");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("May");title_8.setVisibility(View.VISIBLE);title_8.setText("31 - Pentecost");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("Jun.");title_1.setText("01 - Whit Monday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jun.");title_2.setText("07 - Trinity Sunday ");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jun.");title_3.setText("11 - Corpus Christi");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jun.");title_4.setText("13 - Queen's Birthday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.VISIBLE);month_5.setText("Jun.");title_5.setVisibility(View.VISIBLE);title_5.setText("20 - June Solstice");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Jun.");title_6.setVisibility(View.VISIBLE);title_6.setText("21 - Father's Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Jun.");title_7.setVisibility(View.VISIBLE);title_7.setText("22 - Windrush Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("Jul.");title_1.setText("12 - Battle of the Boyne");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jul.");title_2.setText("13 - Battle of the Boyne observed");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jul.");title_3.setText("30 - Tisha B'Av");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jul.");title_4.setText("31 - Eid ul Adha");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("Aug.");title_1.setText("03 - Raksha Bandhan");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Aug.");title_2.setText("03 - Summer Bank Holiday");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Aug.");title_3.setText("11 - Janmashtami");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setVisibility(View.VISIBLE);month_4.setText("Aug.");title_4.setVisibility(View.VISIBLE);title_4.setText("15 - Assumption of Mary");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.VISIBLE);month_5.setText("Aug.");title_5.setVisibility(View.VISIBLE);title_5.setText("20 - Muharram/Lslamic New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Aug.");title_6.setVisibility(View.VISIBLE);title_6.setText("22 - Ganesh Chaturthi");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Aug.");title_7.setVisibility(View.VISIBLE);title_7.setText("29 - Ashura");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Aug.");title_8.setVisibility(View.VISIBLE);title_8.setText("31 - Summer Bank Holiday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("Sep.");title_1.setText("19 - Rosh Hashana");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Sep.");title_2.setText("22 - September Equinox");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Sep.");title_3.setText("28 - Yom Kippur");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("Oct.");title_1.setText("03 - First day of Sukkot");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Oct.");title_2.setText("04 - Feast of St Francis of Assisi");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Oct.");title_3.setText("09 - Hoshana Rabbah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Oct.");title_4.setText("10 - Shemini Atzeret");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Oct.");title_5.setText("11 - Simchat Torah");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Oct.");title_6.setText("17 - Navaratri");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Oct.");title_7.setText("25 - Dussehra");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Oct.");title_8.setVisibility(View.VISIBLE);title_8.setText("25 - Daylight Saving Time ends");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

                        month_9.setVisibility(View.VISIBLE);month_9.setText("Oct.");title_9.setVisibility(View.VISIBLE);title_9.setText("29 - Milad un Nabi (Mawlid)");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.VISIBLE);month_10.setText("Oct.");title_10.setVisibility(View.VISIBLE);title_10.setText("31 - Halloween");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("Nov.");title_1.setText("01 - All Saints's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Nov.");title_2.setText("02 - All Souls' Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Nov.");title_3.setText("05 - Guy Fawkes Day");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Nov.");title_4.setText("08 - Remembrance Sunday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Nov.");title_5.setText("14 - Diwali/Deepavali");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Nov.");title_6.setText("29 - First Sunday of Advent");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Nov.");title_7.setText("30 - St Andrew's Day");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("Dec.");title_1.setText("08 - Feast of the Immaculate Conception");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Dec.");title_2.setText("11 - First Day of Hanukkah");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Dec.");title_3.setText("18 - Last day of Hanukkah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Dec.");title_4.setText("21 - December Solstice");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Dec.");title_5.setText("24 - Christmas Eve");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Dec.");title_6.setText("25 - Christmas Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Dec.");title_7.setText("26 - Boxing Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setText("Dec.");title_8.setText("28 - Substitute Bank Holiday for Boxing Day");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setText("Dec.");title_9.setText("31 - New Year's Eve");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else {
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.november);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);

                    }
                }
            }
        });
        ImageButton next = findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (cal_month.get(GregorianCalendar.MONTH) == Calendar.DECEMBER && cal_month.get(GregorianCalendar.YEAR)==2019) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(MainActivity.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }*/
                setNextMonth();
                refreshCalendar();

                if (isBlue){
                    main.setBackgroundResource(R.drawable.blue_theme);
                }else if (isRed){
                    main.setBackgroundResource(R.drawable.red_theme);
                }else if (isGreen){
                    main.setBackgroundResource(R.drawable.green_theme);
                }else if (isPurple){
                    main.setBackgroundResource(R.drawable.purple_theme);
                }else if (isPink){
                    main.setBackgroundResource(R.drawable.rose_theme);
                }else if (isNormal){
                    if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.january);
                        month_1.setText("Jan.");title_1.setText("01 - New Year's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jan.");title_2.setText("02 - 2nd January");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jan.");title_3.setText("06 - Epiphany");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jan.");title_4.setText("07 - Orthodox Christmas Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Jan.");title_5.setText("14 - Orthodox New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Jan.");title_6.setText("25 - Burns Night");red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.VISIBLE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Jan.");title_7.setText("25 - Chinese New Year");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.february);
                        month_1.setText("Feb.");title_1.setText("10 - Tu B'Shevat (Arbor Day)");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Feb.");title_2.setText("14 - Valentine's Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Feb.");title_3.setText("21 - Maha Shivaratri");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Feb.");title_4.setText("25 - Carnival / Shrove Tuesday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Feb.");title_5.setText("26 - Carnival / Ash Wednesday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.march);
                        month_1.setText("Mar.");title_1.setText("01 - St. David's Day");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.VISIBLE);

                        month_2.setText("Mar.");title_2.setText("10 - Holi");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Mar.");title_3.setText("10 - Purim");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Mar.");title_4.setText("17 - St Patrick's Day");red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.VISIBLE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Mar.");title_5.setText("20 - March Equinox");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Mar.");title_6.setVisibility(View.VISIBLE);title_6.setText("22 - Isra and Mi'raj");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Mar.");title_7.setVisibility(View.VISIBLE);title_7.setText("22 - Mothering Sunday");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Mar.");title_8.setVisibility(View.VISIBLE);title_8.setText("29 - Daylight Saving Time starts");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.april);
                        month_1.setText("Apr.");title_1.setText("05 - Palm Sunday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Apr.");title_2.setText("09 - Maundy Thursday");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Apr.");title_3.setText("09 - First day of Passover");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Apr.");title_4.setText("10 - Good Friday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Apr.");title_5.setText("11 - Holy Saturday");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Apr.");title_6.setText("12 - Easter Sunday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Apr.");title_7.setText("13 - Easter Monday");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.VISIBLE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.VISIBLE);orange_7.setVisibility(View.VISIBLE);

                        month_8.setText("Apr.");title_8.setText("13 - Easter Monday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.VISIBLE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.VISIBLE);month_9.setText("Apr.");title_9.setVisibility(View.VISIBLE);title_9.setText("16 - Last day of Passover");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.VISIBLE);month_10.setText("Apr.");title_10.setVisibility(View.VISIBLE);title_10.setText("17 - Orthodox Good Friday");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.VISIBLE);month_11.setText("Apr.");title_11.setVisibility(View.VISIBLE);title_11.setText("18 - Orthodox Holy Saturday");red_11.setVisibility(View.VISIBLE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.VISIBLE);month_12.setText("Apr.");title_12.setVisibility(View.VISIBLE);title_12.setText("19 - Orthodox Easter");red_12.setVisibility(View.VISIBLE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.VISIBLE);month_13.setText("Apr.");title_13.setVisibility(View.VISIBLE);title_13.setText("20 - Orthodox Easter Monday");red_13.setVisibility(View.VISIBLE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.VISIBLE);month_14.setText("Apr.");title_14.setVisibility(View.VISIBLE);title_14.setText("21 - Yom HaShoah");red_14.setVisibility(View.VISIBLE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.VISIBLE);month_15.setText("Apr.");title_15.setVisibility(View.VISIBLE);title_15.setText("22 - Stephen Lawrence Day");red_15.setVisibility(View.VISIBLE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.VISIBLE);month_16.setText("Apr.");title_16.setVisibility(View.VISIBLE);title_16.setText("23 - St. George's Day");red_16.setVisibility(View.VISIBLE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.VISIBLE);month_17.setText("Apr.");title_17.setVisibility(View.VISIBLE);title_17.setText("23 - Shakespeare Day");red_17.setVisibility(View.VISIBLE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.VISIBLE);month_18.setText("Apr.");title_18.setVisibility(View.VISIBLE);title_18.setText("24 - Ramadan Start");red_18.setVisibility(View.VISIBLE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.VISIBLE);month_19.setText("Apr.");title_19.setVisibility(View.VISIBLE);title_19.setText("29 - Yom HaAtzmaut");red_19.setVisibility(View.VISIBLE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.may);
                        month_1.setText("May");title_1.setText("08 - Early May Bank Holiday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("May");title_2.setText("12 - Lag B'Omer");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("May");title_3.setText("19 - Laylatul Qadr (Night of Power)");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("May");title_4.setText("21 - Ascension Day");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("May");title_5.setText("24 - Eid ul Fitr");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("May");title_6.setText("25 - Spring Bank Holiday");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("May");title_7.setText("29 - Shavuot");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setText("May");title_8.setText("31 - Pentecost");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.june);
                        month_1.setText("Jun.");title_1.setText("01 - Whit Monday");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jun.");title_2.setText("07 - Trinity Sunday ");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jun.");title_3.setText("11 - Corpus Christi");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jun.");title_4.setText("13 - Queen's Birthday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Jun.");title_5.setText("20 - June Solstice");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Jun.");title_6.setText("21 - Father's Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Jun.");title_7.setText("22 - Windrush Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.july);
                        month_1.setText("Jul.");title_1.setText("12 - Battle of the Boyne");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Jul.");title_2.setText("13 - Battle of the Boyne observed");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Jul.");title_3.setText("30 - Tisha B'Av");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Jul.");title_4.setText("31 - Eid ul Adha");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.august);
                        month_1.setText("Aug.");title_1.setText("03 - Raksha Bandhan");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Aug.");title_2.setText("03 - Summer Bank Holiday");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Aug.");title_3.setText("11 - Janmashtami");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Aug.");title_4.setText("15 - Assumption of Mary");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.VISIBLE);month_5.setText("Aug.");title_5.setVisibility(View.VISIBLE);title_5.setText("20 - Muharram/Lslamic New Year");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Aug.");title_6.setVisibility(View.VISIBLE);title_6.setText("22 - Ganesh Chaturthi");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Aug.");title_7.setVisibility(View.VISIBLE);title_7.setText("29 - Ashura");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Aug.");title_8.setVisibility(View.VISIBLE);title_8.setText("31 - Summer Bank Holiday");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.september);
                        month_1.setText("Sep.");title_1.setText("19 - Rosh Hashana");red_1.setVisibility(View.GONE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.VISIBLE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Sep.");title_2.setText("22 - September Equinox");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.VISIBLE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Sep.");title_3.setText("28 - Yom Kippur");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setVisibility(View.GONE);title_4.setVisibility(View.GONE);red_4.setVisibility(View.GONE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.GONE);title_5.setVisibility(View.GONE);red_5.setVisibility(View.GONE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.GONE);title_6.setVisibility(View.GONE);red_6.setVisibility(View.GONE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.GONE);title_7.setVisibility(View.GONE);red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.october);
                        month_1.setText("Oct.");title_1.setText("03 - First day of Sukkot");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Oct.");title_2.setText("04 - Feast of St Francis of Assisi");red_2.setVisibility(View.GONE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.VISIBLE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Oct.");title_3.setText("09 - Hoshana Rabbah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setVisibility(View.VISIBLE);month_4.setText("Oct.");title_4.setVisibility(View.VISIBLE);title_4.setText("10 - Shemini Atzeret");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setVisibility(View.VISIBLE);month_5.setText("Oct.");title_5.setVisibility(View.VISIBLE);title_5.setText("11 - Simchat Torah");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setVisibility(View.VISIBLE);month_6.setText("Oct.");title_6.setVisibility(View.VISIBLE);title_6.setText("17 - Navaratri");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setVisibility(View.VISIBLE);month_7.setText("Oct.");title_7.setVisibility(View.VISIBLE);title_7.setText("25 - Dussehra");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Oct.");title_8.setVisibility(View.VISIBLE);title_8.setText("25 - Daylight Saving Time ends");red_8.setVisibility(View.GONE);blue_8.setVisibility(View.VISIBLE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.VISIBLE);orange_8.setVisibility(View.VISIBLE);

                        month_9.setVisibility(View.VISIBLE);month_9.setText("Oct.");title_9.setVisibility(View.VISIBLE);title_9.setText("29 - Milad un Nabi (Mawlid)");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.VISIBLE);month_10.setText("Oct.");title_10.setVisibility(View.VISIBLE);title_10.setText("31 - Halloween");red_10.setVisibility(View.VISIBLE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.november);
                        month_1.setText("Nov.");title_1.setText("01 - All Saints's Day");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Nov.");title_2.setText("02 - All Souls' Day");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Nov.");title_3.setText("05 - Guy Fawkes Day");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Nov.");title_4.setText("08 - Remembrance Sunday");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Nov.");title_5.setText("14 - Diwali/Deepavali");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Nov.");title_6.setText("29 - First Sunday of Advent");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Nov.");title_7.setText("30 - St Andrew's Day");red_7.setVisibility(View.GONE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.VISIBLE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.GONE);title_8.setVisibility(View.GONE);red_8.setVisibility(View.GONE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.GONE);title_9.setVisibility(View.GONE);red_9.setVisibility(View.GONE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2020")){
                        holiday.setVisibility(View.VISIBLE); holiday_details.setVisibility(View.VISIBLE);holiday_2.setVisibility(View.VISIBLE);
                        main.setBackgroundResource(R.drawable.december);
                        month_1.setText("Dec.");title_1.setText("08 - Feast of the Immaculate Conception");red_1.setVisibility(View.VISIBLE);blue_1.setVisibility(View.GONE);light_blue_1.setVisibility(View.GONE);light_green_1.setVisibility(View.GONE);orange_1.setVisibility(View.GONE);

                        month_2.setText("Dec.");title_2.setText("11 - First Day of Hanukkah");red_2.setVisibility(View.VISIBLE);blue_2.setVisibility(View.GONE);light_blue_2.setVisibility(View.GONE);light_green_2.setVisibility(View.GONE);orange_2.setVisibility(View.GONE);

                        month_3.setText("Dec.");title_3.setText("18 - Last day of Hanukkah");red_3.setVisibility(View.VISIBLE);blue_3.setVisibility(View.GONE);light_blue_3.setVisibility(View.GONE);light_green_3.setVisibility(View.GONE);orange_3.setVisibility(View.GONE);

                        month_4.setText("Dec.");title_4.setText("21 - December Solstice");red_4.setVisibility(View.VISIBLE);blue_4.setVisibility(View.GONE);light_blue_4.setVisibility(View.GONE);light_green_4.setVisibility(View.GONE);orange_4.setVisibility(View.GONE);

                        month_5.setText("Dec.");title_5.setText("24 - Christmas Eve");red_5.setVisibility(View.VISIBLE);blue_5.setVisibility(View.GONE);light_blue_5.setVisibility(View.GONE);light_green_5.setVisibility(View.GONE);orange_5.setVisibility(View.GONE);

                        month_6.setText("Dec.");title_6.setText("25 - Christmas Day");red_6.setVisibility(View.VISIBLE);blue_6.setVisibility(View.GONE);light_blue_6.setVisibility(View.GONE);light_green_6.setVisibility(View.GONE);orange_6.setVisibility(View.GONE);

                        month_7.setText("Dec.");title_7.setText("26 - Boxing Day");red_7.setVisibility(View.VISIBLE);blue_7.setVisibility(View.GONE);light_blue_7.setVisibility(View.GONE);light_green_7.setVisibility(View.GONE);orange_7.setVisibility(View.GONE);

                        month_8.setVisibility(View.VISIBLE);month_8.setText("Dec.");title_8.setVisibility(View.VISIBLE);title_8.setText("28 - Substitute Bank Holiday for Boxing Day");red_8.setVisibility(View.VISIBLE);blue_8.setVisibility(View.GONE);light_blue_8.setVisibility(View.GONE);light_green_8.setVisibility(View.GONE);orange_8.setVisibility(View.GONE);

                        month_9.setVisibility(View.VISIBLE);month_9.setText("Dec.");title_9.setVisibility(View.VISIBLE);title_9.setText("31 - New Year's Eve");red_9.setVisibility(View.VISIBLE);blue_9.setVisibility(View.GONE);light_blue_9.setVisibility(View.GONE);light_green_9.setVisibility(View.GONE);orange_9.setVisibility(View.GONE);

                        month_10.setVisibility(View.GONE);title_10.setVisibility(View.GONE);red_10.setVisibility(View.GONE);blue_10.setVisibility(View.GONE);light_blue_10.setVisibility(View.GONE);light_green_10.setVisibility(View.GONE);orange_10.setVisibility(View.GONE);

                        month_11.setVisibility(View.GONE);title_11.setVisibility(View.GONE);red_11.setVisibility(View.GONE);blue_11.setVisibility(View.GONE);light_blue_11.setVisibility(View.GONE);light_green_11.setVisibility(View.GONE);orange_11.setVisibility(View.GONE);

                        month_12.setVisibility(View.GONE);title_12.setVisibility(View.GONE);red_12.setVisibility(View.GONE);blue_12.setVisibility(View.GONE);light_blue_12.setVisibility(View.GONE);light_green_12.setVisibility(View.GONE);orange_12.setVisibility(View.GONE);

                        month_13.setVisibility(View.GONE);title_13.setVisibility(View.GONE);red_13.setVisibility(View.GONE);blue_13.setVisibility(View.GONE);light_blue_13.setVisibility(View.GONE);light_green_13.setVisibility(View.GONE);orange_13.setVisibility(View.GONE);

                        month_14.setVisibility(View.GONE);title_14.setVisibility(View.GONE);red_14.setVisibility(View.GONE);blue_14.setVisibility(View.GONE);light_blue_14.setVisibility(View.GONE);light_green_14.setVisibility(View.GONE);orange_14.setVisibility(View.GONE);

                        month_15.setVisibility(View.GONE);title_15.setVisibility(View.GONE);red_15.setVisibility(View.GONE);blue_15.setVisibility(View.GONE);light_blue_15.setVisibility(View.GONE);light_green_15.setVisibility(View.GONE);orange_15.setVisibility(View.GONE);

                        month_16.setVisibility(View.GONE);title_16.setVisibility(View.GONE);red_16.setVisibility(View.GONE);blue_16.setVisibility(View.GONE);light_blue_16.setVisibility(View.GONE);light_green_16.setVisibility(View.GONE);orange_16.setVisibility(View.GONE);

                        month_17.setVisibility(View.GONE);title_17.setVisibility(View.GONE);red_17.setVisibility(View.GONE);blue_17.setVisibility(View.GONE);light_blue_17.setVisibility(View.GONE);light_green_17.setVisibility(View.GONE);orange_17.setVisibility(View.GONE);

                        month_18.setVisibility(View.GONE);title_18.setVisibility(View.GONE);red_18.setVisibility(View.GONE);blue_18.setVisibility(View.GONE);light_blue_18.setVisibility(View.GONE);light_green_18.setVisibility(View.GONE);orange_18.setVisibility(View.GONE);

                        month_19.setVisibility(View.GONE);title_19.setVisibility(View.GONE);red_19.setVisibility(View.GONE);blue_19.setVisibility(View.GONE);light_blue_19.setVisibility(View.GONE);light_green_19.setVisibility(View.GONE);orange_19.setVisibility(View.GONE);

                    }else {
                        holiday.setVisibility(View.GONE); holiday_details.setVisibility(View.GONE);holiday_2.setVisibility(View.GONE);
                        if (android.text.format.DateFormat.format("MMMM", cal_month).equals("January")){
                            main.setBackgroundResource(R.drawable.january);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("February")){
                            main.setBackgroundResource(R.drawable.february);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("March")){
                            main.setBackgroundResource(R.drawable.march);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("April")){
                            main.setBackgroundResource(R.drawable.april);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("May")){
                            main.setBackgroundResource(R.drawable.may);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("June")){
                            main.setBackgroundResource(R.drawable.june);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("July")){
                            main.setBackgroundResource(R.drawable.july);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("August")){
                            main.setBackgroundResource(R.drawable.august);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("September")){
                            main.setBackgroundResource(R.drawable.september);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("October")){
                            main.setBackgroundResource(R.drawable.october);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("November")){
                            main.setBackgroundResource(R.drawable.november);
                        }else if (android.text.format.DateFormat.format("MMMM", cal_month).equals("December")){
                            main.setBackgroundResource(R.drawable.december);
                        }
                    }
                }
            }
        });
        GridView gridview = findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = EnglandCalendar.day_string.get(position);
                ((EnglandCalendar) parent.getAdapter()).getPositionList(selectedGridDate, MainActivity.this);
            }

        });

    }

    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(Calendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    @SuppressLint("SetTextI18n")
    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void popupWindow(){
        final Dialog dialogs = new Dialog(MainActivity.this);
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
        if (id == R.id.power) {
            logout();
            return true;
        }
        if (id == R.id.theme){
            //open_popup_window();
            popupWindow();
        }
        if (id == R.id.reminder){
            Intent intent = new Intent(MainActivity.this, RemindTaskActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_holiday){
            Intent intent = new Intent(MainActivity.this, AllHolidayActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.all_event){
            Intent intent = new Intent(MainActivity.this, AllEventActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        System.exit(0);
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

                if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("January 2019")){
                    main.setBackgroundResource(R.drawable.january);
                    //theme_layout.setBackgroundResource(R.drawable.january);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("February 2019")){
                    main.setBackgroundResource(R.drawable.february);
                    //theme_layout.setBackgroundResource(R.drawable.february);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("March 2019")){
                    main.setBackgroundResource(R.drawable.march);
                    //theme_layout.setBackgroundResource(R.drawable.march);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("April 2019")){
                    main.setBackgroundResource(R.drawable.april);
                    //theme_layout.setBackgroundResource(R.drawable.april);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("May 2019")){
                    main.setBackgroundResource(R.drawable.may);
                    //theme_layout.setBackgroundResource(R.drawable.may);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("June 2019")){
                    main.setBackgroundResource(R.drawable.june);
                    //theme_layout.setBackgroundResource(R.drawable.june);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("July 2019")){
                    main.setBackgroundResource(R.drawable.july);
                    //theme_layout.setBackgroundResource(R.drawable.july);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("August 2019")){
                    main.setBackgroundResource(R.drawable.august);
                    //theme_layout.setBackgroundResource(R.drawable.august);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("September 2019")){
                    main.setBackgroundResource(R.drawable.september);
                    //theme_layout.setBackgroundResource(R.drawable.september);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("October 2019")){
                    main.setBackgroundResource(R.drawable.october);
                    //theme_layout.setBackgroundResource(R.drawable.october);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("November 2019")){
                    main.setBackgroundResource(R.drawable.november);
                    //theme_layout.setBackgroundResource(R.drawable.november);
                }else if (android.text.format.DateFormat.format("MMMM yyyy", cal_month).equals("December 2019")){
                    main.setBackgroundResource(R.drawable.december);
                    //theme_layout.setBackgroundResource(R.drawable.december);
                }
            }
        }
    }
}