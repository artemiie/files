/**
 * https://refactoring.guru/ru/design-patterns/factory-method
 * https://refactoring.guru/ru/design-patterns/factory-method/java/example
 *
 * Цель
 *
 * Паттерн Фабричный метод предлагает создавать объекты не напрямую,
 * используя оператор new, а через вызов особого фабричного метода.
 *
 * Создание интерфейса, который порождает объекты. Выбор того, экземпляр
 * какого класса создавать остается за классов, которые имплементируют
 * данные интерфейс.
 *
 * Для чего
 *
 * Для делегироания создания экземпляров другому классу.
 *
 * Пример использования
 *
 * - когда заранее неизветсно, экземпляры какого класса нужно будет создать
 * - класс спроектирован таким образом, что создаваемые им объекты имеют
 *   свойства определенного класса
 */

public class Program {
  public static void main(String[] args) {
    DeveloperFactory developerFactory = createDeveloper("java");
    Developer developer = developerFactory.createDeveloper();
    developer.writeCode();
  }

  static DeveloperFactory createDeveloper(String developer) {
    if (developer.equals("java")) {
      return new JavaDeveloperFactory();
    } else if (developer.equals("cpp")) {
      return new CppDeveloperFactory();
    } else {
      throw new RuntimeException(developer + " developer is not available.");
    }
  }

}

public interface DeveloperFactory {
  Developer createDeveloper();
}

public class JavaDeveloperFactory implements DeveloperFactory {
  @Override
  Developer createDeveloper() {
    return new JavaDeveloper();
  }
}

public class CppDeveloperFactory implements DeveloperFactory {
  @Override
  Developer createDeveloper() {
    return new CppDeveloper();
  }
}

public interface Developer {
  void writeCode();
}

public class JavaDeveloper implements Developer {
  @Override
  void writeCode() {
    System.out.println("Java developer");
  }
}

public class CppDeveloper implements Developer {
  @Override
  void writeCode() {
    System.out.println("Cpp developer");
  }
}