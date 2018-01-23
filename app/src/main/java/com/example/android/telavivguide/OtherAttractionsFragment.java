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
public class OtherAttractionsFragment extends Fragment {
    private String title;
    private int page;
    public static OtherAttractionsFragment newInstance(int page, String title) {
        OtherAttractionsFragment otherAttractionsFragment = new OtherAttractionsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        otherAttractionsFragment.setArguments(args);
        return otherAttractionsFragment;
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

    public OtherAttractionsFragment() {
        // Required empty public constructor
    }

    // this fragment uses the  Location object I created and the LocationAdapter
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.others1), getString(R.string.others1_description),
                getString(R.string.others1_address),getString(R.string.others1_phone),
                getString(R.string.others1_link),R.drawable.others1));
        locations.add(new Location(getString(R.string.others2), getString(R.string.others2_description),
                getString(R.string.others2_address),
                getString(R.string.others2_link),R.drawable.others2));
        locations.add(new Location(getString(R.string.others3), getString(R.string.others3_description),
                getString(R.string.others3_address),
                getString(R.string.others3_link),R.drawable.others3));
        locations.add(new Location(getString(R.string.others4), getString(R.string.others4_description),
                getString(R.string.others4_address),
                getString(R.string.others4_link),R.drawable.others4));
        locations.add(new Location(getString(R.string.others5), getString(R.string.others5_description),
                getString(R.string.others5_address),
                getString(R.string.others5_link),R.drawable.others5));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
//
//        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//        // There should be a {@link ListView} with the view ID called list, which is declared in the
//        // word_listyout file.
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
