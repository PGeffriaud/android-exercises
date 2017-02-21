package fr.pierreg.library.service;

import java.util.List;

import fr.pierreg.library.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> listBooks();

}