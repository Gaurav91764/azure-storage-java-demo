package org.gaurav;

import org.gaurav.service.AzureStorageContainerService;
import org.gaurav.util.BlobServiceClientUtil;

public class App
{
    public static void main( String[] args )
    {
        AzureStorageContainerService blobService = new AzureStorageContainerService();


        blobService.getAllContainers().forEach(
                blobContainerItem -> System.out.println(blobContainerItem.getName())
        );

        blobService
                .getBlobContainer("hellocontainer")
                .listBlobs()
                .forEach(blobItem -> System.out.println(blobItem.getName()));

        blobService.setBlobContainerName("quickstart");
        blobService.deleteContainer();

        System.out.println("Listing container after deleting one");

        blobService
                .getAllContainers()
                .forEach(blobContainerItem -> System.out.println(blobContainerItem.getName()));
    }
}
