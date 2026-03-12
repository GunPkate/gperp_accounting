package com.gperp_acc.transaction.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ResourceUtils;

import com.gperp_acc.transaction.enumtypes.ReportTypeEnum;
import com.gperp_acc.transaction.jasperutils.JasperReportsUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXmlExporterOutput;

public class DocumentService {


    public static void employeeJasperReportInBytes(String fileType) throws Exception {
        String template = "reports/employee.jrxml";
        // List<Employee> employees = employeeRepository.findAll();
        // List<EmployeeDto> dataSource = employeeMapper.mapEntityListToDtoListForEmployee(employees);
    //1. Create Required Parameters
        // Map<String, Object> parameters = new HashMap<>();
        // FileInputStream leafBannerStream = new FileInputStream(ResourceUtils.getFile("classpath:reports/logo.jpg").getAbsolutePath());
        // parameters.put("comanyName", "BLACK STAR TECHNOLOGIES");
        // parameters.put("address", "Address: Raheja Mind Space Entrance Gate, HITEC City, Hyderabad -500081");
        // parameters.put("header", "Employees Salary Report");
        // parameters.put("logo", leafBannerStream);
        // parameters.put("createdBy","Satya Kaveti");
        // //2.Create DataSource
        // JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataSource);
        // //3.Compile .jrmxl template, stored in JasperReport object
        // String path = ResourceUtils.getFile("classpath:" + template).getAbsolutePath();
        // JasperReport jasperReport = JasperCompileManager.compileReport(path);
        // //4.Fill Report - by passing complied .jrxml object, paramters, datasource
        // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
        // //5.Export Report - by using JasperExportManager
        // ReportTypeEnum reportType = ReportTypeEnum.getReportTypeByCode(fileType);
        // return JasperReportsUtil.exportJasperReportBytes(jasperPrint, reportType); 
    }  

}
