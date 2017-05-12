package com.censhare.model;

import com.censhare.utils.BuildStatus;
import lombok.Data;

/**
 * Created by oku-ext on 5/12/17.
 */
@Data
public class TeamcityBuild {

    private String projectId;
    private String name;
    private BuildStatus status;

    public TeamcityBuild(String projectId, String name, BuildStatus status) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
    }
}
