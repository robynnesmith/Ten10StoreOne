package pageObjects;

import java.util.Random;

public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String invalidEmail;
    private String password;
    private String invalidPassword;
    private String birthdate;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String phoneNumber;
    private String aliasName;

    public PersonalDetails(String firstName, String lastName, String email, String invalidEmail, String password, String invalidPassword, String birthDate, String address, String city, String state, String postcode, String phoneNumber, String aliasName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.invalidEmail = invalidEmail;
        this.password = password;
        this.invalidPassword = invalidPassword;
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

    public String getFirstName(String nameType) {
        if (nameType.equals("numeric")) {
            return "123";
        }
        return null;
    }

    public String getPassword(String passwordType) {
        if (passwordType.equals("numeric")) {
            return "1234";
        }
        return null;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail(String emailType) {
        if (emailType.equals("registered")) {
            return email;
        } else if (emailType.equals("unregistered")) {
            return generateRandomEmailAddress();
        }
        return null;
    }

    private String generateRandomEmailAddress() {
        Random random = new Random();
        int randomNumber = random.nextInt();
        return "testsherwood+" + randomNumber + "@nest.com";
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidPassword(){
        return invalidPassword;
    }

    public String getBirthdate(){
        return birthdate;
    }

    public String getBirthdate(String birthdateType) {
        if (birthdateType.equals("invalid")) {
            return "1234";
        }
        return null;
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