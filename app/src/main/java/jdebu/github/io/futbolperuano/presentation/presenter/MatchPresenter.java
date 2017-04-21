package jdebu.github.io.futbolperuano.presentation.presenter;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.interactor.IMatchCallback;
import jdebu.github.io.futbolperuano.domain.interactor.MatchInteractor;
import jdebu.github.io.futbolperuano.domain.model.Match;
import jdebu.github.io.futbolperuano.presentation.view.MatchView;

/**
 * Created by jose on 21/04/2017.
 */

public class MatchPresenter implements Presenter<MatchView>,IMatchCallback {
    private MatchView matchView;
    private final MatchInteractor matchInteractor;

    public MatchPresenter(MatchInteractor matchInteractor) {
        this.matchInteractor = matchInteractor;
    }


    @Override
    public void addView(MatchView view) {
        this.matchView=view;
    }

    @Override
    public void removeView(MatchView view) {
        this.matchView=null;
    }

    @Override
    public void onMatchesSuccess(List<Match> matches) {
        this.matchView.hideLoading();
        this.matchView.renderMatches(matches);
    }

    @Override
    public void onMatchesFailure(Exception exception) {
        this.matchView.hideLoading();
        this.matchView.showErrorMessage(exception.getMessage());
    }
    public void getMatches(){
        this.matchView.showLoading();
        this.matchInteractor.getMatches(this);
    }
}
