/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GetDateTime {

    static DateTimeFormatter format = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");
    public static LocalDateTime now = LocalDateTime.now();

    public static List<String> get7Date() {
        List<String> dateList = new ArrayList<String>();
        for (int i = 6; i >= 0; i--) {
            dateList.add(now.minusDays(i).format(format));
        }
        return dateList;
    }
}
