package com.ssafy.trip.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.trip.model.dao.TravelDao;
import com.ssafy.trip.model.dto.Gugun;
import com.ssafy.trip.model.dto.Sido;
import com.ssafy.trip.model.dto.Spot;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/travel")
public class TravelController {

	private final TravelDao travelDao;
	
	

	public TravelController(TravelDao travelDao) {
		super();
		this.travelDao = travelDao;
	}

	@GetMapping("/spot")
	@ResponseBody
	private ResponseEntity<List<Spot>> getTravel(@RequestParam Map<String,String> map) throws Exception {
		map.forEach((a,b) -> System.out.println(a + " " + b));
		List<Spot> list = travelDao.getTravelList(map);
		return new ResponseEntity<List<Spot>>(list, HttpStatus.OK);
	}

	@GetMapping("/gugun")
	@ResponseBody
	private List<Gugun> getGugun(@RequestParam String sido) throws Exception {
		List<Gugun> list = travelDao.getGugunList(sido);
		System.out.println(list);
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
