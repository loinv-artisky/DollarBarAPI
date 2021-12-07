package com.artisky.dollarbarapi.repositories;

import com.artisky.dollarbarapi.entities.DollarBarEntity;
import com.artisky.dollarbarapi.entities.ids.DollarBarEntityId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DollarBarRepository extends CrudRepository<DollarBarEntity, DollarBarEntityId> {

    @Query(nativeQuery = true, name = "DollarBar.5min.getFromTimeToTime")
    public List<DollarBarEntity> findDollarBar5MinFromTimeToTime(String symbol, long startTime, long endTime);

}
