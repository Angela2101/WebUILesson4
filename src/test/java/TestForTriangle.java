import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForTriangle {

    int a;
    int b;
    int c;

    private static Logger logger = LoggerFactory.getLogger(TestForTriangle.class);

    @ParameterizedTest
    @CsvSource({"3,2,2", "3,4,5", "9,12,15"})
    @DisplayName("проверки на площадь треугольника")
    public void IsTriangleTest(int x, int y, int z) {
        logger.info("Рассчитываем периметр треугольника");
        double p = ((float) (x + y + z)) / 2;
        logger.info("Вызов метода рассчета площади");
        double squareTriangle = SquareTriangle.CalculateSquare(x, y, z);
        logger.info("Проверка теста");
        assertTrue(squareTriangle >= 0, " Это не треугольник");
        assertTrue(Math.abs(squareTriangle - Math.sqrt(p * (p - x) * (p - y) * (p - z))) <= 0.000001);
    }


    @DisplayName("проверка на прямой угол")
    @Test
    public void IsRightAngleTest() {
        a = 6;
        b = 8;
        c = 10;
        double squareTriangle = SquareTriangle.CalculateSquare(a, b, c);
        assertTrue(squareTriangle >= 0, " Это не треугольник");
        assertTrue(Math.abs(squareTriangle - 0.5 * a * b) <= 0.000001);
    }

    @DisplayName("Это не треугольник")
    @Test
    public void NegativeTest1() {
        double squareTriangle = SquareTriangle.CalculateSquare(0, 0, 0);
        assertTrue(squareTriangle <= 0, " Это не треугольник");
        Assertions.assertEquals(squareTriangle, -1);
    }

    @DisplayName("Проверка на отрицательные значения")
    @Test
    public void NegativeTest2() {
        double squareTriangle = SquareTriangle.CalculateSquare(-3, -4, -5);
        assertTrue(squareTriangle <= 0, " Это не треугольник");
        Assertions.assertEquals(squareTriangle, -1);
    }

    @DisplayName("Равнобедренный треугольник")
    @Test
    public void IsIsoscelesTriangle() {
        a = 5;
        b = a;
        c = 2;
        double squareTriangle = SquareTriangle.CalculateSquare(a, b, c);
        assertTrue(squareTriangle >= 0, " Это не треугольник");
        assertTrue(Math.abs(squareTriangle - 0.5 * c * Math.sqrt(a * a - ((double) c * c) / 4)) <= 0.000001);
    }
}
