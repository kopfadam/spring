package com.apress.todo.repository;

import com.apress.todo.domain.ToDo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository implements CommonRepository<ToDo> {

    private Map<String, ToDo> todos = new HashMap<>();


    @Override
    public ToDo save(ToDo domain) {
        ToDo result = todos.get(domain.getId());

        if (result != null) {
            result.setDescription(domain.getDescription());
            result.setModified(LocalDateTime.now());
            result.setCompleted(domain.isCompleted());
            domain = result;
        }

        todos.put(domain.getId(), domain);
        return todos.get(domain.getId()); // why do we not return domain object directly??
    }

    @Override
    public Iterable<ToDo> save(Collection<ToDo> domains) {
        domains.forEach(this::save);
        return findAll();
    }

    @Override
    public void delete(ToDo domain) {
        todos.remove(domain.getId());
    }

    @Override
    public ToDo findById(String id) {
        return todos.get(id);
    }

    @Override
    public Iterable<ToDo> findAll() {
        return todos
                .entrySet()
                .stream()
                .sorted(entryComparator)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private Comparator<Map.Entry<String, ToDo>> entryComparator =
            (Map.Entry<String, ToDo> todo1, Map.Entry<String, ToDo> todo2) ->
            {
                return todo1.getValue().getCreated().compareTo(todo2.getValue().getCreated());
            };
}
