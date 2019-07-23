package com.drw.cqrs.queries;

import com.drw.cqrs.models.Salary;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface SalaryMapper {

    @Select(value= "{ CALL proc_getSalaryDocumentData( #{documentID, mode=IN, jdbcType=INTEGER} )}")
    @Options(statementType = StatementType.CALLABLE)
    List<Salary> getSalaryDocumentData(int documentID);
}
