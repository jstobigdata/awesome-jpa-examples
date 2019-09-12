package example03.embeddedId.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Embeddable
public class PKSystemUser implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private SubSystem subSystem;

    private String username;

    public PKSystemUser() {
    }

    public PKSystemUser(SubSystem subSystem, String username) {
        this.subSystem = subSystem;
        this.username = username;
    }

    public SubSystem getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(SubSystem subSystem) {
        this.subSystem = subSystem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PKSystemUser that = (PKSystemUser) o;
        return Objects.equals(subSystem, that.subSystem) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subSystem, username);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PKSystemUser.class.getSimpleName() + "[", "]")
                .add("subSystem=" + subSystem)
                .add("username='" + username + "'")
                .toString();
    }
}
