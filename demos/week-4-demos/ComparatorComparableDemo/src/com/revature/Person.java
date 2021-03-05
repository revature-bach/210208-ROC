package com.revature;

public class Person /*implements Comparable<Person>*/ {

	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
//	@Override
//	public int compareTo(Person o) {
//		// this > otherObj => positive
//		// this < otherObj => negative
//		// this == otherObj => 0
////		return this.age - o.getAge();
//		
//		// If I want to compare first by age, and then compare by firstName, if ages are equal..
//		if (this.age != o.getAge()) {
//			return this.age - o.getAge();
//		} else if (!this.firstName.equals(o.firstName)) {
//			return this.firstName.compareTo(o.firstName);
//		} else {
//			return this.lastName.compareTo(o.lastName);
//		}
//	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
}
