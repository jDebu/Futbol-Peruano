package jdebu.github.io.futbolperuano.domain.interactor;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.model.Team;

/**
 * Created by jose on 20/04/2017.
 */

public interface ITeamCallback {
    void onTeamsSuccess(List<Team> teams);
    void onTeamFailure(Exception exception);
}
