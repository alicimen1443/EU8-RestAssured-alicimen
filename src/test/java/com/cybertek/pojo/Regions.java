package com.cybertek.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter // from lombok dependency
@Setter // from lombok dependency
@ToString // from lombok dependency
@JsonIgnoreProperties(ignoreUnknown = true) //this is from jackson
public class Regions {

    private List<Region> items;
    private int count;
}
