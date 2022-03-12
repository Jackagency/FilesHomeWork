import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OneMoreZipParse {
    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    void parseZipTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("files/ezyzip.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("pdf")) {
                    assertThat(entry.getName()).contains("TestPd.pdf");
                } else if (entry.getName().contains("xlsx")) {
                    assertThat(entry.getName()).contains("TestEx.xlsx");
                } else if (entry.getName().contains("csv")) {
                    assertThat(entry.getName()).contains("TestCs.csv");
                }
            }
        }
    }

}
