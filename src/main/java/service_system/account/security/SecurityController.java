package main.java.service_system.account.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * Rest service controller for all service calls related to account security actions.
 *
 * Created by skeane on 3/10/2023.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    /**
     *
     */
    @GetMapping()
    public boolean validatePass() {

    }

    /**
     *
     */
    @GET()
    public boolean initializeAccount() {

    }


    /**
     *
     */
    @GET()
    public void deleteUser() {}


}
