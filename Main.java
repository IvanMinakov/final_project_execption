java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол: ");
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            if (data.length != 6) { // проверяем количество данных
                System.err.println("Неверное количество данных!");
                return;
            }
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[4]); // пробуем распарсить номер телефона
            } catch (NumberFormatException e) {
                System.err.println("Неверный формат номера телефона!");
                return;
            }
            char gender = data[5].charAt(0);
            if (gender != 'f' && gender != 'm') { // проверяем пол
                System.err.println("Неверный формат пола!");
                return;
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true)); // создаем файл с фамилией
                writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender); // записываем данные в файл
                writer.newLine(); // переходим на следующую строку
                writer.close(); // закрываем соединение с файлом
                System.out.println("Данные успешно записаны в файл " + lastName + ".txt");
            } catch (Exception e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
