package example02;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "institutes")
@Access(AccessType.FIELD)
public class Institute implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String instituteName;

    private String shortName;

    private String instituteCode;

    private String email;

    @Column(name = "phoneNumber")
    private String contactNumber;

    @OneToMany
    private Set<Department> departments = new HashSet<>(0);

    @OneToOne(cascade = CascadeType.REMOVE)
    private SocialProfile socialProfile;

    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdTimestamp;

    private LocalDateTime updatedTimestamp;

    //No-arg constructor
    public Institute(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getInstituteCode() {
        return instituteCode;
    }

    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public SocialProfile getSocialProfile() {
        return socialProfile;
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        this.socialProfile = socialProfile;
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
        return new StringJoiner(", ", Institute.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("instituteName='" + instituteName + "'")
                .add("shortName='" + shortName + "'")
                .add("instituteCode='" + instituteCode + "'")
                .add("email='" + email + "'")
                .add("contactNumber='" + contactNumber + "'")
                .add("socialProfile=" + socialProfile)
                .add("createdTimestamp=" + createdTimestamp)
                .add("updatedTimestamp=" + updatedTimestamp)
                .toString();
    }
}
