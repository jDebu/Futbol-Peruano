package jdebu.github.io.futbolperuano.data.mapper;

import java.util.ArrayList;
import java.util.List;

import jdebu.github.io.futbolperuano.data.model.TeamEntity;
import jdebu.github.io.futbolperuano.data.model.TeamResponse;
import jdebu.github.io.futbolperuano.domain.model.Team;

/**
 * Created by jose on 20/04/2017.
 */

public class TeamDataMapper {
    public Team transform(TeamEntity teamEntity){
        Team team=new Team();
        if (teamEntity==null)return team;
        team.setName(teamEntity.getName());
        team.setPhoto(teamEntity.getLogo());
        String url=teamEntity.getUrl();
        //int num=(url.substring(37)).indexOf('/');
        //team.setLink(url.substring(28,36).concat(url.substring(36,37+num)));
        return team;
    }
    public List<Team> transformResponse(TeamResponse teamResponse){
        List<Team> teams=new ArrayList<>();
        if (teamResponse==null) return teams;
        for (TeamEntity teamEntity:teamResponse.getData()){
            teams.add(transform(teamEntity));
        }
        return teams;
    }
}
