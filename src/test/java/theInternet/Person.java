package theInternet;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    /**
     * Create Element with below information
     LastName	FirstName	Email	Due	WebSite	Action
     */

    private String lastName;
    private String firstName;
    private String email;
    private Float due;
    private String website;

}
