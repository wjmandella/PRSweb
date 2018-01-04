package prs.web;

import java.util.ArrayList;
import java.util.List;

public class BaseController {
	public static <T> List<T> getReturnArray (T tObj) {
		ArrayList<T> uList = new ArrayList<>();
		if (tObj!=null) {
			uList.add(tObj);			
		}
		return uList;
	}

}
