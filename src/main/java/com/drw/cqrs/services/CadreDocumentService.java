package com.drw.cqrs.services;



import com.drw.cqrs.models.Cadre;
import com.drw.cqrs.registry.DocumentAdapterService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service("Cadre")
public class CadreDocumentService implements DocumentAdapterService<MultipartFile> {




    @Override
    public String upload(MultipartFile  request) {

        //Save in Disk
        //Save in DB

        return "CadreDoc";

    }


    @Override
    public List<Cadre> download(int documentID) {
        return null;
    }

}
