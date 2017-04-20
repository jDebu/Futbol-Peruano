package jdebu.github.io.futbolperuano.data.datasource.rest;

import jdebu.github.io.futbolperuano.data.model.TeamResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jose on 18/04/2017.
 */

public interface DevServicesApiInterface {

    @GET("/equipos/")
    Call<TeamResponse> teams();
}
