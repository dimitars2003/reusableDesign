package Filter;

public interface Filter<T>
{
    boolean matches(T item);
}