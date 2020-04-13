package kz.kaspi;

import kz.kaspi.shop.Cashier;
import kz.kaspi.shop.product.clothes.Clothes.Color;
import kz.kaspi.shop.product.clothes.Clothes.Size;
import kz.kaspi.shop.product.clothes.Jeans;
import kz.kaspi.shop.product.clothes.Jeans.Cloth;
import kz.kaspi.shop.product.clothes.Jeans.Fit;
import kz.kaspi.shop.product.clothes.Shirt;
import kz.kaspi.shop.product.clothes.Shirt.NeckType;
import kz.kaspi.shop.product.food.Kefir;
import kz.kaspi.shop.product.food.Milk;
import kz.kaspi.shop.product.food.Sausage.Builder;
import kz.kaspi.shop.product.food.Sausage.MeatType;
import kz.kaspi.shop.product.other.CleaningAgent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Cashier cashier = new Cashier();

        List<Buyer> buyers = new ArrayList<>();

        Buyer buyer1 = new Buyer("Azamat");
        buyer1.add(new Jeans(2.3, "Jeans, yes it is!", now, Size.S, Color.BLACK, Fit.SLIM, Cloth.JEAN));
        buyer1.add(new Shirt(40, "$40 shirts", now, Size.L, Color.GREEN, NeckType.HENLEY));
        buyer1.add(new Kefir(99.1, "For sure kefir", now, 20, 20));
        buyers.add(buyer1);

        Buyer buyer2 = new Buyer("Tomiris");
        buyer2.add(Builder.getInstance().
                price(45.1).title("Sausage").issueDate(now.minusDays(38)).
                expireDays(41).meatType(MeatType.HALF_SMOKED).
                build());
        buyer2.add(new CleaningAgent(9999, "007", now.minusYears(1)));
        buyer2.add(new Milk(11.99, "Milk yeah", now, 2, 3.2f));
        buyers.add(buyer2);

        Buyer buyer3 = new Buyer("Carol");
        buyer3.add(Builder.getInstance().
                price(999).title("Built sausage").issueDate(now.minusDays(39)).
                expireDays(2).meatType(MeatType.COOKED).
                build());
        buyer3.add(new Jeans(1.22, "Jeanssss", now.minusDays(222), Size.XL, Color.GREEN, Fit.BAGGY,
                Cloth.ECRU));
        buyer3.add(new Jeans(51, "WEWEWE", now.minusDays(1), Size.XS, Color.MIXED, Fit.SKINNY,
                Cloth.CHAMBRAY));
        buyers.add(buyer3);

        Buyer buyer4 = new Buyer("Loser");
        buyers.add(buyer4);

        Buyer buyer5 = new Buyer("Carol");
        buyer5.add(new Shirt(23.2, "SHIRT of SHIRT", now.minusYears(1), Size.M, Color.YELLOW,
                NeckType.ROUND));
        buyers.add(buyer5);

        buyers.forEach(buyer -> {
            double sum = cashier.calculate(buyer);

            if (sum >= 0) {
                System.out.println(buyer + " ---> " + sum);
            }
        });
    }
}
