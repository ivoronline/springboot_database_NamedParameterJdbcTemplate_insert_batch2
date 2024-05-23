package com.ivoronline.springboot_database_namedparameterjdbctemplate_insert_batch.service;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_insert_batch.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public int[] insert(List<PersonDTO> records) {

    String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";      //DTO Properties

    SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(records.toArray());

    return namedParameterJdbcTemplate.batchUpdate(sql, parameters);

  }

}
