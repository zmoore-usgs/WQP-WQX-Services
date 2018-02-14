package gov.usgs.cida.wqp.dao.count;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import gov.usgs.cida.wqp.CsvDataSetLoader;
import gov.usgs.cida.wqp.DBIntegrationTest;
import gov.usgs.cida.wqp.dao.NameSpace;
import gov.usgs.cida.wqp.mapping.CountColumn;

@Category(DBIntegrationTest.class)
@DatabaseSetup("classpath:/testData/csv/")
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class CountDaoResDetectQntLmtTest extends BaseCountDaoTest {

	protected NameSpace nameSpace = NameSpace.RES_DETECT_QNT_LMT;
	protected boolean includeActivity = true;
	protected boolean includeResults = true;

	@Test
	public void testHarness() {
		nullParameterTest();
		emptyParameterTest();
		analyticalMethodTest();
		assemblageTest();
		avoidTest();
		bboxTest();
		characteristicNameTest();
		characteristicTypeTest();
		countryTest();
		countyTest();
		huc2Test();
		huc3Test();
		huc4Test();
		huc5Test();
		huc6Test();
		huc7Test();
		huc8Test();
		huc10Test();
		huc12Test();
		minActivitiesTest();
		minResultsTest();
		nldiUrlTest();
		organizationTest();
		pcodeTest();
		projectTest();
		providersTest();
		resultTest();
		sampleMediaTest();
		siteIdTest();
		manySitesTest();
		siteTypeTest();
		startDateHiTest();
		startDateLoTest();
		stateTest();
		subjectTaxonomicNameTest();
		withinTest();
		multipleParameterStationSumTest();
		multipleParameterActivitySumTest();
		multipleParameterActivitySumStationSumTest();
		multipleParameterResultSumTest();
		multipleParameterResultSumStationSumTests();
	}

	public void nullParameterTest() {
		List<Map<String, Object>> counts = nullParameterTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, TOTAL_RES_DETECT_QNT_LMT_COUNT, NWIS_RES_DETECT_QNT_LMT_COUNT, STEWARDS_RES_DETECT_QNT_LMT_COUNT, STORET_RES_DETECT_QNT_LMT_COUNT, BIODATA_RES_DETECT_QNT_LMT_COUNT);
	}

	public void emptyParameterTest() {
		List<Map<String, Object>> counts = emptyParameterTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, TOTAL_RES_DETECT_QNT_LMT_COUNT, NWIS_RES_DETECT_QNT_LMT_COUNT, STEWARDS_RES_DETECT_QNT_LMT_COUNT, STORET_RES_DETECT_QNT_LMT_COUNT, BIODATA_RES_DETECT_QNT_LMT_COUNT);
	}

	public void analyticalMethodTest() {
		List<Map<String, Object>> counts = analyticalMethodTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "22", "6", null, "16", null);
	}

	public void assemblageTest() {
		List<Map<String, Object>> counts = assemblageTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "17", null, null, "16", "1");
	}

	public void avoidTest() {
		List<Map<String, Object>> counts = avoidTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, STORET_RES_DETECT_QNT_LMT_COUNT, null, null, STORET_RES_DETECT_QNT_LMT_COUNT, null);
	}

	public void bboxTest() {
		List<Map<String, Object>> counts = bboxTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "42", "7", "9", "26", null);
	}

	public void characteristicNameTest() {
		List<Map<String, Object>> counts = characteristicNameTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "16", null, null, "16", null);
	}

	public void characteristicTypeTest() {
		List<Map<String, Object>> counts = characteristicTypeTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "21", null, "5", "16", null);
	}

	public void countryTest() {
		List<Map<String, Object>> counts = countryTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "44", "7", "9", "27", "1");
	}

	public void countyTest() {
		List<Map<String, Object>> counts = countyTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "43", "7", "9", "27", null);
	}

	public void huc2Test() {
		List<Map<String, Object>> counts = huc2Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "31", "7", "9", "15", null);
	}

	public void huc3Test() {
		List<Map<String, Object>> counts = huc3Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "31", "7", "9", "15", null);
	}

	public void huc4Test() {
		List<Map<String, Object>> counts = huc4Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "18", "7", null, "11", null);
	}

	public void huc5Test() {
		List<Map<String, Object>> counts = huc5Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "18", "7", null, "11", null);
	}

	public void huc6Test() {
		List<Map<String, Object>> counts = huc6Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "17", "6", null, "11", null);
	}

	public void huc7Test() {
		List<Map<String, Object>> counts = huc7Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "17", "6", null, "11", null);
	}

	public void huc8Test() {
		List<Map<String, Object>> counts = huc8Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "11", null, null, "11", null);
	}

	public void huc10Test() {
		List<Map<String, Object>> counts = huc10Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "11", null, null, "11", null);
	}

	public void huc12Test() {
		List<Map<String, Object>> counts = huc12Test(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "11", null, null, "11", null);
	}

	public void manySitesTest() {
		List<Map<String, Object>> counts = manySitesTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "22", null, null, "22", null);
	}

	public void minActivitiesTest() {
		List<Map<String, Object>> counts = minActivitiesTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "67", "6", "5", "56", null);
	}

	public void minResultsTest() {
		List<Map<String, Object>> counts = minResultsTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "62", "6", null, "56", null);
	}

	public void nldiUrlTest() {
		List<Map<String, Object>> counts = nldiUrlTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "22", null, null, "22", null);
	}

	public void organizationTest() {
		List<Map<String, Object>> counts = organizationTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "43", "7", "9", "27", null);
	}

	public void pcodeTest() {
		List<Map<String, Object>> counts = pcodeTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "16", "1", null, "15", null);
	}

	public void projectTest() {
		List<Map<String, Object>> counts = projectTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "28", "6", "6", "15", "1");
	}

	public void providersTest() {
		List<Map<String, Object>> counts = providersTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "73", "7", "9", "57", null);
	}

	public void resultTest() {
		init();
		filter.setResult(getResult());
		List<Map<String, Object>> counts = countDao.getCounts(nameSpace, filter);
		assertStationResults(counts, 2, "1", null, null, "1", null);
		assertActivityResults(counts, 2, "1", null, null, "1", null);
		assertResultResults(counts, 2, "1", null, null, "1", null);
		assertResDetectQntLmtResults(counts, 2, "1", null, null, "1", null);
		cleanup();
	}

	public void sampleMediaTest() {
		List<Map<String, Object>> counts = sampleMediaTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "70", "6", "6", "57", "1");
	}

	public void siteIdTest() {
		List<Map<String, Object>> counts = siteIdTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "32", "7", "9", "16", null);
	}

	public void siteTypeTest() {
		List<Map<String, Object>> counts = siteTypeTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "73", "6", "9", "57", "1");
	}

	public void startDateHiTest() {
		List<Map<String, Object>> counts = startDateHiTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "70", "6", "6", "57", "1");
	}

	public void startDateLoTest() {
		List<Map<String, Object>> counts = startDateLoTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 5, "33", "7", "9", "16", "1");
	}

	public void stateTest() {
		List<Map<String, Object>> counts = stateTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "43", "7", "9", "27", null);
	}

	public void subjectTaxonomicNameTest() {
		List<Map<String, Object>> counts = subjectTaxonomicNameTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 3, "16", null, null, "15", "1");
	}

	public void withinTest() {
		List<Map<String, Object>> counts = withinTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 4, "69", "7", "9", "53", null);
	}

	public void multipleParameterStationSumTest() {
		List<Map<String, Object>> counts = multipleParameterStationSumTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "7", null, null, "7", null);
	}

	public void multipleParameterActivitySumTest() {
		List<Map<String, Object>> counts = multipleParameterActivitySumTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "14", null, null, "14", null);
	}

	public void multipleParameterActivitySumStationSumTest() {
		List<Map<String, Object>> counts = multipleParameterActivitySumStationSumTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "11", null, null, "11", null);
	}

	public void multipleParameterResultSumTest() {
		List<Map<String, Object>> counts = multipleParameterResultSumTest(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "10", null, null, "10", null);
	}

	public void multipleParameterResultSumStationSumTests() {
		List<Map<String, Object>> counts = multipleParameterResultSumStationSumTests(nameSpace, includeActivity, includeResults);
		assertResDetectQntLmtResults(counts, 2, "7", null, null, "7", null);
	}

	private void assertResDetectQntLmtResults(List<Map<String, Object>> counts, int size,
			String total, String nwis, String stewards, String storet, String biodata) {
		assertResults(counts, CountColumn.KEY_RES_DETECT_QNT_LMT_COUNT, size, total, nwis, stewards, storet, biodata);
	}

}
