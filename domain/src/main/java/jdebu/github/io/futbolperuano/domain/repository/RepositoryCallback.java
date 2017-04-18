package jdebu.github.io.futbolperuano.domain.repository;

/**
 * Created by jose on 18/04/2017.
 */

public interface RepositoryCallback {
    void onFailure(Exception exception);
    void onSuccess(Object object);
}

