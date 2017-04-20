package jdebu.github.io.futbolperuano.presentation.utils.media;

import android.widget.ImageView;

/**
 * Created by jose on 19/04/2017.
 */
public interface ImageLoader {

    void load(String url, ImageView imageView);
    void loadLocal(String path, ImageView imageView);
}
