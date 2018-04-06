package src.main.java.BuilderPattern;

/**
 * Created by siyu on 5/3/2017.
 */
public class User {

    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    //The User constructor is private, which means that this class can not be directly instantiated from the client code.
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //The class is immutable. All attributes are final and they’re set on the constructor. Additionally, we only provide getters for them.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        //The builder constructor only receives the required attributes and this attributes are the only ones that are defined “final”
        // on the builder to ensure that their values are set on the constructor.
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() throws IllegalStateException{
            User user = new User(this);
            if (user.getAge() > 120) {
                throw new IllegalStateException("Age out of range"); // thread-safe
            }
            return user;
        }

    }

}
