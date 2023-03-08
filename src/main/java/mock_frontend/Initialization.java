package mock_frontend;

/**
 * FRONTEND CLASS
 *
 * Class contains pseudocode for the initialization page.
 *
 * Created by skeane on 3/10/2023.
 */
public class Initialization {

    // Upon first opening the application, displays two options:
    //          - USER
    //          - COMPANY

    // USER OPTION
    // Two options:
    //          1. Login.
    //              a. Call service to verify login information.
    //                  - If successful, continue to the User MainMenu page.
    //                  - If failed, go back to Login page.
    //              b. If login was successful, also call service to grab ID of the user associated with the username.
    //                  - Save ID locally.
    //          2. Create account.
    //              a. Page to input all required user information.
    //                  - Check to see if all fields are populated before proceeding.
    //              b. Create new User object and call service to save to database.
    //                  - Service will check validity of submitted information (no duplicates)
    //                  - If successful, call service to grab ID of the user associated with the username and save ID locally.
    //                  - If failed, go back to Create Account page.

    // COMPANY OPTION
    //          1. Login.
    //              a. Call service to verify login information.
    //                  - If successful, continue to the Company MainMenu page.
    //                  - If failed, go back to Login page.
    //              b. If login was successful, also call service to grab ID of the company associated with the username.
    //                  - Save ID locally.
    //          2. Create account.
    //              a. Page to input all required company information.
    //                  - Check to see if all fields are populated before proceeding.
    //              b. Create new Company object and call service to save to database.
    //                  - Service will check validity of submitted information (no duplicates)
    //                  - If successful, call service to grab ID of the company associated with the username and save ID locally.
    //                  - If failed, go back to Create Account page.

}
