package com.hit.eryi.infrastructure.persistence;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * Copyright © 2018 CHJ Automotive
 *
 * @author sunzhichao
 * @since 18/5/21 上午10:23
 */
public class UpdateByRecordProvider extends MapperTemplate {

    public UpdateByRecordProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String updateByRecordSelective(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, "record", true, isNotEmpty()));
        sql.append(whereAllIfColumns(entityClass)); //不允许更新条件为空或"" ！！！
        return sql.toString();
    }


    public String whereAllIfColumns(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<where>");
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        //当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnList) {
            sql.append(SqlHelper.getIfNotNull("example", column, " AND " + column.getColumnEqualsHolder("example"), true));
        }
        sql.append("</where>");
        return sql.toString();
    }
}
