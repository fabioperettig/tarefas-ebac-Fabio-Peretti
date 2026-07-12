package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ClinicalReportReader {

    public CureCredentials read() {
        InputStream inputStream = getClass()
                                 .getResourceAsStream("/reports/disease_report.txt");

        if (inputStream == null) {
            throw new IllegalStateException("Clinical report not found.");
        }

        String doctorName = null;
        Integer credentialNumber = null;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        )) {

            String line;
            while ((line = reader.readLine()) != null){
                if (line.startsWith("doctor_name=")){
                    doctorName = line.substring("doctor_name=".length()).trim();
                }

                if (line.startsWith("credential_number=")){
                    credentialNumber = Integer.parseInt(line.substring("credential_number=".length()).trim());
                }
            }

        } catch (IOException exception) {
            throw  new IllegalStateException("Could not read the clinical report.", exception);
        }

        if (doctorName == null || credentialNumber == null) {
            throw new IllegalStateException("Invalid clinical report.");
        }

        return new CureCredentials(doctorName, credentialNumber);
    }

}
