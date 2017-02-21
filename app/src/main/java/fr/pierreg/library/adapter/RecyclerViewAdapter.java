package fr.pierreg.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.android.androidexercises.R;
import fr.pierreg.library.model.Book;

/**
 * Created by PierreG on 21/02/17.
 *
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private LayoutInflater layoutInflater;
    private List<Book> books;

    public RecyclerViewAdapter(LayoutInflater layoutInflater, List<Book> books) {
        this.layoutInflater = layoutInflater;
        this.books = books;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookItemView itemView = (BookItemView) holder.itemView;
        itemView.bindView(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
