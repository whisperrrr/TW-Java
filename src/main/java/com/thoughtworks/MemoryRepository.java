package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryRepository<E> implements Repository<E> {
    Map<String, E> memoryRepository = new HashMap<>();

    @Override
    public void save(String id, E entity) {
        memoryRepository.put(id, entity);
    }

    @Override
    public E get(String id) {
        return memoryRepository.get(id);
    }

    @Override
    public E delete(String id) {
        return memoryRepository.remove(id);
    }

    @Override
    public E update(String id, E entity) {
        return memoryRepository.replace(id, entity);
    }

    @Override
    public List<E> list() {
        Set<String> keys = memoryRepository.keySet();
        List<E> memoryRepositoryList = new ArrayList<>();
        for (String key : keys) {
            memoryRepositoryList.add(memoryRepository.get(key));
        }
        return memoryRepositoryList;
    }
}
