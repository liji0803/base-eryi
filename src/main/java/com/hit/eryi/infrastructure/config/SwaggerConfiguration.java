package com.hit.eryi.infrastructure.config;

import com.hit.eryi.common.consts.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

/**
 * Swagger 通用配置
 */
@Slf4j
@Configuration
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfiguration {

    @Value("${swagger.title}")
    private String swaggerTitle;

    @Value("${swagger.description}")
    private String swaggerDescription;

    @Value("${swagger.terms-of-servic-url}")
    private String termsOfServiceUrl;

    @Value("${swagger.contact.name}")
    private String swaggerContactName;

    @Value("${swagger.contact.url}")
    private String swaggerContactUrl;

    @Value("${swagger.contact.email}")
    private String swaggerContactEmail;

    @Value("${swagger.license}")
    private String swaggerLicense;

    @Value("${swagger.license-url}")
    private String swaggerLicenseUrl;

    @Value("${swagger.version}")
    private String swaggerVersion;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerTitle)
                .description(swaggerDescription)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(swaggerContactName, swaggerContactUrl, swaggerContactEmail))
                .license(swaggerLicense)
                .licenseUrl(swaggerLicenseUrl)
                .version(swaggerVersion)
                .build();
    }

    @Bean
    public Docket init() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hit.eryi"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.OPTIONS, extractStatusCodes())
                .alternateTypeRules(new AlternateTypeRule[0])
                .forCodeGeneration(false);
    }

    private List<ResponseMessage> extractStatusCodes() {
        final LinkedList<ResponseMessage> list = new LinkedList<>();
        for (StatusCode sc : StatusCode.values()) {
            final ResponseMessageBuilder builder = new ResponseMessageBuilder();
            final ResponseMessage message = builder
                    .code(sc.getCode())
                    .message(sc.getMessage())
                    .build();
            list.add(message);
        }
        return list;
    }
}
