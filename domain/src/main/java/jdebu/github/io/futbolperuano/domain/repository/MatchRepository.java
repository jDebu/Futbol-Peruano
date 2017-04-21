package jdebu.github.io.futbolperuano.domain.repository;

import jdebu.github.io.futbolperuano.domain.interactor.IMatchCallback;

/**
 * Created by jose on 21/04/2017.
 */

public interface MatchRepository {
    void getMatches(final IMatchCallback iMatchCallback);
}
