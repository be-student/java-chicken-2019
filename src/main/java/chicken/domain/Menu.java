package chicken.domain;

import java.util.Objects;

public class Menu {

    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(int number, String name, Category category, int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isId(int id) {
        return number == id;
    }

    public int calculatePrice(int count) {
        if (category == Category.BEVERAGE) {
            return price * count;
        }
        return price * count - count / 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return number == menu.number && price == menu.price && name.equals(menu.name) && category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, category, price);
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
