import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class BonusDatesBetween {

    static void printBonusDatesBetween(int fromYear, int toYear) throws ParseException {
        LocalDate date1 = new SimpleDateFormat("yyyy").parse(String.valueOf(fromYear)).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate date2 = new SimpleDateFormat("yyyy").parse(String.valueOf(toYear)).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        for (LocalDate date = date1; date.isBefore(date2); date = date.plusDays(1)) {
            String stringDate = date.toString().replace("-", "");
            String firstHalf = stringDate.substring(0, 4);
            String secondHalf = new StringBuilder(stringDate.substring(4, 8)).reverse().toString();
            if (firstHalf.equals(secondHalf)) {
                System.out.println(date.toString());
            }
        }
    }

    public static void main(String args[]) throws ParseException {
        printBonusDatesBetween(2010, 2015);
    }

}
