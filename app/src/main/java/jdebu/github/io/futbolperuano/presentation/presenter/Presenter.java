package jdebu.github.io.futbolperuano.presentation.presenter;

/**
 * Created by jose on 20/04/2017.
 */

public interface Presenter<T> {

    void addView(T view);
    void removeView(T view);
}
