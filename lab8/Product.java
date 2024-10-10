package lesson8.labs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product {
	final String title;
	final double price;
	final int model;
	enum SortMethod {BYTITLE, BYPRICE};

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getModel() {
		return model;
	}

	public Product(String title, Double price, int model) {
		this.title = title;
		this.price = price;
		this.model = model;
	}

	public static void productSort(List<Product> productList, SortMethod method) {
		class ProductComparator implements Comparator<Product> {
			@Override
			public int compare(Product p1, Product p2) {
				if(method == SortMethod.BYTITLE) {
					return p1.getTitle().compareTo(p2.getTitle());
				} else {
						return Double.compare(p1.getPrice(), p2.getPrice());

				}
			}
		}

		Collections.sort(productList, new ProductComparator());
	}

	public static void productSortLambda(List<Product> productList, SortMethod method) {
		Collections.sort(productList, (p1, p2) -> {
			if(method == SortMethod.BYTITLE) {
				return p1.getTitle().compareTo(p2.getTitle());
			} else {
				return Double.compare(p1.getPrice(), p2.getPrice());
			}
		});
	}
	@Override
	public String toString() {
		return String.format("\n %s : %s : %s", title, price, model);
	}
}


