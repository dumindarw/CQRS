package com.drw.cqrs.registry;


import java.io.IOException;
import java.util.List;

public interface DocumentAdapterService<T> {
    String upload(T request) throws IOException;
    List download(int documentID);
}
