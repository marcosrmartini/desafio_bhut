package br.com.bhut.desafio.payload;

import java.io.Serializable;


public class CarPayload implements Serializable {

	private static final long serialVersionUID = -1536997609820823006L;

//	"_id": "5da645aff8c90839dee0d19e",
//    "title": "palio",
//    "brand": "fiat",
//    "price": "12",
//    "age": 23,
//    "__v": 0

	private String _id;
	private String title;
	private String brand;
	private String price;
	private int age;
	private int __v;

	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	@Override
	public String toString() {
		return "Car [id=" + _id + ", title=" + title + ", brand=" + brand + ", price=" + price + ", age=" + age
				+ ", __v=" + __v + "]";
	}

}
