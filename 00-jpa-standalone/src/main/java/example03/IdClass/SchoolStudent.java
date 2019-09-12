package example03.IdClass;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "school_students")
@IdClass(PKSchoolStudent.class)
public class SchoolStudent {

    @Id
    private String className;

    @Id
    private String rollNumber;

    @Id
    @GeneratedValue
    private Long registrationId;

    private String email;

    private String name;

    //Must have empty constructor
    public SchoolStudent() {
    }

    public SchoolStudent(String className, String rollNumber, String email, String name) {
        this.className = className;
        this.rollNumber = rollNumber;
        this.email = email;
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolStudent that = (SchoolStudent) o;
        return Objects.equals(className, that.className) &&
                Objects.equals(rollNumber, that.rollNumber) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(email, that.email) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, rollNumber, registrationId, email, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SchoolStudent.class.getSimpleName() + "[", "]")
                .add("className='" + className + "'")
                .add("rollNumber='" + rollNumber + "'")
                .add("registrationId=" + registrationId)
                .add("email='" + email + "'")
                .add("name='" + name + "'")
                .toString();
    }
}

