package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.trip.model.dao.TravelDao;
import com.ssafy.trip.model.dto.Gugun;
import com.ssafy.trip.model.dto.Sido;
import com.ssafy.trip.model.dto.Spot;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/travel")
//@CrossOrigin(origins = "http://127.0.0.1:9000")
public class TravelController {

    private final TravelDao travelDao;

    public TravelController(TravelDao travelDao) {
        super();
        this.travelDao = travelDao;
    }

    @GetMapping("/spot")
    @ResponseBody
    private ResponseEntity<List<Spot>> getTravel(int sido, int gugun, int category, String keyWord) throws Exception {
        Map<String, String> map = new HashMap<>();
        if (sido != 0) map.put("sido_code", String.valueOf(sido));
        if (gugun != 0) map.put("gugun_code", String.valueOf(gugun));
        if (category != 0) map.put("content_type_id", String.valueOf(category));
        map.put("keyword", String.valueOf(keyWord));

        List<Spot> list = travelDao.getTravelList(map);
        return new ResponseEntity<List<Spot>>(list, HttpStatus.OK);
    }

    @GetMapping("/gugun/{sido}")
    @ResponseBody
    private List<Gugun> getGugun(@PathVariable String sido) throws Exception {
        List<Gugun> list = travelDao.getGugunList(sido);
        return list;
    }

    @GetMapping("/sido")
    @ResponseBody
    private List<Sido> getSido() throws Exception {
        List<Sido> list = travelDao.getSidoList();
        return list;
    }

    @GetMapping("/searchTravel")
    private String getsearchTravel(HttpServletRequest req, HttpServletResponse resp) {
        return "searchTravel";
    }
}
