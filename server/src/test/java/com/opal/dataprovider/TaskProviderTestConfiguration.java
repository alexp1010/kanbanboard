package com.opal.dataprovider;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
class TaskProviderTestConfiguration {

    @Bean
    @Primary
    public TaskProvider taskProvider() {
        return Mockito.mock(TaskProvider.class);
    }
}