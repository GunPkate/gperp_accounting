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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class DocumentService {

    @Autowired
    private TransactionRepository transactionRepository;

    public byte[] employeeJasperReportInBytes(ReportTypeEnum reportType) throws Exception {
   
        List<Transaction> dataSource = transactionRepository.findAll();

        Map<String, Object> parameters = new HashMap<>();
        // FileInputStream leafBannerStream = new FileInputStream(ResourceUtils.getFile("classpath:reports/logo.jpg").getAbsolutePath());
        parameters.put("comanyName", "BLACK STAR TECHNOLOGIES");
        parameters.put("address", "Address: Raheja Mind Space Entrance Gate, HITEC City, Hyderabad -500081");
        parameters.put("header", "Employees Salary Report");
        // parameters.put("logo", leafBannerStream);
        parameters.put("createdBy","Satya Kaveti");
        
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataSource);

        String template = "templates/employee/Blank_A4.jasper";
        String path = ResourceUtils.getFile("classpath:" + template).getAbsolutePath();

        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
   
        return JasperReportsUtil.exportJasperReportBytes(jasperPrint, reportType); 
    }  
}
