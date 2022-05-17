package com.zhonglv.benchmarking.config;

import com.fasterxml.classmate.TypeResolver;
import com.zhonglv.benchmarking.domain.entity.po.single.LowExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author yangj
 */
@EnableOpenApi
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    private final TypeResolver typeResolver;

    @Value("${spring.application.name}")
    private String name;

    @Bean
    public Docket createRestApi() {
        //swagger设置，基本信息，要解析的接口及路径等
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.zhonglv.benchmarking.controller"))
                //接口URI路径设置，any是全路径，也可以通过PathSelectors.regex()正则匹配
                .paths(PathSelectors.any())
                .build()
                .groupName(name)
                .additionalModels(typeResolver.resolve(SuperExcelPo.class),
                        typeResolver.resolve(MediumExcelPo.class),
                        typeResolver.resolve(LowExcelPo.class));
    }

    //生成接口信息，包括标题、联系人，联系方式等
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档-benchmarking")
                .description("如有疑问，请联系开发工程师")
                .contact(new Contact("zhonglv", "", ""))
                .version("1.0")
                .build();
    }
}
