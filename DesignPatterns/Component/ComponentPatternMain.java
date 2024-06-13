package DesignPatterns.Component;

public class ComponentPatternMain {
    public static void main(String[] args) {
        ContentsComponent contents = new Contents("Contents", 1);
		// Создаем содержание
		ContentsComponent introduction = new Contents("1. Introduction", 1);
		ContentsComponent creatingAndDestroyingObject = new Contents("2. Creating and destroying object", 5);
		ContentsComponent methodsCommonToAllObject = new Contents("1. Methods common to all object", 37);
		ContentsComponent classesAndInterfaces = new Contents("1. Classes and interfaces", 73);

		contents.add(introduction);
		contents.add(creatingAndDestroyingObject);
		contents.add(methodsCommonToAllObject);
		contents.add(classesAndInterfaces);
		
		// Добавим главы
		creatingAndDestroyingObject.add(new ContentsItem("2.1 Consider static factory methods instead of constructors", 5));
		creatingAndDestroyingObject.add(new ContentsItem("2.2 Consider a builder when faced with many constructor parameters ", 10));
		creatingAndDestroyingObject.add(new ContentsItem("2.3 Enforce the singleton property with a private constructor ", 17));
		methodsCommonToAllObject.add(new ContentsItem("3.1 Obey the general contract when overriding equals ", 37));
		methodsCommonToAllObject.add(new ContentsItem("3.2 Always override hashCode when you override equals ", 50));
		classesAndInterfaces.add(new ContentsItem( "4.1 Minimize the accessibility of classes and members ", 73));
		classesAndInterfaces.add(new ContentsItem("4.2 in public classes, use accessor methods, not public fields ", 78));
		classesAndInterfaces.add(new ContentsItem("4.3 Minimize mutability ", 80));

		System.out.println("\"Effective Java\" Joshua Bloch, 2018");

		Book book = new Book(contents);
		book.printContents();
    }
}








