package main.java.mock_frontend.user.sub_menu;

/**
 * FRONTEND CLASS
 *
 * Class contains pseudocode for the request submission option.
 *
 * Created by skeane on 3/10/2023.
 */
public class RequestCreator {

    // Displays the input fields for creating a request.

    //          1. Select vehicle from list stored in database.
    //              a. Make call to database (Required info: User ID).
    //              b. Show options in a dropdown.
    //          2. Enter pickup time.
    //              a. Enter time using calendar function.                              Calendar Function Reasoning: Prevents incorrect formatting of time by user.
    //          3. Enter pickup location.
    //              a. Two options:
    //                  - Immediate location using GPS.                                 GPS Reasoning: Simpler for user, can decrease user error.
    //                  - Enter address input as String.                                String Reasoning: Allows for a different location.
    //                      - Include basic checks for address (ex. not empty).
    //          4. Enter destination.
    //              a. Make call to database (Required info: User ID).
    //              b. Display saved locations.
    //              c. Show "Other" option.
    //                  - "Other" option should allow for address input as String.      "Other" Option Reasoning: Allows for an unsaved location.
    //                      - Include basic checks for address (ex.not empty).
    //          5. Select company to submit it.
    //              a. Make call to database.
    //              b. Display options in a dropdown.

    // After inputting all fields, check should be in place to confirm no fields are empty. Won't let user proceed if fields
    // are empty.
    // If all fields are populated, create a Request object and call the database to save it.

    // Page will now display request status and inputted information.
    // Will update with company/driver contact information if company accepts request.
    //          1. Will need to call service, to check on status.
    //              a. Determine a refresh rate.
    // Will also display a "CANCEL" button to cancel the request.
    //          1. Will need option to call service, to cancel request.

}
