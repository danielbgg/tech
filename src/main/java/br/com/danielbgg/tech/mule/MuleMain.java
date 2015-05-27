package br.com.danielbgg.tech.mule;

import org.mule.MuleServer;

public class MuleMain {

	public static void main(String[] args) throws Exception {
		MuleServer.main(new String[] { "-config", "mule-local.xml" });
	}
	
}
