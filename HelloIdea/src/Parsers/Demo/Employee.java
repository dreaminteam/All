package Parsers.Demo;

/**
 * Created by dreaminteam on 17.12.14.
 */

class Employee {

    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + id + ")" + location;
    }
}
