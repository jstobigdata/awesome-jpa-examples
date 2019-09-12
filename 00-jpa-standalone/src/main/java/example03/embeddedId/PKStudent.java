package example03.embeddedId;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Embeddable
public class PKStudent implements Serializable {

    private String className;

    private String rollNumber;

    private PKStudent(){}

    public PKStudent(String className, String rollNumber){
        this.className = className;
        this.rollNumber = rollNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PKStudent pkStudent = (PKStudent) o;
        return Objects.equals(className, pkStudent.className) &&
                Objects.equals(rollNumber, pkStudent.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, rollNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PKStudent.class.getSimpleName() + "[", "]")
                .add("className='" + className + "'")
                .add("rollNumber='" + rollNumber + "'")
                .toString();
    }
}
