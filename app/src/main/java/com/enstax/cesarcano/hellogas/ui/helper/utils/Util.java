package com.enstax.cesarcano.hellogas.ui.helper.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.Toast;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Util<Data> {
    public static Intent setIntent(Context context, Class destination) {

        Intent intent = new Intent(context, destination);
        context.startActivity(intent);

        return intent ;
    }

    public Intent setIntentExtra(Context context, Class destination, String key, Data data) {
        Intent intent = new Intent(context, destination);
        intent.putExtra(key, (Parcelable) data);
        context.startActivity(intent);

        return intent ;
    }

    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}