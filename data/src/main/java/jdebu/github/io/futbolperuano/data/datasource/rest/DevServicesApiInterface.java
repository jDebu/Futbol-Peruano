package jdebu.github.io.futbolperuano.data.datasource.rest;

import jdebu.github.io.futbolperuano.data.model.MatchResponse;
import jdebu.github.io.futbolperuano.data.model.TeamResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jose on 18/04/2017.
 */

public interface DevServicesApiInterface {

    @GET("/equipos/")
    Call<TeamResponse> teams();
    @GET("/equipo/{matchesTeam}")
    Call<MatchResponse> matches(@Path("matchesTeam") String matchesTeam);
}
