package org.gaurav.service;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobContainerItem;
import org.gaurav.util.BlobServiceClientUtil;

public class AzureStorageContainerService {
    private String blobContainerName;

    public AzureStorageContainerService() {}

    public AzureStorageContainerService(String containerName) {
        this.blobContainerName = containerName;
    }

    public void setBlobContainerName(String blobContainerName) {
        this.blobContainerName = blobContainerName;
    }

    public PagedIterable<BlobContainerItem> getAllContainers() {
        return BlobServiceClientUtil.getBlobServiceClient()
                .listBlobContainers();
    }

    public BlobContainerClient getBlobContainer() {
        return BlobServiceClientUtil.getBlobServiceClient()
                .getBlobContainerClient(this.blobContainerName);
    }

    public BlobContainerClient getBlobContainer(String containerName) {
        return BlobServiceClientUtil.getBlobServiceClient()
                .getBlobContainerClient(containerName);
    }

    public BlobContainerClient createBlobContainer() {
        return BlobServiceClientUtil.getBlobServiceClient()
                .createBlobContainer(this.blobContainerName);
    }

    public BlobContainerClient createBlobContainer(String containerName) {
        return BlobServiceClientUtil.getBlobServiceClient()
                .createBlobContainer(containerName);
    }

    public void deleteContainer() {
        BlobServiceClientUtil.getBlobServiceClient()
                .getBlobContainerClient(this.blobContainerName)
                .delete();
    }

    public void deleteContainer(String containerName) {
        BlobServiceClientUtil.getBlobServiceClient()
                .getBlobContainerClient(containerName)
                .delete();
    }
}
