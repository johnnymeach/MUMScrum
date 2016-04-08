
package org.mum.scrum.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
		"org.mum.scrum" }, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {
				"org.mum.scrum.web.*" }))
@PropertySource(value = { "classpath:application.properties" })

public class AppConfig {
}
