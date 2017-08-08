Polymorphism
===================
Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.

Any Java object that can pass more than one IS-A test is considered to be polymorphic. In Java, all Java objects are polymorphic since any object will pass the IS-A test for their own type and for the class Object.

It is important to know that the only possible way to access an object is through a reference variable. A reference variable can be of only one type. Once declared, the type of a reference variable cannot be changed.

The reference variable can be reassigned to other objects provided that it is not declared final. The type of the reference variable would determine the methods that it can invoke on the object.

A reference variable can refer to any object of its declared type or any subtype of its declared type. A reference variable can be declared as a class or interface type.
> **Example**
> `public interface Vegetarian{}`
> `public class Animal{}`
> `public class Deer extends Animal implements Vegetarian{}`

Now, the Deer class is considered to be polymorphic since this has multiple inheritance. Following are true for the above examples −

    A Deer IS-A Animal
    A Deer IS-A Vegetarian
    A Deer IS-A Deer
    A Deer IS-A Object

When we apply the reference variable facts to a Deer object reference, the following declarations are legal 

    Deer d = new Deer();
    Animal a = d;
    Vegetarian v = d;
    Object o = d;
All the reference variables d, a, v, o refer to the same Deer object in the heap.

----------

Virtual Methods
-------------
In this section, I will show you how the behavior of overridden methods in Java allows you to take advantage of polymorphism when designing your classes.

We already have discussed method overriding, where a child class can override a method in its parent. An overridden method is essentially hidden in the parent class, and is not invoked unless the child class uses the super keyword within the overriding method.

> **Example file 1:  Employee.java**
> 

    public class Employee {
    	private String name;
    	private String address;
    	private int number;
    
    	public Employee(String name, String address, int number) {
    		System.out.println("Constructing an Employee");
    		this.name = name;
    		this.address = address;
    		this.number = number;
    	}
    
    	public void mailCheck() {
    		System.out.println("Mailing a check to " + this.name + " " + this.address);
    	}
    
    	public String toString() {
    		return name + " " + address + " " + number;
    	}
    
    	public String getName() {
    		return name;
    	}
    
    	public String getAddress() {
    		return address;
    	}
    
    	public void setAddress(String newAddress) {
    		address = newAddress;
    	}
    
    	public int getNumber() {
    		return number;
    	}
    }

> **Example file 2:  Salary.java**
> 

    public class Salary extends Employee {
    	private double salary; // Annual salary
    
    	public Salary(String name, String address, int number, double salary) {
    		super(name, address, number);
    		setSalary(salary);
    	}
    
    	public void mailCheck() {
    		System.out.println("Within mailCheck of Salary class ");
    		System.out.println("Mailing check to " + getName() + " with salary " + salary);
    	}
    
    	public double getSalary() {
    		return salary;
    	}
    
    	public void setSalary(double newSalary) {
    		if (newSalary >= 0.0) {
    			salary = newSalary;
    		}
    	}
    
    	public double computePay() {
    		System.out.println("Computing salary pay for " + getName());
    		return salary / 52;
    	}
    
    	public static void main(String[] args) {
    		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
    		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
    		System.out.println("Call mailCheck using Salary reference --");
    		s.mailCheck();
    		System.out.println("\n Call mailCheck using Employee reference--");
    		e.mailCheck();
    	}
    }

> **Output (after running Salary.java):**
> Constructing an Employee
> Constructing an Employee
> Call mailCheck using Salary reference --
> Within mailCheck of Salary class 
> Mailing check to Mohd Mohtashim with salary 3600.0

> Call mailCheck using Employee reference--
> Within mailCheck of Salary class 
> Mailing check to John Adams with salary 2400.0


Here, we instantiate two Salary objects. One using a Salary reference s, and the other using an Employee reference e.

While invoking s.mailCheck(), the compiler sees mailCheck() in the Salary class at compile time, and the JVM invokes mailCheck() in the Salary class at run time.

mailCheck() on e is quite different because e is an Employee reference. When the compiler sees e.mailCheck(), the compiler sees the mailCheck() method in the Employee class.

Here, at compile time, the compiler used mailCheck() in Employee to validate this statement. At run time, however, the JVM invokes mailCheck() in the Salary class.

This behavior is referred to as virtual method invocation, and these methods are referred to as virtual methods. An overridden method is invoked at run time, no matter what data type the reference is that was used in the source code at compile time.
Abstraction
-------------
As per dictionary, abstraction is the quality of dealing with ideas rather than events. For example, when you consider the case of e-mail, complex details such as what happens as soon as you send an e-mail, the protocol your e-mail server uses are hidden from the user. Therefore, to send an e-mail you just need to type the content, mention the address of the receiver, and click send.

Likewise in Object-oriented programming, abstraction is a process of hiding the implementation details from the user, only the functionality will be provided to the user. In other words, the user will have the information on what the object does instead of how it does it.

In Java, abstraction is achieved using Abstract classes and interfaces.

###Abstract Class###
A class which contains the abstract keyword in its declaration is known as abstract class.

 - Abstract classes may or may not contain abstract methods, i.e.,
   methods without body ( public void get(); )
 - But, if a class has at least one abstract method, then the class must be declared abstract.
 - If a class is declared abstract, it cannot be instantiated.
 - To use an abstract class, you have to inherit it from another class, provide implementations to the abstract methods in it.
 - If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.

> **Example (Employee.java): **
> 

    public abstract class Employee {
    	private String name;
    	private String address;
    	private int number;
    
    	public Employee(String name, String address, int number) {
    		System.out.println("Constructing an Employee");
    		this.name = name;
    		this.address = address;
    		this.number = number;
    	}
    
    	public double computePay() {
    		System.out.println("Inside Employee computePay");
    		return 0.0;
    	}
    
    	public void mailCheck() {
    		System.out.println("Mailing a check to " + this.name + " " + this.address);
    	}
    
    	public String toString() {
    		return name + " " + address + " " + number;
    	}
    
    	public String getName() {
    		return name;
    	}
    
    	public String getAddress() {
    		return address;
    	}
    
    	public void setAddress(String newAddress) {
    		address = newAddress;
    	}
    
    	public int getNumber() {
    		return number;
    	}
    }

Now if you ***try to instantiate the Employee class***

    public class AbstractDemo {
       public static void main(String [] args) {
          Employee e = new Employee("George W.", "Houston, TX", 43);
          System.out.println("\n Call mailCheck using Employee reference--");
          e.mailCheck();
       }
    }
> **You will receive error:**
Employee.java:46: Employee is abstract; cannot be instantiated
      Employee e = new Employee("George W.", "Houston, TX", 43);
                   ^
1 error


###Inheriting the Abstract Class###
You cannot instantiate the Employee class, but you can instantiate the Salary Class, and using this instance you can access all the three fields and seven methods of Employee class as shown below
> **Example (Salary.java):**
>

    public class Salary extends Employee {
    	private double salary; // Annual salary
    
    	public Salary(String name, String address, int number, double salary) {
    		super(name, address, number);
    		setSalary(salary);
    	}
    
    	public void mailCheck() {
    		System.out.println("Within mailCheck of Salary class ");
    		System.out.println("Mailing check to " + getName() + " with salary " + salary);
    	}
    
    	public double getSalary() {
    		return salary;
    	}
    
    	public void setSalary(double newSalary) {
    		if (newSalary >= 0.0) {
    			salary = newSalary;
    		}
    	}
    
    	public double computePay() {
    		System.out.println("Computing salary pay for " + getName());
    		return salary / 52;
    	}
    
    	public static void main(String[] args) {
    		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
    		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
    		System.out.println("Call mailCheck using Salary reference --");
    		s.mailCheck();
    		System.out.println("\n Call mailCheck using Employee reference--");
    		e.mailCheck();
    	}
    }

> **Output**
> Constructing an Employee
> Constructing an Employee
> Call mailCheck using Salary reference --
> Within mailCheck of Salary class 
> Mailing check to Mohd Mohtashim with salary 3600.0

> Call mailCheck using Employee reference--
> Within mailCheck of Salary class 
> Mailing check to John Adams with salary 2400.0
###Abstract Methods###
If you want a class to contain a particular method but you want the actual implementation of that method to be determined by child classes, you can declare the method in the parent class as an abstract.

 - `abstract` keyword is used to declare the method as abstract.
 - You have to place the `abstract` keyword before the method name in the method declaration.
 - An `abstract` method contains a method signature, but no method body.
 - Instead of curly braces, an abstract method will **have a semoi colon (;) at the end**.
> **Example**
> 

		public abstract class Employee {
		       private String name;
		       private String address;
		       private int number;
			   public abstract double computePay();
		       // Remainder of class definition
		    }
Declaring a method as abstract has two consequences:
 - The class containing it must be declared as abstract.
 - Any class inheriting the current class must either override the abstract method or declare itself as abstract.

Suppose Salary class inherits the Employee class, then it should implement the computePay() method as shown below
> **Example**
> 

    public class Salary extends Employee {
       private double salary;   // Annual salary
       public double computePay() {
          System.out.println("Computing salary pay for " + getName());
          return salary/52;
       }
       // Remainder of class definition
    }

Interfaces
-------------
An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.

Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types. Method bodies exist only for default methods and static methods.

Writing an interface is similar to writing a class. But a class describes the attributes and behaviors of an object. And an interface contains behaviors that a class implements.

Unless the class that implements the interface is abstract, all the methods of the interface need to be defined in the class.

An interface is similar to a class in the following ways:

 - An interface can contain any number of methods.
 - An interface is written in a file with a .java extension, with the name of the interface matching the name of the file.
 - The byte code of an interface appears in a .class file.
 - Interfaces appear in packages, and their corresponding bytecode file must be in a directory structure that matches the package name.

However, an interface is different from a class in several ways:

 - You cannot instantiate an interface.
 - An interface does not contain any constructors.
 - All of the methods in an interface are abstract.
 - An interface cannot contain instance fields. The only fields that can appear in an interface must be declared both static and final.
 - An interface is not extended by a class; it is implemented by a class.
 - An interface can extend multiple interfaces.

###Declaring Interfaces###
> **Example**
>

    /* File name : NameOfInterface.java */
    import java.lang.*;
    // Any number of import statements
    public interface NameOfInterface {
       // Any number of final, static fields
       // Any number of abstract method declarations\
    }
Interfaces have the following properties −

 - An interface is implicitly abstract. You do not need to use the abstract keyword while declaring an interface. 
 - Each method in an interface is also implicitly abstract, so the abstract keyword is not needed. 
 - Methods in an interface are implicitly public.

> **Example**

    /* File name : Animal.java */
    interface Animal {
       public void eat();
       public void travel();
    }

###Implementing Interfaces###
When a class implements an interface, you can think of the class as signing a contract, agreeing to perform the specific behaviors of the interface. If a class does not perform all the behaviors of the interface, the class must declare itself as abstract.

A class uses the ***implements*** keyword to implement an interface. The implements keyword appears in the class declaration following the extends portion of the declaration.
 
> **Example**
> 

    /* File name : MammalInt.java */
    public class MammalInt implements Animal {
    
       public void eat() {
          System.out.println("Mammal eats");
       }
    
       public void travel() {
          System.out.println("Mammal travels");
       } 
    
       public int noOfLegs() {
          return 0;
       }
    
       public static void main(String args[]) {
          MammalInt m = new MammalInt();
          m.eat();
          m.travel();
       }
    } 

> **Output**
> Mammal eats
Mammal travels

When overriding methods defined in interfaces, there are several rules to be followed −

 - Checked exceptions should not be declared on implementation methods other than the ones declared by the interface method or subclasses of those declared by the interface method.
 - The signature of the interface method and the same return type or subtype should be maintained when overriding the methods.
 - An implementation class itself can be abstract and if so, interface methods need not be implemented.


When implementation interfaces, there are several rules −

 - A class can implement more than one interface at a time.
 - A class can extend only one class, but implement many interfaces.
 - An interface can extend another interface, in a similar way as a class can extend another class.

    

    


Further reading
===================
[What is the use of Java virtual method invocation?][1]

  [1]: https://stackoverflow.com/questions/11431185/what-is-the-use-of-java-virtual-method-invocation
