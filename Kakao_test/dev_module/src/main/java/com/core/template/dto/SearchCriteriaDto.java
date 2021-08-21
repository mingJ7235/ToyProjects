package com.core.template.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static org.springframework.util.StringUtils.isEmpty;

@Getter
@NoArgsConstructor
public class SearchCriteriaDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private String search;

    public void setSdate (String sdate)  {
        setStartDate(sdate);
    }

    public void setEdate (String edate) {
        setEndDate(edate);
    }

    public void setStartDate (String startDate) {
        if (isEmpty(startDate)) return;
        try {
            this.startDate = LocalDate.parse(startDate);
        } catch (Exception e) {
            this.startDate = LocalDate.now().minusMonths(1);
        }
    }

    public void setEndDate (String endDate) {
        if(isEmpty(endDate)) return;
        try {
            this.endDate = LocalDate.parse(endDate);
        } catch (Exception e) {
            this.endDate = LocalDate.now();
        }
    }

    public void setSearch (String search) {
        if (isEmpty(search)) {
            this.search = "all";
        } else {
            this.search = search;
        }
    }
}
