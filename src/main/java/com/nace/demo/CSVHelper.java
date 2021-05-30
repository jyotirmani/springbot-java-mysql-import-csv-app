package com.nace.demo;

import com.nace.demo.model.Nace;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "OrderId", "Level", "Level", "Parent", "Description", "ItemIncludeContent", "ItemAdditionalContent", "Rulling", "ItemExcludes", "ReferenceToISIC" };

  public static boolean hasCSVFormat(MultipartFile file) {
    if (TYPE.equals(file.getContentType())
        || file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<Nace> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Nace> NaceList = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Nace nace = new Nace(
            Long.parseLong(csvRecord.get("OrderId")),
            csvRecord.get("Level"),
            csvRecord.get("Code"),
            csvRecord.get("Parent"),
            csvRecord.get("Description"),
            csvRecord.get("ItemIncludeContent"),
            csvRecord.get("ItemAdditionalContent"),
            csvRecord.get("Rulling"),
            csvRecord.get("ItemExcludes"),
            csvRecord.get("ReferenceToISIC")
        );

        NaceList.add(nace);
      }

      return NaceList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToCSV(List<Nace> NaceList) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Nace Nace : NaceList) {
        List<String> data = Arrays.asList(
            String.valueOf(Nace.getOrderId()),
            Nace.getLevel(),
            Nace.getCode(),
            Nace.getParent(),
            Nace.getDescription(),
            Nace.getItemIncludeContent(),
            Nace.getItemAdditionalContent(),
            Nace.getRulling(),
            Nace.getItemExcludes(),
            Nace.getReferenceToISIC()
        );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
