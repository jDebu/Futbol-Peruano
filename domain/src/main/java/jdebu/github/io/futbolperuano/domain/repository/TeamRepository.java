package jdebu.github.io.futbolperuano.domain.repository;

import jdebu.github.io.futbolperuano.domain.interactor.ITeamCallback;

/**
 * Created by jose on 18/04/2017.
 */

public interface TeamRepository {
    void getTeams(final ITeamCallback iTeamCallback);
}
