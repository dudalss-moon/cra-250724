package mission2.service;

import mission2.domain.Car;
import mission2.domain.CarType;
import mission2.domain.parts.Brake;
import mission2.domain.parts.Engine;
import mission2.domain.parts.Steering;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CarAssemblerTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void test_Exit() {
        // arrange
        Car car = new Car();
        RunTest runTest = mock(RunTest.class);
        Scanner sc = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        CarAssembler assembler = new CarAssembler(car, runTest, sc);

        // act
        assembler.assembleCar();

        // assert
        assertTrue(outContent.toString().contains("바이바이"));
    }

    @Test
    void test_Sedan_GM_MANDO_BOSCH_Success() {
        // arrange
        Car car = new Car();
        RunTest runTest = mock(RunTest.class);
        String inputArgs = "1\n1\n1\n1\n1\nexit\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(inputArgs.getBytes()));
        CarAssembler assembler = new CarAssembler(car, runTest, sc);

        // act
        assembler.assembleCar();
        Car actual = assembler.getCar();

        // assert
        assertEquals(CarType.SEDAN, actual.getCarType());
        assertEquals(Engine.GM, actual.getEngine());
        assertEquals(Brake.MANDO, actual.getBrake());
        assertEquals(Steering.BOSCH, actual.getSteering());
    }

    @Test
    void test_Sedan_Continental_fail() {
        // arrange
        Car car = new Car();
        RunTest runTest = mock(RunTest.class);
        String inputArgs = "1\n1\n2\n1\n1\nexit\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(inputArgs.getBytes()));
        CarAssembler assembler = new CarAssembler(car, runTest, sc);

        // act
        assembler.assembleCar();
        Car actual = assembler.getCar();

        // assert
        assertEquals(CarType.SEDAN, actual.getCarType());
        assertEquals(Engine.GM, actual.getEngine());
        assertEquals(Brake.CONTINENTAL, actual.getBrake());
        assertEquals(Steering.BOSCH, actual.getSteering());
    }

    @Test
    void test_Select_fail() {
        // arrange
        Car car = new Car();
        RunTest runTest = mock(RunTest.class);
        String inputArgs = "4\n1\n2\n1\n1\nexit\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(inputArgs.getBytes()));
        CarAssembler assembler = new CarAssembler(car, runTest, sc);

        // act
        assembler.assembleCar();
        Car actual = assembler.getCar();

        // assert
        assertEquals(null, actual.getCarType());
    }
}