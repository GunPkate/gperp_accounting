package com.gperp_acc.transaction.mapper;

import org.springframework.stereotype.Component;

import com.gperp_acc.transaction.enumtypes.ReportTypeEnum;

@Component
public class ReportTypeEnumMapper {

    public ReportTypeEnum convertFile(String fileType) {
        for(ReportTypeEnum type: ReportTypeEnum.values()){
            if(type.toString().equals(fileType)){
                return type;  
            }
        }
        return null;
    }
}
