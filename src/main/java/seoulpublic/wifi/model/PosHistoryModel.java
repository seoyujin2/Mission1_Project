package seoulpublic.wifi.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PosHistoryModel {

    private int histNo;
    private String longitude;
    private String latitude;
    private Date searchDate;

}


