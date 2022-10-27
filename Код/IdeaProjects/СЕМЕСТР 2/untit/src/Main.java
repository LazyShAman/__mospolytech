public class Main {
    public static void main (String[] args) {
        String input = "*****";
        String regex = "\\**";
        boolean result = input.matches(regex);
        System.out.println(result);

        input = "0123";
        regex = "(1|2|3|4|5|6|7|8|9)(0|1|2|3|4|5|6|7|8|9)*";
        //regex = "[1-9][0-9]*"; // N
        result = input.matches(regex);
        System.out.println(result);

        input = "0000.0123";
        regex = "(0|[1-9]*).[0-9]*"; // R
        result = input.matches(regex);
        System.out.println(result);

        input = "abc123@gmail.com";
        regex = "([A-Z][a-z][0-9]*).[0-9]*"; // R
        result = input.matches(regex);
        System.out.println(result);

        input = "vlad..vlad.vorobyev@yandex.ru";
        /*
           ЛОГИН
             первый и последний символы почты - буква или цифра;
             между ними буквы, цифры и "-", "_", ".";
             затем @;
           ДОМЕН НИЖНЕГО УРОВНЯ
             после идут буквы, цифры и "-";
             затем .;
           ДОМЕН ВЕРХНЕГО УРОВНЯ
             от двух штук буквы, цифры и "-";
         */
        regex = "([0-9A-Za-z][-0-9A-z\\.]+[0-9A-Za-z])@([-A-Za-z]+.)[-A-Za-z]{2,}";
        result = input.matches(regex);
        System.out.println(result);
    }
}
