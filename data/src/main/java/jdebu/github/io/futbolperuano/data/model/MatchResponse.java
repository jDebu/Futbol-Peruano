package jdebu.github.io.futbolperuano.data.model;

import java.util.List;

/**
 * Created by jose on 20/04/2017.
 */

public class MatchResponse extends BaseResponse {
    private List<MatchEntity> data;

    public List<MatchEntity> getData() {
        return data;
    }

    public void setData(List<MatchEntity> data) {
        this.data = data;
    }
}
