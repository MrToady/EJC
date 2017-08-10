package task_10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeMapFillerTest {
    @Test
    void fill() {
        File inputDirectory = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData");
        File outputDirectory = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData");
        String outputFileName = "Output table";
        DirectoryHandler directoryHandler = new DirectoryHandler(inputDirectory, outputDirectory, outputFileName);
        ConcurrentHashMap<String, Long> testTimeMap = new ConcurrentHashMap<>();
        TimeMapFiller testMapFiller = new TimeMapFiller(testTimeMap);

        ConcurrentHashMap<String, Long> expectedTimeMap = new ConcurrentHashMap<>();
        expectedTimeMap.put("grozhnev;https://vk.com/video", 472915508L);
        expectedTimeMap.put("ira_vasileva;https://javacorejune.slack.com/messages/C5YK1DM45/details/", 2L);
        expectedTimeMap.put("k.nikolaeva;https://vk.com/video", 709385052L);
        expectedTimeMap.put("klysov;https://vk.com/video", 389594951L);
        expectedTimeMap.put("kshavonina;https://vk.com/video", 893400926L);
        expectedTimeMap.put("skuznet;https://www.google.ru/", 551847740L);
        expectedTimeMap.put("slavastap;https://github.com/MrToady/EJC", 548108468L);
        expectedTimeMap.put("uandreeva;http://stas.raskumandrin.ru/weather", 7175780L);
        expectedTimeMap.put("uandreeva;https://github.com/pulls", 526894732L);

        assertEquals(expectedTimeMap, testMapFiller.fill(directoryHandler));
    }
}