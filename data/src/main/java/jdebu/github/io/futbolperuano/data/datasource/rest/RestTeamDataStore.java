package jdebu.github.io.futbolperuano.data.datasource.rest;


import java.io.IOException;
import java.util.List;

import jdebu.github.io.futbolperuano.data.BuildConfig;
import jdebu.github.io.futbolperuano.data.datasource.TeamDataStore;
import jdebu.github.io.futbolperuano.data.model.TeamEntity;
import jdebu.github.io.futbolperuano.data.model.TeamResponse;
import jdebu.github.io.futbolperuano.domain.repository.RepositoryCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jose on 18/04/2017.
 */

public class RestTeamDataStore implements TeamDataStore{
    private final String ERROR_MESSAGE="Ocurrio un error";
    private final String DEV_FLAVOR= "dev";
    private final String PROD_FLAVOR= "prod";


    @Override
    public void getTeams(final RepositoryCallback repositoryCallback) {
        Call<TeamResponse> call=null;
        String flavor = BuildConfig.FLAVOR.toString();
        if (flavor.equals(DEV_FLAVOR)){
            call=ApiClient.getDevServicesApiClient().teams();
        }
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                //Log.e("llego",response.toString());
                if (response.isSuccessful()){
                    TeamResponse teamResponse=response.body();
                    if (teamResponse!=null){
                        //List<TeamEntity> teamEntityList=teamResponse.getData();
                        //Log.e("RESTTEAM",teamEntityList.toString());
                        repositoryCallback.onSuccess(teamResponse);
                    }else{
                        repositoryCallback.onFailure(new Exception(ERROR_MESSAGE));
                    }
                }else{
                    repositoryCallback.onFailure(new Exception(ERROR_MESSAGE));
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
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
