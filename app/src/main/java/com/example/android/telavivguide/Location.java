package com.example.android.telavivguide;


public class Location {
    /** name of the attraction */
    private String mNameOfAttraction;
    /** description of the attraction */
    private String mDescriptionOfAttraction;
    /** address of the attraction */
    private String mAddress;
    /** phone of the attraction */
    private String mPhoneOfAttraction = NO_PHONE_PROVIDED;
    /** website of the attraction */
    private String mLinkOfAttraction;
    /** Image resource ID for the attraction */
    private int mImageResourceId;

    /** Constant value that represents no phone was provided for this location */
    private static final String NO_PHONE_PROVIDED = null;


    /**
     * Create a new Location object.
     * @param nameOfAttraction is the name of the attraction
     *
     * @param descriptionOfAttraction is the description of the attraction
     *
     * @param address is the address of the attraction
     *
     * @param phoneOfAttraction is the phone number of the attraction
     *
     * @param linkOfAttraction is the website of the attraction
     *
     * @param imageResourceId is the id of the image file
     */
    public Location(String nameOfAttraction, String descriptionOfAttraction, String address, String phoneOfAttraction,
                    String linkOfAttraction, int imageResourceId) {
        mNameOfAttraction = nameOfAttraction;
        mDescriptionOfAttraction = descriptionOfAttraction;
        mAddress = address;
        mPhoneOfAttraction = phoneOfAttraction;
        mLinkOfAttraction = linkOfAttraction;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Location object with a different constructor (this one does not have a phone for the attraction.
     *
     * @param nameOfAttraction is the name of the attraction
     *
     * @param descriptionOfAttraction is the description of the attraction
     *
     * @param address is the address of the attraction
     *
     * @param linkOfAttraction is the phone number of the attraction
     *
     * @param imageResourceId is the id of the image file
     */
    public Location(String nameOfAttraction, String descriptionOfAttraction, String address, String linkOfAttraction,
                    int imageResourceId) {
        mNameOfAttraction = nameOfAttraction;
        mDescriptionOfAttraction = descriptionOfAttraction;
        mAddress = address;
        mLinkOfAttraction = linkOfAttraction;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the attraction
     */
    public String getNameOfAttraction() {
        return mNameOfAttraction;
    }
    /**
     * Get the description of the attraction
     */
    public String getDescriptionOfAttraction() {
        return mDescriptionOfAttraction;
    }
    /**
     * Get the address of the attraction
     */
    public String getAddressOfAttraction() {
        return mAddress;
    }
    /**
     * Get the phone of the attraction
     */
    public String getPhoneOfAttraction() {
        return mPhoneOfAttraction;
    }
    /**
     * Get the website of the attraction
     */
    public String getLinkOfAttraction() {
        return mLinkOfAttraction;
    }
    /**
     * Get the image location  for that word image.
     */
    public int getImageResourceId () { return  mImageResourceId; }
    /**
     * Returns whether or not there is an phone string for this word.
     */
    public boolean hasPhone() { return mPhoneOfAttraction != NO_PHONE_PROVIDED; }

}

