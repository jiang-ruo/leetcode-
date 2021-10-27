package leetcode.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author XiaoLOrange
 * @time 2021.09.26
 * @title
 */

@Data
@AllArgsConstructor
public class Params<T> {

	private Object[] ps;
	private T rs;

	public Params(Object... ps){
		this.ps = ps;
	}

}
