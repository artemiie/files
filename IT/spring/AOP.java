/**
 * AOP - Aspect Oriented Programming - изменения стандартного поведения метода.
 *
 *       Для того, чтобы модифицировать работу какого-то объекта,
 *       существует возможность вешать proxy объект над объектом.
 *
 *       Этот proxy объект создается с помощью Reflection API
 *
 *
 *                              -------------------
 *                              |   proxy         |
 *                              |                 |
 *              ——————————      |     ——————————  |
 *              | caller | ———> |---> | target |  |
 *              ——————————      |     ——————————  |
 *                              -------------------
 *
 *
 * Типичные задачи AOP
 *       - логирование (каждый класс должен  отмечаться логами)
 *       - безопасность (проверка имеем ли мы право на вызов метода)
 *       - управление транзакциями (открывать транзакцию, коммитить, откатывать)
 *
 * AOP помогает решить задачи без дублирования кода.
 *
 *
 */



/**
 *
 * Термины:
 *
 * Joinpoint - место в коде, в выполнение которого вмешиваемся и начинаем выполнять что-то свое.
 *
 * Advice - код, который инжектится и выполняется в joinpoint.
 *
 * Pointcut - множество joinpoint-ов.
 *            Пример:  - все методы, начинающиеся со слова get
 *                     - все методы, с аннотацией @Benchmarked
 *            Связывая pointcut и advice мы указываем что и когда будет работать.
 *
 * Aspect - комбинация advice + pointcut, оформленная в виде отдельного класса.
 *          Определяет добавляемую в приложение логику, ответственную за какую-то задачц.
 *
 * Weaving - процесс вплетения кода advice в нужные места кода.
 *
 * Target - метод, чьё поведение изменяется с помощью AOP.
 *
 */


/**
 *
 * Возможности реализовать AOP
 *
 * 1. Статически - вплетение на уровне исходников или байт-кода.
 * 2. Динамически - создавая прокси и используя вплетение в runtime
 *
 * Spring AOP использует динамический AOP.
 *
 */


/**
 *
 * Для активации BeanPostProcessor, сканирующего AOP-аннотации,
 * надо включить аннотацию @EnableAspectJAutoProxy
 *
 */

/**
 * Пример аспекта
 */

@Component
@Aspect
public class BenchmarkAspect {
    @Around("@annotation(Benchmark)") //pointcut expression
    public Object execEntryPoint(ProceedingJoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        long start = System.nanoTime();
        Object retVal = joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println(end-start);
        return retVal;
    }
}


/**
 * Типы advice
 *      - @Before
 *      - @AfterReturning
 *      - @AfterThrowing
 *      - @After
 *      - @Aroud
 */

/**
 * BeanPostProcessor
 *
 *  - postProcessBeforeInitialization
 *  - postProcessAfterInitialization
 */