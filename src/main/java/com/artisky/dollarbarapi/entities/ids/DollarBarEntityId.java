package com.artisky.dollarbarapi.entities.ids;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class DollarBarEntityId implements Serializable {
    private Long time;
    private String symbol;
}
