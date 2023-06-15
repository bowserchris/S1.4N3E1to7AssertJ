package n3e1;

import java.util.Objects;

public class TestObjectInt {
	
	private Integer number;
	
	public TestObjectInt(Integer number) {
		this.number = number;
	}

	public Integer getValue() {
		return number;
	}

	public void setValue(Integer value) {
		this.number = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TestObjectInt other = (TestObjectInt) obj;
		return Objects.equals(number, other.number);
	}
	
	

}
