package com.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	List<Food> food = new ArrayList<>();

	public void on() {
		for (int a = 0; a < food.size(); a++) {
			Food f = food.get(a);
			System.out.println(f.getId() + ")" + f.getName());
		}
	}

	public static void main(String[] args) {
		Main m = new Main();

		try {
			FileReader fr = new FileReader("menu.txt");
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			String[] tokens = line.split(",");
			int count = Integer.parseInt(tokens[0]);

			for (int i = 0; i < count; i++) {
				String name = tokens[i * 2 + 1];
				int price = Integer.parseInt(tokens[i * 2 + 2]);

				m.food.add(new Food(i + 1, name, price));

			}
			m.on();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
