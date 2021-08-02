package com.kakao.provider;

import com.kakao.dto.DataDto;

public interface DataProvider {

    public DataDto getDataDto (Long memberId);
}
