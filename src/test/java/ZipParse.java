import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;



public class ZipParse {
    ClassLoader classLoader = getClass().getClassLoader();


    @Test
    void parseZipTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("files/test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).contains("TestCs.csv");
            }
        }
    }

}
