package com.hit.eryi.infrastructure.persistence;

import tk.mybatis.mapper.entity.SqlsCriteria;
import tk.mybatis.mapper.util.Sqls;

import java.util.Objects;
import java.util.Optional;

/**
 * @author SongJian
 * Created by SongJian at 2018/9/23.
 */
public class ExtSqlsCriteria<T> implements SqlsCriteria {
    private Sqls.Criteria criteria = new Sqls.Criteria();

    public static <T> ExtSqlsCriteria<T> custom() {
        return new ExtSqlsCriteria();
    }

    @Override
    public Sqls.Criteria getCriteria() {
        return criteria;
    }


    public ExtSqlsCriteria<T> andIsNull(String property) {
        this.criteria.getCriterions().add(new Sqls.Criterion(property, "is null", "and"));
        return this;
    }

    public ExtSqlsCriteria<T> andIsNotNull(String property) {
        this.criteria.getCriterions().add(new Sqls.Criterion(property, "is not null", "and"));
        return this;
    }

    public ExtSqlsCriteria<T> andEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "=", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andNotEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<>", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andGreaterThan(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, ">", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andGreaterThanOrEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, ">=", "and"));
        }
        return this;
    }


    public ExtSqlsCriteria<T> andLessThan(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andLessThanOrEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<=", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andIn(String property, Iterable values) {
        if (Objects.nonNull(values)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, values, "in", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andNotIn(String property, Iterable values) {
        if (Objects.nonNull(values)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, values, "not in", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andBetween(String property, Object value1, Object value2) {
        if (Objects.nonNull(value1) || Objects.nonNull(value2)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, Optional.ofNullable(value1).orElse(value2), Optional.ofNullable(value2).orElse(value1), "between", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andNotBetween(String property, Object value1, Object value2) {
        if (Objects.nonNull(value1) || Objects.nonNull(value2)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, Optional.ofNullable(value1).orElse(value2), Optional.ofNullable(value2).orElse(value1), "not between", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andLike(String property, String value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "like", "and"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> andNotLike(String property, String value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "not like", "and"));
        }
        return this;
    }


    public ExtSqlsCriteria<T> orIsNull(String property) {
        this.criteria.getCriterions().add(new Sqls.Criterion(property, "is null", "or"));
        return this;
    }

    public ExtSqlsCriteria<T> orIsNotNull(String property) {
        this.criteria.getCriterions().add(new Sqls.Criterion(property, "is not null", "or"));
        return this;
    }


    public ExtSqlsCriteria<T> orEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "=", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orNotEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<>", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orGreaterThan(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, ">", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orGreaterThanOrEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, ">=", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orLessThan(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orLessThanOrEqualTo(String property, Object value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "<=", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orIn(String property, Iterable values) {
        if (Objects.nonNull(values)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, values, "in", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orNotIn(String property, Iterable values) {
        if (Objects.nonNull(values)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, values, "not in", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orBetween(String property, Object value1, Object value2) {
        if (Objects.nonNull(value1) || Objects.nonNull(value2)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, Optional.ofNullable(value1).orElse(value2), Optional.ofNullable(value2).orElse(value1), "between", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orNotBetween(String property, Object value1, Object value2) {
        if (Objects.nonNull(value1) || Objects.nonNull(value2)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, Optional.ofNullable(value1).orElse(value2), Optional.ofNullable(value2).orElse(value1), "not between", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orLike(String property, String value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "like", "or"));
        }
        return this;
    }

    public ExtSqlsCriteria<T> orNotLike(String property, String value) {
        if (Objects.nonNull(value)) {
            this.criteria.getCriterions().add(new Sqls.Criterion(property, value, "not like", "or"));
        }
        return this;
    }
}
