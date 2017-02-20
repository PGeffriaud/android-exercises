package fr.android.androidexercises;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button openButton = (Button) findViewById(R.id.openButton);

        final Book book = new Book("Garry Whopper", "CK Rowling");

        openButton.setOnClickListener(v -> {
            new DatePickerDialog(LibraryActivity.this, (view, year, month, dayOfMonth) ->
                    new TimePickerDialog(LibraryActivity.this, (view1, hourOfDay, minute) ->
                            Toast.makeText(LibraryActivity.this, String.format("%d/%d/%d %d:%d", dayOfMonth+1, month+1, year, hourOfDay, minute), Toast.LENGTH_SHORT).show(),
                    12, 0, true).show(),
            2017, 2, 20).show();
        });


   /* Intent intent = new Intent(LibraryActivity.this, BookActivity.class);
    //Add book to intent
    intent.putExtra("BOOK", book);
    startActivity(intent);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
