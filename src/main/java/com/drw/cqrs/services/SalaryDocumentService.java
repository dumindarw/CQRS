package com.drw.cqrs.services;


import com.drw.cqrs.commands.SalaryRepository;
import com.drw.cqrs.models.Salary;
import com.drw.cqrs.queries.SalaryMapper;
import com.drw.cqrs.registry.DocumentAdapterService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service("Salary")
public class SalaryDocumentService implements DocumentAdapterService<MultipartFile> {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    private SalaryMapper salaryMapper;

    String[] HEADERS = { "EmployeeID", "Amount"};

    @Override
    public String upload(MultipartFile request) throws IOException {

        int documentID = salaryRepository.getCurrentDocumentID() + 1;

        InputStream inputStream =  new BufferedInputStream(request.getInputStream());
        Reader reader = new InputStreamReader(inputStream);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(reader);

        List<Salary> salaries = new ArrayList<>();

        records.forEach(record -> {
            int employeeID = Integer.parseInt(record.get("EmployeeID"));
            double amount = Double.parseDouble(record.get("Amount"));

            salaries.add(new Salary(employeeID, amount, documentID));

        });

        salaryRepository.saveDocumentContent(salaries);

        return "SalaryDoc Saved";

    }

    @Override
    public List<Salary> download(int documentID) {

        return salaryMapper.getSalaryDocumentData(documentID);
    }


}
