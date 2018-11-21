package com.ft.devPlugins.dao.impl;

import com.ft.devPlugins.dao.LanguageDao;
import com.ft.devPlugins.entity.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("languageDaoImpl")
public class LanguageDaoImpl extends BaseDaoImpl<Language> implements LanguageDao{

	@Override
	public List<Language> getList(int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithException(Language language) throws Exception {
		super.insert(language);
		throw new Exception("error occured!");
	}
	
}
