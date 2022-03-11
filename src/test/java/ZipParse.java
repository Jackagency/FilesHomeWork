import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;



public class ZipParse {

    @Test
    void parseZipTest() throws Exception {
        String pathFile = "/Users/jackagency/IdeaProjects/FilesHomeWork/src/test/resources/files/test.zip";
        ZipFile zipFile = new ZipFile(pathFile);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().contains("pdf")) {
                assertThat(entry.getName()).isEqualTo("TestPd.pdf");
            } else if (entry.getName().contains("xlsx")) {
                assertThat(entry.getName()).isEqualTo("TestEx.xlsx");
            } else if (entry.getName().contains("csv")) {
                assertThat(entry.getName()).isEqualTo("TestCs.csv");
            }
        }
    }

}
