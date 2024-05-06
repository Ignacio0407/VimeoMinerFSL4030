
package aiss.restclient.model.Vimeo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pictures {

    @JsonProperty("base_link")
    private String baseLink;

    @JsonProperty("base_link")
    public String getBaseLink() {
        return baseLink;
    }

    @JsonProperty("base_link")
    public void setBaseLink(String baseLink) {
        this.baseLink = baseLink;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(((this.baseLink == null)?"<null>":this.baseLink));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
