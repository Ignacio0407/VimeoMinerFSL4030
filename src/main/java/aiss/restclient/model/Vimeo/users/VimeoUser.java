
package aiss.restclient.model.Vimeo.users;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoUser {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("pictures")
    private Pictures pictures;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("pictures")
    public Pictures getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append("\n           name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append("\n           link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append("\n           createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append("\n           pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
