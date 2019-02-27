package com.qijia.app.mybatis.plus.spring.boot.autoconfigure;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by weichen on 2018/9/28.
 */

@Configuration
@ConditionalOnProperty(name = "app-mybatis-plus-enable", havingValue = "true")
@ConfigurationProperties(prefix = "mybatis-plus")
public class AppMybatisPlusConfig implements EnvironmentAware {

	public static final String MAPPER_BASE_PACKAGE = "mybatis-plus.scanner-mapper-base-package";

	private String mapperBasePackage;

	@Override
	public void setEnvironment(Environment environment) {
		this.mapperBasePackage = environment.getProperty(MAPPER_BASE_PACKAGE);
	}

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;

	}

	/**
	 * SQL打印插件
	 */
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		// 日志方式打印
//		performanceInterceptor.setWriteInLog(true);
		return performanceInterceptor;
	}

	/**
	 * 扫码Mapper
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
		scannerConfigurer.setBasePackage(mapperBasePackage);
		return scannerConfigurer;
	}
}
