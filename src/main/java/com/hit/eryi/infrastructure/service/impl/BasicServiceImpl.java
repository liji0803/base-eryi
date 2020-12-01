package com.hit.eryi.infrastructure.service.impl;//package com.hit.eryi.infrastructure.service.impl;
//
//import com.chehejia.framework.beans.model.page.PageParam;
//import com.chehejia.framework.beans.model.page.PageResult;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.hit.eryi.infrastructure.persistence.BasicMapper;
//import com.hit.eryi.infrastructure.persistence.domain.BaseDomain;
//import com.hit.eryi.infrastructure.service.BasicService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import tk.mybatis.mapper.entity.Example;
//
//import java.beans.PropertyDescriptor;
//import java.io.Serializable;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author SongJian
// * Created by SongJian at 2018/4/17.
// */
//public class BasicServiceImpl<E extends BaseDomain<K>, K extends Serializable> implements BasicService<E, K> {
//
//    @Autowired(required = false)
//    private BasicMapper<E> mapper;
//
//    private Class<E> entityClass;
//
//    @SuppressWarnings("unchecked")
//    public BasicServiceImpl() {
//
//        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
//        Type genType = getClass().getGenericSuperclass();
//
//        while (!(genType.getTypeName().equals("java.lang.Object"))) {
//            if (genType instanceof ParameterizedType) {
//                //返回表示此类型实际类型参数的 Type 对象的数组。
//                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//                if (params.length > 1) {
//                    if (params[0] instanceof Class) {
//                        entityClass = (Class<E>) params[0];
//                    }
//                    break;
//                }
//            } else {
//                genType = ((Class) genType).getGenericSuperclass();
//            }
//        }
//    }
//
//    @Override
//    public E get(K pk) {
//        return mapper.selectByPrimaryKey(pk);
//    }
//
//    @Override
//    public E get(E e) {
//        return mapper.selectOne(e);
//    }
//
//    @Override
//    public E getByExample(Example example) {
//        List<E> list = mapper.selectByExample(example);
//        if (list != null && list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void save(E e) {
//        mapper.insertSelective(e);
//    }
//
//    @Override
//    public int save(Collection<E> entityList) {
//        if (entityList == null || entityList.size() == 0) {
//            return 0;
//        } else {
//            return (int) entityList.parallelStream()
//                    .map(mapper::insertSelective)
//                    .filter(i -> i > 0).count();
//        }
//    }
//
//    @Override
//    public int saveBatch(List<E> entityList) {
//        if (entityList == null || entityList.size() == 0) {
//            return 0;
//        }
//        return mapper.insertList(entityList);
//    }
//
//    @Override
//    public int updateByPrimaryKey(E e) {
//        return mapper.updateByPrimaryKey(e);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(E e) {
//        return mapper.updateByPrimaryKeySelective(e);
//    }
//
//    @Override
//    public PageResult<E> queryPageResults(PageParam<E> pp) {
//        //RowBounds rb = new RowBounds();
//        int pageNum = pp.getPageNo();
//        int pageSize = pp.getPageSize();
//        //前置处理
//
//        //TODO 最多一次返回100条记录
//        if (pageSize > 100) {
//            pageSize = 100;
//        }
//
//        List<E> results;
//
//        PageHelper.startPage(pageNum, pageSize);
//        E pm = pp.getParam();
//        if (entityClass != null) {
//            Example example = new Example(entityClass);
//            Example.Criteria criteria = example.createCriteria();
//            PropertyDescriptor[] propArray = BeanUtils.getPropertyDescriptors(entityClass);
//            for (PropertyDescriptor pd : propArray) {
//                if (pd.getPropertyType().equals(Class.class)) {
//                    continue;
//                }
//                try {
//                    Object value = pd.getReadMethod().invoke(pm);
//                    if (value != null) {
//                        criteria.andEqualTo(pd.getName(), value);
//                    }
//                } catch (IllegalAccessException | InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (StringUtils.hasText(pp.getOrderBy())) {
//                example.setOrderByClause(pp.getOrderBy() + (pp.isAsc() ? " ASC" : " DESC"));
//            }
//            results = mapper.selectByExample(example);
//        } else {
//            results = mapper.select(pp.getParam());
//        }
//        //List<E> results = mapper.selectByRowBounds(pp.getPm(),rb);
//        Page page = (Page) results;
//        return PageResult.<E>builder()
//                .pageNo(page.getPageNum())
//                .pageSize(page.getPageSize())
//                .totalCount(page.getTotal())
//                .pageCount((long) page.getPages())
//                .results(results)
//                .build();
//    }
//
//    @Override
//    public PageResult<E> queryPageResults(PageParam pp, Example example) {
//        //RowBounds rb = new RowBounds();
//        int pageNum = pp.getPageNo();
//        int pageSize = pp.getPageSize();
//        //前置处理
//
//        //TODO 最多一次返回100条记录
//        if (pageSize > 100) {
//            pageSize = 100;
//        }
//
//        PageHelper.startPage(pageNum, pageSize);
//        List<E> results = mapper.selectByExample(example);
//        PageResult<E> pr = new PageResult<>();
//        Page page = (Page) results;
//        return PageResult.<E>builder()
//                .pageNo(page.getPageNum())
//                .pageSize(page.getPageSize())
//                .totalCount(page.getTotal())
//                .pageCount((long) page.getPages())
//                .results(results)
//                .build();
//    }
//
//    @Override
//    public List<E> find(E e) {
//        return mapper.select(e);
//    }
//
//    @Override
//    public int delete(K id) {
//        return mapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public int delete(List<E> objectlist) {
//        if (objectlist == null) {
//            return 0;
//        }
//        int rows = 0;
//        //TODO 批量删除的效率不见的比较高
//        for (E e : objectlist) {
//            rows += delete(e);
//        }
//        return rows;
//    }
//
//    @Override
//    public int delete(E e) {
//        return mapper.delete(e);
//    }
//
//    @Override
//    public boolean exists(E e) {
//        int count = mapper.selectCount(e);
//        return count > 0;
//    }
//
//    @Override
//    public List<E> find(Example example) {
//        return mapper.selectByExample(example);
//    }
//
//    @Override
//    public int selectCount(E e) {
//        return mapper.selectCount(e);
//    }
//
//    @Override
//    public int selectCount(Example example) {
//        return mapper.selectCountByExample(example);
//    }
//
//    @Override
//    public int updateByExampleSelective(E record, Example example) {
//        return mapper.updateByExampleSelective(record, example);
//    }
//
//    @Override
//    public List<E> listAll() {
//        try {
//            return mapper.select(entityClass.newInstance());
//        } catch (InstantiationException | IllegalAccessException e) {
//            return new ArrayList<>(0);
//        }
//    }
//
//    @Override
//    public int updateByExample(E record, Example example) {
//        return mapper.updateByExample(record, example);
//    }
//}
