import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("ПРОЕКТ \"CALCULATING MACHINE\" V1.0\n" +
                "Введите желаемую операцию из двух операндов, разделяя их пробелами:");

        Scanner my_scanner = new Scanner(System.in);
        String input_str = my_scanner.nextLine();

        //Проверка адекватности инпута
        //Проверка количества строк после разделения
        String[] separated_input = input_str.split(" ");
        if (separated_input.length != 3) {
            throw  new Exception();//System.out.println("Некорректный ввод");
        }


        //Проверка количества римских цифр, перевод их в стринговые цифры
        int roman_counter = 0;
        for (int i = 0; i <= 2; i += 2){
            for (RomanNumeral number : RomanNumeral.values()) {
                if (number.name().equalsIgnoreCase(separated_input[i])) {
                    roman_counter++;
                    separated_input[i] = number.getEquivalent();
                }
            }
        }
        if (roman_counter == 1 || roman_counter == 3) {
            throw new Exception();//System.out.println("Только римские или только арабские, или, ну или ты вообще не понимаешь, что такое калькулятор");
        }

        //попытка перевода стринговых цифр в интовые
        int[] operands = new int[2];
        try{
            operands[0] = Integer.parseInt(separated_input[0]);
            operands[1] = Integer.parseInt(separated_input[2]);
        }
        catch (Exception e) {
            throw new Exception();//System.out.println("Калькулятор - это про цифры(причем про целые в случае calculating machine)"
        }

        //Убеждаюсь, что операнды меньше 10
        for(int i = 0; i < operands.length; i++){
            if (operands[i] > 10)
                throw new Exception();//System.out.println("Числа великоваты");

        }

        //как убедился, что римских цифр нет или обе римские, убедился в интовости операндов, делаю ансвер
        int answer;
        switch(separated_input[1]){
            case "+":
                answer = operands[0] + operands[1];
                break;
            case "-":
                answer = operands[0] - operands[1];
                break;
            case "/":
                answer = operands[0] / operands[1];
                break;
            case "*":
                answer = operands[0] * operands[1];
                break;
            default:
                throw new Exception();//System.out.println("У тебя должен быть специальный значок в серединке, переделывай");
        }

        //Делаю римский ансвер для случая из двух римских
        if (roman_counter == 2){
            if (answer < 1)
                throw new Exception();//System.out.println("Ой, там такое в ответе, лучше не смотреть даже");

            StringBuilder roman_answer = new StringBuilder();
            String[] roman_symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] arabic_values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            int i = 0;
            while (answer > 0) {
                if (answer >= arabic_values[i]) {
                    roman_answer.append(roman_symbols[i]);
                    answer -= arabic_values[i];
                } else
                    i++;
            }
            System.out.println(roman_answer);
        }
        else
            System.out.println(answer);
    }
}