package com.ssafy.trip.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ssafy.trip.model.dto.Gugun;
import com.ssafy.trip.model.dto.Sido;
import com.ssafy.trip.model.dto.Spot;

@Mapper
@Repository
public interface TravelDao {

	public List<Spot> getTravelList(Map<String,String> map);

	@Cacheable(value = "TravelCache")
	public List<Spot> redis();

	public List<Spot> noRedis();

	public List<Gugun> getGugunList(String sido);
	
	public List<Sido> getSidoList();
}
