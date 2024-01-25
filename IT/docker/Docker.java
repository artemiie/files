/**
 * Источник https://www.youtube.com/playlist?list=PLnh8EajVFTl7oqQGrnobnlKghaUQ6IOva
 */

/**
 *      Docker image - шаблон, на основание которого создается docker container.
 *                      image имеет уникальное название и тег.
 *                      image состоит из metadata и layers.
 *
 *      metadata - информация про все, что необходимо знать,
 *                  чтоб на основании image запустить container
 *                  (информация про слои, порты, команды, итд)
 *
 *      layers - набор директорий и файлов. Иерархическая структура,
 *                слои наслаиваются друг на друга. слои являются read-only.
 *
 *               пример: 1 слой всегда snapshot операционной системы
 *                       2 слой JVM
 *                       3 файл jar
 *
 *  Скачать готовый образ
 *      docker pull {registry}/{repository}/{name}:{tag}
 *
 *      docker pull ubuntu
 *      docker pull ubuntu:latest
 *      docker pull fliostor/ubuntu:latest
 *
 *
 *
 *
 */