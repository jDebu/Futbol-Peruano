package jdebu.github.io.futbolperuano.data.datasource;

import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;

/**
 * Created by jose on 20/04/2017.
 */

public interface MatchDataStore {
    void getMatches(RepositoryCallback repositoryCallback);
}
