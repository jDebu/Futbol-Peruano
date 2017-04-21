package jdebu.github.io.futbolperuano.domain.interactor;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.model.Match;

/**
 * Created by jose on 21/04/2017.
 */

public interface IMatchCallback {
    void onMatchesSuccess(List<Match> matches);
    void onMatchesFailure(Exception exception);
}
