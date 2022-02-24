package com.xay.xmlapp;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * @author v_vyqyxiong
 */
public class XmlApplicationContextTest {

	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		Connector conn = new Connector();
		conn.setPort(80);
		tomcat.setConnector(conn);

		Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());
		ctx.addApplicationListener("org.springframework.web.context.ContextLoaderListener");
		ctx.addParameter("contextConfigLocation","classpath:com/xay/xmlapp/spring-application.xml");

		Wrapper mvc = tomcat.addServlet("", "mvc", "org.springframework.web.servlet.DispatcherServlet");
		mvc.addMapping("/");
		mvc.addInitParameter("contextConfigLocation","classpath:com/xay/xmlapp/spring-mvc.xml");

		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
