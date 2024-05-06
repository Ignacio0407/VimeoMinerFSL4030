
package aiss.restclient.model.Vimeo.comments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import aiss.restclient.model.Vimeo.users.VimeoUser;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("text")
    private String text;
    @JsonProperty("created_on")
    private String createdOn;
    @JsonProperty("user")
    private VimeoUser user;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("user")
    public VimeoUser getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(VimeoUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n     uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append("\n       text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append("\n       createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append("\n       user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append("\n,");
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
