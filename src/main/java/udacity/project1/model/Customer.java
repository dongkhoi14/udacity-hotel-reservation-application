package udacity.project1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (emailValidation(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Wrong email format: " + email);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Customer Name : " + firstName + " " + lastName + " ,Email : " + email +"\n";
    }

    private boolean emailValidation(String email) {
        var EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
