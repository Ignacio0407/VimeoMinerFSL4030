
package aiss.restclient.model.Vimeo.caption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Caption {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("display_language")
    private String language;
    @JsonProperty("name")
    private String name;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("display_language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("display_language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append("\n       language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append("\n       name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
