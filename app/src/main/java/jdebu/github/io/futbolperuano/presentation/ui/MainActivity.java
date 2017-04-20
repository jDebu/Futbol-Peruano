package jdebu.github.io.futbolperuano.presentation.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.Bind;
import jdebu.github.io.futbolperuano.R;
import jdebu.github.io.futbolperuano.presentation.adapter.TeamAdapter;
import jdebu.github.io.futbolperuano.data.datasource.TeamDataStoreFactory;
import jdebu.github.io.futbolperuano.data.mapper.TeamDataMapper;
import jdebu.github.io.futbolperuano.data.repository.TeamDataRepository;
import jdebu.github.io.futbolperuano.domain.interactor.TeamInteractor;
import jdebu.github.io.futbolperuano.domain.model.Team;
import jdebu.github.io.futbolperuano.domain.repository.TeamRepository;
import jdebu.github.io.futbolperuano.presentation.presenter.TeamPresenter;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.MarginDecoration;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.RecyclerClickListener;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.RecyclerTouchListener;
import jdebu.github.io.futbolperuano.presentation.view.MainView;

public class MainActivity extends BaseActivity implements MainView{

    @Bind(R.id.flProgress) View flProgress;
    @Bind(R.id.rvTeams) RecyclerView rvTeams;
    @Bind(R.id.container) RelativeLayout container;

    private List<Team> teams;
    private TeamAdapter teamAdapter;
    private TeamPresenter teamPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.i("url",ApiClient.API_BASE_URL);
        //new RestTeamDataStore().getTeams(this);
        injectView();
        setupTeamPresenter();
        ui();
        getTeams();
    }

    private void setupTeamPresenter() {
        //TeamDataRepository ejecuta getTeams por implementar TeamRepository y guarda lista de Team en iTeamCallback
        TeamRepository teamRepository=new TeamDataRepository(new TeamDataStoreFactory(),new TeamDataMapper());
        TeamInteractor teamInteractor=new TeamInteractor(teamRepository);
        teamPresenter=new TeamPresenter(teamInteractor);
        teamPresenter.addView(this);//agregando la instancia de la vista recien ahi puedo obtener el servicio
    }
    private void getTeams() {
        teamPresenter.getTeams();
    }

    private void ui() {
        rvTeams.setHasFixedSize(false);
        rvTeams.addItemDecoration(new MarginDecoration(this));
        rvTeams.setLayoutManager(new LinearLayoutManager(this));

        rvTeams.addOnItemTouchListener(new RecyclerTouchListener(this, rvTeams, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (teams!=null){
                    Team team=teams.get(position);

                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void showLoading() {
        flProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flProgress.setVisibility(View.GONE);
    }

    @Override
    public void renderTeams(List<Team> teams) {
        Log.d("RENDER",teams.toString());
        this.teams=teams;
        teamAdapter= new TeamAdapter(teams);
        rvTeams.setAdapter(teamAdapter);
    }

    @Override
    public void showErrorMessage(String message) {
        showMessage(container,message);
    }

    @Override
    public void gotoTeamMatchs(Bundle bundle) {

    }
    @Override
    protected void onDestroy() {
        if(teamPresenter!=null){teamPresenter.removeView(this);}
        super.onDestroy();
    }
}
