package org.gaurav.service;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobItem;

public class AzureService {

    private BlobServiceClient getBlobService() {
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=storagezombie;AccountKey=HlYotPKy+Qq1g1PtefDfMpj/8QOzxqYfgzLKZzmAWjln9/xXMyVWmkdjLf1xSwVjxWvfgW4uVs3W+ASteaT8yQ==;EndpointSuffix=core.windows.net";
        return new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
    }

    public BlobContainerClient createContainer(String containerName) {
        return getBlobService().createBlobContainer(containerName);
    }

    public void uploadBlob(String blob, String container) {
        BlobContainerClient blobContainerClient = getBlobService()
                .getBlobContainerClient(container);

        BlobClient blobClient = blobContainerClient.getBlobClient(blob);
        blobClient.uploadFromFile("data/welcome.txt");
    }

    public PagedIterable<BlobItem> getAllBlobs(String blobContainer) {
        BlobContainerClient containerClient = getBlobService()
                .getBlobContainerClient(blobContainer);

        return containerClient.listBlobs();
    }

    public void downloadBlob(String blobContainer, String blob) {
        BlobClient blobClient = getBlobService()
                .getBlobContainerClient(blobContainer)
                .getBlobClient(blob);

        blobClient.downloadToFile(blob.replace(".txt", "download.txt"));
    }

    public void deleteContainer(String container) {
        getBlobService().getBlobContainerClient(container).delete();
    }
}
