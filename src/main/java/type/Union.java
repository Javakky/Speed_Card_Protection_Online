package type;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Union<T> {
    private T data;
    private Class<T> clazz;

    public boolean isNull(){
        return data == null;
    }

    public Union(T data){
        this.data = data;
        this.clazz = (Class<T>) data.getClass();
    }

    public T getData() {
        return data;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public ImmutablePair<Class<T>, T> get(){
        return ImmutablePair.of(clazz, data);
    }

    @Override
    public boolean equals(Object obj) {
        return data.equals(obj) && obj.getClass() == clazz;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
