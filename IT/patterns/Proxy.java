/**
 * Прокси структурный паттерн проектирования, который позволяет подставлять
 * вместо реальных объектов специальные объекты-заменители.
 *
 * Эти объекты перехватывают вызовы к оригинальному объекту,
 * позволяя сделать что-то до или после передачи вызова оригиналу.
 *
 * + Ленивая инициализация (виртуальный прокси). Когда у вас есть тяжёлый
 *   объект, грузящий данные из файловой системы или базы данных.
 *
 * + Защита доступа (защищающий прокси). Когда в программе есть разные типы
 *   пользователей, и вам хочется защищать объект от неавторизованного доступа.
 *   Например, если ваши объекты — это важная часть операционной системы,
 *   а пользователи — сторонние программы (хорошие или вредоносные).
 *
 * + Кеширование объектов («умная» ссылка). Когда нужно кешировать
 *   результаты запросов клиентов и управлять их жизненным циклом.
 *
 * + Логирование запросов (логирующий прокси).
 *   Когда требуется хранить историю обращений к сервисному объекту.
 */