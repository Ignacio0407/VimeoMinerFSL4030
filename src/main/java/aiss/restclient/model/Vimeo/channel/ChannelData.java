package aiss.restclient.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelData {

    @JsonProperty("data")
    private List<VimeoChannel> data;

    @JsonProperty("data")
    public List<VimeoChannel> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<VimeoChannel> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ChannelData [data=" + data + "]";
    }
}
