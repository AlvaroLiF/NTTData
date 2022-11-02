package com.nttdata.tomcat;

/**
 * Formación - Apache Tomcat - JSP - Taller
 * 
 * Primer JSP
 * 
 * @author NTT Data
 *
 */
public class NTTDataJSP {
	
	/**
	 * Constructor privado
	 */
	private NTTDataJSP() {
		
	}
	
	/**
	 * Saludo mediante JSP.
	 * 
	 * @param name
	 * @return String
	 */
	public static String helloNTTData(final String name) {
		return "Bienvenid@s al proyecto FP DUAL " + name;
	}
	
}
