package Filter;

public interface FieldExtractor<T, V>
{
    V extractValue(T item);
}
