package com.gperp_acc.transaction.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gperp_acc.transaction.jasperutils.GenApp;
import com.gperp_acc.transaction.mapper.ReportTypeEnumMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DocumentController {
    @Autowired
    private  GenApp genApp;

    private final ReportTypeEnumMapper mapper;
    
    @RequestMapping(path = "/jasper/emp24", method=RequestMethod.GET)
    public ResponseEntity<String> employeeJasperReport24(@RequestParam(name ="fileType", defaultValue="DOC") String fileType) throws Exception {
        String report = genApp.getReportTypeByCode(mapper.convertFile(fileType));
        log.info("Eum :"+report);
        return ResponseEntity.ok().body(report);
    } 
    
    // @GetMapping("/jasper/emp24")
    // public ResponseEntity<ReportTypeEnum> employeeJasperReport24(@RequestParam(name ="fileType", defaultValue="DOC") String fileType) throws Exception {

    // ReportTypeEnum report = ReportTypeEnum.getReportTypeByCode(fileType);
    //     log.info("Eum :"+report);
    //     return ResponseEntity.ok().body(report);
    // }
    // // byte[] bytes = reportsService.employeeJasperReport24(fileType);
    //     byte[] bytes = DocumentService.employeeJasperReportInBytes(fileType);
    //     if (null != bytes) {
    //         ByteArrayResource resource = new ByteArrayResource(bytes);
    //         String fileName = "Employee24_JasperReport" + "_" + LocalDateTime.now() + report.getExtension();
    //         return ResponseEntity.ok()
    //                 .header(com.gperp_acc.transaction.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
    //                 .contentLength(resource.contentLength())
    //                 .contentType(MediaType.APPLICATION_OCTET_STREAM)
    //                 .body(resource);
    //     } else {
    //         throw new Exception("File Download Failed");
    //     }
    // }
}
