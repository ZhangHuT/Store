package domain;

import java.math.BigDecimal;

//商品类
public class Store {
	private int sid;//货品编号
	private String sname;//货品名称
	private String sbrand;//货品品牌
	private int dir;//货品分类
	private String sfactory;//供应商
	private BigDecimal sale;//零售价
	private BigDecimal rsale;//成本价
	private BigDecimal discount;//折扣
	private int count;//货品的数量
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSbrand() {
		return sbrand;
	}
	public void setSbrand(String sbrand) {
		this.sbrand = sbrand;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public String getSfactory() {
		return sfactory;
	}
	public void setSfactory(String sfactory) {
		this.sfactory = sfactory;
	}
	public BigDecimal getSale() {
		return sale;
	}
	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public String toString() {
		return "Store [sid=" + sid + ", sname=" + sname + ", sbrand=" + sbrand + ", dir=" + dir + ", sfactory="
				+ sfactory + ", sale=" + sale + ", discount=" + discount + ", count=" + count + "]";
	}
}