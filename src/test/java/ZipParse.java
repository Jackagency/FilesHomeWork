import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;



public class ZipParse {

    @Test
    void parseZipTest() throws Exception {
        String pathFile = "/Users/jackagency/IdeaProjects/FilesHomeWork/src/test/resources/files/ezyzip.zip";
        ZipFile zipFile = new ZipFile(pathFile);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().contains("pdf")) {
                assertThat(entry.getName()).contains("TestPd.pdf");
                parsePdfTest(zipFile.getInputStream(entry));
            } else if (entry.getName().contains("xlsx")) {
                parseXlsTest(zipFile.getInputStream(entry));
                assertThat(entry.getName()).contains("TestEx.xlsx");
            } else if (entry.getName().contains("csv")) {
                assertThat(entry.getName()).contains("TestCs.csv");
                parseCsvTest(zipFile.getInputStream(entry));
            }
        }
    }

    void parsePdfTest(InputStream file) throws Exception {
        PDF pdf = new PDF(file);
        assertThat(pdf.text).contains(
                "Period"
        );
    }
    void parseXlsTest(InputStream file) throws Exception {
        XLS xls = new XLS(file);
        assertThat(xls.excel
                .getSheetAt(0)
                .getRow(2)
                .getCell(1)
                .getStringCellValue()).contains("Стажер");
    }

    void parseCsvTest(InputStream file) throws Exception {
        try (CSVReader reader = new CSVReader(new InputStreamReader(file))) {
            List<String[]> content = reader.readAll();
            assertThat(content.get(3)).contains(
                    "C343"
            );
        }
    }

}
