package com.core.template.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SearchCriteriaDto {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String search;

    public void setSdate (String sdate)  {

    }

    public void setEdate (String edate) {

    }
}
