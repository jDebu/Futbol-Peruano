package jdebu.github.io.futbolperuano.data.model;

/**
 * Created by jose on 20/04/2017.
 */

public class MatchEntity {
    private String LOCAL;
    private String IMG_LOCAL;
    private String LOCAL_SCORE;
    private String URL_LOCAL;
    private String VISIT;
    private String IMG_VISIT;
    private String VISIT_SCORE;
    private String URL_VISIT;
    private String STATE_MATCH;
    private String RESULT_TEAM;
    private String DATE_MATCH;

    public String getLOCAL() {
        return LOCAL;
    }

    public void setLOCAL(String LOCAL) {
        this.LOCAL = LOCAL;
    }

    public String getIMG_LOCAL() {
        return IMG_LOCAL;
    }

    public void setIMG_LOCAL(String IMG_LOCAL) {
        this.IMG_LOCAL = IMG_LOCAL;
    }

    public String getLOCAL_SCORE() {
        return LOCAL_SCORE;
    }

    public void setLOCAL_SCORE(String LOCAL_SCORE) {
        this.LOCAL_SCORE = LOCAL_SCORE;
    }

    public String getURL_LOCAL() {
        return URL_LOCAL;
    }

    public void setURL_LOCAL(String URL_LOCAL) {
        this.URL_LOCAL = URL_LOCAL;
    }

    public String getVISIT() {
        return VISIT;
    }

    public void setVISIT(String VISIT) {
        this.VISIT = VISIT;
    }

    public String getIMG_VISIT() {
        return IMG_VISIT;
    }

    public void setIMG_VISIT(String IMG_VISIT) {
        this.IMG_VISIT = IMG_VISIT;
    }

    public String getVISIT_SCORE() {
        return VISIT_SCORE;
    }

    public void setVISIT_SCORE(String VISIT_SCORE) {
        this.VISIT_SCORE = VISIT_SCORE;
    }

    public String getURL_VISIT() {
        return URL_VISIT;
    }

    public void setURL_VISIT(String URL_VISIT) {
        this.URL_VISIT = URL_VISIT;
    }

    public String getSTATE_MATCH() {
        return STATE_MATCH;
    }

    public void setSTATE_MATCH(String STATE_MATCH) {
        this.STATE_MATCH = STATE_MATCH;
    }

    public String getRESULT_TEAM() {
        return RESULT_TEAM;
    }

    public void setRESULT_TEAM(String RESULT_TEAM) {
        this.RESULT_TEAM = RESULT_TEAM;
    }

    public String getDATE_MATCH() {
        return DATE_MATCH;
    }

    public void setDATE_MATCH(String DATE_MATCH) {
        this.DATE_MATCH = DATE_MATCH;
    }
}
