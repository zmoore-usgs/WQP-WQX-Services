package gov.usgs.cida.wqp.transform;

import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import gov.usgs.cida.wqp.service.ILogService;

public class MapToDelimitedTransformer extends Transformer {

	protected static final String LF = StringUtils.LF;
	protected static final String CR = StringUtils.CR;
	public static final String TAB = "\t";
	public static final String COMMA = ",";
	protected static final String SPACE = " ";

	protected final String delimiter;

	public MapToDelimitedTransformer(OutputStream target, Map<String, String> mapping, ILogService logService, Integer logId, String delimiter) {
		super(target, mapping, logService, logId);
		this.delimiter = delimiter;
		init();
	}

	protected void init() {
		writeHeader();
	}

	protected void writeHeader() {
		boolean firstPass = true;
		for (Entry<?, ?> entry: mapping.entrySet()) {
			String value = getMappedName(entry);
			if (firstPass) {
				firstPass = false;
			} else {
				writeToStream(delimiter);
			}
			writeToStream(encode(value));
		}
	}

	protected void writeData(Map<String, Object> result) {
		writeToStream(LF);
		boolean firstPass = true;
		for (String col: mapping.keySet()) {
			if (firstPass) {
				firstPass = false;
			} else {
				writeToStream(delimiter);
			}
			String value = getStringValue(result.get(col));
			if (null != value) {
				writeToStream(encode(value.toString()));
			}
		}
	}

	public String encode(String value) {
		if (delimiter.contentEquals(TAB)) {
			return value.replace(LF, SPACE).replace(CR, SPACE).replace(TAB, SPACE);
		} else {
			return StringEscapeUtils.escapeCsv(value);
		}
	}

	public String getDelimiter() {
		return delimiter;
	}
}
