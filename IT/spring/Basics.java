/**
 * Spring Framework это
 *      - DI container
 *      - AOP
 *      - Облегчение тестирования
 *      - Облегчает интегрирование с огромным количеством тезнологий
 *      - Очень развитый и продолжает развиваться
 */


/**
 * Способы конфигурации Spring:
 *      - Annotation-based (наиболее употребляемая)
 *      - XML-based
 *      - Groovy-based
 *
 * Как определять и порождать bean
 *
 *      — classpath scanning - поиск аннотированных классов - @ComponentScan("package name")
 *          - @Component
 *              - @Service
 *              - @Controller
 *              - @Repository
 *              * эти аннотации ничем не отличаются с точки зрения построения бинов
 *      — фабричные методы
 *          - @Configuration -> @Bean
 */


/**
 * Для использования классов из библиотек можно пользоваться созданивем бинов через @Configuration -> @Bean
 */

@Configuration
public class AppConfig {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Color randomColor() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}

/**
 * Scope
 *      SCOPE_SINGLETON - по умолчанию. Создается один при первом запросе и всюду используется один экземпляр.
 *      SCOPE_PROTOTYPE - создается новый при каждом запросе.
 */

/**
 * По умолчанию все синглетоны создаются при поднятии контейнера
 * (чтобы fail fast, и чтоб избежать задаржек при работе приложения)
 *
 * Это поведение можно изменить для конкретного бина при помощи @Lazy (ленивая инициализация)
 *
 * Может быть плохой идеей использовать @Lazy потому что:
 *      - при использовании приложения пользователю придется ждать пока объект будет создаваться.
 *      - если из-за проблем с конфигурацией мы этот объект не сможем создать, то мы это узнаем в процессе работы приложения.
 */

/**
 * Bean
 *
 * У каждого бина есть имя
 *      - имя класса (SpeakerImpl -> speakerImpl)
 *      - фабричный метод (getSpeaker -> speaker)
 *      - параметр аннотации ( @Service("speaker") )
 */

/**
 * Виды injection
 *
 *      - constructor (самы распространенный)
 *              + дает иммутабельность
 *              + легко тестировать
 *              + красиво
 *      - setter
 *      - field
 *              - вне контекста спринга делает объект неиспользуемым
 *              + удобно в классах тестах
 *      - lookup method
 *              + используется в случае если в bean singleton нужно инжектить bean prototype
 *
 *                Пример 1.
 *                @Component
 *                public abstract class Foo {
 *                      @Lookup
 *                      abstract Bar getBar();
 *
 *                      public void bar() {
 *                          Bar b = new getBar();
 *                      }
 *                }
 *
 *                Пример 2.
 *                @Component
 *                public class Foo {
 *                      @Lookup
 *                      Bar getBar() {
 *                          return null;
 *                      }
 *
 *                      public void bar() {
 *                          Bar b = new getBar();
 *                      }
 *                }
 *
 *
 */