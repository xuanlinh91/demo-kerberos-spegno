package jp.co.ntt.common.repository.spectification;

import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import org.springframework.data.jpa.domain.Specification;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class AccountingReportSpecs implements SearchableSpec{
    private AccountingReportSpecs(){}
    public static Specification<AccountingReportEntity> hasReportId(Integer reportId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("reportId"), reportId);
    }

    public static Specification<AccountingReportEntity> hasSubReportNo(Integer subReportNo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("subReportNo"), subReportNo);
    }

    public static Specification<AccountingReportEntity> hasFiscalPeriod(String fiscalPeriod) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("fiscalPeriod"), fiscalPeriod);
    }

    public static Specification<AccountingReportEntity> notDeleted() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("deleteDatetime"));
    }

    public static Specification<AccountingReportEntity> getDefaultSpecs(Integer reportId, Integer subReportNo, String fiscalPeriod, Integer version) {
//        Todo catch NullPointerException here
        Specification<AccountingReportEntity> specification = Specification
                .where(hasReportId(reportId))
                .and(hasSubReportNo(subReportNo))
                .and(notDeleted());
        if (fiscalPeriod != null) specification = specification.and(hasFiscalPeriod(fiscalPeriod));
        if (version != null) specification = specification.and(hasVersion(version));

        return specification;
    }

    public static Specification<AccountingReportEntity> hasVersion(Integer version) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("version"), version);
    }
}
