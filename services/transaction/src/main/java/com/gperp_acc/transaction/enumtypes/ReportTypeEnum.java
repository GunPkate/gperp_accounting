package com.gperp_acc.transaction.enumtypes;

public enum ReportTypeEnum {
    CSV{
        @Override
        public String toString(){return "CSV"; }  
    },
    DOC{
        @Override
        public String toString(){return "DOC"; }  
    },
    XLSX{
        @Override
        public String toString(){return "XLSX"; }  
    },
    XML{
        @Override
        public String toString(){return "XML"; }  
    },
    HTML{
        @Override
        public String toString(){return "HTML"; }  
    };
}
