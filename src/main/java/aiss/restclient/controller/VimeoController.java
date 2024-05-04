﻿package aiss.restclient.controller;

import aiss.restclient.model.channel.VimeoChannel;
import aiss.restclient.service.VimeoService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apipath")
public class VimeoController {

    @Autowired
    VimeoService vimeoService;

    // POST http://localhost:8080/apipath/{id}

    @GetMapping("/{id}")
    public VimeoChannel findOne(@PathVariable String id){
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        return vimeoService.getChannels(token,id);
    }

    @PostMapping("/{id}")
    public VimeoChannel create(@PathVariable String id){
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        VimeoChannel channel = vimeoService.getChannels(token,id);
        return new VimeoChannel(channel.getName(), channel.getDescription(), channel.getCreatedTime(), new ArrayList<>());
    }
}
