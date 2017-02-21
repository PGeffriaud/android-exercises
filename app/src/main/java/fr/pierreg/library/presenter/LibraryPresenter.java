package fr.pierreg.library.presenter;

import java.util.ArrayList;
import java.util.List;

import fr.pierreg.library.model.Book;
import fr.pierreg.library.service.HenriPotierService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by PierreG on 21/02/17.
 *
 */

public class LibraryPresenter {


    public Call<List<Book>> getBooks() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        return service.listBooks();
    }

}
