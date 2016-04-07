/**
 * 
 */
package org.mum.scrum.web.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * @author Sam
 * 
 */
@Configuration
@ComponentScan(basePackages={"org.mum.scrum"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
	}

	
//   Remember to disable (or never enable) configureDefaultServletHandling in whatever class you have that extends 
//	WebMvcConfigurerAdapter or an exception will never be thrown for unmapped URLs, and hence can never be
//	caught by this method. Technically I suppose all URLs are effectively mapped by 
	//** if you do enable this setting
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
//	{
//		configurer.enable();
//	}
	

//		auto add csrf token to <form:form>
	@Bean
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new CsrfRequestDataValueProcessor();
    }
	
//	Message source for this context, loaded from localized "messages_xx" files.
//  Files are stored inside src/main/resources
	@Bean 
	public ReloadableResourceBundleMessageSource messageSource(){
	    ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
	    reloadableResourceBundleMessageSource.setBasename("classpath:/messages/messages");
	    return reloadableResourceBundleMessageSource;
	}
//	@Bean(name = "validator")
//	public LocalValidatorFactoryBean validator()
//	{
//	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource());
//	    return bean;
//	}
//	@Bean(name = "messageSource")
//	public MessageSource configureMessageSource()
//	{
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:messages");
//		messageSource.setCacheSeconds(5);
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
	{
		SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("org.springframework.dao.DataAccessException", "error");
		b.setExceptionMappings(mappings);
		return b;
	}
//	apache tiles
	@Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);            
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }
	@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                "/WEB-INF/defs/general.xml"                
        });
        tilesConfigurer.setCheckRefresh(true);        
        return tilesConfigurer;
    }
	
//	@Bean
//	public ViewResolver resolver()
//	{
//		InternalResourceViewResolver url = new InternalResourceViewResolver();
//		url.setPrefix("/views/");
//		url.setSuffix(".jsp");
//		return url;
//	}
//	@Override
//    public void configureMessageConverters( List<HttpMessageConverter<?>> converters ) {
//        converters.add(converter());
//    }
//    @Bean
//    MappingJackson2HttpMessageConverter converter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        //do your customizations here...
//        return converter;
//    }
}