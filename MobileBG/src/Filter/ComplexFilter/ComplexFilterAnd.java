package Filter.ComplexFilter;

import java.util.ArrayList;
import java.util.List;

import Filter.Filter;

public class ComplexFilterAnd<T> implements ComplexFilter<T>{
	private List<Filter<T>>complexFilter = new ArrayList<>();
	
	ComplexFilterAnd(List<Filter<T>> complexFilterAdd)
	{
		complexFilter = complexFilterAdd;
	}
	
	@Override
	public boolean matches(T item) {
		for(int i = 0; i < complexFilter.size();i++) {
			if(complexFilter.get(i).matches(item)) {
				return false;
			}
		}
		return true;
	}
	
	
}
