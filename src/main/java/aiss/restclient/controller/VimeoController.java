package aiss.restclient.controller;

import aiss.restclient.model.VideoMiner.Channel;
import aiss.restclient.model.VideoMiner.Comment;
import aiss.restclient.model.VideoMiner.User;
import aiss.restclient.model.Vimeo.channel.VimeoChannel;
import aiss.restclient.service.VimeoService;
import aiss.restclient.model.VideoMiner.Video;
import aiss.restclient.model.VideoMiner.Caption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/apipath")
public class VimeoController {

    //@Autowired
    VimeoService vimeoService = new VimeoService();

    @Autowired
    RestTemplate restTemplate;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/channels")
    public List<Channel> post() {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        List<VimeoChannel> channels = vimeoService.getAllChannels(token);
        List<Channel> res = new ArrayList<>();
        channels.forEach(vimeoChannel -> {
            Channel newChannel = new Channel();
            newChannel.setId(vimeoChannel.getUri().replace("/channels/", ""));
            newChannel.setName(vimeoChannel.getName());
            newChannel.setDescription(vimeoChannel.getDescription());
            newChannel.setCreatedTime(vimeoChannel.getCreatedTime());
            if (vimeoChannel.getVideos() != null && !vimeoChannel.getVideos().isEmpty()) {
                vimeoChannel.getVideos().forEach(vimeoVideo -> {
                    Video vid = new aiss.restclient.model.VideoMiner.Video();
                    vid.setId(vimeoVideo.getUri().replace("/videos/", ""));
                    vid.setName(vimeoVideo.getName());
                    if (vimeoVideo.getDescription() != null) {
                        vid.setDescription(vimeoVideo.getDescription().toString());
                    }
                    vid.setReleaseTime(vimeoVideo.getCreatedTime());
                    vid.setCaptions(new ArrayList<>());
                    if (vimeoVideo.getCaptions() != null && !vimeoVideo.getCaptions().isEmpty()) {
                        vimeoVideo.getCaptions().forEach(vimeoCaption -> {
                            Caption cap = new aiss.restclient.model.VideoMiner.Caption();
                            cap.setId(vimeoCaption.getUri().replace("/captions/", ""));
                            cap.setLanguage(vimeoCaption.getLanguage());
                            cap.setName(vimeoCaption.getName());
                            vid.getCaptions().add(cap);
                        });
                    }
                    vid.setComments(new ArrayList<>());
                    if(vimeoVideo.getComments() != null && !vimeoVideo.getComments().isEmpty()) {
                        vimeoVideo.getComments().forEach(vimeoComment -> {
                            Comment com = new Comment();
                            User user = new User();
                            com.setId(vimeoComment.getUri().replace("/comments/", ""));
                            com.setText(vimeoComment.getText());
                            user.setName(vimeoComment.getUser().getName());
                            user.setUser_link(vimeoComment.getUser().getLink());
                            user.setPicture_link(vimeoComment.getUser().getPictures().getBaseLink());
                            com.setAuthor(user);
                            vid.getComments().add(com);
                        });
                    }
                    newChannel.getVideos().add(vid);
                });
                res.add(newChannel);
                restTemplate.postForObject("http://localhost:8080/videominer/channels", newChannel, Channel.class);
            }
        });
        return res;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/channels/{id}")
    public Channel post(@PathVariable String id) {
        Channel VideoChannel = new Channel();
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        VimeoChannel vimeoChannel = vimeoService.getChannels(token, id);
        Channel newChannel = new Channel();
        newChannel.setId(vimeoChannel.getUri().replace("/channels/", ""));
        newChannel.setName(vimeoChannel.getName());
        newChannel.setDescription(vimeoChannel.getDescription());
        newChannel.setCreatedTime(vimeoChannel.getCreatedTime());
        if (vimeoChannel.getVideos() != null && !vimeoChannel.getVideos().isEmpty()) {
            vimeoChannel.getVideos().forEach(vimeoVideo -> {
                Video vid = new aiss.restclient.model.VideoMiner.Video();
                vid.setId(vimeoVideo.getUri().replace("/videos/", ""));
                vid.setName(vimeoVideo.getName());
                if (vimeoVideo.getDescription() != null) {
                    vid.setDescription(vimeoVideo.getDescription().toString());
                }
                vid.setReleaseTime(vimeoVideo.getCreatedTime());
                vid.setCaptions(new ArrayList<>());
                if (vimeoVideo.getCaptions() != null && !vimeoVideo.getCaptions().isEmpty()) {
                    vimeoVideo.getCaptions().forEach(vimeoCaption -> {
                        Caption cap = new Caption();
                        cap.setId(vimeoCaption.getUri().replace("/captions/", ""));
                        cap.setLanguage(vimeoCaption.getLanguage());
                        cap.setName(vimeoCaption.getName());
                        vid.getCaptions().add(cap);
                    });
                }
                vid.setComments(new ArrayList<>());
                if(vimeoVideo.getComments() != null && !vimeoVideo.getComments().isEmpty()) {
                    vimeoVideo.getComments().forEach(vimeoComment -> {
                        Comment com = new Comment();
                        User user = new User();
                        com.setId(vimeoComment.getUri().replace("/comments/", ""));
                        com.setText(vimeoComment.getText());
                        user.setName(vimeoComment.getUser().getName());
                        user.setUser_link(vimeoComment.getUser().getLink());
                        user.setPicture_link(vimeoComment.getUser().getPictures().getBaseLink());
                        com.setAuthor(user);
                        vid.getComments().add(com);
                    });
                }
                newChannel.getVideos().add(vid);
            });
            VideoChannel = restTemplate.postForObject("http://localhost:8080/videominer/channels", newChannel, Channel.class);
        }
        return VideoChannel;
    }
}
