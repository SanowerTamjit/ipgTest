package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    App testObj;
    @Test
    void justAnExample() {

    }
    @BeforeEach
    void init() {
        testObj = new App();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    @Order(1)
    @DisplayName("[Test 1] Empty String checking - Should be null")
    void checkWithEmptyString() {
        testObj.convertString("");
        assertEquals("String should not be empty!\n", errContent.toString());
    }

    @Test
    @Order(2)
    @DisplayName("[Test 2] Null String checking - Should be null")
    void checkWithNullString() {
        testObj.convertString(null);
        assertNull(null);
    }

    @Test
    @Order(3)
    @DisplayName("[Test 3] Valid String checking")
    void checkWithValidString() {
        testObj.convertString("hello world");
        assertEquals("HELLO WORLD\n" +
                "hElLo wOrLd\n", outContent.toString());
    }

    @Test
    @Order(4)
    @DisplayName("[Test 4] Valid String with Numbers and Symbol")
    void checkWithValidStringWithNumberSymbol() {
        testObj.convertString("1` hello world -- 1");
        assertEquals("1` HELLO WORLD -- 1\n" +
                "1` HeLlO WoRlD -- 1\n", outContent.toString());
    }


    //CSV

    @Test
    @Order(5)
    @DisplayName("[Test 5] Empty String Argument Checking - Should be null")
    void checkWithEmptyArguments() {
        testObj.createCSV("", "");
        assertEquals("String should not be empty!\n", errContent.toString());
    }

    @Test
    @Order(6)
    @DisplayName("[Test 6] FileFormat Checking - Should be null")
    void checkWithInvalidFileFormatArguments() {
        testObj.createCSV("Hello World", "/aa/aa/asd");
        assertEquals("File format should be .csv !\n", errContent.toString());
    }
    @Test
    @Order(7)
    @DisplayName("[Test 7] FileFormat Checking - Should be null")
    void checkWithInvalidFilePathArguments() {
        testObj.createCSV("Hello World", "....aa/aa/asd.csv");
        assertNull(null);
    }
    @Test
    @Order(8)
    @DisplayName("[Test 8] Valid data Checking - Should be null")
    void checkWithValidArguments() {
        testObj.createCSV("hello world", "output.csv");
        assertEquals("CSV created!\n", outContent.toString());
    }
}
