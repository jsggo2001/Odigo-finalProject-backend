package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.model.dto.Gugun;
import com.ssafy.trip.model.dto.Sido;
import com.ssafy.trip.model.dto.Spot;

public interface TravelService {

	List<Sido> getsidoList();

	List<Gugun> getGugunList(String sido);

	List<Spot> getTravelList(Map<String,String> map);

}