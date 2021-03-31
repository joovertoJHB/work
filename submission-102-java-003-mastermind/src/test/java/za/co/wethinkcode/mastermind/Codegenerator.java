package za.co.wethinkcode.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

public class Codegenerator {

    @Test
    public void generateCodeTest() {
        CodeGenerator code = new CodeGenerator();
        assertEquals(code.generateCode(), code.generateCode());
    }
}