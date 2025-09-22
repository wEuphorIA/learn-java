package com.itheima.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().info(
                new Info()
                        .title("后台管理系统API")
                        .version("1.0")
                        .description("后台管理系统API"));
    }

    @Bean
    public GroupedOpenApi systemAPI() {

        return GroupedOpenApi.builder().group("部门信息管理").
                pathsToMatch(
                        "/depts/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi clazzAPI() {

        return GroupedOpenApi.builder().group("班级信息管理").
                pathsToMatch(
                        "/clazzs/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi empAPI() {

        return GroupedOpenApi.builder().group("员工信息管理").
                pathsToMatch(
                        "/emps/**"
                ).
                build();
    }

    // @Bean
    // public GroupedOpenApi loginAPI() {
    //
    //     return GroupedOpenApi.builder().group("后台登录管理").
    //             pathsToMatch(
    //                     "/admin/login/**",
    //                     "/admin/info"
    //             ).
    //             build();
    // }

    // @Bean
    // public GroupedOpenApi apartmentAPI() {
    //
    //     return GroupedOpenApi.builder().group("公寓信息管理").
    //             pathsToMatch(
    //                     "/admin/apartment/**",
    //                     "/admin/room/**",
    //                     "/admin/label/**",
    //                     "/admin/facility/**",
    //                     "/admin/fee/**",
    //                     "/admin/attr/**",
    //                     "/admin/payment/**",
    //                     "/admin/region/**",
    //                     "/admin/term/**",
    //                     "/admin/file/**"
    //             ).build();
    // }
    // @Bean
    // public GroupedOpenApi leaseAPI() {
    //     return GroupedOpenApi.builder().group("租赁信息管理").
    //             pathsToMatch(
    //                     "/admin/appointment/**",
    //                     "/admin/agreement/**"
    //             ).build();
    // }
    // @Bean
    // public GroupedOpenApi userAPI() {
    //     return GroupedOpenApi.builder().group("平台用户管理").
    //             pathsToMatch(
    //                     "/admin/user/**"
    //             ).build();
    // }
}