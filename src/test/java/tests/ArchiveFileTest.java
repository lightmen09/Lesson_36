package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ArchiveFileTest {

    private final ClassLoader cl = ArchiveFileTest.class.getClassLoader();

    @Test
    @DisplayName("Проверяем, что ZIP содержит все нужные файлы")
    void zipContainsAllExpectedFiles() throws Exception {
        InputStream stream = Objects.requireNonNull(
                cl.getResourceAsStream("docs.zip"),
                "Архив docs.zip не найден!"
        );

        boolean pdfFound = false, xlsxFound = false, csvFound = false;

        try (ZipInputStream zis = new ZipInputStream(stream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Файл в архиве: " + entry.getName());
                if (entry.getName().endsWith(".pdf")) pdfFound = true;
                if (entry.getName().endsWith(".xlsx")) xlsxFound = true;
                if (entry.getName().endsWith(".csv")) csvFound = true;
            }
        }

        assertTrue(pdfFound, "В архиве не найден PDF-файл");
        assertTrue(xlsxFound, "В архиве не найден XLSX-файл");
        assertTrue(csvFound, "В архиве не найден CSV-файл");
    }

    @Test
    @DisplayName("PDF внутри ZIP содержит ключевые слова")
    void pdfFileShouldContainKeywords() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("docs.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertTrue(
                            pdf.text.contains("Project Specification") &&
                                    pdf.text.contains("Version 1.2"),
                            "PDF не содержит ожидаемых фраз!"
                    );
                    break;
                }
            }
        }
    }

    @Test
    @DisplayName("XLSX внутри ZIP содержит корректные данные")
    void xlsxFileShouldContainExpectedValues() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("docs.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    String header = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    String firstRowName = xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
                    double firstRowSalary = xls.excel.getSheetAt(0).getRow(1).getCell(2).getNumericCellValue();

                    assertEquals("ID", header);
                    assertEquals("Alice Brown", firstRowName);
                    assertEquals(72000.0, firstRowSalary);
                    break;
                }
            }
        }
    }

    @Test
    @DisplayName("CSV внутри ZIP содержит ожидаемые строки")
    void csvFileShouldContainExpectedRows() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("docs.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    try (CSVReader reader = new CSVReader(new InputStreamReader(zis))) {
                        List<String[]> rows = reader.readAll();

                        assertEquals(3, rows.size());
                        assertArrayEquals(new String[]{"Product", "Price", "Quantity"}, rows.get(0));
                        assertArrayEquals(new String[]{"Laptop", "950", "3"}, rows.get(1));
                        assertArrayEquals(new String[]{"Keyboard", "50", "5"}, rows.get(2));
                    }
                    break;
                }
            }
        }
    }


}
