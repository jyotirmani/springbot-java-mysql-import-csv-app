package com.nace.demo.service;

import com.nace.demo.CSVHelper;
import com.nace.demo.model.Nace;
import com.nace.demo.repository.NaceRepository;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class NaceService {
  @Autowired
  NaceRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Nace> naceData = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(naceData);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Nace> naceData = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(naceData);
    return in;
  }

  public List<Nace> getAllNace() {
    return repository.findAll();
  }
}