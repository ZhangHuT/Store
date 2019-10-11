package dao;

import java.util.List;

import domain.Store;

//货品的数据库
public interface IStoreDao {
	/**
	 *获取指定id的获货品
	 * @param id 要获取货品的id
	 * @return 若有该货品，返回该货品，没有则返回null
	 */
	Store get(int id);
	
	/**
	 * 返回所有的货品
	 * @return 货品按输入的顺序输出
	 */
	List<Store> list();
	
	/**
	 * 向货品的数据库中添加新的货品
	 * @param obj 添加的货品
	 */
	void save(Store obj);
	
	/**
	 * 删除指定的货品，或货品已卖光
	 * @param id 要删除货品的id
	 */
	void remove(int id);
	
	/**
	 * 返回货品数据库中的所有数据，为分页准备
	 * @return 返回数据库中存在的数据
	 */
	int count();
	
	/**
	 * 修改数据库中的某条数据的信息
	 * @param obj 要修改信息的货物
	 */
	void update(Store obj);
}
