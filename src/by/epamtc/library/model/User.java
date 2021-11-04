package by.epamtc.library.model;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (firstName == null) {
            if (user.firstName != null) return false;
        } else if (!firstName.equals(user.firstName)) return false;
        if (lastName == null) {
            if (user.lastName != null) return false;
        } else if (!lastName.equals(user.lastName)) return false;
        if (login == null) {
            if (user.login != null) return false;
        } else if (!login.equals(user.login)) return false;
        if (password == null) {
            if (user.password != null) return false;
        } else if (!password.equals(user.password)) return false;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
