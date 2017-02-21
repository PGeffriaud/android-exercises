package fr.pierreg.library.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import fr.android.androidexercises.R;
import fr.pierreg.library.adapter.RecyclerViewAdapter;
import fr.pierreg.library.model.Book;

public class LibraryActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        List<Book> books = getBooks();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);
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
