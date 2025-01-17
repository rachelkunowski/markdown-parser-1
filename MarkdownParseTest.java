import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testLinksTestFile() throws InterruptedException, IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> testLinks = new ArrayList<>();
        testLinks.add("https://something.com");
        testLinks.add("some-thing.html");
        assertEquals(testLinks, links);
    }

    @Test
    public void testLinksTestFile2() throws InterruptedException, IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> testLinks = new ArrayList<>();
        testLinks.add("https://google.com");
        testLinks.add("some-thing.html");
        assertEquals(testLinks, links);
    }

    @Test
    public void testLinksTestFile9() throws InterruptedException, IOException {
        Path fileName = Path.of("test-file9.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> testLinks = new ArrayList<>();
        testLinks.add("https://google.com");
        assertEquals(testLinks, links);
    }
 }
