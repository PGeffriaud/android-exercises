package fr.pierreg.library.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.android.androidexercises.R;
import fr.pierreg.library.model.Book;

public class BookItemView extends LinearLayout {

    private TextView nameTextView;
    private TextView priceTextView;
    private ImageView imageView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nameTextView = (TextView) findViewById(R.id.nameTextView);
        this.priceTextView = (TextView) findViewById(R.id.priceTextView);
        this.imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void bindView(Book book) {
        this.nameTextView.setText(book.name);
        this.priceTextView.setText(String.valueOf(book.price));
        this.imageView.setImageResource(R.drawable.ic_launcher);

    }
}
