package DesignPatterns.Component;

// Класс Leaf - конечный элемент дерева, он является наследником Component. 
// Данный класс не содержит дочерних элементов. Он также реализует методы, полученные по наследству от класса Component. 
// Некоторые методы могут не иметь смысла в данном классе (например метод add()), в таких случаях генерируется исключение.

//  Этот класс отвечает за наши параграфы. Здесь не будет списка новыъ элементов,
//  так как он будет у нас как лист на дереве — не будет содержать в себе больше элементов.
public class ContentsItem extends ContentsComponent{
    String name;
	Integer pages;

	public ContentsItem(String name, Integer pages) {
		this.name = name;
		this.pages = pages;
	}
  
	public String getName() {
		return name;
	}
  
	public Integer getPages() {
		return pages;
	}
    // Выводим название параграфа и номер страницы.

	public void print() {
		System.out.print("  " + getName());
		for (int i = 0; i < 68-getName().length(); i++) {
			System.out.print(".");
		}
		System.out.println(getPages());
	}
}
