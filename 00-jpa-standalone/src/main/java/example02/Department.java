package example02;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Initialized to 0 to avoid NullPointerException.
     */
    @Id
    @GeneratedValue
    private Long id = 0L;

    private String deptName;

    private String shortName;

    private String deptCode;

    private String description;

    @OneToOne
    private SocialProfile socialProfile;

    @ManyToOne
    private Institute institute;

    private LocalDateTime createdTimestamp;

    private LocalDateTime updatedTimestamp;

    // No argument constructor
    public Department(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SocialProfile getSocialProfile() {
        return socialProfile;
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        this.socialProfile = socialProfile;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Department.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deptName='" + deptName + "'")
                .add("shortName='" + shortName + "'")
                .add("deptCode='" + deptCode + "'")
                .add("description='" + description + "'")
                .add("socialProfile=" + socialProfile)
                .add("createdTimestamp=" + createdTimestamp)
                .add("updatedTimestamp=" + updatedTimestamp)
                .toString();
    }
}
