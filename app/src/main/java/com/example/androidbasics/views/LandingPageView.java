package com.example.androidbasics.views;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.androidbasics.R;

public class LandingPageView extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    void showContact() {
        long ret = -1;
        String data = "";
        String selection = ContactsContract.Contacts.DISPLAY_NAME + " like'%Subya%'";
        String[] projection = new String[] {
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Email.CONTENT_URI.toString()
        };
        Cursor c = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection,
                selection,
                null,
                null);
        if (c.moveToFirst()){
            int data1 = c.getColumnIndex("contact_id");
            int data2 = c.getColumnIndex("contact_id");
            do{
                data = c.getString(data1);
                // do what ever you want here
            }while(c.moveToNext());
        }
        c.close();
        System.out.println("-------> " + ret);
        System.out.println("-------> " + data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showContact();
        setContentView(R.layout.landing_page);

        Button start = findViewById(R.id.start_game);
        EditText player1Name = findViewById(R.id.player_1_name);
        EditText player2Name = findViewById(R.id.player_2_name);

        start.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, TicTacToeView.class);
            intent.putExtra("player1Name", player1Name.getText().toString());
            intent.putExtra("player2Name", player2Name.getText().toString());
            startActivity(intent);
        });
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
