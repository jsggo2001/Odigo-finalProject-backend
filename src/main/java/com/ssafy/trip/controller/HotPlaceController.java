package com.ssafy.trip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotplace")
public class HotPlaceController {

    @GetMapping
    protected String index() throws Exception {
        return "true";
    }
}
