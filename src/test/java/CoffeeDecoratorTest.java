import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoffeeDecoratorTest {

	Coffee order;

	@BeforeEach
	void init(){
		order = new BasicCoffee();
	}

	@Test
	void test() {
		double cost = order.makeCoffee();
		assertEquals(3.99, cost);
	}

	@Test
	void test_cream(){
		this.order = new Cream (order);
		double cost = order.makeCoffee();
		assertEquals(4.49, cost);
	}

	@Test
	void test_sugar(){
		this.order = new Sugar (order);
		double cost = order.makeCoffee();
		assertEquals(4.49, order.makeCoffee());
	}

	@Test
	void test_extraShot(){
		this.order = new ExtraShot (order);
		double cost = order.makeCoffee();
		assertEquals(5.09, order.makeCoffee());
	}

	@Test
	void test_frenchVanillaSwirl(){
		this.order = new FrenchVanillaSwirl (order);
		double cost = order.makeCoffee();
		assertEquals(4.74, order.makeCoffee());
	}

	@Test
	void test_almondMilk(){
		this.order = new AlmondMilk (order);
		double cost = order.makeCoffee();
		assertEquals(4.99, order.makeCoffee());
	}

	@Test
	void test_total(){
		this.order = new Cream (order);
		this.order = new Sugar (order);
		this.order = new AlmondMilk(order);
		this.order = new ExtraShot(order);
		assertEquals(7.09, order.makeCoffee(), "Total doesn't works as expected.");
	}

	@Test
	void test_sameAddon(){
		this.order = new FrenchVanillaSwirl(order);
		this.order = new FrenchVanillaSwirl(order);
		assertEquals(5.49,order.makeCoffee());
	}

	@Test
	void test_checkIfOrderIsNull() {
		assertNotNull(order);
	}

	@Test
	void test_MultipleDoubleAddons(){
		this.order = new ExtraShot(order);
		this.order = new ExtraShot(order);
		this.order = new AlmondMilk(order);
		this.order = new AlmondMilk(order);
		double cost = order.makeCoffee();
		assertEquals(8.19, cost);
	}
}
