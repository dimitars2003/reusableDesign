package Filter.ComplexFilter;

import java.util.ArrayList;
import java.util.List;

import Filter.Filter;

public class ComplexFilterNofM<T> implements ComplexFilter<T> {
private List<Filter<T>>complexFilter = new ArrayList<>();
private int n = 0;
private int m = 0;
	
	ComplexFilterNofM(List<Filter<T>> complexFilterAdd, int nAdd, int mAdd)
	{
		complexFilter = complexFilterAdd;
		n = nAdd;
		m = mAdd;
	}
	@Override
	public boolean matches(T item) {
		int count = 0;
		for(int i = 0; i < m;i++) {
			if(complexFilter.get(i).matches(item)) {
				count++;
			}
			if(count >= n) {
				return true;
			}
			
		}
		return false;
	}
	
}
