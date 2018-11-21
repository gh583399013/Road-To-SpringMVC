package com.ft.devPlugins.service.impl.hibernate;

import com.ft.devPlugins.dao.LanguageDao;
import com.ft.devPlugins.entity.Language;
import com.ft.devPlugins.service.LanguageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class LanguageServiceImpl implements LanguageService {
	@Resource(name = "languageDaoImpl")
	private LanguageDao languageDao;

	@Override
	public int saveLanguage(Language language) {
		languageDao.insert(language);
		return 0;
	}

	@Override
	public int saveLanguageWithException(Language language) throws Exception {
		languageDao.insertWithException(language);
		return 0;
	}	
	
	@Override
	@Transactional(rollbackFor={Exception.class})
	public int persistLanguageWithException(Language language) throws Exception {
		languageDao.insertWithException(language);
		return 0;
	}

}
