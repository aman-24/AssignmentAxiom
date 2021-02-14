package app.framework.config;

import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.framework.utils.AndroidDeviceModel;
import app.framework.utils.FileUtility;
import app.framework.utils.IOSDeviceModel;

public class DriverConfig {

	public static String executionPlatform;

    public static synchronized String getExecutionPlatform() {
        return executionPlatform;
    }

    public synchronized void setExecutionPlatform(String executionPlatform) {
    	DriverConfig.executionPlatform = executionPlatform;
    }

    public static IOSDeviceModel readIOSDeviceConfig() throws IOException {
        byte[] jsonData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        jsonData = Files.readAllBytes(FileUtils.getFile(FileUtility.getFile("iosDevice.json")).toPath());
        IOSDeviceModel[] iosDeviceModels = objectMapper.readValue(jsonData, IOSDeviceModel[].class);
        return new IOSDeviceModel(iosDeviceModels);
    }

    public static AndroidDeviceModel readAndroidDeviceConfig() throws IOException {
        byte[] jsonData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        jsonData = Files.readAllBytes(FileUtils.getFile(FileUtility.getFile("androidDevice.json")).toPath());
        AndroidDeviceModel[] androidDeviceModels = objectMapper.readValue(jsonData, AndroidDeviceModel[].class);
        return new AndroidDeviceModel(androidDeviceModels);
    }

}
