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
import fr.pierreg.library.presenter.LibraryPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();

    private LibraryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Timber.plant(new Timber.DebugTree());

        presenter = new LibraryPresenter();
        presenter.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                for (Book book : response.body()) {
                    Timber.i(book.toString());
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);
                recyclerView.setLayoutManager(new GridLayoutManager(LibraryActivity.this, getResources().getInteger(R.integer.columns)));

                recyclerView.setAdapter(
                        new RecyclerViewAdapter(LayoutInflater.from(LibraryActivity.this), response.body()));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t);
            }
        });



    }

}

/*
listCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                LibraryPresenter.this.books = response.body();
                for (Book book : response.body()) {
                    Timber.i(book.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t);
            }
        });
 */
