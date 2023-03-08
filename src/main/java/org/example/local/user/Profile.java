package org.example.local.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private static final Logger logger = LoggerFactory.getLogger(Profile.class);

    private int userId;

    /**
     * List of vehicles owned by the user.
     *
     * Note: Planned to be hard-capped at 3 vehicles, using a list for future expansion.
     */
    private List<Integer> vehicles = new ArrayList<>();

    /**
     * List of saved locations.
     *
     * Note: Planned to be hard-capped at 5 locations, using a list for future expansion.
     */
    private List<Integer> locations = new ArrayList<>();



}
