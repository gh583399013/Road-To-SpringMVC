package com.ft.devPlugins.dao;

import java.util.List;

public interface BaseDao<T> {
	public int insert(T t);
	public int update(T t);
	public int get(String id);
	public int delete(T t);
	public int remove(String id);
	public List<T> getList(int page, int pageSize);
}
