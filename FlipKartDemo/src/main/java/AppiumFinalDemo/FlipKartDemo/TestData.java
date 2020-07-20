package AppiumFinalDemo.FlipKartDemo;

import org.testng.annotations.DataProvider;

public class TestData 
{
	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		//2 sets of data, "hello" , "!@#$$"
		Object[][] obj=new Object[][]
				{
			
				{"Apple Mobiles"},
				};
				
				return obj;
				
	}

}

