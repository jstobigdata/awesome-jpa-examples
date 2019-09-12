package example03.embeddedId;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "my_students")
public class MyStudent {

    @EmbeddedId
    private PKStudent compId;

    private String email;

    private String name;

    //Must have empty constructor
    public MyStudent() {
    }

    public MyStudent(PKStudent compId, String email, String name) {
        this.compId = compId;
        this.email = email;
        this.name = name;
    }

    public PKStudent getCompId() {
        return compId;
    }

    public void setCompId(PKStudent compId) {
        this.compId = compId;
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
        MyStudent myStudent = (MyStudent) o;
        return Objects.equals(compId, myStudent.compId) &&
                Objects.equals(email, myStudent.email) &&
                Objects.equals(name, myStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compId, email, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyStudent.class.getSimpleName() + "[", "]")
                .add("compId=" + compId)
                .add("email='" + email + "'")
                .add("name='" + name + "'")
                .toString();
    }
}

