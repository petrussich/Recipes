package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recipe {
    public Integer id;
    public String name;
    public String category;
    public String main_img;
    public String time;
    public String difficulty_level;
    public Integer favorite;

    public List<Step> steps;
    public List<String> ingrgredients;

    @Override
    public String toString() {;
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", main_img='" + main_img + '\'' +
                ", time='" + time + '\'' +
                ", difficulty_level='" + difficulty_level + '\'' +
                ", favorite=" + favorite +
                '}';
    }
    public Recipe() {
    }

    public Recipe(Integer id, String name, String category, String main_img, String time, String difficulty_level, Integer favorite) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.main_img = main_img;
        this.time = time;
        this.difficulty_level = difficulty_level;
        this.favorite = favorite;
    }



    public Double[] Count_p_c_f_cl (ArrayList<Product> Ingr){
        Double[] p_c_f_cl = {0.0, 0.0, 0.0, 0.0};

        for (Product ing: Ingr) {
            p_c_f_cl[0] += ing.temp_weight/100 * ing.protein;
            p_c_f_cl[1] += ing.temp_weight/100 * ing.carbohydrates;
            p_c_f_cl[2] += ing.temp_weight/100 * ing.fats;
            p_c_f_cl[3] += ing.temp_weight/100 * ing.calories;
        }

        return p_c_f_cl;
    }

    public int compareTo(Recipe o) {
        return name.compareTo(o.name);
    }
    public String getName() {
        return name;
    }
    public static final Comparator<Recipe> COMPARE_BY_COUNT = new Comparator<Recipe>() {

        public int compare(Recipe lhs, Recipe rhs) {
            return lhs.getCount() - rhs.getCount();
        }
    };
    private int getCount() {
        return 0;
    }

}
