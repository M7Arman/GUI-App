package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Arman Kostandyan
 */
public class User {

    private StringProperty id;
    private StringProperty fullName;
    private IntegerProperty age;
    private StringProperty email;

    /**
     * Default constructor.
     */
    public User() {
        this(null, null, 0, null);
    }

    private User(String id, String fullName, int age, String email) {
        this.id = new SimpleStringProperty(id);
        this.fullName = new SimpleStringProperty(fullName);
        this.age = new SimpleIntegerProperty(age);
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public static ObservableList<User> dummyUser() {
        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("user_1", "John Doe", 20, "john.doe@gmail.com"));
        users.add(new User("user_2", "George A. Mackay", 16, "GeorgeAMackay@inbound.plus"));
        users.add(new User("user_3", "Timothy B. Walker", 35, "TimothyBWalker@inbound.plus"));
        users.add(new User("user_4", "Noah F. Damgaard", 24, "NoahFDamgaard@inbound.plus"));
        users.add(new User("user_5", "Haakon Høiland", 15, "HaakonHiland@inbound.plus"));
        users.add(new User("user_6", "Makar Woronoff", 20, "MakarWoronoff@inbound.plus"));

        return users;
    }
}
