package com.ft.devPlugins.dao;

import com.ft.devPlugins.entity.Language;

import java.util.List;

public interface LanguageDao extends BaseDao<Language> {
	//下面这六个方法 在底层BaseDao中已经声明 无需重复声明，提高代码复用
//	public int insert(Language language);
//	public int update(Language language);
//	public int get(String id);
//	public int delete(Language language);
//	public int remove(String id);
//	public List<Language> getList(int page,int pageSize);
	public List<Language> getList(int pageSize);
	public void insertWithException(Language language) throws Exception;
}
