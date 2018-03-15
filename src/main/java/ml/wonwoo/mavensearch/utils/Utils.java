package ml.wonwoo.mavensearch.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Utils {

  private Utils() {
    throw new AssertionError();
  }

  private static Map<Long, String> daysLookup =
          IntStream.rangeClosed(1, 31).boxed()
                  .collect(Collectors.toMap(Integer::longValue, Utils::getOrdinal));

  private static DateTimeFormatter englishDateFormatter = new DateTimeFormatterBuilder()
          .appendPattern("MMMM")
          .appendLiteral(" ")
          .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
          .appendLiteral(" ")
          .appendPattern("yyyy")
          .toFormatter(Locale.ENGLISH);

  public static String formatToEnglish(TemporalAccessor temporal) {
    return englishDateFormatter.format(temporal);
  }

  public static String formatToEnglish(long value) {
    return formatToEnglish(longToDateTime(value));
  }


  public static LocalDateTime longToDateTime(long value) {
    return Instant
            .ofEpochMilli(value)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
  }

  private static String getOrdinal(int n) {
    if (n >= 11 && n <= 13) {
      return n + "th";
    }
    if (n % 10 == 1) {
      return n + "st";
    }
    if (n % 10 == 2) {
      return n + "nd";
    }
    if (n % 10 == 3) {
      return n + "rd";
    }
    return n + "th";
  }

}