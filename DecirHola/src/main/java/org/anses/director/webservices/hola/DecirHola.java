package org.anses.director.webservices.hola;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;

@WebService
public class DecirHola {
	
	@WebMethod
	public String hola(@WebParam(name="nombre", mode=Mode.IN) String nombre){
		System.out.println("*****name " +  nombre);
		return "Hola " + nombre + "!";
	}
}
