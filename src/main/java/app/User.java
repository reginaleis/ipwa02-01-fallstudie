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
    private Role role;

    public User(String firstName, String lastName, Role role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

}
