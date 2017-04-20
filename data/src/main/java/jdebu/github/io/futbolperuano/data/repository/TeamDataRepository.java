package jdebu.github.io.futbolperuano.data.repository;


import java.util.List;

import jdebu.github.io.futbolperuano.data.datasource.TeamDataStore;
import jdebu.github.io.futbolperuano.data.datasource.TeamDataStoreFactory;
import jdebu.github.io.futbolperuano.data.mapper.TeamDataMapper;
import jdebu.github.io.futbolperuano.data.model.TeamResponse;
import jdebu.github.io.futbolperuano.domain.interactor.ITeamCallback;
import jdebu.github.io.futbolperuano.domain.model.Team;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;
import jdebu.github.io.futbolperuano.domain.repository.TeamRepository;

/**
 * Created by jose on 20/04/2017.
 */

public class TeamDataRepository implements TeamRepository {
    private final TeamDataStoreFactory teamDataStoreFactory;
    private final TeamDataMapper teamDataMapper;

    public TeamDataRepository(TeamDataStoreFactory teamDataStoreFactory, TeamDataMapper teamDataMapper) {
        this.teamDataStoreFactory = teamDataStoreFactory;
        this.teamDataMapper = teamDataMapper;
    }

    @Override
    public void getTeams(final ITeamCallback iTeamCallback) {
        TeamDataStore teamDataStore=this.teamDataStoreFactory.create(TeamDataStoreFactory.CLOUD);
        //aca llama al servicio y se guarda en RepositoryCallback
        teamDataStore.getTeams(new RepositoryCallback() {
            @Override
            public void onFailure(Exception exception) {
                iTeamCallback.onTeamFailure(exception);
            }

            @Override
            public void onSuccess(Object object) {
                TeamResponse teamResponse=((TeamResponse) (object));
                List<Team> teams=teamDataMapper.transformResponse(teamResponse);
                //Log.e("DATAREPOSITORY",teams.toString());
                iTeamCallback.onTeamsSuccess(teams);
            }
        });
    }
}
