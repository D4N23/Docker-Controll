package com.dockercontroll.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dockercontroll.service.DockerService;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/container")
public class ContainerController {
    
     private final DockerService dockerService;

    public ContainerController(DockerService dockerService){
        this.dockerService = dockerService;
    }

    @GetMapping("/filter")
    public List<Container> getContainerByName(@RequestParam(required = false, defaultValue = "true") Boolean showAll){
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id) {
       dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id) {
       dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable String id) {
       dockerService.deleteContainer(id);;
    }

    @PostMapping("")
    public void createContainer(@RequestParam String imageName) {
       dockerService.createContainer(imageName);
    }
    
}
