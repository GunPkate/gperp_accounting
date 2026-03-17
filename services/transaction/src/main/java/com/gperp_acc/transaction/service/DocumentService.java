package com.gperp_acc.transaction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.gperp_acc.transaction.enumtypes.ReportTypeEnum;
import com.gperp_acc.transaction.jasperutils.JasperReportsUtil;
import com.gperp_acc.transaction.model.entity.Transaction;
import com.gperp_acc.transaction.repo.TransactionRepository;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@Slf4j
public class DocumentService {

    @Autowired
    private TransactionRepository transactionRepository;

    public byte[] employeeJasperReportInBytes(ReportTypeEnum reportType) throws Exception {
   
        List<Transaction> data = transactionRepository.findAll();
        // List<EmployeeDto> dataSource = transactionService.mapEntityListToDtoListForEmployee(data);
        // 1. Create Required Parameters
        Map<String, Object> parameters = new HashMap<>();
        // FileInputStream leafBannerStream = new FileInputStream(ResourceUtils.getFile("classpath:reports/logo.jpg").getAbsolutePath());
        parameters.put("comanyName", "BLACK STAR TECHNOLOGIES");
        parameters.put("address", "Address: Raheja Mind Space Entrance Gate, HITEC City, Hyderabad -500081");
        parameters.put("header", "Employees Salary Report");
        // parameters.put("logo", leafBannerStream);
        parameters.put("createdBy","Satya Kaveti");
        
        //2.Create DataSource
        // JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataSource);
        //3.Compile .jrmxl template, stored in JasperReport object
        String template = "templates/employee/employee.jrxml";
        String path = ResourceUtils.getFile("classpath:" + template).getAbsolutePath();
        log.info( String.format("DocumentService %s", path) );
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        //4.Fill Report - by passing complied .jrxml object, paramters, datasource
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
        //5.Export Report - by using JasperExportManager
   
        return JasperReportsUtil.exportJasperReportBytes(jasperPrint, reportType); 
    }  
}
