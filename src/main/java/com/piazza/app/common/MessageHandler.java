package com.piazza.app.common;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageHandler {
	private static MessageSourceAccessor messageSourceAccessor = null;

	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		MessageHandler.messageSourceAccessor = messageSourceAccessor;
	}

	public static MessageSourceAccessor getMessageSourceAccessor() {
		return MessageHandler.messageSourceAccessor;
	}

	public static Integer getInteger(String code) {
		String userMessage = messageSourceAccessor.getMessage(code);
		return Integer.parseInt(userMessage);
	}

	public static String getMessage(String code) {
		String userMessage = messageSourceAccessor.getMessage(code);
		return userMessage;
	}

	public static String getMessage(String code, Locale locale) {

		String userMessage = messageSourceAccessor.getMessage(code, locale);
		return userMessage;
	}
}
