
package aiss.restclient.model.Vimeo.caption;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoCaptions {

    @JsonProperty("data")
    private List<Caption> caption;

    @JsonProperty("data")
    public List<Caption> getCaption() {
        return caption;
    }

    @JsonProperty("data")
    public void setCaption(List<Caption> caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VimeoCaptions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("caption");
        sb.append('=');
        sb.append(((this.caption == null)?"<null>":this.caption));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
