package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dao.TravelDao;
import com.ssafy.trip.model.dto.Gugun;
import com.ssafy.trip.model.dto.Sido;
import com.ssafy.trip.model.dto.Spot;

@Service
public class TravelServiceImpl implements TravelService {

	private TravelDao travelDao;

	public TravelServiceImpl(TravelDao travelDao) {
		super();
		this.travelDao = travelDao;
	}

	@Override
	public List<Sido> getsidoList()  {
		return travelDao.getSidoList();
	}
	
	@Override
	public List<Gugun> getGugunList(String sido) {
		return travelDao.getGugunList(sido);
	}

	@Override
	public List<Spot> getTravelList(Map<String,String> map) {
		return travelDao.getTravelList(map);
	}

	
}
