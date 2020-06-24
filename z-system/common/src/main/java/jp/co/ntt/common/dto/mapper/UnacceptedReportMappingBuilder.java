package jp.co.ntt.common.dto.mapper;

import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedReport;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;

public class UnacceptedReportMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(AccountingReportEntity.class, UnacceptedReport.class, TypeMappingOptions.oneWay())
                .fields("remarks3", "slipCreator")
                .fields("remarks1", "slipType")
                .fields("remarks2", "nameCode");
    }
}
