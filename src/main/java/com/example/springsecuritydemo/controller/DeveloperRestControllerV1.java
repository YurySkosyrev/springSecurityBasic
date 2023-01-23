package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.entity.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> Developers = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Sergey", "Sergeev"),
            new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return Developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return Developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        this.Developers.add(developer);
        return developer;
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @DeleteMapping({"/{id}"})
    public void deleteByID(@PathVariable Long id){
        this.Developers.removeIf(developer -> developer.getId().equals(id));
    }

}

