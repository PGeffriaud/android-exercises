package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String toastValue = R.string.toast_done + " " + getIntent().getStringExtra("name");
        Toast.makeText(this, toastValue, Toast.LENGTH_SHORT).show();
    }
}
