import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FulfillmentTest {
	private CalculateCostDAO cDao = new CalculateCostDAO();
	private ProductDAO pDao = new ProductDAO();
	private FileDAO fDao = new FileDAO();
	
	@Before
	public void beforeTest() {
		cDao = new CalculateCostDAO();
		System.out.println("beforeTest()");
	}
	
	@Test		//물품 10개 이하일 때 뜨는 숫자
	public void selectProductCount() {
		int result = pDao.selectProductCount();
		assertEquals(3, result);
		System.out.println("selectProductCount()");
	}
	
	@Test		//csv파일 넣기
	public void insertFileIntoTable() {
		String result = fDao.toString();
		assertNotNull("조회결과 null", result);
		System.out.println("insertFileIntoTable()");
	}
	
	@Test		//매출 총이익 2017년 6월
	public void totalSalesChart1() {
		int result = cDao.totalSalesChart(2017, 6);
		assertEquals(2890, result);
		System.out.println("totalSalesChart1()");
	}
	
	@Test		//매출 총이익 2018년 11월
	public void totalSalesChart2() {
		int result = cDao.totalSalesChart(2018, 11);
		assertEquals(3890, result);
		System.out.println("totalSalesChart2()");
	}
	
	@After
	public void afterTest() {
		cDao = new CalculateCostDAO();
		System.out.println("afterTest()");
	}

}
