package com.example.iika;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SessionHandler {

    private static final String PREF_NAME = "userSession";
    private static final String KEY_EXPIRES = "expires";
    private static final String KEY_USERID = "userID";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE = "mobile_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";


    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public SessionHandler(Context Context) {
        this.mContext = Context;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    public void loginUser(String userID, String name, String mobile, String email, String password) {
        mEditor.putString(KEY_USERID, userID);
        mEditor.putString(KEY_NAME, name);
        mEditor.putString(KEY_MOBILE, mobile);
        mEditor.putString(KEY_EMAIL, email);
        mEditor.putString(KEY_PASSWORD, password);

        mEditor.commit();
    }

    public boolean isLoggedIn() {
        if (!mPreferences.getString(KEY_USERID, KEY_EMPTY).equals(KEY_EMPTY)) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserDetails() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();
        user.setUserID(mPreferences.getString(KEY_USERID, KEY_EMPTY));
        user.setName(mPreferences.getString(KEY_NAME, KEY_EMPTY));
        user.setMobile(mPreferences.getString(KEY_MOBILE, KEY_EMPTY));
        user.setEmail(mPreferences.getString(KEY_EMAIL,KEY_EMPTY));
        user.setPassword(mPreferences.getString(KEY_PASSWORD,KEY_EMPTY));

        return user;
    }

    public void logoutUser(){

        mEditor.clear();
        mEditor.commit();
    }

//    public void savePlaceItemList(ArrayList<CartListItem> productListItems) {
//        Gson gson = new Gson();
//        String json = gson.toJson(productListItems);
//        mEditor.putString("courses", json);
//        mEditor.apply();
//    }

//    private ArrayList<CartListItem> getPlaceProductList() {
//
//        ArrayList<CartListItem> productListItemArrayList;
//        Gson gson = new Gson();
//        String json = mPreferences.getString("courses", null);
//
//        // below line is to get the type of our array list.
//        Type type = new TypeToken<ArrayList<ProductListItem>>() {}.getType();
//
//        // in below line we are getting data from gson
//        // and saving it to our array list
//        productListItemArrayList = gson.fromJson(json, type);
//
//        // checking below if the array list is empty or not
//        if (productListItemArrayList == null) {
//            // if the array list is empty
//            // creating a new array list.
//            productListItemArrayList = new ArrayList<>();
//        }
//        return productListItemArrayList;
//    }
//
//    public void setPrefStringValue(String key,String value) {
//        mEditor.putString(key, value);
//        mEditor.commit();
//        mEditor.apply();
//    }
//
//    public void setPrefIntValue(String key,int value) {
//        mEditor.putInt(key, value);
//        mEditor.commit();
//        mEditor.apply();
//    }
//
//    public String getPrefStringValue(String key) {
//        return mPreferences.getString(key,"");
//    }
//
//    public int getPrefIntValue(String key) {
//        return mPreferences.getInt(key,0);
//    }

}
