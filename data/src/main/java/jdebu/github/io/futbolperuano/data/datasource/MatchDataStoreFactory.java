package jdebu.github.io.futbolperuano.data.datasource;

import jdebu.github.io.futbolperuano.data.datasource.rest.RestMatchDataStore;

/**
 * Created by jose on 20/04/2017.
 */

public class MatchDataStoreFactory {
    public static final  int DB=1;
    public static final  int CLOUD=2;
    public static final  int PREFERENCES=3;
    private String linkMatchesTeam;

    public MatchDataStoreFactory(String linkMatchesTeam) {
        this.linkMatchesTeam = linkMatchesTeam;
    }

    public MatchDataStore create(int dataSource){
        MatchDataStore matchDataStore=null;
        switch (dataSource){
            case DB:break;
            case CLOUD: matchDataStore=new RestMatchDataStore(linkMatchesTeam);break;
            case PREFERENCES:break;//pass context
        }
        return matchDataStore;
    }
}
