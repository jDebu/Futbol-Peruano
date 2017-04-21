package jdebu.github.io.futbolperuano.presentation.view;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.model.Match;


/**
 * Created by jose on 20/04/2017.
 */

public interface MatchView extends BaseView {
    void renderMatches(List<Match> matches);
    void showErrorMessage(String message);
}
