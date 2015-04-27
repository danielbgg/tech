package br.com.danielbgg.tech.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackExample {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("br.com.danielbgg.tech.logback.LogbackExample");
		logger.debug("Hello world.");

		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
	}

}
