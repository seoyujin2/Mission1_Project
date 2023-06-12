package seoulpublic.wifi.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PosHistoryDto {

    private int histNo;
    private String longitude;
    private String latitude;
    private Date searchDate;

}


