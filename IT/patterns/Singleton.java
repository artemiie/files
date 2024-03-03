/**
 * Singleton позволяет создать объект в одном экземпляре.
 * К этому объекту есть глобальный доступ, обычно через статический метод или
 * переменную.
 *
 * Чаще всего это полезно для доступа к какому-то общему ресурсу, например,
 * базе данных.
 *
 * Такое поведение невозможно реализовать с помощью обычного конструктора,
 *  так как конструктор класса всегда возвращает новый объект.
 *
 *  Почему не работает без volatile?
 *
 * Проблема идиомы Double Checked Lock заключается в модели памяти Java,
 * точнее в порядке создания объектов. Можно условно представить этот
 * порядок следующими этапами [2, 3]:
 *
 * Пусть мы создаем нового студента: Student s = new Student(), тогда
 *
 * 1) local_ptr = malloc(sizeof(Student)) // выделение памяти под сам объект;
 * 2) s = local_ptr // инициализация указателя;
 * 3) Student::ctor(s); // конструирование объекта (инициализация полей);
 *
 * Таким образом, между вторым и третьим этапом возможна ситуация, при которой
 * другой поток может получить и начать использовать
 * (на основании условия, что указатель не нулевой) не полностью
 * сконструированный объект.
 */


public class Singleton {
  private static volatile Singleton instance;
  private static final Object lock = new Object();

  public static Singleton getInstance() {
    Singleton result = instance;
    if (result != null) {
      return result;
    }

    synchronized (lock) {
      if (instance == null) {
        return instance = new Singleton();
      }
      return instance;
    }
  }
}