package jdebu.github.io.futbolperuano.presentation.presenter;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.interactor.ITeamCallback;
import jdebu.github.io.futbolperuano.domain.interactor.TeamInteractor;
import jdebu.github.io.futbolperuano.domain.model.Team;
import jdebu.github.io.futbolperuano.presentation.view.MainView;

/**
 * Created by jose on 20/04/2017.
 */

public class TeamPresenter implements ITeamCallback,Presenter<MainView> {
    private final TeamInteractor teamInteractor;
    private MainView mainView;

    public TeamPresenter(TeamInteractor teamInteractor) {
        this.teamInteractor = teamInteractor;
    }
    //recibe lista de teams llamado en MainActivity
    @Override
    public void onTeamsSuccess(List<Team> teams) {
        this.mainView.hideLoading();
        Log.d("TEAMS",teams.toString());
        this.mainView.renderTeams(teams);
    }

    @Override
    public void onTeamFailure(Exception exception) {
        this.mainView.hideLoading();
        this.mainView.showErrorMessage(exception.getMessage());
    }

    @Override
    public void addView(MainView view) {
        this.mainView=view;
    }

    @Override
    public void removeView(MainView view) {
        this.mainView=null;
    }

    public void getTeams() {
        this.mainView.showLoading();
        teamInteractor.getTeams(this);
    }

    public void selectedTeam(Team team) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("TEAM",team);
        this.mainView.gotoTeamMatchs(bundle);
    }
}
