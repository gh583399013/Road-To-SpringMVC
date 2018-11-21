package com.ft.devPlugins.service;

import com.ft.devPlugins.entity.Language;

public interface LanguageService {
	public int saveLanguage(Language language);
	public int persistLanguageWithException(Language language) throws Exception;
	public int saveLanguageWithException(Language language) throws Exception;
}
