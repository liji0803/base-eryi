package com.hit.eryi.infrastructure.persistence;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Copyright © 2018 CHJ Automotive
 *
 * @author sunzhichao
 * @since 18/5/21 上午10:41
 */
public interface UpdateByRecordMapper<T> {

    /**
     * 更新条件更新
     *
     * @param record
     * @param example
     *
     * @return
     */
    @UpdateProvider(type = UpdateByRecordProvider.class, method = "updateByRecordSelective")
    int updateByRecordSelective(@Param("record") T record, @Param("example") T example);

}
