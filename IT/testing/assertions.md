Класс org.junit.jupiter.api.Assetions имеет следующие методы:

assertEquals() - проверка на эквивалентность
assertNotEquals()

assertTrue/False(boolean) - проверяет актульное значение
assertTrue/False(boolean, message) - в случае ошибки выводится сообщение
assertTrue/False(boolean, message, paremeters[]) - можно указать параметры сообщения

assertAll(() -> assertTrue()) - если тест имеет больше одного ассерта, то 
при падении одного ассерта остальные не будут выполнены. assertAll 
позволяет проверить все ассерты вне зависимости от результата их выполнения.