package jp.co.ntt.common.util;

import jp.co.ntt.common.dto.request.datatable.accounting.Column;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableOrdering;
import jp.co.ntt.common.repository.spectification.SearchableSpec;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public final class SpecUtil {
    private SpecUtil() {}

    public static <V extends Sort> Optional<Sort> andSort(List<V> criteria) {
        Iterator<V> itr = criteria.iterator();
        if (itr.hasNext()) {
            Sort sort = (itr.next());
            while (itr.hasNext() && itr.next() != null) {
                sort = sort.and(itr.next());
            }

            return Optional.of(sort);
        }

        return Optional.empty();
    }

    public static List<Sort> generateSortList(DataTableCriteria dataTableCriteria) {
        List<DataTableOrdering> ordering = dataTableCriteria.getOrder();
        List<Column> columns = dataTableCriteria.getColumns();

        return ordering.stream()
                .filter(item -> columns.get(item.getColumn()).isOrderable() && isNotBlank(columns.get(item.getColumn()).getName()))
                .map(order -> {
                    String columnName = columns.get(order.getColumn()).getName();
                    String sortType = order.getDir();
                    if (sortType.equalsIgnoreCase(DataTableOrdering.ASC)) {
                        return Sort.by(Sort.Order.asc(columnName));
                    } else if (sortType.equalsIgnoreCase(DataTableOrdering.DESC)) {
                        return Sort.by(Sort.Order.desc(columnName));
                    } else return null;
                }).collect(Collectors.toList());
    }

    public static <T> Specification<T> generateSearchSpec(DataTableCriteria dataTableCriteria) {
        String keyword = dataTableCriteria.getSearch().getValue();
        List<Column> columns = dataTableCriteria.getColumns();
        Specification<T> searchCondition = Specification.where(null);
        List<Specification<T>> searchList = columns.stream()
                .filter(column -> column.isSearchable() && isNotBlank(column.getName()))
                .map(column -> {
                    String columnName = column.getName();
                    Specification<T> result = SearchableSpec.hasColumnEqual(columnName, keyword);
                    return result;
                }).collect(Collectors.toList());


        for (Specification<T> item : searchList) {
                searchCondition = searchCondition.or(item);
        }

        return searchCondition;
    }
}
