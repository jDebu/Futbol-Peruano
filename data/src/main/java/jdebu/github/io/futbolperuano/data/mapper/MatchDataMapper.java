package jdebu.github.io.futbolperuano.data.mapper;


import java.util.ArrayList;
import java.util.List;

import jdebu.github.io.futbolperuano.data.model.MatchEntity;
import jdebu.github.io.futbolperuano.data.model.MatchResponse;
import jdebu.github.io.futbolperuano.domain.model.Match;

/**
 * Created by jose on 20/04/2017.
 */

public class MatchDataMapper {
    public Match transform(MatchEntity matchEntity){
        Match match=new Match();
        if (matchEntity==null) return match;
        match.setNameLocal(matchEntity.getLOCAL());
        match.setPhotoLocal(matchEntity.getIMG_LOCAL());
        match.setScoreLocal(matchEntity.getLOCAL_SCORE());
        String url=matchEntity.getURL_LOCAL();
        int num=(url.substring(37)).indexOf('/');
        match.setLinkLocal(url.substring(36,37+num));
        match.setNameVisit(matchEntity.getVISIT());
        match.setPhotoVisit(matchEntity.getIMG_VISIT());
        match.setScoreVisit(matchEntity.getVISIT_SCORE());
        url=matchEntity.getURL_VISIT();
        num=(url.substring(37)).indexOf('/');
        match.setLinkVisit(url.substring(36,37+num));
        match.setStateMatch(matchEntity.getSTATE_MATCH());
        match.setResultTeam(matchEntity.getRESULT_TEAM());
        match.setDateMatch(matchEntity.getDATE_MATCH());
        return match;
    }
    public List<Match> transformResponse(MatchResponse matchResponse){
        List<Match> matches=new ArrayList<>();
        if (matchResponse==null) return matches;
        for (MatchEntity matchEntity:matchResponse.getData()){
            matches.add(transform(matchEntity));
        }
        return matches;
    }
}
