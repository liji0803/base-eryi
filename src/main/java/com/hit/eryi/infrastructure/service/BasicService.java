package com.hit.eryi.infrastructure.service;//package com.hit.eryi.infrastructure.service;
//
//import com.chehejia.framework.beans.model.page.PageParam;
//import com.chehejia.framework.beans.model.page.PageResult;
//import com.chehejia.framework.persistence.domain.BaseDomain;
//import tk.mybatis.mapper.entity.Example;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author SongJian
// * Created by SongJian at 2018/4/17.
// */
//public interface BasicService<E extends BaseDomain<K>, K extends Serializable> {
//
//    E get(K id);
//
//    /**
//     * <p>保存实体对象 </p>
//     *
//     * @param entity 实体对象
//     */
//    void save(E entity);
//
//    /**
//     * <p>方法描述</p>
//     *
//     * @param entityList 实体对象列表，selective
//     * @return 保存成功数目
//     */
//    int save(Collection<E> entityList);
//
//    /**
//     * <p>方法描述</p>
//     *
//     * @param entityList 实体对象列表，非selective
//     * @return 保存成功数目
//     */
//    int saveBatch(List<E> entityList);
//
//    /**
//     * <p> 更新实体，空值会用Null覆盖数据库中得值 </p>
//     *
//     * @param object 实体
//     */
//    int updateByPrimaryKey(E object);
//
//    /**
//     * 更新实体，以主键确定记录，只更新非空的值，需要设空得操作请使用updateByPrimaryKey
//     *
//     * @param e 实体
//     * @return 更新记录数
//     */
//    int updateByPrimaryKeySelective(E e);
//
//    int delete(K id);
//
//    int delete(List<E> objectlist);
//
//    int delete(E e);
//
//    //TODO 若数据库内有多条符合条件的数据，会抛出异常，需外部处理
//    E get(E domain);
//
//    E getByExample(Example example);
//
//    //TODO 增加动态指定所需列的方法，提高性能
//
//    /**
//     * <p> 分页查询实体对象（通过Entity） </p>
//     *
//     * @param pp
//     * @return PageResults
//     */
//    PageResult<E> queryPageResults(PageParam<E> pp);
//
//    PageResult<E> queryPageResults(PageParam pp, Example example);
//
//    /**
//     * @param e
//     * @return
//     */
//    List<E> find(E e);
//
//    //TODO 注释补全
//    int selectCount(E e);
//
//    int selectCount(Example example);
//
//    boolean exists(E e);
//
//    /**
//     * 根据Example查询条件查询
//     *
//     * @param example 查询条件
//     * @return 记录列表
//     */
//    List<E> find(Example example);
//
//
//    int updateByExampleSelective(E record, Example example);
//
//    /**
//     * 用提供的记录中的值，更新Example查询条件匹配的记录，包括空值
//     *
//     * @param record  更新值
//     * @param example 查询条件
//     * @return 更新的记录数
//     */
//    int updateByExample(E record, Example example);
//
//    /**
//     * 列出全部记录，适合记录较少的表
//     *
//     * @return 全部记录集合
//     */
//    List<E> listAll();
//
//}
