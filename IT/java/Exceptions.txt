/**
 *
 * Источник https://www.youtube.com/watch?v=usiKCn7SwxI&ab_channel=ComputerScienceCenter
 *
 *
 * Исключения в Java — объекты, которые можно "выбрасывать".
 *
 * - Можно выбрасывать явно - "throw".
 * - Могут быть выброшены вызванным методом или конструктором ( непроверяемые или явно объявленные ).
 * - Выбрасываются виртуальной машиной ( непроверяемые ).
 *
 * Для создания своего исключения можно расширять класс
 * - Exception (для создания проверяемого исключения)
 * - RuntimeException (для создания непроверяемого исключения).
 */
public class Test {
    static class MyException extends Exception {
    }

    /**
     * Из-за того, что мы не обрабатываем исключение и оно проверяемое,
     * то мы обязаны объявить его в сигнатуре метода
     */
    static void test() throws MyException {
        throw new MyException();
    }

    /**
     * Здесь ошибка, из-за того, что мы вызываем метод у которого объявлено проверяемое исключение,
     * мы должны что-то сделать с этим исключением.
     *
     * Мы можем либо перебросить, тогда мы обязаны добавить исключение в сигнатуру метода,
     * либо поймать и обработать.
     *
     * Если какой-то блок никогда не будет выполнен,
     * из-за того что вышестоящий блок будет обрабатывать все исключения, тогда получим ошибку компиляции.
     *
     *
     * 
     * @param args
     */
    public static void main(String[] args) /** throws MyException() */
    {
        /** try { */
        test();
        /** } catch (MyException exception) {
         } */


        /**
         * Для обработки исключений используется блок try-catch.
         * Весь код в блоке try выполняется последовательно до момента возникновения исключения,
         * далее выполняются блоки catch.
         * Находится первый блок, который способен обработать исключение, и выполняется его логика.
         * В одном try может выполниться один catch.
         */
        try{
            test();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

/**
 *                                             +-- Other (checked)
 *                                            |
 *                +-- Exception (checked) ----
 *               |                            \
 * Throwable ----                              +-- RuntimeException (unchecked)
 *               \
 *                + -- Error (unchecked)
 *
 *
 *
 * Есть базовый класс Throwable. У него есть два наследника
 * - Error
 * - Exception
 *
 * Исключения могут быть проверяемые и непроверяемые.
 *
 * - Проверяемые исключения мы обязаны ловить или перебрасывать ( объявлять в сигнатуре метода ). (класс и подклассы Exception, кроме RuntimeException)
 * - Непроверяемые могут вылететь из любого метода, даже если не объявлено в сигнатуре метода. (класс и подклассы Error и RuntimeException)
 *
 * Исключения Error можно ловить и обрабатывать.
 * Если есть большая программа и в какой-то части кода возникло исключение Error,
 * его можно обработать не останавливая другие функции программы, это лучше, чем остановка всего сервиса.
 *
 *  Примеры исключений:
 *      Error:
 *          - StackOverflowError
 *          - NoSuchFieldError
 *          - OutOfMemoryError
 *      Exception:
 *          - SQLException
 *          - IOException
 *          - IllegalAccessException
 *          - TimeoutException
 *      RuntimeException:
 *          - NullPointerException
 *          - ArithmeticException
 *          - ArrayIndexOutOfBoundException
 *          - IndexOutOfBoundException
 *
 * Unchecked исключения сигнализируют о баге в программе, что означает,
 * что эти исключения не надо ловить и обрабатывать, а надо фиксить баг.
 *
 * Checked исключения - это ошибка вызванная состоянием внешнего мира,
 * и как бы правильно мы не писали нашу программу, мы не можем их избежать.
 * Поэтому эти исключения надо обрабатывать.
 *  Пример:
 *   Мы пытаемся открыть файл, а его нет на нашем компьютере,
 *   это вызовет ошибку IOException, это ситуация с которой мы всегда можем столкнуться.
 *
 *
 *  Способы обработки исключений:
 *   - Логирование ( редко, в специальных точках программы )
 *      try {
 *          test();
 *      }catch(MyException exception) {
 *          exception.printStackTrace(); // bad practice
 *          LOG.log(Level.SEVERE, "Error while executing test", exception); // good practice
 *      }
 *   - Восстановление после исключения ( если не свидетельствует об ошибке программы, а о внешних проблемах )
 *   - Перебрасывать ( завернув в исключение другого типа, при этом сохраняя исходное исключения в виде причины )
 *      try {
 *          test();
 *      }catch (IOException exception){
 *          throw new MyException("Unable to execute test"); // bad practice
 *          throw new MyException("Unable to execute test", exception); // good practice
 *      }
 *
 *  -------------------------------------------
 *
 *   Еще один вариант реализации конструкции try - это try-finally.
 *   Секция finally будет выполнена после try вне зависимости от того, как завершилась секция try.
 *
 *      try {
 *
 *      } catch(){
 *
 *      } finally {
 *
 *      }
 *
 *   или
 *
 *      try {
 *
 *      } finally {
 *
 *      }
 *
 *  Интересно!
 *      1. Метод вернет значение 6.
 *
 *      public static int test(){
 *          try {
 *              return 5;
 *          }
 *          finally {
 *              return 6; // bad practice
 *          }
 *      }
 *
 *      2. Метод вернет значение 5.
 *
 *      public static int test(){
 *          int x = 5;
 *          try {
 *              return x;
 *          }
 *          finally {
 *              x = 6;
 *          }
 *      }
 *
 */



