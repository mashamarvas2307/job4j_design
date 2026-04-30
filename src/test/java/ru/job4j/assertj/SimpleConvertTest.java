package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .startsWith("first")
                .allSatisfy(str ->
                        assertThat(str).isNotNull()
                )
                .noneMatch(str -> false);
        assertThat(list).filteredOn(str -> str.contains("e")).first().isEqualTo("second");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotNull()
                .allSatisfy(e -> {
                    assertThat(e.length()).isLessThan(10);
                    assertThat(e).doesNotContain("x");
                });
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second");
        assertThat(map).hasSize(2)
                .containsEntry("first", 0)
                .containsKeys("first", "second")
                .containsValues(0, 1)
                .doesNotContainKey("five")
                .doesNotContainValue(8);
    }
}