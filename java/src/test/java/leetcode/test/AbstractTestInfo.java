package leetcode.test;

import lombok.AllArgsConstructor;

import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 */

public abstract class AbstractTestInfo<T> implements TestInfo<T>{

	protected StatisTest st = new StatisTest(this);
	//
	private Iterable<Object[]> ib;
	private Iterator<Object[]> i;
	private int size;

	@Override
	public boolean verify(Object[] params, T rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		if(!i.hasNext()) i = ib.iterator();
		return i.next();
	}

	@Override
	public void print(Object[] params, T rs) {
		System.out.printf("result: %s", RsForPrint(rs));
		System.out.println();
	}

	/**
	 * 该方法主要用于重写，设置打印rs的格式
	 * @param rs
	 * @return
	 */
	public String RsForPrint(T rs){
		return rs == null ? null : rs.toString();
	}

	public void setIb(Iterable<Object[]> ib) {
		this.ib = ib;
		this.i = ib.iterator();
		this.size = 0;
		while(this.i.hasNext()){
			this.size++;
			this.i.next();
		}
	}

	public void setIb(Object[][] array){
		this.ib = new InnerIterale(array);
		this.size = array.length;
		this.i = ib.iterator();
	}

	/**
	 * obj.m();
	 * @param obj
	 * @param m
	 */
	public void doMethod(Object obj, Method m){
//		StatisTest st = new StatisTest(this);
		st.doMethod(size, obj, m);
	}

	@AllArgsConstructor
	private class InnerIterale implements Iterable<Object[]>{

		private Object[][] objs;

		@Override
		public Iterator<Object[]> iterator() {
			return new InnerIterator(objs);
		}
	}

	private class InnerIterator implements Iterator<Object[]>{

		private Object[][] objs;
		private int size;
		private int pointer = 0;

		public InnerIterator(Object[][] objs){
			this.objs = objs;
			this.size = objs.length;
		}

		@Override
		public boolean hasNext() {
			return pointer < size;
		}

		@Override
		public Object[] next() {
			return objs[pointer++];
		}
	}

}
