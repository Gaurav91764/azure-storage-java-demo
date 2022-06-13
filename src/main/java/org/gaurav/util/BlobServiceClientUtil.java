package org.gaurav.util;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class BlobServiceClientUtil {
    public static BlobServiceClient getBlobServiceClient() {
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=storagezombie;AccountKey=HlYotPKy+Qq1g1PtefDfMpj/8QOzxqYfgzLKZzmAWjln9/xXMyVWmkdjLf1xSwVjxWvfgW4uVs3W+ASteaT8yQ==;EndpointSuffix=core.windows.net";
        return new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
    }
}
