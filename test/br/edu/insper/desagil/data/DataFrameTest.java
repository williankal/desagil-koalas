package br.edu.insper.desagil.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataFrameTest {
	private static double DELTA = 0.000001;

	private DataFrame d;

	@BeforeEach
	public void setUp() {
		d = new DataFrame();
	}

	@Test
	public void invalidMin() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.min("invalidMin");
		});
		assertEquals("Column invalidMin is invalid!", e.getMessage());
	}

	@Test
	public void invalidMax() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.max("invalidMax");
		});
		assertEquals("Column invalidMax is invalid!", e.getMessage());
	}

	@Test
	public void invalidSum() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.sum("invalidSum");
		});
		assertEquals("Column invalidSum is invalid!", e.getMessage());
	}

	@Test
	public void invalidAvg() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.avg("invalidAvg");
		});
		assertEquals("Column invalidAvg is invalid!", e.getMessage());
	}

	@Test
	public void invalidVar() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.var("invalidVar");
		});
		assertEquals("Column invalidVar is invalid!", e.getMessage());
	}

	@Test
	public void invalidStd() {
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.std("invalidStd");
		});
		assertEquals("Column invalidStd is invalid!", e.getMessage());
	}

	@Test
	public void emptyMin() {
		d.addColumn("emptyMin", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.min("emptyMin");
		});
		assertEquals("Column emptyMin is empty!", e.getMessage());
	}

	@Test
	public void emptyMax() {
		d.addColumn("emptyMax", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.max("emptyMax");
		});
		assertEquals("Column emptyMax is empty!", e.getMessage());
	}

	@Test
	public void emptySum() {
		d.addColumn("emptySum", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.sum("emptySum");
		});
		assertEquals("Column emptySum is empty!", e.getMessage());
	}

	@Test
	public void emptyAvg() {
		d.addColumn("emptyAvg", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.avg("emptyAvg");
		});
		assertEquals("Column emptyAvg is empty!", e.getMessage());
	}

	@Test
	public void emptyVar() {
		d.addColumn("emptyVar", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.var("emptyVar");
		});
		assertEquals("Column emptyVar is empty!", e.getMessage());
	}

	@Test
	public void emptyStd() {
		d.addColumn("emptyStd", new ArrayList<>());
		DataFrameException e = assertThrows(DataFrameException.class, () -> {
			d.std("emptyStd");
		});
		assertEquals("Column emptyStd is empty!", e.getMessage());
	}

	@Test
	public void oneValue() {
		List<Double> values = new ArrayList<>();
		values.add(4.2);
		d.addColumn("oneValue", values);

		assertEquals(4.2, d.min("oneValue"), DELTA);
		assertEquals(4.2, d.max("oneValue"), DELTA);
		assertEquals(4.2, d.sum("oneValue"), DELTA);
		assertEquals(4.2, d.avg("oneValue"), DELTA);
		assertEquals(0.0, d.var("oneValue"), DELTA);
		assertEquals(0.0, d.std("oneValue"), DELTA);
	}

	@Test
	public void twoEqualValues() {
		List<Double> values = new ArrayList<>();
		values.add(4.2);
		values.add(4.2);
		d.addColumn("twoEqualValues", values);

		assertEquals(4.2, d.min("twoEqualValues"), DELTA);
		assertEquals(4.2, d.max("twoEqualValues"), DELTA);
		assertEquals(8.4, d.sum("twoEqualValues"), DELTA);
		assertEquals(4.2, d.avg("twoEqualValues"), DELTA);
		assertEquals(0.0, d.var("twoEqualValues"), DELTA);
		assertEquals(0.0, d.std("twoEqualValues"), DELTA);
	}

	@Test
	public void twoAscendingValues() {
		List<Double> values = new ArrayList<>();
		values.add(3.5);
		values.add(4.2);
		d.addColumn("twoAscendingValues", values);

		assertEquals(3.5   , d.min("twoAscendingValues"), DELTA);
		assertEquals(4.2   , d.max("twoAscendingValues"), DELTA);
		assertEquals(7.7   , d.sum("twoAscendingValues"), DELTA);
		assertEquals(3.85  , d.avg("twoAscendingValues"), DELTA);
		assertEquals(0.1225, d.var("twoAscendingValues"), DELTA);
		assertEquals(0.35  , d.std("twoAscendingValues"), DELTA);
	}

	@Test
	public void twoDescendingValues() {
		List<Double> values = new ArrayList<>();
		values.add(4.2);
		values.add(3.5);
		d.addColumn("twoDescendingValues", values);

		assertEquals(3.5   , d.min("twoDescendingValues"), DELTA);
		assertEquals(4.2   , d.max("twoDescendingValues"), DELTA);
		assertEquals(7.7   , d.sum("twoDescendingValues"), DELTA);
		assertEquals(3.85  , d.avg("twoDescendingValues"), DELTA);
		assertEquals(0.1225, d.var("twoDescendingValues"), DELTA);
		assertEquals(0.35  , d.std("twoDescendingValues"), DELTA);
	}

	@Test
	public void threeEqualValues() {
		List<Double> values = new ArrayList<>();
		values.add(4.2);
		values.add(4.2);
		values.add(4.2);
		d.addColumn("threeEqualValues", values);

		assertEquals( 4.2, d.min("threeEqualValues"), DELTA);
		assertEquals( 4.2, d.max("threeEqualValues"), DELTA);
		assertEquals(12.6, d.sum("threeEqualValues"), DELTA);
		assertEquals( 4.2, d.avg("threeEqualValues"), DELTA);
		assertEquals( 0.0, d.var("threeEqualValues"), DELTA);
		assertEquals( 0.0, d.std("threeEqualValues"), DELTA);
	}

	@Test
	public void threeAscendingValues() {
		List<Double> values = new ArrayList<>();
		values.add(3.5);
		values.add(4.2);
		values.add(6.7);
		d.addColumn("threeAscendingValues", values);

		assertEquals( 3.5     , d.min("threeAscendingValues"), DELTA);
		assertEquals( 6.7     , d.max("threeAscendingValues"), DELTA);
		assertEquals(14.4     , d.sum("threeAscendingValues"), DELTA);
		assertEquals( 4.8     , d.avg("threeAscendingValues"), DELTA);
		assertEquals( 1.886666, d.var("threeAscendingValues"), DELTA);
		assertEquals( 1.373559, d.std("threeAscendingValues"), DELTA);
	}

	@Test
	public void threeDescendingValues() {
		List<Double> values = new ArrayList<>();
		values.add(6.7);
		values.add(4.2);
		values.add(3.5);
		d.addColumn("threeDescendingValues", values);

		assertEquals( 3.5     , d.min("threeDescendingValues"), DELTA);
		assertEquals( 6.7     , d.max("threeDescendingValues"), DELTA);
		assertEquals(14.4     , d.sum("threeDescendingValues"), DELTA);
		assertEquals( 4.8     , d.avg("threeDescendingValues"), DELTA);
		assertEquals( 1.886666, d.var("threeDescendingValues"), DELTA);
		assertEquals( 1.373559, d.std("threeDescendingValues"), DELTA);
	}
}
