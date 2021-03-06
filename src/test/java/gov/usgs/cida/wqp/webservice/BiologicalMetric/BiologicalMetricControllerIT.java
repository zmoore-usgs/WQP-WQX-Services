package gov.usgs.cida.wqp.webservice.BiologicalMetric;

import static gov.usgs.cida.wqp.swagger.model.BiologicalMetricCountJson.HEADER_BIODATA_BIOLOGICAL_METRIC_COUNT;
import static gov.usgs.cida.wqp.swagger.model.BiologicalMetricCountJson.HEADER_NWIS_BIOLOGICAL_METRIC_COUNT;
import static gov.usgs.cida.wqp.swagger.model.BiologicalMetricCountJson.HEADER_STEWARDS_BIOLOGICAL_METRIC_COUNT;
import static gov.usgs.cida.wqp.swagger.model.BiologicalMetricCountJson.HEADER_STORET_BIOLOGICAL_METRIC_COUNT;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.HEADER_BIODATA_SITE_COUNT;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.HEADER_NWIS_SITE_COUNT;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.HEADER_STEWARDS_SITE_COUNT;
import static gov.usgs.cida.wqp.swagger.model.StationCountJson.HEADER_STORET_SITE_COUNT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import gov.usgs.cida.wqp.Application;
import gov.usgs.cida.wqp.CsvDataSetLoader;
import gov.usgs.cida.wqp.mapping.Profile;
import gov.usgs.cida.wqp.springinit.DBTestConfig;
import gov.usgs.cida.wqp.util.HttpConstants;
import gov.usgs.cida.wqp.webservice.BaseControllerIntegrationTest;

@EnableWebMvc
@AutoConfigureMockMvc()
@SpringBootTest(webEnvironment=WebEnvironment.MOCK,
	classes={DBTestConfig.class, Application.class})
@DatabaseSetup("classpath:/testData/csv/")
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class BiologicalMetricControllerIT extends BaseControllerIntegrationTest {

	protected static final Profile PROFILE = Profile.BIOLOGICAL_METRIC;
	protected static final boolean POSTABLE = true;
	protected static final String ENDPOINT = HttpConstants.BIOLOGICAL_METRIC_SEARCH_ENDPOINT + "?mimeType=";
	protected static final String TOTAL_BIOLOGICAL_METRIC_COUNT = "13";
	protected static final String BIODATA_BIOLOGICAL_METRIC_COUNT = "2";
	protected static final String NWIS_BIOLOGICAL_METRIC_COUNT = "2";
	protected static final String STEWARDS_BIOLOGICAL_METRIC_COUNT = "2";
	protected static final String STORET_BIOLOGICAL_METRIC_COUNT = "7";
	protected static final String FILTERED_TOTAL_BIOLOGICAL_METRIC_COUNT = "1";
	protected static final String FILTERED_STORET_BIOLOGICAL_METRIC_COUNT = "1";

	@Test
	public void testHarness() throws Exception {
		getAsCsvTest();
		getAsCsvZipTest();
		getAsTsvTest();
		getAsTsvZipTest();
		getAsXlsxTest();
		getAsXlsxZipTest();
		getAsXmlTest();
		getAsXmlZipTest();
		getAllParametersTest();
		postGetCountTest();
	}

	public void getAsCsvTest() throws Exception {
		getAsDelimitedTest(ENDPOINT + CSV, HttpConstants.MIME_TYPE_CSV, CSV, PROFILE, POSTABLE);
	}

	public void getAsCsvZipTest() throws Exception {
		getAsDelimitedZipTest(ENDPOINT + CSV_AND_ZIP, HttpConstants.MIME_TYPE_ZIP, CSV, PROFILE, POSTABLE);
	}

	public void getAsTsvTest() throws Exception {
		getAsDelimitedTest(ENDPOINT + TSV, HttpConstants.MIME_TYPE_TSV, TSV, PROFILE, POSTABLE);
	}

	public void getAsTsvZipTest() throws Exception {
		getAsDelimitedZipTest(ENDPOINT + TSV_AND_ZIP, HttpConstants.MIME_TYPE_ZIP, TSV, PROFILE, POSTABLE);
	}

	public void getAsXlsxTest() throws Exception {
		getAsXlsxTest(ENDPOINT + XLSX, HttpConstants.MIME_TYPE_XLSX, XLSX, PROFILE, POSTABLE);
	}

	public void getAsXlsxZipTest() throws Exception {
		getAsXlsxZipTest(ENDPOINT + XLSX_AND_ZIP, HttpConstants.MIME_TYPE_ZIP, XLSX, PROFILE, POSTABLE);
	}

	public void getAsXmlTest() throws Exception {
		getAsXmlTest(ENDPOINT + XML, HttpConstants.MIME_TYPE_XML, XML, PROFILE, POSTABLE);
	}

	public void getAsXmlZipTest() throws Exception {
		getAsXmlZipTest(ENDPOINT + XML_AND_ZIP, HttpConstants.MIME_TYPE_ZIP, XML, PROFILE, POSTABLE);
	}

	public void getAllParametersTest() throws Exception {
		getAllParametersTest(ENDPOINT + CSV, HttpConstants.MIME_TYPE_CSV, CSV, PROFILE, POSTABLE);
	}

	public void postGetCountTest() throws Exception {
		String urlPrefix = HttpConstants.BIOLOGICAL_METRIC_SEARCH_ENDPOINT + "/count?mimeType=";
		
		String compareObject = "{\"" + HttpConstants.HEADER_TOTAL_SITE_COUNT + "\":\"" + FILTERED_TOTAL_SITE_COUNT
				+ "\",\"" + HttpConstants.HEADER_TOTAL_BIOLOGICAL_METRIC_COUNT + "\":\"" + FILTERED_TOTAL_BIOLOGICAL_METRIC_COUNT
				+ "\",\"" + HEADER_STORET_SITE_COUNT + "\":\"" + FILTERED_STORET_SITE_COUNT
				+ "\",\"" + HEADER_STORET_BIOLOGICAL_METRIC_COUNT + "\":\"" + FILTERED_STORET_BIOLOGICAL_METRIC_COUNT
				+ "\"}";
		postGetCountTest(urlPrefix, compareObject, PROFILE);
	}

	@Override
	public ResultActions unFilteredHeaderCheck(ResultActions resultActions) throws Exception {
		return resultActions
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_SITE_COUNT, TOTAL_SITE_COUNT))
				.andExpect(header().string(HEADER_NWIS_SITE_COUNT, NWIS_SITE_COUNT))
				.andExpect(header().string(HEADER_STEWARDS_SITE_COUNT, STEWARDS_SITE_COUNT))
				.andExpect(header().string(HEADER_STORET_SITE_COUNT, STORET_SITE_COUNT))
				.andExpect(header().string(HEADER_BIODATA_SITE_COUNT, BIODATA_SITE_COUNT))
		
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_BIOLOGICAL_METRIC_COUNT, TOTAL_BIOLOGICAL_METRIC_COUNT))
				.andExpect(header().string(HEADER_NWIS_BIOLOGICAL_METRIC_COUNT, NWIS_BIOLOGICAL_METRIC_COUNT))
				.andExpect(header().string(HEADER_STEWARDS_BIOLOGICAL_METRIC_COUNT, STEWARDS_BIOLOGICAL_METRIC_COUNT))
				.andExpect(header().string(HEADER_STORET_BIOLOGICAL_METRIC_COUNT, STORET_BIOLOGICAL_METRIC_COUNT))
				.andExpect(header().string(HEADER_BIODATA_BIOLOGICAL_METRIC_COUNT, BIODATA_BIOLOGICAL_METRIC_COUNT));
	}

	@Override
	public ResultActions filteredHeaderCheck(ResultActions resultActions) throws Exception {
		return resultActions
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_SITE_COUNT, FILTERED_TOTAL_SITE_COUNT))
				.andExpect(header().string(HEADER_STORET_SITE_COUNT, FILTERED_STORET_SITE_COUNT))
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_BIOLOGICAL_METRIC_COUNT, FILTERED_TOTAL_BIOLOGICAL_METRIC_COUNT))
				.andExpect(header().string(HEADER_STORET_BIOLOGICAL_METRIC_COUNT, FILTERED_STORET_BIOLOGICAL_METRIC_COUNT));
	}

	@Override
	public ResultActions noResultHeaderCheck(ResultActions resultActions) throws Exception {
		return resultActions
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_SITE_COUNT, "0"))
				.andExpect(header().string(HttpConstants.HEADER_TOTAL_BIOLOGICAL_METRIC_COUNT, "0"));
	}

}
