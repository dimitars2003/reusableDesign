package Filter.ComplexFilter;

import Filter.Filter;

public class AndFilter<T> implements Filter<T>{
    private final Filter<T> left;
    private final Filter<T> right;
    public AndFilter(Filter<T> left, Filter<T> right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean matches(T item) {
        return left.matches(item) && right.matches(item);
    }
}
