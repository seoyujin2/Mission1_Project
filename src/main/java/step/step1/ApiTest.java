package step.step1;

import seoulpublic.wifi.service.WifiApiComponent;

public class ApiTest {


    /**
     * TODO: 1. Open API 테스트
     */
    public static void main(String[] args) {

        String result = OpenApi.get(1, 1);
        System.out.println(result);

        System.out.println("여기이이이" + WifiApiComponent.fromJson(result).toString());
        System.out.println("여긴 나와야돼"+ result);

        TbPublicWifiInfo tbPublicWifiInfo = new TbPublicWifiInfo();

        int totalCount = OpenApi.getCount();
        System.out.println(totalCount + " 이게 개수임");

//        TbPublicWifiInfo wifiInfo = WifiApiComponent.fromJson(result);

//        System.out.println("이것입니다요" + WifiApiComponent.fromJson(result));

    }



}
