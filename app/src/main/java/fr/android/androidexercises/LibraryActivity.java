package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LibraryActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        List<Book> books = getBooks();


//        ListView bookListView = (ListView) findViewById(R.id.bookListView);
//        bookListView.setAdapter(new BookAdapter(this, books));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.columns)));

        recyclerView.setAdapter(
                new RecyclerViewAdapter(LayoutInflater.from(this), books));

    }

    private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            books.add(new Book(
                    String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                    RANDOM.nextInt(30))
            );
        }
        return books;
    }

}
