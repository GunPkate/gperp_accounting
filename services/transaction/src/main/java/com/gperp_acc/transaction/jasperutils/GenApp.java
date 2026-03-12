package com.gperp_acc.transaction.jasperutils;

import org.springframework.stereotype.Service;

import com.gperp_acc.transaction.enumtypes.ReportTypeEnum;

@Service
public class GenApp {
    public String getReportTypeByCode(ReportTypeEnum fileType) {
        switch (fileType){
            case DOC :
            return "1";
            case XML :
            return "2";
            default:
            return "0";
        }
    }
}
