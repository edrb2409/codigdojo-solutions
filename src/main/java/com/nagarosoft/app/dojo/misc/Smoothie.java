package com.nagarosoft.app.dojo.misc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Functional Smooothies Inc. is releasing a new smoothie machine that will make the best icy fruit beverages of all time. According to Wikipedia:
 *
 * A smoothie (occasionally spelled smoothee or smoothy) is a thick, cold beverage made from pureed raw fruit blended with ice cream or frozen yogurt along with other ingredients such as crushed ice, fruit juice, sweeteners, dairy products, nuts, seeds, etc.
 *
 * In order to sell the machine to smoothie vendors all over the world, Functional Smooothies needs to ensure that the machine takes all dietary preferences and allergies into account. They have hired you to write the software for the machine.
 *
 * The software has a menu of standard smoothie options, including the ingredients for each drink. When a customer places their order, they supply a list of zero or more dietary restrictions that must be honoured. Your software will print out a list of the ingredients that the smoothie operator needs to put into the machine.
 *
 * Menu
 * The menu options, along with the ingredients needed for each are as follows.
 *
 * Classic: strawberry, banana, pineapple, mango, peach, honey
 * Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
 * Greenie: green apple, lime, avocado, spinach, ice, apple juice
 * Just Desserts: banana, ice cream, chocolate, peanut, cherry
 * Input
 * You should write a function called ingredients, which takes as input a string containing item from the menu and optionally one or more ingredients to omit from the smoothie, separated by commas.
 *
 * Restricted ingredients have to be preceded by - sign, as opposed to the ones that should be added. As adding new ingredients is not supported yet, any input with additional ingredents is considered invalid.
 *
 * Note that in a very rare cases of the user input processor mechanical failures, there order might be lost or arrive empty to the software.
 *
 * Output
 * The function should return a string listing the ingredients that the operator needs to put in. To make it more convenient for the operator, the ingredients should be listed in alphabetical order and separated by commas in the string returned from the function.
 *
 * In case of input being invalid an IllegalArgumentException should be thrown. Smoothie with no ingredients is represented as "".
 *
 * Examples
 * if a customer orders a Classic but is allergic to strawberry and peanuts, your function will be called with the argument "Classic,-strawberry,-peanut" should return "banana,honey,mango,peach,pineapple". Note that it is valid have the allergens not present in the ordered smoothie.
 * Requesting Classic with additional chocolate "Classic,chocolate" should result in IllegalArgumentException being thrown
 * Same result should apply for requesting a smoothie that is not present in the menu "Vitamin smoothie"
 */
public class Smoothie {

    public static final Map<String, List<String>> options = getOptions();

    public static String ingredients(String order) {
        if(order == null || order.isEmpty()) throw new IllegalArgumentException();

        final String[] orderParsed = order.split(",", 2);

        final String menuOption = orderParsed[0];
        final List<String> ingredientsOptions = orderParsed.length == 2 ?
                Arrays.asList(orderParsed[1].split(",")) : new ArrayList<>();

        if(!containsOption(menuOption)) throw new IllegalArgumentException();

        if(hasAdditionalIngredient(ingredientsOptions)) throw new IllegalArgumentException();

        return  getIngredientsFiltered(menuOption, ingredientsOptions).stream()
                    .sorted()
                    .collect(Collectors.joining(","));

    }

    private static Map<String, List<String>> getOptions() {
        Map<String, List<String>> options = new HashMap<>();

        options.put("Classic", Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
        options.put("Freezie", Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));
        options.put("Greenie", Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));
        options.put("Just Desserts", Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry"));

        return options;
    }

    private static boolean containsOption(String menuOption) {
        return options.containsKey(menuOption);
    }

    private static boolean hasAdditionalIngredient(List<String> ingredientsOptions) {
        return ingredientsOptions.stream().anyMatch(it -> !it.startsWith("-"));
    }

    private static List<String> getIngredientsFiltered(String menuOption, List<String> ingredientsOptions) {
        List<String> ingredients = new ArrayList<>(options.get(menuOption));

        ingredients.removeIf(it -> ingredientsOptions.contains("-" + it));

        return ingredients;
    }

}
