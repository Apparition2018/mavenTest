package knowledge.datetime.time;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ZoneDateTime
 * ISO-8601日历，具有时区的日期时间，如2007-12-03T10:15:30+01:00 Europe/Paris
 * <p>
 * https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html
 * https://www.yiibai.com/javatime/javatime_zoneddatetime.html
 *
 * @author ljh
 * created on 2019/8/8 19:39
 */
public class ZonedDateTimeDemo {

    private ZonedDateTime zdt;

    public ZonedDateTimeDemo() {
        zdt = ZonedDateTime.of(2018, 8, 8,
                20, 8, 8, 0,
                ZoneId.systemDefault());
    }

    /**
     * LocalDate	    toLocalDate()                       ZonedDateTime → LocalDate
     * LocalTime	    toLocalTime()                       ZonedDateTime → LocalTime
     * LocalDateTime	toLocalDateTime()                   ZonedDateTime → LocalDateTime
     * <p>
     * ChronoZonedDateTime
     * default Instant	toInstant()                         ZonedDateTime → Instant
     * default long	    toEpochSecond()                     ZonedDateTime → Second (纪元)
     */
    @Test
    public void to() {
        System.out.println(zdt.toLocalDate());       // 2018-08-08
        System.out.println(zdt.toLocalTime());       // 20:08:08
        System.out.println(zdt.toLocalDateTime());   // 2018-08-08T20:08:08
        System.out.println(zdt.toInstant());         // 2018-08-08T12:08:08Z
    }

}