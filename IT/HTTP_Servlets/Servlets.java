/**
 * Servlet lifecycle
 *
 *      1. Инициализация сервлета, выполняется один раз при обращении к сервлету.
 *         1. Load Servlet class - Загрузка класса в JVM
 *         2. New Servlet Instance (Reflection API) - создается экземпляр сервлета
 *         3. Invoke servlet.init();
 *
 *      2. - Invoke servlet.service() при каждом образении к сервлету.
 *
 *      3. - Invoke servlet.destroy() выполняется один раз, когда Tomcat заканчивает работу.
 *
 * 
 * 
 */