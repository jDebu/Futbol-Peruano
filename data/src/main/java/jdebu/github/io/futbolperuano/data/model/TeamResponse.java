package jdebu.github.io.futbolperuano.data.model;

import java.util.List;

/**
 * Created by jose on 18/04/2017.
 */

public class TeamResponse extends BaseResponse {
    private List<TeamEntity> data;

    public List<TeamEntity> getData() {
        return data;
    }

    public void setData(List<TeamEntity> data) {
        this.data = data;
    }
}
