package example02;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "socialProfiles")
public class SocialProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id = 0L;

    /**
     * URL Link to home page web site.
     */
    private String homePageUrl;

    /**
     * Link to Facebook page.
     */
    private String facebookProfileLink;

    /**
     * Link to Twitter page.
     */
    private String twitterProfileLink;

    /**
     * Link to Linkedin page.
     */
    private String linkedinProfileLink;

    /**
     * Link to Pintrest page.
     */
    private String pintrestProfileLink;

    /**
     * Link to Google-plus page.
     */
    private String googlePlusProfileLink;


    /**
     * Audit trail.
     */
    private LocalDateTime createdTimestamp;

    private LocalDateTime updatedTimestamp;

    public SocialProfile(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getFacebookProfileLink() {
        return facebookProfileLink;
    }

    public void setFacebookProfileLink(String facebookProfileLink) {
        this.facebookProfileLink = facebookProfileLink;
    }

    public String getTwitterProfileLink() {
        return twitterProfileLink;
    }

    public void setTwitterProfileLink(String twitterProfileLink) {
        this.twitterProfileLink = twitterProfileLink;
    }

    public String getLinkedinProfileLink() {
        return linkedinProfileLink;
    }

    public void setLinkedinProfileLink(String linkedinProfileLink) {
        this.linkedinProfileLink = linkedinProfileLink;
    }

    public String getPintrestProfileLink() {
        return pintrestProfileLink;
    }

    public void setPintrestProfileLink(String pintrestProfileLink) {
        this.pintrestProfileLink = pintrestProfileLink;
    }

    public String getGooglePlusProfileLink() {
        return googlePlusProfileLink;
    }

    public void setGooglePlusProfileLink(String googlePlusProfileLink) {
        this.googlePlusProfileLink = googlePlusProfileLink;
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
        return new StringJoiner(", ", SocialProfile.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("homePageUrl='" + homePageUrl + "'")
                .add("facebookProfileLink='" + facebookProfileLink + "'")
                .add("twitterProfileLink='" + twitterProfileLink + "'")
                .add("linkedinProfileLink='" + linkedinProfileLink + "'")
                .add("pintrestProfileLink='" + pintrestProfileLink + "'")
                .add("googlePlusProfileLink='" + googlePlusProfileLink + "'")
                .add("createdTimestamp=" + createdTimestamp)
                .add("updatedTimestamp=" + updatedTimestamp)
                .toString();
    }
}
