package com.example.kalpesh.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public static final String Log_Tag = EarthquakeAdapter.class.getSimpleName() ;

    public EarthquakeAdapter(Activity context,ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes) ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView ;
         if(listItemView == null) {
             listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false) ;
         }
        Earthquake earthquake = getItem(position) ;
        TextView tvPlace = listItemView.findViewById(R.id.tv_place) ;
        String place = earthquake.getPlace() ;
        TextView tvPlaceLocation = listItemView.findViewById(R.id.tv_place_location) ;
        tvPlaceLocation.setVisibility(View.GONE);
        String[] str = place.split(Pattern.quote("of"));
        if(place.contains("of")) {
            Log.i("this is split 1", str[0]);
            Log.i("this is split2 ->", str[1]);
            tvPlaceLocation.setText(str[1]);
            tvPlaceLocation.setVisibility(View.VISIBLE);
        }
        //tvPlace.setText(earthquake.getPlace());
        tvPlace.setText(str[0]);
        TextView tvDate = listItemView.findViewById(R.id.tv_date);
        TextView tvMag = listItemView.findViewById(R.id.tv_mag);
        tvDate.setText(formateDate(earthquake.getDate()) + " " + formateTime(earthquake.getDate()));
        tvMag.setText(Double.toString(earthquake.getMagnitude()));

        return listItemView;
    }

    public String formateDate(long milliseconds){
        Date date = new Date(milliseconds);
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat("MMM DD, yyyy") ;
        return simpleDateFormate.format(date) ;
    }

    public String formateTime(long milliseconds){
        Date date = new Date(milliseconds) ;
        SimpleDateFormat simpletimeFormat = new SimpleDateFormat("h:mm a") ;
        return simpletimeFormat.format(date) ;
    }
}
