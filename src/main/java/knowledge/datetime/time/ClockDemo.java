package knowledge.datetime.time;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Clock
 * 一种时钟，使用一个时区提供对当前时刻、日期和时间的访问
 * https://docs.oracle.com/javase/8/docs/api/java/time/Clock.html
 *
 * @author ljh
 * created on 2021/1/16 10:41
 */
public class ClockDemo {

    private Clock clock;

    public ClockDemo() {
        this.clock = Clock.tick(Clock.systemUTC(), Duration.ofHours(1));    // TickClock[SystemClock[Z],PT1H]
        this.clock = Clock.tickMinutes(ZoneId.systemDefault());             // TickClock[SystemClock[Asia/Shanghai],PT1M]
        this.clock = Clock.tickSeconds(ZoneId.systemDefault());             // TickClock[SystemClock[Asia/Shanghai],PT1S]
        this.clock = Clock.systemUTC();                                     // SystemClock[Z]
        this.clock = Clock.systemDefaultZone();                             // SystemClock[Asia/Shanghai]
        this.clock = Clock.system(ZoneId.systemDefault());                  // SystemClock[Asia/Shanghai]
        this.clock = Clock.offset(this.clock, Duration.ofHours(-1));        // OffsetClock[SystemClock[Asia/Shanghai],PT-1H]
        this.clock = Clock.fixed(Instant.parse("2008-08-08T12:08:08.00Z"), ZoneId.systemDefault());
        System.out.println(clock);
        // FixedClock[2008-08-08T12:08:08Z,Asia/Shanghai]
    }

    @Test
    public void testClock() {
        System.out.println(clock.millis());             // 1218197288000
        System.out.println(clock.getZone());            // Asia/Shanghai
        System.out.println(clock.instant());            // 2008-08-08T12:08:08Z
        System.out.println(Date.from(clock.instant())); // Fri Aug 08 20:08:08 CST 2008
    }
}
