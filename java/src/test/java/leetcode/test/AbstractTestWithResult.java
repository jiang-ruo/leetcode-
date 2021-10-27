package leetcode.test;

import leetcode.test.bean.Params;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author XiaoLOrange
 * @time 2021.09.26
 * @title
 */

public abstract class AbstractTestWithResult<T> implements TestInfo<T>{

	private Iterable<Params<T>> ib;
	private Iterator<Params<T>> i;
	private int size;
	protected Params<T> current;

	@Override
	public Object[] buildParams() {
		if(!i.hasNext()) i = ib.iterator();
		current = i.next();
		return current.getPs();
	}

	@Override
	public void print(Object[] params, T rs) {
		print(params, rs, current == null ? null : current.getRs());
	}

	/**
	 *
	 * @param params 输入的参数
	 * @param rs 程序执行的结果
	 * @param standard 预先输入的正确结果/标准答案
	 */
	public void print(Object[] params, T rs, T standard){
		String s = parseRs(rs);
		System.out.printf("result: %s", s);
		if(standard != null) {
			System.out.printf(s.length() > 60 ? "\n" : ", ");
			System.out.printf("standard: %s", parseRs(standard));
		}
		System.out.println();
	}

	/**
	 * 该方法主要用于重写，设置打印rs的格式
	 * @param rs
	 * @return
	 */
	public String parseRs(T rs){
		return rs == null ? null : rs.toString();
	}

	@Override
	public boolean verify(Object[] params, T rs) {
		if(current != null && current.getRs() != null){
			boolean flag = current.getRs() == rs || current.getRs().equals(rs);
			current = null;
			return flag;
		}
		return true;
	}

	public void setIb(Iterable<Params<T>> ib) {
		this.ib = ib;
		this.i = ib.iterator();
		this.size = 0;
		while(this.i.hasNext()){
			this.size++;
			this.i.next();
		}
	}

	public void setIb(Object[][] array){
		int size = array.length;
		Params<T>[] ps = new Params[size];
		for (int i = 0; i < size; i++){
			ps[i] = new Params<T>(array[i]);
		}
		setIb(ps);
	}

	public void setIb(Params<T>[] array){
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
		StatisTest st = new StatisTest(this);
		st.doMethod(size, obj, m);
	}

	@AllArgsConstructor
	private class InnerIterale implements Iterable<Params<T>>{

		private Params<T>[] objs;

		@Override
		public Iterator<Params<T>> iterator() {
			return new InnerIterator(objs);
		}
	}

	private class InnerIterator implements Iterator<Params<T>>{

		private Params<T>[] objs;
		private int size;
		private int pointer = 0;

		public InnerIterator(Params<T>[] objs){
			this.objs = objs;
			this.size = objs.length;
		}

		@Override
		public boolean hasNext() {
			return pointer < size;
		}

		@Override
		public Params next() {
			return objs[pointer++];
		}
	}
}
