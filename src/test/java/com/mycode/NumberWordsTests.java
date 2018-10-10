package com.mycode;

import org.junit.*;
import com.mycode.NumberWords;

public class NumberWordsTests {
	private NumberWords numberWords ;
	
	@Before
	public void setup() {
		numberWords = new NumberWords() ;
	}

	@Test
	public void numberOutOfRangeReturnsError() {
		Assert.assertEquals( "Error", "Number out of range", numberWords.toWords( -1 ) ) ;
	}

	@Test
	public void exitZero() {
		Assert.assertEquals( "Error", "End of Program", numberWords.toWords( 0 ) ) ;
	}

	@Test
	public void lengthGreaterThanFour() {
		Assert.assertEquals( "Error", "Length more than 4 is not supported", numberWords.toWords( 10000 ) ) ;
	}

	@Test
	public void oneDigit() {
		Assert.assertEquals( "Error", "one" , numberWords.toWords( 1 ) ) ;
	}
	
	@Test
	public void twoDigit() {
		Assert.assertEquals( "Error", "twenty", numberWords.toWords( 20 ) ) ;
		Assert.assertEquals( "Error", "thirteen", numberWords.toWords( 13 ) ) ;
		Assert.assertEquals( "Error", "twenty one", numberWords.toWords( 21 ) ) ;
		Assert.assertEquals( "Error", "fifty", numberWords.toWords( 50 ) ) ;
		Assert.assertEquals( "Error", "ninety nine", numberWords.toWords( 99 ) ) ;
	}
	
	@Test
	public void threeDigit() {
		Assert.assertEquals( "Error", "one hundred", numberWords.toWords( 100 ) ) ;
		Assert.assertEquals( "Error", "one hundred ninety nine", numberWords.toWords( 199 ) ) ;
		Assert.assertEquals( "Error", "nine hundred ninety nine", numberWords.toWords( 999 ) ) ;
	}
	
	@Test
	public void FourDigit() {
		Assert.assertEquals( "Error", "one thousand one hundred ninety nine", numberWords.toWords( 1199 ) ) ;
		Assert.assertEquals( "Error", "nine thousand nine hundred ninety nine", numberWords.toWords( 9999 ) ) ;
	}
}
