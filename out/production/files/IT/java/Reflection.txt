/**
 * Reflection api позволяет получить информацию о коде (поля, методы, конструкторы, и тд), в процессе выполнения программы.
 *
 * Employee e = new Employee();
 * Employee m = new Manager();
 *
 * Получаем информацию в Runtime
 * Class<? extends Employee> ce = e.getClass();
 * Class<? extends Employee> cm = m.getClass();
 *
 * ce.getName() -> path + Employee
 * cm.getName() -> path + Manager
 *
 * ce.getSimpleName() -> Employee
 * cm.getSimpleName() -> Manager
 *
 * Employee newEmp = ce.getDeclaredConstructor().newInstance();
 *
 * Так можно Class<Integer> c3 = int.class;
 * но c3.getConstructors() вернет пустой массив.
 *
 * А еще можно Class<int[]> c4 = int[].class;
 *
 * Может быть выброшен ClassNotFoundException
 * Class<?> clazz = Class.forName("class name");
 *
 *
 *
 * Методы класса Class
 *      getFields() - все публичные поля
 *      getMethods() - все публичные методы
 *      getConstructors() - все публичные конструкторы
 *
 *      getDeclaredFields() - все поля (без унаследованных)
 *      getDeclaredMethods() - все методы (без унаследованных)
 *      getDeclaredConstructors() - все конструкторы (без унаследованных)
 *
 *      ReflecionUtils.getAllFields() - все поля класса (+ унаследованные)
 *
 *  Generics, private, final - это конструкции компилятора, которые в compile time не дают нам написать невалидный код.
 *  С помощью рефлексии в runtime эти конструкции можно обойти.
 *
 */

public class Employee {
    public int id;
    public String name;
    public String department;
    private double salary;

    public Employee(){}

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void changeDepartment(String newDepartment){
        department = newDepartment;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employee = Class.forName("Employee");

        Field fieldId = employee.getField("id"); // returns field id of the class Employee
        System.out.println(fieldId.getType()); // int

        Field fieldSalary = employee.getDeclaredField(salary);
        fieldSalary.setAccessible(true); // makes private field accessible
        fieldSalary.set(employee, 500);

        Field[] publicfields = employee.getFields(); // returns all public fields of the class Employee
        for (Field field : publicfields){
            System.out.println(field.getName() + " - " + field.getType());
        }

        Field[] allfields = employee.getDeclaredFields(); // returns all fields of the class Employee
        for (Field field : allfields){
            System.out.println(field.getName() + " - " + field.getType());
        }

        Method cdMethod = employee.getMethod("changeDepartment", String.class);
        System.out.println(cdMethod.getReturnType()); // void
        System.out.println(Arrays.toString(cdMethod.getParameterTypes())); // String

        Method[] allMethods = employee.getDeclaredMethods(); // returns all methods of the class Employee
        for (Method method : allMethods){
            System.out.println(method.getName() + " - " + method.getReturnType());
        }

        Constructor constructor = employee.getConstructor();
        System.out.println(constructor.getParameterCount());
        System.out.println(constructor.getParameterTypes());

        Constructor constructorWith3Params = employee.getConstructor(int.class,String.class, String.class);

        Constructor[] constructors = employee.getConstructors();


        Object emp1 = constructor.newInstance(); // creates new Employee
        Object emp2 = constructorWith3Params.newInstance(1,"Name", "Dep");

        cdMethod.setAccessible(true); // makes private method accessible
        cdMethod.invoke(emp2,"new Dep"); // call method

    }
}