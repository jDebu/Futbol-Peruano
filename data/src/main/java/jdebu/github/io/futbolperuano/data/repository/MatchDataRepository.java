package jdebu.github.io.futbolperuano.data.repository;

import java.util.List;

import jdebu.github.io.futbolperuano.data.datasource.MatchDataStore;
import jdebu.github.io.futbolperuano.data.datasource.MatchDataStoreFactory;
import jdebu.github.io.futbolperuano.data.mapper.MatchDataMapper;
import jdebu.github.io.futbolperuano.data.model.MatchResponse;
import jdebu.github.io.futbolperuano.domain.interactor.IMatchCallback;
import jdebu.github.io.futbolperuano.domain.model.Match;
import jdebu.github.io.futbolperuano.domain.repository.MatchRepository;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;

/**
 * Created by jose on 21/04/2017.
 */

public class MatchDataRepository implements MatchRepository {
    private final MatchDataStoreFactory matchDataStoreFactory;
    private final MatchDataMapper matchDataMapper;

    public MatchDataRepository(MatchDataStoreFactory matchDataStoreFactory, MatchDataMapper matchDataMapper) {
        this.matchDataStoreFactory = matchDataStoreFactory;
        this.matchDataMapper = matchDataMapper;
    }

    @Override
    public void getMatches(final IMatchCallback iMatchCallback) {
        MatchDataStore matchDataStore=this.matchDataStoreFactory.create(MatchDataStoreFactory.CLOUD);
        matchDataStore.getMatches(new RepositoryCallback() {
            @Override
            public void onFailure(Exception exception) {
                iMatchCallback.onMatchesFailure(exception);
            }

            @Override
            public void onSuccess(Object object) {
                MatchResponse matchResponse=((MatchResponse) (object));
                List<Match> matches=matchDataMapper.transformResponse(matchResponse);
                iMatchCallback.onMatchesSuccess(matches);
            }
        });
    }
}
