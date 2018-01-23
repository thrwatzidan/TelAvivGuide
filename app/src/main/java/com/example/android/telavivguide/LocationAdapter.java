package com.example.android.telavivguide;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * this is the constructor for the LocationAdapter object
     */
    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, locations);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // get the Location object in the current position in the array
        Location currentLocation = getItem(position);
        // the name of the attraction is set in it's location in list_item layout
        TextView mNameOfAttraction = listItemView.findViewById(R.id.name_of_attraction);
        mNameOfAttraction.setText(currentLocation.getNameOfAttraction());
        // the description of the attraction is set in it's location in list_item layout
        TextView mDescriptionOfAtrraction = listItemView.findViewById(R.id.description_of_attraction);
        mDescriptionOfAtrraction.setText(currentLocation.getDescriptionOfAttraction());
        // the address of the attraction is set in it's location in list_item layout
        TextView mAddressOfAtrraction = listItemView.findViewById(R.id.address_of_attraction);
        mAddressOfAtrraction.setText(currentLocation.getAddressOfAttraction());
        // the phone of the attraction is set in it's location in list_item layout
        TextView mPhoneOfAtrraction = listItemView.findViewById(R.id.phone_of_attraction);
        // Check if a phone number is provided for this location or not
        if (currentLocation.hasPhone()) {
            // If a phone number is available, display it
            mPhoneOfAtrraction.setText(currentLocation.getPhoneOfAttraction());
        } else {
            // Otherwise hide the TextView (set visibility to GONE)
            mPhoneOfAtrraction.setVisibility(View.GONE);
        }

        // the web-link of the attraction is set so that the link won't be shown, but the text
        // "Click here for more information", that is set to be bold. this is set in it's location in list_item layout
        SpannableString ss = new SpannableString(getContext().getString(R.string.link_text_shown));
        ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 31,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan(currentLocation.getLinkOfAttraction()), 0, 31,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView mlinkOfAtrraction = listItemView.findViewById(R.id.link_of_attraction);
        mlinkOfAtrraction.setText(ss);
        mlinkOfAtrraction.setMovementMethod(LinkMovementMethod.getInstance());

        ImageView imageView = listItemView.findViewById(R.id.list_item_image);
        // display the provided image based on the resource ID
        imageView.setImageResource(currentLocation.getImageResourceId());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);

        return listItemView;
    }
}
