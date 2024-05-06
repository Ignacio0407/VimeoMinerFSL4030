package aiss.restclient.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.restclient.model.Vimeo.channel.VimeoChannel;
import aiss.restclient.model.Vimeo.videos.VimeoVideos;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VimeoServiceTest {

    //@Autowired
    VimeoService service = new VimeoService();

    @Test
    @DisplayName("Get channels")
    void getChannels() {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        String id = "988576";
        VimeoChannel channels = service.getChannels(token, id);
        assertNotNull(channels, "The channels are null");
        System.out.println(channels);
    }

    @Test
    @DisplayName("Get videos")
    void getVideos() {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        String videosUri = "https://api.vimeo.com/videos/136262971";
        VimeoVideos videos = service.getVideos(token, videosUri);
        assertNotNull(videos, "The videos are null");
        System.out.println(videos);
    }

    public static void main(String[] args) {
        VimeoServiceTest v = new VimeoServiceTest();
        v.getChannels();
    }
}