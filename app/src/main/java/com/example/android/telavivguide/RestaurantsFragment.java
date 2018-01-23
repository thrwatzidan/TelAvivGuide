package com.example.android.telavivguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {
    // newInstance constructor for creating fragment with arguments
    private String title;
    private int page;
    public static RestaurantsFragment newInstance(int page, String title) {
        RestaurantsFragment restaurantsFragment = new RestaurantsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        restaurantsFragment.setArguments(args);
        return restaurantsFragment;
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

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    // this fragment uses the  Location object I created and the LocationAdapter
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.restaurant1), getString(R.string.restaurant1_description),
                getString(R.string.restaurant1_address), getString(R.string.restaurant1_phone),
                getString(R.string.restaurant1_link),R.drawable.restaurant1));
        locations.add(new Location(getString(R.string.restaurant2), getString(R.string.restaurant2_description),
                getString(R.string.restaurant2_address), getString(R.string.restaurant2_phone),
                getString(R.string.restaurant2_link),R.drawable.restaurant2));
        locations.add(new Location(getString(R.string.restaurant3), getString(R.string.restaurant3_description),
                getString(R.string.restaurant3_address), getString(R.string.restaurant3_phone),
                getString(R.string.restaurant3_link),R.drawable.restaurant3));
        locations.add(new Location(getString(R.string.restaurant4), getString(R.string.restaurant4_description),
                getString(R.string.restaurant4_address), getString(R.string.restaurant4_phone),
                getString(R.string.restaurant4_link),R.drawable.restaurant4));
        locations.add(new Location(getString(R.string.restaurant5), getString(R.string.restaurant5_description),
                getString(R.string.restaurant5_address), getString(R.string.restaurant5_phone),
                getString(R.string.restaurant5_link),R.drawable.restaurant5));
        locations.add(new Location(getString(R.string.restaurant6), getString(R.string.restaurant6_description),
                getString(R.string.restaurant6_address), getString(R.string.restaurant6_phone),
                getString(R.string.restaurant6_link),R.drawable.restaurant6));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
//
//        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//        // There should be a {@link ListView} with the view ID called list, which is declared in the
//        // location_list file.
//
        ListView listView = rootView.findViewById(R.id.list);
//
//
//        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
//        // {@link ListView} will display list items for each word in the list of locations.
//        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
//        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
//
        listView.setAdapter(adapter);

        return rootView;
    }
}
