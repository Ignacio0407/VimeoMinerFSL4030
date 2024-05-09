package aiss.restclient.service;

import aiss.restclient.model.caption.Caption;
import aiss.restclient.model.caption.VimeoCaptions;
import aiss.restclient.model.channel.ChannelData;
import aiss.restclient.model.channel.VimeoChannel;
import aiss.restclient.model.comments.Comment;
import aiss.restclient.model.comments.VimeoComments;
import aiss.restclient.model.users.VimeoUser;
import aiss.restclient.model.videos.VimeoVideos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.restclient.model.Vimeo.caption.Caption;
import aiss.restclient.model.Vimeo.caption.VimeoCaptions;
import aiss.restclient.model.Vimeo.channel.VimeoChannel;
import aiss.restclient.model.Vimeo.comments.Comment;
import aiss.restclient.model.Vimeo.comments.VimeoComments;
import aiss.restclient.model.Vimeo.users.VimeoUser;
import aiss.restclient.model.Vimeo.videos.VimeoVideos;

import java.util.ArrayList;
import java.util.List;


@Service
public class VimeoService {
    
    //@Autowired
    RestTemplate restTemplate = new RestTemplate();

    public HttpEntity<VimeoChannel> auth (String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        return new HttpEntity<>(null, headers);
    }

    public List<VimeoChannel> getAllChannels(String token) {
        String uri = "https://api.vimeo.com/channels?per_page=3&sort=followers";
        ResponseEntity<ChannelData> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), ChannelData.class);
        List<VimeoChannel> channels = new ArrayList<>();
        /*
        response.getBody().getData().forEach(channel -> channels.add(getChannels(token, channel.getUri().replace("/channels/",""))));
        */
        response.getBody().getData().forEach(channel -> {
            VimeoVideos vimeoVideos = getVideos(token, channel.getUri()+"/videos");
            channel.setVideos(vimeoVideos.getData());
        });
        return response.getBody().getData();
    }

    public VimeoChannel getChannels(String token, String id) {
        String uri = String.format("https://api.vimeo.com/channels/%s", id);
        ResponseEntity<VimeoChannel> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), VimeoChannel.class);
        String videoUri = response.getBody().getUri() + "/videos";
        response.getBody().setVideos(getVideos(token, videoUri).getData());
        /*
        response.getBody().setUri(response.getBody().getUri().replace("/channels/",""));
        String videoFields = "uri,name,description,created_time,metadata.connections.comments.uri";
        response.getBody().setVideos(getVideos(token,videoFields,response.getBody().getMetadata().getConnections().getVideos().getUri()).getData());
        */
        if(response.getBody().getVideos() == null){
            response.getBody().setVideos(new ArrayList<>());
        }
        return response.getBody();
    }
    public VimeoVideos getVideos(String token, String videosUri) {
        String uri = String.format("https://api.vimeo.com%s?per_page=2&sort=likes", videosUri);
        ResponseEntity<VimeoVideos> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), VimeoVideos.class);
        response.getBody().getData().forEach(video -> {
            String commentUri = video.getUri() + "/comments";
            video.setComments(getComments(token, commentUri));
            String captionUri = video.getUri() + "/texttracks";
            video.setCaptions(getCaptions(token, captionUri));
        });
        return response.getBody();
    }

    public List<Caption> getCaptions(String token, String captionUri){
        String uri = String.format("https://api.vimeo.com%s?per_page=1", captionUri);
        ResponseEntity<VimeoCaptions> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), VimeoCaptions.class);
        return response.getBody().getCaption();
    }

    public List<Comment> getComments(String token, String commentUri){
        String uri = String.format("https://api.vimeo.com%s?per_page=1", commentUri);
        ResponseEntity<VimeoComments> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), VimeoComments.class);
        response.getBody().getComment().forEach(comment -> {
            String userUri = comment.getUser().getUri();
            comment.setUser(getUser(token, userUri));
        });
        return response.getBody().getComment();
    }

    public VimeoUser getUser(String token, String userUri){
        String uri = "https://api.vimeo.com"+userUri;
        ResponseEntity<VimeoUser> response = restTemplate.exchange(uri, HttpMethod.GET, auth(token), VimeoUser.class);
        return response.getBody();
    }
}
