package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.IStoreDao;
import dao.impl.StoreDaoImpl;
import domain.Store;

class StoreDaoImplTest {
	private IStoreDao dao=new StoreDaoImpl();
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		List<Store> list = dao.list();
		System.out.println(list);
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testCount() {
		System.out.println(dao.count());
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

}
