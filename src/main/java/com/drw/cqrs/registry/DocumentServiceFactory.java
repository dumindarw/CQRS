package com.drw.cqrs.registry;

public interface DocumentServiceFactory {

    <T> DocumentAdapterService<T> getService(String service);
}
