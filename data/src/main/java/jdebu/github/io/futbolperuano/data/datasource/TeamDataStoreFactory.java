package jdebu.github.io.futbolperuano.data.datasource;

import jdebu.github.io.futbolperuano.data.datasource.rest.RestTeamDataStore;

/**
 * Created by jose on 20/04/2017.
 */

public class TeamDataStoreFactory {
    public static final  int DB=1;
    public static final  int CLOUD=2;
    public static final  int PREFERENCES=3;

    public TeamDataStore create(int dataSource){
        TeamDataStore teamDataStore=null;
        switch (dataSource){
            case DB:break;
            case CLOUD: teamDataStore=new RestTeamDataStore();break;
            case PREFERENCES:break;//pass context
        }
        return teamDataStore;
    }
}
