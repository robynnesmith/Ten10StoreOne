package pageObjects;

public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String invalidEmail;
    private String password;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String phoneNumber;
    private String aliasName;

    public PersonalDetails(String firstName, String lastName, String email, String invalidEmail, String password, String address, String city, String state, String postcode, String phoneNumber, String aliasName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.invalidEmail = invalidEmail;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.aliasName = aliasName;
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

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAliasName() {
        return aliasName;
    }
}