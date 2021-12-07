package com.artisky.dollarbarapi.entities;

import com.artisky.dollarbarapi.entities.ids.DollarBarEntityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@Setter
@IdClass(DollarBarEntityId.class)
public class DollarBarEntity {
    @Id
    private Long time;
    @Id
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
}
