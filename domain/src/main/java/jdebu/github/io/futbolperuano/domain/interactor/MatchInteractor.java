package jdebu.github.io.futbolperuano.domain.interactor;

import jdebu.github.io.futbolperuano.domain.repository.MatchRepository;

/**
 * Created by jose on 21/04/2017.
 */

public class MatchInteractor {
    private final MatchRepository matchRepository;

    public MatchInteractor(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
    public void getMatches(IMatchCallback iMatchCallback){
        matchRepository.getMatches(iMatchCallback);
    }
}
