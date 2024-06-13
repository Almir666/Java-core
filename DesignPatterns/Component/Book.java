package DesignPatterns.Component;

// Этот класс содержит ContentsComponent contents, то есть наше содержание и напишем метод 
public class Book {
    ContentsComponent contents;

	public Book(ContentsComponent contents) {
		this.contents = contents;
	}
// Выводит содержимое на печать
	public void printContents() {
		contents.print();
	}
}
