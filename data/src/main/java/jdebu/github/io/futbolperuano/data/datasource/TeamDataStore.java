package jdebu.github.io.futbolperuano.data.datasource;

import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;

/**
 * Created by jose on 18/04/2017.
 */

public interface TeamDataStore {
    void getTeams(RepositoryCallback repositoryCallback);
}
