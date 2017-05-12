package com.censhare.model;

import lombok.Data;

import java.net.URL;

/**
 * Created by oku-ext on 5/12/17.
 */
@Data
public class TeamcityProject {
    private String id;
    private String name;
    private URL url;

    public TeamcityProject(String id, String name, URL url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
