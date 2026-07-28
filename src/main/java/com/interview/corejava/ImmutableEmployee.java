package com.interview.corejava;

import java.util.List;
import java.util.Objects;

public final class ImmutableEmployee {
    private final long id;
    private final String name;
    private final List<String> skills;

    public ImmutableEmployee(long id, String name, List<String> skills) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.skills = List.copyOf(skills);
    }

    public long id() { return id; }
    public String name() { return name; }
    public List<String> skills() { return skills; }
}
