package seoulpublic.wifi.service;


import seoulpublic.wifi.model.PosHistoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PosHistoryService extends SqliteConnection {

    /**
     * 위경도 조회하는 히스토리 정보에 대한 기능을 구혀내 주세요.
     */

    public void insert(PosHistoryModel model) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnect();
            String sql = "INSERT INTO wifi_info (LNT, LAT, SEARCH_DATE) VALUES (?, ?, datetime('now', 'localtime'));";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getLongitude());
            preparedStatement.setString(2, model.getLatitude());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected < 0) {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

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
    }

    public List<PosHistoryModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<PosHistoryModel> wifiList = new ArrayList<>();

        ResultSet rs = null;

        try {
            connection = getConnect();

            String sql = "SELECT * FROM HIST";
            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String histNo = rs.getString("HIST_NO");
                String longitude = rs.getString("LNT");
                String latitude = rs.getString("LAT");
                Date date = rs.getDate("SRCH_DTTM");

                PosHistoryModel histWifi = new PosHistoryModel();
                histWifi.setHistNo(Integer.parseInt(histNo));
                histWifi.setLongitude(longitude);
                histWifi.setLatitude(latitude);
                histWifi.setSearchDate(date);

                wifiList.add(histWifi);
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

        return wifiList;
    }

}
