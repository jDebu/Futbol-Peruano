package jdebu.github.io.futbolperuano.domain.model;

import java.io.Serializable;

/**
 * Created by jose on 19/04/2017.
 */

public class Team implements Serializable{
    private String name;
    private String photo;
    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
