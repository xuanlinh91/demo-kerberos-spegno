package jp.co.ntt.common.config;

import jp.co.ntt.common.dto.mapper.UnacceptedReportMappingBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    public Mapper getMapper(){
        return DozerBeanMapperBuilder.create()
                .withMappingBuilder(new UnacceptedReportMappingBuilder())
                .build();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
