package com.censhare.controller;

import com.censhare.model.TeamcityBuild;
import com.censhare.model.TeamcityProject;
import com.censhare.service.MockData;
import com.censhare.utils.UserAction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by oku-ext on 5/11/17.
 */
@Controller
public class ChecksController {

    private static final Logger log = Logger.getLogger(ChecksController.class.getName());

    private RestTemplate restTemplate;
    private List<TeamcityProject> projects;
    private List<TeamcityBuild> builds;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    @ModelAttribute("projects")
    public List<TeamcityProject> populateProjects() {
        return getTeamcityProjects();
    }

    @ModelAttribute("builds")
    public List<TeamcityBuild> populateBuilds() {
        return getTeamcityBuilds();
    }

    @RequestMapping({"/", "/projects"})
    public String loadPage() {
        return "checks";
    }

    @RequestMapping(method = POST, value = "/build/{id}")
    public void handleUserAction(@RequestParam("action") UserAction action) {
        switch (action) {

            case MERGE:
                // merge branches through git API
                break;
            case UPDATE:
                // update branch through git API
                break;
        }

    }

    @Scheduled(fixedDelay = 1000)
    private List updateBuildStatuses(List<TeamcityBuild> builds) {

        String buildsFromTeamcity = restTemplate.getForObject("https://build-server.censhare.com/guestAuth/app/rest/builds/{N1 - Nn}", String.class);

        // parse builds xml string and return List

        return builds;
    }

    private List getTeamcityProjects() {

//        String teamcityProjects = restTemplate.getForObject("https://build-server.censhare.com/guestAuth/app/rest/projects", String.class);

        // parse projects xml string and return List


        return MockData.getProjects();
    }

    private List getTeamcityBuilds() {

//        String teamcityBuilds = restTemplate.getForObject("https://build-server.censhare.com/guestAuth/app/rest/builds", String.class);

        // parse projects xml string and return List

        return MockData.getBuilds();
    }
}
