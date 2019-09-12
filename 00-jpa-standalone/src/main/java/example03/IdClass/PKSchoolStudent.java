package example03.IdClass;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class PKSchoolStudent implements Serializable {

    private String className;

    private String rollNumber;

    private Long registrationId;

    private PKSchoolStudent() {
    }

    public PKSchoolStudent(String className, String rollNumber, Long registrationId) {
        this.className = className;
        this.rollNumber = rollNumber;
        this.registrationId = registrationId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PKSchoolStudent that = (PKSchoolStudent) o;
        return Objects.equals(className, that.className) &&
                Objects.equals(rollNumber, that.rollNumber) &&
                Objects.equals(registrationId, that.registrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, rollNumber, registrationId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PKSchoolStudent.class.getSimpleName() + "[", "]")
                .add("className='" + className + "'")
                .add("rollNumber='" + rollNumber + "'")
                .add("registrationId=" + registrationId)
                .toString();
    }
}
