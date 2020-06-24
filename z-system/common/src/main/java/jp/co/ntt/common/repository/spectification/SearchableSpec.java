package jp.co.ntt.common.repository.spectification;

import org.springframework.data.jpa.domain.Specification;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public interface SearchableSpec {
    static <T> Specification<T> hasColumnEqual(String column, Object value) {
        return (root, query, criteriaBuilder) -> {
            if (root.get(column).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.get(column), "%" + value + "%");
            } else if(isNumeric(value)){
                return criteriaBuilder.equal(root.get(column), value);
            } else return null;
        };
    }
}
