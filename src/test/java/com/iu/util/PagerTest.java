package com.iu.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iu.s4.AbstractTestCase;

public class PagerTest extends AbstractTestCase {

	private static Pager pager;
	
	@BeforeClass
	public static void setData() {
		pager = new Pager();
	}
	
	@Test
	public void test() {
		//assertEquals(1, pager.getCurPage());
		//curPage X		1
		//perBlock X	5
		//assertEquals(5, pager.getPerBlock());
		//perPage X		10
		//assertEquals(10, pager.getPerPage());
		//kind X		title
		//assertEquals("title", pager.getKind());
		//search X		""
		//assertEquals("", pager.getSearch());
		pager.makeRow();
		assertEquals(10, pager.getLastRow());
	
	}

}
