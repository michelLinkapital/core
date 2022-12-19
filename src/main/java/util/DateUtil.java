package util;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static io.jsonwebtoken.lang.Strings.hasText;
import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Has the responsibility to make operations over dates.
 */
public class DateUtil {

    private static final Logger log = getLogger(DateUtil.class);

    private static final String GENERAL_PATTERN = "[M[/][-][.]d[/][-][.]yyyy[['T'][ ]H:m:s[.SSS][VV]]]" +
            "[d[/][-][.]M[/][-][.]yyyy[['T'][ ]H:m:s[.SSS][VV]]]" +
            "[yyyy[/][-][.]M[/][-][.]d[['T'][ ]H:m:s[.SSS][VV]]]";

    private DateUtil() {
    }

    /**
     * Converts a string to a date with the "yyyy-MM-dd" pattern.
     *
     * @param date {@link String} The date to parse.
     * @return {@link Date}
     * @throws ParseException If the beginning of the specified String object cannot be parsed.
     */
    public static Date convert(String date) throws ParseException {
        //todo sacar estos formatos de fecha del util
        var format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return format.parse(date);
    }

    /**
     * Parse a date to a string with the provided pattern.
     *
     * @param date    {@link Date} The date to format.
     * @param pattern {@link String} The format to apply.
     * @return {@link Date}
     */
    public static @NotNull String format(Date date, String pattern) {
        var format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return format.format(date);
    }

    /**
     * Converts a string to a date with the "MM-yyyy" pattern. Ex: novembro 2021
     *
     * @param date {@link String} The date to parse.
     * @return {@link Date} The Date object parsed from String object.
     */
    public static LocalDate parseToLocalDate(String date) {
        var now = LocalDate.now();
        if (!hasText(date))
            return now;

        var array = date.trim().split(" ");
        if (array.length < 2)
            return now;

        var m = array[0];
        var year = array[1];

        if (!hasText(m) || !hasText(year))
            return now;

        var month = switch (m) {
            case "janeiro" -> 1;
            case "fevereiro" -> 2;
            case "março" -> 3;
            case "abril" -> 4;
            case "maio" -> 5;
            case "junho" -> 6;
            case "julho" -> 7;
            case "agosto" -> 8;
            case "setembro" -> 9;
            case "outubro" -> 10;
            case "novembro" -> 11;
            default -> 12;
        };

        return LocalDate.of(parseInt(year), month, 1);
    }

    /**
     * Gets number of years between two dates.
     *
     * @param init {@link Date} The init date.
     * @param end  {@link Date} The end date.
     * @return {@link Integer}   The primitive integer. The number of years between first and last date.
     */
    public static int yearsDiff(Date init, Date end) {
        var a = Calendar.getInstance();
        var b = Calendar.getInstance();

        a.setTime(init);
        b.setTime(end);

        var diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);

        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE)))
            diff--;

        return diff;
    }

    /**
     * Parse date in defined format.
     *
     * @param date {@link String} the date to be parsed
     *             dd(/-.)MM(/-.)yyyy [T] [h:m:s][zona]
     *             MM(/-.)dd(/-.)yyyy [T] [h:m:s][zona]
     *             yyyy(/-.)dd(/-.)MM [T] [h:m:s][zona]
     * @return {@link LocalDateTime}
     */
    public static @NotNull LocalDateTime parse(String date) {
        try {
            var formatter = new DateTimeFormatterBuilder()
                    .appendPattern(GENERAL_PATTERN)
                    .parseDefaulting(HOUR_OF_DAY, 0)
                    .toFormatter();

            return LocalDateTime.parse(date, formatter);
        } catch (Exception e) {
            log.error(e.getMessage());

            return LocalDateTime.now();
        }
    }

    public static @NotNull LocalDate parseLocalDate(String date) {
        var formatter = new DateTimeFormatterBuilder()
                .appendPattern(GENERAL_PATTERN)
                .parseDefaulting(HOUR_OF_DAY, 0)
                .toFormatter();

        return LocalDate.parse(date, formatter);
    }

}
