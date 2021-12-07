package com.artisky.dollarbarapi.controllers;

import com.artisky.dollarbarapi.entities.DollarBarEntity;
import com.artisky.dollarbarapi.repositories.DollarBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DollarBarController {
    @Autowired
    DollarBarRepository dollarBarRepository;

    @GetMapping("/ohclv")
    public List<Object> getDollarBarFromTimeToTime(String symbol, long startTime, long endTime, int interval){
        List<DollarBarEntity> dollarBarEntityList = null;
        if(interval == 5) {
            dollarBarEntityList = dollarBarRepository.findDollarBar5MinFromTimeToTime(symbol, startTime, endTime);
        }
        return generateReturn(dollarBarEntityList);
    }

    public List<Object> generateReturn(List<DollarBarEntity> dollarBarEntityList){
        List<Object> returnList = new ArrayList<>();
        for (var entity: dollarBarEntityList) {
            List<Object> values = new ArrayList<>();
            values.add(entity.getTime());
            values.add(entity.getOpen());
            values.add(entity.getHigh());
            values.add(entity.getLow());
            values.add(entity.getClose());
            values.add(entity.getVolume());
            returnList.add(values);
        }
        return returnList;
    }

}
