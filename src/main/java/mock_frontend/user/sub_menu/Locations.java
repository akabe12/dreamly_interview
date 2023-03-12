package main.java.mock_frontend.user.sub_menu;

/**
 * FRONTEND CLASS
 *
 * Class contains pseudocode for the saved locations view option.
 *
 * Created by skeane on 3/10/2023.
 */
public class Locations {

    // Displays all saved locations in an interact-able table format.
    //          1. Make service call
    //              a. REST service call:           /location/view/{id}
    //                  - "id" in the REST call is that of the internal user ID used in the database.
    //                  - REST service class is located under: main/java/service_system/support/LocationController.java
    //          2. Selecting a location will allow for modification or deletion.
    //              a. Modification shows all fields.
    //              b. Option to cancel or save.
    //                  - Cancel: Go back to table view.
    //                  - Save: Call database/service.
    //          3. At the bottom of the table there should be an option to add a location.
    //              a. Option should only appear if max number of locations has not been hit.
    //              b. Option to cancel or save.
    //                  - Cancel: Go back to table view.
    //                  - Save: Call database/service.

}
