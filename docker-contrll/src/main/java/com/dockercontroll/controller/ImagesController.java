package com.dockercontroll.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dockercontroll.service.DockerService;
import com.github.dockerjava.api.model.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    
    private final DockerService dockerService;

    public ImagesController(DockerService dockerService){
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Image> listImages(){
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> getImageByName(@RequestParam(required = false, defaultValue = "image-") String filterName){
        return dockerService.filterImages(filterName);
    }

}
