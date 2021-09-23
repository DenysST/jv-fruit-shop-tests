package core.basesyntax.service.files;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {
    private static final String FILE_HEAD = "type,fruitRecord,quantity";
    private static final String FROM_FILE_NAME = "src/test/resources/input.csv";
    private static final String FROM_INCORRECT_PATH = "incorrect_input.csv";
    private static List<String> testList = new ArrayList<>();
    private static FileReader fileReader;

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReader();
        testList.add(FILE_HEAD);
        testList.add("b,banana,100");
        testList.add("b,apple,50");
    }

    @Test
    public void read_correctData_Ok() {
        List<String> expected = testList;
        List<String> actual = fileReader.read(FROM_FILE_NAME);
        assertEquals(expected, actual);
    }

    @After
    public void afterEachTest() {
        testList.clear();
    }

    @Test(expected = RuntimeException.class)
    public void read_incorrectPath_NotOk() {
        fileReader.read(FROM_INCORRECT_PATH);
    }

}