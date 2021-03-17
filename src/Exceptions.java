/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
 * с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */

public class Exceptions {
    public static void main(String[] args) {

        String[][] array = new String[][]{
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}};

//        String[][] array = new String[][]{
//                {"1", "1", "1", "1"},
//                {"1", "1", "1", "1"},
//                {"2", "2", "2", "2"},
//                {"3", "3", "3", "3"},
//                {"4", "4", "4", "4"}};

//        String[][] array = new String[][]{
//                {"1", "1", "1", "1", "1"},
//                {"2", "2", "2", "2"},
//                {"3", "3", "3", "3"},
//                {"4", "4", "4", "4"}};

//        String[][] array = new String[][]{
//                {"a", "1", "1", "1"},
//                {"2", "2", "2", "2"},
//                {"3", "3", "3", "3"},
//                {"4", "4", "4", "4"}};

        try {
            try {
                int res = run(array);
                System.out.println(res);
            } catch (MyArraySizeException ignored) {
            }
        } catch (MyArrayDataException e) {
            System.out.println("Проверь координату: " + e.a + " x " + e.b);
        }

    }

    private static int run(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

