
Источник https://www.udemy.com/course/java-ot-zaura/learn/lecture/21094050#overview



                             ----------
                              Iterable
                             ----------
                                  |
                          ----------------
                             Collection
                       -----------------------
                        |         |         \
                     ------    -------    -----      -----
                      List      Queue      Set        Map
                     ------    -------    -----      -----






                              ----------
                                 List
                          -------------------
                           |       |        \
                 ------------  --------  ------------
                   ArrayList    Vector    LinkedList
                 ------------  --------  ------------
                                  |
                              ---------
                                Stack
                              ---------
 
 
 
  List - базовый интерфейс для колекции.
         Каждый элемент имеет индекс.
         Сохраняет порядок добавления элементов.
         Элементы упорядочены, можно хранить дубликаты, можно хранить null.
 
          Методы:
               add(element)
               add(index, element)
               addAll(list)
               addAll(index, list)
               get(index)
               set(index, element) (replace)
               size()
               isEmpty()
               toString()
               remove(element)
               remove(index)
               removeAll(list)
               retainAll(list)
               clear()
               indexOf(element)
               lastIndexOf(element)
               contains(element)
               containsAll(list)
               subList(from_index, to_index)
               toArray()
               toArray(String[])
 
          Наследники:
 
          ArrayList - самая используемая коллекция. Похож на массив, но может расширятся.
 
          LinkedList - цепочка элементов. Каждый элемент имеет ссылку на следующий и предыдущий элемент, то есть ссылки на своих соседей.
                         Первый элемент цепи называется голова (head), последний элемент хвост (tail).
 
          Stack - Last in, first out (LIFO).
                  Методы:
                          push - добавить значение в стек
                          pop - возвращает последний добавленый элемент, и удаляет его из стека.
                          peek - возвращает последний добавленый элемент, но не удаляет его.
 
      Collections.binarySearch(list, key)
      Collections.sort(list)
      Collections.reverse(list)
      Collections.shuffle(list)
      Arrays.asList(list)
      Arrays.sort(list)
      Arrays.binarySearch(list, key)
      List.of(elements) (immutable)
      List.copyOf(list) (immutable)
 
 




                         -----------
                             Map
                    ----------------------
                      |       |        \
            -----------  -----------   -----------
              HashMap     SortedMap     HashTable
            -----------  -----------   -----------
                 |              \
        ---------------    ---------------
         LinkedHashMap       NavigableMap
        ---------------    ---------------
                                  \
                             -----------
                               TreeMap
                             -----------
 Map - элементы состоят из ключ/значение.
       Не сохраняет порядок добавления элементов.
       Ключи не могут повторяться.
       Значения могут повторяться.
       Ключ и значение может иметь значение null.
       Ключ и значение могут быть разных типов.

       Методы:
                 put(key, value)
                 putIfAbsent()
                 get(key)
                 remove(key)
                 containsValue(value)
                 containsKey(key)
                 keySet()
                 values()
                 entrySet()


 TreeMap - красно-черное дерево. элементами являются пары ключ/значение.
           Элементы хранятся в отсортированном по возрастанию порядке.
           Сортировка по ключу.

           Методы:
                    descendingMap()
                    tailMap(fromKey)
                    headMap(toKey)
                    lastEntry()
                    firstEntry()

 LinkedHashMap - наследник HashMap. Хранит информацию о порядке подавления элементов.
                 Каждый элемент имеет ссылку на следующий и предыдущий элемент.




                          ---------
                             Set
                          ---------
                          |       \
                   ---------      -----------
                    HashSet        SortedSet
                   ---------      -----------
                      |                 \
             ---------------          --------------
              LinkedHashSet            NavigableSet
             ---------------          --------------
                                             \
                                         -----------
                                           TreeSet
                                         -----------


 Set - коллекция уникальных элементов.

     HashSet - в основе стоит HashMap с заглушкой для value.
               Не сохраняет порядок добавления.

               Методы:
                         addAll(hashset)
                         retainAll(hashset)
                         removeAll(hashset)

     TreeSet - в основе стоит TreeMap с заглушкой для value.
               Элементы хранятся в отсортированном по возрастанию порядке.

               Методы:
                         first()
                         last()
                         headSet()
                         tailSet()
                         subSet()


