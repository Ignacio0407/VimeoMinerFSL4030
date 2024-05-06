package aiss.restclient.controller;

import aiss.restclient.model.Vimeo.channel.VimeoChannel;
import aiss.restclient.service.VimeoService;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apipath")
public class VimeoController {

    //@Autowired
    VimeoService vimeoService = new VimeoService();

    // POST http://localhost:8080/apipath/{id}

    @GetMapping("/{id}")
    public VimeoChannel findOne(@PathVariable String id){
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        return vimeoService.getChannels(token,id);
    }

    @PostMapping("/{id}")
    public VimeoChannel post(@PathVariable String id) {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        VimeoChannel channel = vimeoService.getChannels(token,id);
        return new VimeoChannel(channel.getName(), channel.getDescription(), channel.getCreatedTime(), new ArrayList<>());
    }
}
