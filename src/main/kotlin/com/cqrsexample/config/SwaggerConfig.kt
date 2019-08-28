package com.cqrsexample.config

import com.google.common.base.Predicates
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.*
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Autowired
    lateinit var build: Optional<BuildProperties>


    @Bean
    open fun api(): Docket {
        var version = "1.0"

        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//<6>, regex must be in double quotes.

                .build();
    }

    @Bean
    open fun uiConfig(): UiConfiguration {
        return UiConfiguration(java.lang.Boolean.TRUE, java.lang.Boolean.FALSE, -1, -1, ModelRendering.MODEL, java.lang.Boolean.FALSE, DocExpansion.LIST, java.lang.Boolean.FALSE, null, OperationsSorter.ALPHA, java.lang.Boolean.FALSE, TagsSorter.ALPHA, UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, null)
    }

    private fun apiInfo(version: String): ApiInfo {
        return ApiInfoBuilder()
                .title("API - Todo Service")
                .description("Transaction Management")
                .version(version)
                .build()
    }

}