package jdebu.github.io.futbolperuano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
//delete
import jdebu.github.io.futbolperuano.data.datasource.rest.ApiClient;
import jdebu.github.io.futbolperuano.data.datasource.rest.RestTeamDataStore;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;

public class MainActivity extends AppCompatActivity implements RepositoryCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.i("url",ApiClient.API_BASE_URL);
        //new RestTeamDataStore().getTeams(this);
    }

    @Override
    public void onFailure(Exception exception) {

    }

    @Override
    public void onSuccess(Object object) {

    }
}
