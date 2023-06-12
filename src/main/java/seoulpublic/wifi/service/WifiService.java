package seoulpublic.wifi.service;


import seoulpublic.wifi.dto.WifiInfoDto;
import seoulpublic.wifi.model.WifiInfoDetailModel;
import seoulpublic.wifi.model.WifiInfoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WifiService extends SqliteConnection {

    /**
     * 와이파이 정보를 저장
     */
    private boolean add(WifiInfoDto model) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnect();
            String sql = "INSERT INTO PUB_WIFI VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getMgrNo());
            preparedStatement.setString(2, model.getRegion());
            preparedStatement.setString(3, model.getMainNm());
            preparedStatement.setString(4, model.getAddress());
            preparedStatement.setString(5, model.getAddressDetail());
            preparedStatement.setString(6, model.getInstallFloor());
            preparedStatement.setString(7, model.getInstallTy());
            preparedStatement.setString(8, model.getInstallMby());
            preparedStatement.setString(9, model.getServiceSe());
            preparedStatement.setString(10, model.getNetworkTy());
            preparedStatement.setString(11, model.getInstallYear());
            preparedStatement.setString(12, model.getIsOutdoor());
            preparedStatement.setString(13, model.getConnectEnv());
            preparedStatement.setString(14, model.getLongitude());
            preparedStatement.setString(15, model.getLatitude());
            preparedStatement.setString(16, model.getWorkDate());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(null, preparedStatement, connection);
        }
    }

    /**
     * 와이파이 정보의 목록을 리턴
     */
    public List<WifiInfoDto> getList(String lnt, String lat) {

        List<WifiInfoDto> wifiInfoDtoList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = getConnect();

            String sql = "SELECT *," +
                    " round(6371*acos(cos(radians( ? ))*cos(radians(LAT))*cos(radians(LNT)-radians( ? ))+sin(radians( ? ))*sin(radians(LAT))), 4)" +
                    " AS DISTANCE" +
                    " FROM PUB_WIFI" +
                    " ORDER BY DISTANCE" +
                    " LIMIT 20;";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(lnt));
            preparedStatement.setString(2, String.valueOf(lat));
            preparedStatement.setString(3, String.valueOf(lnt));

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String dist = rs.getString("DISTANCE");
                String mgrNo = rs.getString("MGR_NO");
                String wrdofc = rs.getString("WRDOFC");
                String mainNm = rs.getString("MAIN_NM");
                String addre1 = rs.getString("ADRES1");
                String addre2 = rs.getString("ADRES2");
                String instlFloor = rs.getString("INSTL_FLOOR");
                String instlTy = rs.getString("INSTL_TY");
                String instlMby = rs.getString("INSTL_MBY");
                String svcSe = rs.getString("SVC_SE");
                String cmcwr = rs.getString("CMCWR");
                String cnstcYear = rs.getString("CNSTC_YEAR");
                String inOutDoor = rs.getString("INOUT_DOOR");
                String remars3 = rs.getString("REMARS3");
                String lntt = rs.getString("LNT");
                String latt = rs.getString("LAT");
                String workDttm = rs.getString("WORK_DTTM" );

                WifiInfoDto wifiInfoDto = new WifiInfoDto();
                wifiInfoDto.setDist(dist);
                wifiInfoDto.setMgrNo(mgrNo);
                wifiInfoDto.setRegion(wrdofc);
                wifiInfoDto.setMainNm(mainNm);
                wifiInfoDto.setAddress(addre1);
                wifiInfoDto.setAddressDetail(addre2);
                wifiInfoDto.setInstallFloor(instlFloor);
                wifiInfoDto.setInstallTy(instlTy);
                wifiInfoDto.setInstallMby(instlMby);
                wifiInfoDto.setServiceSe(svcSe);
                wifiInfoDto.setNetworkTy(cmcwr);
                wifiInfoDto.setInstallYear(cnstcYear);
                wifiInfoDto.setIsOutdoor(inOutDoor);
                wifiInfoDto.setConnectEnv(remars3);
                wifiInfoDto.setLongitude(lntt);
                wifiInfoDto.setLatitude(latt);
                wifiInfoDto.setWorkDate(workDttm);

                wifiInfoDtoList.add(wifiInfoDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return wifiInfoDtoList;
    }


}
