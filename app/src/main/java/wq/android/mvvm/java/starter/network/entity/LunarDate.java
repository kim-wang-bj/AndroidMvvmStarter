package wq.android.mvvm.java.starter.network.entity;

import java.util.List;
import java.util.Map;

import lombok.Value;

/**
 * @author Wang Qi
 */
@Value
public class LunarDate {
    private int year;
    private int month;
    private int day;
    private int lunarYear;
    private int lunarMonth;
    private int lunarDay;
    private String cnyear;
    private String cnmonth;
    private String cnday;
    private String hyear;
    private String cyclicalYear;
    private String cyclicalMonth;
    private String cyclicalDay;
    private String suit;
    private String taboo;
    private String animal;
    private String week;
    private List<String> festivalList;
    private Map<String, String> jieqi;
    private int maxDayInMonth;
    private boolean leap;
    private String lunarYearString;
    private boolean bigMonth;
}
