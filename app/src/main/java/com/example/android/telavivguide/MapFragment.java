package com.example.android.telavivguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import static com.example.android.telavivguide.MainActivity.viewPager;


public class MapFragment extends Fragment {
    //global variables for the MapFragment (uses Google map object)
    MapView mapView;
    GoogleMap map;
    private String title;
    private int page;


    // newInstance constructor for creating fragment with arguments
    public static MapFragment newInstance(int page, String title) {
        MapFragment mapFragment = new MapFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        mapFragment.setArguments(args);
        return mapFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this fragment across configuration changes.
        setRetainInstance(true);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false);
        // Gets the MapView from the XML layout and creates it
        mapView = v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        //** making sure that the user won't be able to drag the map for the city I chose
        map.getUiSettings().setScrollGesturesEnabled(false);
        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());
        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(32.08, 34.78), 13);
        map.animateCamera(cameraUpdate);

        // Find the View that shows the restaurants category
        TextView restaurants = v.findViewById(R.id.restaurants);
        // Set a click listener so that when you click on the Restaurants view you go to the tab with Restaurants fragment
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        // Find the View that shows the markets category
        TextView markets = v.findViewById(R.id.markets);
        // Set a click listener so that when you click on the Markets view you go to the tab with Markets fragment
        markets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        // Find the View that shows the museums category
        TextView museums = v.findViewById(R.id.museums);
        // Set a click listener so that when you click on the Museums view you go to the tab with Museums fragment
        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });

        // Find the View that shows the Other Attraction category
        TextView attractions = v.findViewById(R.id.attractions);
        // Set a click listener so that when you click on the Other Attractions view you go to the tab with Other Attractions fragment
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(5);
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
}