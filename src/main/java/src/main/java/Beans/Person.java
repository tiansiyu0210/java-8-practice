/**
 * Created by stian on 4/6/18.
 */
package src.main.java.Beans;

import java.util.Objects;

/**
 * Created by stian on 4/6/18.
 */
public class Person {

    private String firstName;
    private String LastName;
    private int age;
    private Gender gender;
    private boolean isMarry = false;

    public enum Gender {
        MALE, FEMALE
    }

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        LastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean marry) {
        isMarry = marry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                isMarry == person.isMarry &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(LastName, person.LastName) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, age, gender, isMarry);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", isMarry=" + isMarry +
                '}';
    }
}
