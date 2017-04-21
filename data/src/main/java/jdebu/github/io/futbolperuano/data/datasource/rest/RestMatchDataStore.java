package jdebu.github.io.futbolperuano.data.datasource.rest;

import android.util.Log;

import jdebu.github.io.futbolperuano.data.BuildConfig;
import jdebu.github.io.futbolperuano.data.datasource.MatchDataStore;
import jdebu.github.io.futbolperuano.data.model.MatchResponse;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jose on 20/04/2017.
 */

public class RestMatchDataStore implements MatchDataStore {
    private final String ERROR_MESSAGE="Ocurrio un error";
    private final String DEV_FLAVOR= "dev";
    private String linkMatchesTeam;

    public RestMatchDataStore(String linkMatchesTeam) {
        this.linkMatchesTeam = linkMatchesTeam;
    }

    @Override
    public void getMatches(final RepositoryCallback repositoryCallback) {
        Call<MatchResponse> call=null;
        String flavor = BuildConfig.FLAVOR.toString();
        if (flavor.equals(DEV_FLAVOR)){
            call=ApiClient.getDevServicesApiClient().matches(linkMatchesTeam);
        }
        call.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                if (response.isSuccessful()){
                    MatchResponse matchResponse=response.body();
                    if (matchResponse!=null){
                        repositoryCallback.onSuccess(matchResponse);
                    }else {
                        repositoryCallback.onFailure(new Exception(ERROR_MESSAGE));
                    }
                } else {
                    repositoryCallback.onFailure(new Exception(ERROR_MESSAGE));
                }
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                String message="Error";
                try {
                    message= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {
                    message=e.getMessage();
                }
                repositoryCallback.onFailure(new Exception(message));
            }
        });
    }
}
