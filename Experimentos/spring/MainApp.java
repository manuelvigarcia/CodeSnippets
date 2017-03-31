/**
 * MainApp.java 03/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package es.training.experimentos.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 03/05/2016
 *
 */
public class MainApp {

    /**
     * 
     *
     * @param args
     */
    public static void main(final String[] args) {
        final ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        final HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
}
