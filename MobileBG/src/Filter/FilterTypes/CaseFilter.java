package Filter.FilterTypes;

import Filter.FieldExtractor;
import Filter.Filter;

public class CaseFilter<T> implements Filter<T>
{
    private final String valueToFind;
    private final FieldExtractor<T, String> fieldExtractor;

    public CaseFilter(FieldExtractor<T, String> fieldExtractor, String valueToFind)
    {
        this.valueToFind = valueToFind;
        this.fieldExtractor = fieldExtractor;
    }

    public boolean matches(T item)
    {
        String value = fieldExtractor.extractValue(item);
        return value.equalsIgnoreCase(valueToFind);
    }
}