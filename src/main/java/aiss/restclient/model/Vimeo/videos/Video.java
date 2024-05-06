
package aiss.restclient.model.Vimeo.videos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import aiss.restclient.model.Vimeo.caption.Caption;
import aiss.restclient.model.Vimeo.comments.Comment;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("created_time")
    private String createdTime;

    private List<Caption> captions;

    private List<Comment> comments;

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }



    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
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

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n   uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append("\n   name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append("\n   description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append("\n   createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append("\n   captions");
        sb.append('=');
        sb.append(((this.captions == null)?"<null>":this.captions));
        sb.append("\n   comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append("\n,");
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
