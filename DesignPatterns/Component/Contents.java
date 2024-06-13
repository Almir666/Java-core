package DesignPatterns.Component;

import java.util.ArrayList;
import java.util.Iterator;
// Класс Composite - это составной элемент дерева, он является наследником Component. 
// Он содержит набор дочерних компонентов children: Componenntss[]. Это могут быть как простые компоненты-листья, 
// так и другие компоненты-контейнеры. Методы данного класса переадресовывают основную работу своим дочерним компонентам, 
// но и могут что-то добавлять своё к результату.
// Здесь в рроли Composite выступает класс Contents.

// Класс Contents наследуем от ContentsComponent. Этот класс будет выполнять роль наших глав, 
// соответственно он должен содержать список уже более мелких элементов (параграфов) — 
// поэтому добавляем ArrayList <СontentsComponents> contentsComponents. 
// Также добавляем поля name и pages, которые будут отвечать за название главы и номера страницы.
public class Contents extends ContentsComponent {
    ArrayList<ContentsComponent> contentsComponents = new ArrayList<ContentsComponent>();
    String name;
    Integer pages;

    public Contents(String name, Integer pages) {
		this.name = name;
		this.pages = pages;
	}

    public void add(ContentsComponent contentsComp) {
        contentsComponents.add(contentsComp);
    }

    public String getName() {
		return name;
	}
 
	public Integer getPages() {
		return pages;
	}

// Переопределим метод public void print() — он будет выводить название главы и страницы, 
// а также перебирать все элементы из contentsComponents и вызывать у них свой метод print().    
    public void print() {
        System.out.print("\n" + getName());
        for (int i = 0; i < 70 - getName().length(); i++) {
            System.out.print(".");
        }
        System.out.println(getPages());

        Iterator<ContentsComponent> iterator = contentsComponents.iterator();
        contentsComponents.stream()
            .takeWhile(x -> iterator.hasNext())
            .map(n -> iterator.next())
            .forEach(ContentsComponent::print);
            
        
    }
}