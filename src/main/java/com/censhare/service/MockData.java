package com.censhare.service;

import com.censhare.model.TeamcityBuild;
import com.censhare.model.TeamcityProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import static com.censhare.utils.BuildStatus.DANGER;
import static com.censhare.utils.BuildStatus.SUCCESS;
import static java.util.Arrays.asList;

/**
 * Created by oku-ext on 5/12/17.
 */
public class MockData {
    private static final Logger log = Logger.getLogger(MockData.class.getName());

    public static List<TeamcityProject> getProjects(){
        URL project1 = null;
        URL project2 = null;
        try {
            project1 = new URL("https://build-server.censhare.com/");
            project2 = new URL("https://build-server.censhare.com/");
        } catch (MalformedURLException e) {
            log.fine(e.getMessage());
        }
        return asList(new TeamcityProject("project1", "project1", project1),
                             new TeamcityProject("project2", "project2", project2));
    }

    public static List<TeamcityBuild> getBuilds(){
        return asList(new TeamcityBuild("project1", "build1", SUCCESS),
                      new TeamcityBuild("project1", "build2", DANGER),
                      new TeamcityBuild("project2", "build3", SUCCESS),
                      new TeamcityBuild("project2", "build4", DANGER));
    }
}
