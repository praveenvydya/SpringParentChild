package com.vydya.spring.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vydya.child.spring.TestChild;

//@ComponentScan(basePackages= {"com.vydya"})
 
public class VydyaListener implements ServletContextListener {
 
	
	@Autowired
	private TestChild testchild;
	
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	//<bean id="testchild" class="com.vydya.child.spring.TestChild"/>
		/*
		 * TestChild cacheManager =
		 * WebApplicationContextUtils.getRequiredWebApplicationContext(
		 * event.getServletContext()).getBean(TestChild.class);
		 */
    	//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    	 AutowireCapableBeanFactory autowireCapableBeanFactory = WebApplicationContextUtils.
    			 getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory();
         autowireCapableBeanFactory.autowireBean(this);

        System.out.println("The application started");
        
       
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The application stopped");
    }
}