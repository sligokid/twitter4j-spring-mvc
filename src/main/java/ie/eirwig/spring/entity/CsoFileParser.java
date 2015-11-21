package ie.eirwig.spring.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class CsoFileParser {

	private static final Logger	LOGGER	= Logger.getLogger(CsoFileParser.class.getName());

	private static final String	CSOFILE	= "/etc/cso/AllThemesTablesCTY.csv";

	private List<CsoCityEntity>	csoData;

	public CsoFileParser(CsoType countType) throws IOException {
		File file = new File(getClass().getResource(CSOFILE).getFile());
		BufferedReader br = new BufferedReader(new FileReader(file));
		csoData = new CopyOnWriteArrayList<CsoCityEntity>();

		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] lineArray = line.split(",");
			CsoCityEntity csoEntity = new CsoCityEntity();
			csoEntity.setGeoGid(lineArray[CsoType.GEOGID.ordinal()]);
			csoEntity.setGeoGtype(lineArray[CsoType.GEOGID.ordinal()]);
			csoEntity.setCity(lineArray[CsoType.GEOGDESC.ordinal()]);
			csoEntity.setLattitude(lineArray[CsoType.LATTITUDE.ordinal()]);
			csoEntity.setLongditude(lineArray[CsoType.LONGITUDE.ordinal()]);

			csoEntity.setCount(lineArray[countType.ordinal()]); // Total
																// population
			csoData.add(csoEntity);
			LOGGER.info(csoEntity.toString());
		}
		br.close();
	}

	public List<CsoCityEntity> getCsoData() {
		return csoData;
	}

}
