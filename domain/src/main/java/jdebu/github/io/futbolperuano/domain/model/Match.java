package jdebu.github.io.futbolperuano.domain.model;

import java.io.Serializable;

/**
 * Created by jose on 20/04/2017.
 */

public class Match implements Serializable {
    private String nameLocal;
    private String photoLocal;
    private String scoreLocal;
    private String linkLocal;
    private String nameVisit;
    private String photoVisit;
    private String scoreVisit;
    private String linkVisit;
    private String stateMatch;
    private String resultTeam;
    private String dateMatch;

    public String getNameLocal() {
        return nameLocal;
    }

    public void setNameLocal(String nameLocal) {
        this.nameLocal = nameLocal;
    }

    public String getPhotoLocal() {
        return photoLocal;
    }

    public void setPhotoLocal(String photoLocal) {
        this.photoLocal = photoLocal;
    }

    public String getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(String scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public String getLinkLocal() {
        return linkLocal;
    }

    public void setLinkLocal(String linkLocal) {
        this.linkLocal = linkLocal;
    }

    public String getNameVisit() {
        return nameVisit;
    }

    public void setNameVisit(String nameVisit) {
        this.nameVisit = nameVisit;
    }

    public String getPhotoVisit() {
        return photoVisit;
    }

    public void setPhotoVisit(String photoVisit) {
        this.photoVisit = photoVisit;
    }

    public String getScoreVisit() {
        return scoreVisit;
    }

    public void setScoreVisit(String scoreVisit) {
        this.scoreVisit = scoreVisit;
    }

    public String getLinkVisit() {
        return linkVisit;
    }

    public void setLinkVisit(String linkVisit) {
        this.linkVisit = linkVisit;
    }

    public String getStateMatch() {
        return stateMatch;
    }

    public void setStateMatch(String stateMatch) {
        this.stateMatch = stateMatch;
    }

    public String getResultTeam() {
        return resultTeam;
    }

    public void setResultTeam(String resultTeam) {
        this.resultTeam = resultTeam;
    }

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }
}
