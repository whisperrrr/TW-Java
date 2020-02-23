package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository implements Repository<Student> {
    Map<String, Student> students = new HashMap<>();

    @Override
    public void save(String id, Student entity) {
        students.put(id, entity);
    }

    @Override
    public Student get(String id) {
        return students.get(id);
    }

    @Override
    public Student delete(String id) {
        return students.remove(id);
    }

    @Override
    public Student update(String id, Student entity) {
        return students.put(id, entity);
    }

    @Override
    public Map<String, Student> list() {
        return students;
    }
}
