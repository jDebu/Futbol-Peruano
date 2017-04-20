package jdebu.github.io.futbolperuano.presentation.ui.recycler;

import android.view.View;

/**
 * Created by jose on 19/04/2017.
 */
public interface RecyclerClickListener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}