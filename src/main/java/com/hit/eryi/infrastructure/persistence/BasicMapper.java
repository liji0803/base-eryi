package com.hit.eryi.infrastructure.persistence;

import com.hit.eryi.infrastructure.persistence.domain.BaseDomain;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface BasicMapper<E extends BaseDomain> extends Mapper<E>, MySqlMapper<E>, UpdateByRecordMapper<E> {

}
