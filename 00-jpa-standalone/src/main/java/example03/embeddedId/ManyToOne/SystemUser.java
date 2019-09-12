package example03.embeddedId.ManyToOne;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class SystemUser {

    @EmbeddedId
    private PKSystemUser pk;

    private String description;

    public SystemUser() {
    }

    public SystemUser(PKSystemUser pk, String name) {
        this.pk = pk;
        this.description = name;
    }

    public PKSystemUser getPk() {
        return pk;
    }

    public void setPk(PKSystemUser pk) {
        this.pk = pk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemUser that = (SystemUser) o;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SystemUser.class.getSimpleName() + "[", "]")
                .add("pk=" + pk)
                .add("name='" + description + "'")
                .toString();
    }
}
