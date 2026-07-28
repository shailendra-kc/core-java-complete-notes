package com.interview.corejava;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableEmployeeTest {
    @Test
    void defensivelyCopiesSkills() {
        List<String> skills = new ArrayList<>(List.of("Java"));
        ImmutableEmployee employee = new ImmutableEmployee(1L, "Shailendra", skills);
        skills.add("Spring");
        assertEquals(List.of("Java"), employee.skills());
        assertThrows(UnsupportedOperationException.class, () -> employee.skills().add("Kafka"));
    }
}
