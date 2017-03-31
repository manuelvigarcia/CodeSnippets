/**
 * HelloWorld.java 03/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package es.training.experimentos.spring;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 03/05/2016
 *
 */
public class HelloWorld {
    private String message;

    public void setMessage(final String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + this.message);
    }
}
