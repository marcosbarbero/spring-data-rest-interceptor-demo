package com.marcosbarbero.data.config;

import com.marcosbarbero.data.model.Exams;
import com.marcosbarbero.data.repository.ExamsRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class PersistenceConfig implements RepositoryRestConfigurer {

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {

    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.withEntityLookup()
                .forRepository(ExamsRepository.class)
                .withIdMapping(Exams::getCustomerId)
                .withLookup((repository, identifier) -> );
    }

//    @Bean
//    public MappedInterceptor mappedInterceptor() {
//        return new MappedInterceptor(new String[]{"/exams/search/findByCustomerId"}, new DecryptInterceptor());
//    }


    static class DecryptCustomerId {
        public Integer decryptCustomerId(String customerId) {
            if ("abcd".equals(customerId)) {
                return 100;
            }
            return 0;
        }
    }
}
