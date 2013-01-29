package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.Profile;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.net.URI;


public class ProfileImpl implements Profile {
    DateTimeFormatter birthdayFormatter = DateTimeFormat.forPattern("EEE, d MMM YYYY HH:mm:ss");

    @JsonCreator
    public ProfileImpl(@JsonProperty("birthday") final String birthday,
                       @JsonProperty("location") final String location,
                       @JsonProperty("name") final String name,
                       @JsonProperty("elite") final boolean elite,
                       @JsonProperty("gender") final String gender,
                       @JsonProperty("athlete_type") final String athleteType,
                       @JsonProperty("profile") final URI profileURI,
                       @JsonProperty("normal_picture") final URI normalPictureURI,
                       @JsonProperty("medium_picture") final URI mediumPictureURI,
                       @JsonProperty("small_picture") final URI smallPictureURI,
                       @JsonProperty("large_picture") final URI largePictureURI) {
        this.birthday = birthdayFormatter.parseDateTime(birthday);
        this.location = location;
        this.name = name;
        isElite = elite;
        this.gender = gender;
        this.athleteType = athleteType;
        this.profileURI = profileURI;
        this.normalPictureURI = normalPictureURI;
        this.mediumPictureURI = mediumPictureURI;
        this.smallPictureURI = smallPictureURI;
        this.largePictureURI = largePictureURI;
    }

    private final DateTime birthday;
    private final String location;
    private final String name;
    private final boolean isElite;
    private final String gender;
    private final String athleteType;
    private final URI profileURI;
    private final URI normalPictureURI;
    private final URI mediumPictureURI;
    private final URI smallPictureURI;
    private final URI largePictureURI;

    @Override
    public DateTime getBirthday() {
        return birthday;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isElite() {
        return isElite;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getAthleteType() {
        return athleteType;
    }

    @Override
    public URI getProfile() {
        return profileURI;
    }

    @Override
    public URI getSmallPicture() {
        return smallPictureURI;
    }

    @Override
    public URI getNormalPicture() {
        return normalPictureURI;
    }

    @Override
    public URI getMediumPicture() {
        return mediumPictureURI;
    }

    @Override
    public URI getLargePicture() {
        return largePictureURI;
    }

    @Override
    public String toString() {
        return "ProfileImpl{" +
                "birthday=" + birthday +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", isElite=" + isElite +
                ", gender='" + gender + '\'' +
                ", athleteType='" + athleteType + '\'' +
                ", profileURI=" + profileURI +
                ", normalPictureURI=" + normalPictureURI +
                ", mediumPictureURI=" + mediumPictureURI +
                ", smallPictureURI=" + smallPictureURI +
                ", largePictureURI=" + largePictureURI +
                '}';
    }
}
