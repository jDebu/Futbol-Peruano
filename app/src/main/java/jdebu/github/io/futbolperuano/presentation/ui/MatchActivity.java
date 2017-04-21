package jdebu.github.io.futbolperuano.presentation.ui;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import butterknife.Bind;
import jdebu.github.io.futbolperuano.R;
import jdebu.github.io.futbolperuano.data.datasource.MatchDataStoreFactory;
import jdebu.github.io.futbolperuano.data.datasource.rest.RestMatchDataStore;
import jdebu.github.io.futbolperuano.data.mapper.MatchDataMapper;
import jdebu.github.io.futbolperuano.data.repository.MatchDataRepository;
import jdebu.github.io.futbolperuano.domain.interactor.MatchInteractor;
import jdebu.github.io.futbolperuano.domain.model.Match;
import jdebu.github.io.futbolperuano.domain.model.Team;
import jdebu.github.io.futbolperuano.domain.repository.MatchRepository;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;
import jdebu.github.io.futbolperuano.presentation.adapter.MatchAdapter;
import jdebu.github.io.futbolperuano.presentation.presenter.MatchPresenter;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.MarginDecoration;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.RecyclerClickListener;
import jdebu.github.io.futbolperuano.presentation.ui.recycler.RecyclerTouchListener;
import jdebu.github.io.futbolperuano.presentation.utils.media.ImageLoaderHelper;
import jdebu.github.io.futbolperuano.presentation.view.MatchView;

public class MatchActivity extends BaseActivity implements MatchView {

    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.ivLogo) ImageView logo;
    @Bind(R.id.tvToolbar) TextView title;

    @Bind(R.id.flProgress) View flProgress;
    @Bind(R.id.rvMatches) RecyclerView rvMatches;
    @Bind(R.id.containerMatches) RelativeLayout container;

    private Team team;
    private ImageLoaderHelper imageLoaderHelper;

    private List<Match> matches;
    private MatchAdapter matchAdapter;
    private MatchPresenter matchPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        getExtras();
        injectView();
        ui();
        populate();
    }

    private void ui() {
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsAbsolute(0,0);
        //events
        toolbar.findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApp();
            }
        });

        imageLoaderHelper= new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
        rvMatches.setHasFixedSize(false);
        rvMatches.addItemDecoration(new MarginDecoration(this));
        rvMatches.setLayoutManager(new LinearLayoutManager(this));
        rvMatches.addOnItemTouchListener(new RecyclerTouchListener(this, rvMatches, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void closeApp() {
        finish();
    }

    private void populate() {
        if (team!=null){
            //new RestMatchDataStore(team.getLink()).getMatches(this);
            title.setText(team.getName());
            imageLoaderHelper.getLoader().load(team.getPhoto(),logo);
            setupMatchPresenter(team);
        }
    }

    private void setupMatchPresenter(Team team) {
        MatchRepository matchRepository=new MatchDataRepository(new MatchDataStoreFactory(team.getLink()),
                new MatchDataMapper());
        MatchInteractor matchInteractor=new MatchInteractor(matchRepository);
        matchPresenter = new MatchPresenter(matchInteractor);
        matchPresenter.addView(this);
        getMatches();
    }

    private void getMatches() {
        matchPresenter.getMatches();
    }

    public void getExtras() {
       if (getIntent()!=null){
           Bundle bundle=getIntent().getExtras();
           if (bundle!=null){
               team=(Team)bundle.getSerializable("TEAM");
           }
       }
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
    public void renderMatches(List<Match> matches) {
        this.matches=matches;
        matchAdapter=new MatchAdapter(matches);
        rvMatches.setAdapter(matchAdapter);
    }

    @Override
    public void showErrorMessage(String message) {
        showMessage(container,message);
    }
}
