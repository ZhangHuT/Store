package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.IStoreDao;
import domain.Store;
import domain.User;

public class StoreDaoImpl implements IStoreDao{
	
	//用来读取resource中的dp.properties文件
	private static Properties pre=new Properties();
	
	//配置好驱动器
	static {
		try {
			pre.load(UserDaoImpl.class.getResourceAsStream("/dp.properties"));
			Class.forName(pre.getProperty("classDriverName"));//加载驱动器
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动器加载失败");
		}
	}
	
	//连接数据库
	private Connection getConnection() {
		Connection conn=null;
		try {return DriverManager.getConnection(pre.getProperty("url"),pre.getProperty("username"),pre.getProperty("password"));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return null;
	}
		
	//高级查询
	public Store get(int id) {
		Connection conn=null;
		ResultSet res=null;
		PreparedStatement pre=null;
		User user=null;
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("获取单个用户的信息失败");
		}finally {
			//关闭资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					if(pre!=null) {
						try {
							pre.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		
		
		}
		
		return null;
	}

	//查询全部的商品信息
	public List<Store> list() {
		List<Store> list=new ArrayList<Store>();
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="SELECT sid,sname,sbrand,dir,sfactory,sale,dicount,count From store";
		try {
			conn = getConnection();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()) {
				Store store=new Store();
				store.setSid(res.getInt("sid"));
				store.setSname(res.getString("sname"));
				store.setSbrand(res.getString("sbrand"));
				store.setDir(res.getInt("dir"));
				store.setSfactory(res.getString("sfactory"));
				store.setSale(res.getBigDecimal("sale"));
				store.setDiscount(res.getBigDecimal("dicount"));
				store.setCount(res.getInt("count"));
				list.add(store);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询全部货品信息失败");
		}finally {
			//关闭资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					if(pre!=null) {
						try {
							pre.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		
		
		}
		return list;
	}

	public void save(Store obj) {
		
	}

	public void remove(int id) {
		
	}

	public int count() {
		int count=0;
		Connection conn=getConnection();
		ResultSet res=null;
		PreparedStatement pre=null;
		String sql="SELECT count(sid) FROM store";
		try {
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			if(res.next()) {
				count=res.getInt("count(sid)");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("获取数据库的总数失败");
		}finally {
			//关闭资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					if(pre!=null) {
						try {
							pre.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		
		}
		return count;
	}

	public void update(Store obj) {
		
	}

}
