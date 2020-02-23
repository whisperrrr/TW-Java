package com.thoughtworks;

import java.util.Collection;
import java.util.Map;

public interface Repository<E> {
    public abstract void save(String id, E entity);
    public abstract E get(String id);
    public abstract E delete(String id);
    public abstract E update(String id, E entity);
    public abstract Map<String, E> list();
}
