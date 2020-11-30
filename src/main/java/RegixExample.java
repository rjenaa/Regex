import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegixExample {

    public static void main(String[] args) {
        System.out.println("abcdefg".matches("c.e"));
        System.out.println("abcdefg".matches(".b.d.f"));

        System.out.println(Arrays.asList("23,42,62,hike".split(",")));

        System.out.println(Arrays.asList("anne on the 100 days".split(" ")));

        System.out.println(Arrays.asList("anne on the 100 days".split("xxx")));

        //matches all characters then it returns empty

        String test = "x and tigers and bears, oh my";

        String replaced= test.replaceAll("q","lions");

        System.out.println(test==replaced);

        Pattern pattern = Pattern.compile(",");

        String[] split = pattern.split("12,34,66,78");
        System.out.println(Arrays.asList(split));

        Pattern masterCardPattern = Pattern.compile(
                "^(?:5[1-5][0-9] {2} | 222[3-9][0-9] | 2 [3-6] [0-9] {2} | 27[01][0-9] | 2720) [0-9]{12}$"
        );

        boolean matches = pattern.matcher("5112345678890123").matches();
        boolean matches1 = pattern.matcher("2721345678890123").matches();
        Collection <String>numbers = Arrays.asList(
                "5112345678890123",
                "2721345678890123"

        );

        System.out.println(matches);

        List<String> valids = numbers.stream().filter(masterCardPattern.asPredicate())
                .collect(Collectors.toList());

        boolean backslash = " (212) 345-6780 "
        .matches("^\\*s\\(\\d{3}\\)\\s*\\d{3}-\\d{4}\\s*$");
        System.out.println(backslash);

        // [a-gA-G]

        //Quantifiers * = 0 or more, + = 1 or more, ? is 0 or 1

        //(pattern)quantifier e.g. (\d+\w+){2/4}

        //Naming them
        Pattern pattern2 = Pattern.compile(
                "(?<business>\\w+) (-(\\w+))+-(?<region>\\w+)");

        //^ beggining of a line, $ end of line , /b before or after a word, /B non word

        String text = "The \"rain\" in Spain \"falls\" mainly on \"the plain\"";
        Pattern patterntext = Pattern.compile("(\"\\w+\")|(\\w+)");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
        {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }

    }


}
