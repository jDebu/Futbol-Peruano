package jdebu.github.io.futbolperuano.presentation.view;

import android.os.Bundle;

import java.util.List;

import jdebu.github.io.futbolperuano.domain.model.Team;

/**
 * Created by jose on 19/04/2017.
 */

public interface MainView extends BaseView {
    void renderTeams(List<Team> teams);
    void showErrorMessage(String message);
    void gotoTeamMatchs(Bundle bundle);
}
