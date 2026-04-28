package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 3);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Cube")
                .contains("be");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(3, 8);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Unknown object")
                .startsWith("Unknown");
    }

    @Test
    void getNumberOfVerticesEqualsMinus1() {
        Box box = new Box(3, 8);
        int result = box.getNumberOfVertices();
        assertThat(result)
                .isEqualTo(-1)
                .isLessThan(5);
    }

    @Test
    void getNumberOfVerticesEquals8() {
        Box box = new Box(8, 4);
        int result = box.getNumberOfVertices();
        assertThat(result)
                .isEqualTo(8)
                .isBetween(4, 10)
                .isPositive();
    }

    @Test
    void isExist() {
        Box box = new Box(4, 4);
        boolean result = box.isExist();
        assertThat(result)
                .isTrue()
                .isNotEqualTo(false);
    }

    @Test
    void isNotExist() {
        Box box = new Box(4, -2);
        boolean result = box.isExist();
        assertThat(result)
                .isFalse()
                .isNotEqualTo(true);
    }

    @Test
    void getAreaEqualsZero() {
        Box box = new Box(3, -2);
        double result = box.getArea();
        assertThat(result)
                .isEqualTo(0)
                .isZero();
    }

    @Test
    void getAreaEquals() {
        Box box = new Box(0, 2);
        double result = box.getArea();
        assertThat(result)
                .isEqualTo(50.26d, withPrecision(0.006d))
                .isLessThan(51);
    }

}