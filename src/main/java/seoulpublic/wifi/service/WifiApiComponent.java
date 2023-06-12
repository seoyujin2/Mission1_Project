package seoulpublic.wifi.service;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WifiApiComponent {

    /**
     * OpenAPI를 통해서 와이파이 정보의 JSON문자열을 리턴함
     */
    private seoulpublic.wifi.dto.TbPublicWifiInfo TbPublicWifiInfo;

    public static TbPublicWifiInfo fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, TbPublicWifiInfo.class);
    }

}
