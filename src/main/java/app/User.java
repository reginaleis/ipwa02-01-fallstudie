package app;

import java.util.List;

public class User {

    enum Role{
        TESTER,
        TESTMANAGER,
        REQ_ENGINEER
    }

    private String firstName;
    private String lastName;
    private List<Role> roles;

    public User(String firstName, String lastName, List<Role> roles){
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

}
