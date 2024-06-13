package Classes.Object.OverrideEquals;

// Переопределяем метод equals();
// Он должен отвечать такми свойствам как: reflexsive/symmetric/transitive/consistent/not null


public class OverrEquals {
    public static void main(String[] args) {
        Book one = new Book("Lord of the rings");
        Book two = new Book("Lord of the rings");
        Book three = new Book("Lord of the rings");

        // reflexive - сравнение обьекта с самим собой возвращает true 
        System.out.println("reflexive:");
        System.out.println(one.equals(one)); 
        System.out.println();

        // symmetric - если один обьект эквивалентен одругому то наоборот должно быть так же
        System.out.println("cymetric:");
        System.out.println(one.equals(two)); 
        System.out.println(two.equals(one)); 
        System.out.println();

        // transitive - если один обьект эквивалентен нескольким, то они вс едоолжны быть эквивалентны между собой
        System.out.println("transitive:");
        System.out.println(one.equals(two));
        System.out.println(two.equals(three));
        System.out.println(one.equals(three));
        System.out.println();

        // consistent - при неоднократном вызове equals() с одними и теми же обьектами всегда должен быть один результат
        System.out.println("consistent:");
        System.out.println(one.equals(three));
        System.out.println(one.equals(three));
        System.out.println(one.equals(three));
        System.out.println(one.equals(three));
        System.out.println();

        // not null - сравнение обьекта с null всегда должно давать false
        System.out.println("not null:");
        System.out.println(one.equals(null)); // false
    }
}


class Book {
    String title;
    public Book(String title) {
        this.title = title;
    }

    // Если obj является экземпляром класса Book то проверяем на not null и сравниваем поле title
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return obj != null && this.title.equals(((Book) obj).title);
        }
        return false;
    }


    // Автоматическое переопределение метода equals():
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;

    //     Book book = (Book) obj;

    //     return title.equals(book.title);
    // }
}