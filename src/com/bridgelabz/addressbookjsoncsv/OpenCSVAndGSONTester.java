package com.bridgelabz.addressbookjsoncsv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndGSONTester {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\Nagu\\eclipse-workspace\\address-book-system-csv-json\\src\\com\\bridgelabz\\addressbookjsoncsv\\users-with-header.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "C:\\Users\\Nagu\\eclipse-workspace\\address-book-system-csv-json\\src\\com\\bridgelabz\\addressbookjsoncsv\\users.json";

    public static void main(String[] args) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));

            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator('|')
                    .build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();

            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

