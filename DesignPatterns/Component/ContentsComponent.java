package DesignPatterns.Component;
// Центральное место в структуре данного паттерна занимает интерфейс или абстрактный класс Component - 
// он содержит ряд методов и может реализовывать поведение по умолчанию или содержать методы без реализации 
// для того чтобы конкретную реализацию задавали классы наследники.
// В данном случае классом Companent будет выступать ContentsComponent

abstract class ContentsComponent {
    // В данном методе в классах наследниках мы переопределим логику добавления элементов нашего содержания.
    public void add(ContentsComponent contentsComponent) {
        throw new UnsupportedOperationException();
    }
    // Получаем название главы
    public String getName() {
		throw new UnsupportedOperationException();
	}
    // Получаем номер страницы
	public Integer getPages() {
		throw new UnsupportedOperationException();
	}
    // Переопределим в классах наследника непосредственно вывод на экран глав и параграфов.
	public void print() {
		throw new UnsupportedOperationException();
	}
}