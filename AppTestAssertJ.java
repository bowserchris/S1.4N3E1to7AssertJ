package n3e1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

////source for these tests are from https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-assertj/
////very useful and allowed me to see an each case example of how it is applied, why and where.

class AppTestAssertJ {
	
	///////Ejercicio1//////
	//An assertion that proves that the value of two integer objects is equal, and 
	//another that shows that they are not.

	@Test		//test para probar si son iguales E1
	void twoIntegerObjectsEqualTrue() {
		var testActual = new TestObjectInt(5);
		var testExpected = new TestObjectInt(5);
		//assertThat(testActual.equals(testExpected));
		assertThat(testActual).isEqualTo(testExpected);
	}
	
	@Test		//test para probar que no son iguales E1
	void twoIntegerObjectsEqualFalse() {
		var testActual = new TestObjectInt(5);
		var testExpected = new TestObjectInt(7);
		assertThat(testActual).isNotEqualTo(testExpected);
	}

	
	///////Ejercicio2//////
	/*An assertion that proves that the reference to one object is the same as another, 
	and another that indicates that it is different.*/
	
	@Test
	void oneReferenceToAnotherObjectIsTheSameObject() {
		var testActual = new TestObjectInt(5);
		var testExpected = testActual;
		assertThat(testActual).isSameAs(testExpected);
	}
	
	@Test
	void oneReferenceToAnotherObjectIsNotTheSameObject() {
		var testActual = new TestObjectInt(5);
		var testExpected = new TestObjectInt(5);
		assertThat(testActual).isNotSameAs(testExpected);
	}
	
	///////Ejercicio3//////
	//An assertion indicating that two arrays of integers are identical.
	
	@Test
	void arraysOfIntegersAreIdentical() {
		int[] arrayActual = new int[] {1,2,3,4};
		int[] arrayExpected = new int[] {1,2,3,4};
		assertThat(arrayActual).isEqualTo(arrayExpected);
	}
	
	///////Ejercicio4//////
	/*1)Create an arrayList containing several types of objects (create them too). 
	2)Write an assertion to verify the order of the objects in the ArrayList as 
	they have been inserted.
	3)Now check that the above list contains the objects in any order.
	4)Verify that, in the above list, one of the objects has been added only 
	once. 
	5)Leave one of the elements unadded, and check that the list does 
	not contain the latter.*/
	//1)
	
	class ArrayListAssertionTest {

		private List<Object> objectList;
		private TestObjectInt objectTest;
		private String objectString;
		private Integer objectInt;
		private Animal objectAnimal;

		void createAndInitializeList() {
			objectTest = new TestObjectInt(5);
			objectString = "hello";
			objectInt = 4;
			objectAnimal = new Animal("labrador");
			objectList = Arrays.asList(objectTest, objectString, objectInt, objectAnimal);
		}

		//2)
		@Test
		void addedToArrayListInGivenOrder() {
			assertThat(objectList).containsExactly(objectTest, objectString, objectInt, objectAnimal);
		}

		//3)
		@Test
		void addedToArrayListInAnyGivenOrder() {
			assertThat(objectList).containsExactlyInAnyOrder(objectString, objectTest, objectAnimal, objectInt);
		}

		//4)
		@Test
		void shouldContainObjectOnlyOnce() {
			assertThat(objectList).containsOnlyOnce(objectAnimal);
		}

		//5)
		@Test
		void shouldNotContainNewAnimalInList(){
			assertThat(objectList).doesNotContain(new Animal("retriever"));
		}
	}
	
	///////Ejercicio5//////
	//It creates a map and verifies that it contains one of the keys it adds.
	
	class MapAssertionTest {
		private Map<String, String> map;
		private String key = "key";
		private String value = "value";

		@Test
		void createAndInitializeMap() {
			map = new HashMap<>();
			map.put(key, value);
		}

		@Test
		void shouldContainCorrectKeyInMap() {
			assertThat(map).containsKey(key);
		}
	}
	
	///////Ejercicio6//////
	//Throws an ArrayIndexOutOfBoundsException in any class. Create an assertion 
	//that validates that the exception is thrown when appropriate.
	@Test
	void ShouldThrowArrayIndexOutOfBoundsException() {
		assertThatThrownBy(() -> { throw new ArrayIndexOutOfBoundsException(); }).isExactlyInstanceOf(ArrayIndexOutOfBoundsException.class);
	}
	
	///////Ejercicio7//////
	//Create an empty Optional object. Write the correct assertion to verify that 
	//it is indeed empty.
	
	@Test
	void optionalObjectShouldBeEmpty(){
		assertThat(Optional.empty()).isEmpty();
	}
}
