package jdebu.github.io.futbolperuano.domain.interactor;

import jdebu.github.io.futbolperuano.domain.repository.TeamRepository;

/**
 * Created by jose on 20/04/2017.
 */

public class TeamInteractor {
    private final TeamRepository teamRepository;

    public TeamInteractor(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public void getTeams(final ITeamCallback iTeamCallback){
        teamRepository.getTeams(iTeamCallback);
    }
}
