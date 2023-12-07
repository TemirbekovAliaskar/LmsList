package service.impl;

import models.DataBase;
import models.Library;
import models.Reader;
import service.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderServiceimpl implements ReaderService {



    @Override
    public void saveReader(Reader reader) {
        for (int i = 0; i < DataBase.readers.size(); i++) {
            DataBase.readers.add(reader);
            System.out.println("Успешно сщхранено  !");
        }
    }

    @Override
    public List<Reader> getAllReaders() {
       return  DataBase.readers;

    }
    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : DataBase.readers) {
            if (reader.getId() == id){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {

        for (int i = 0; i < DataBase.readers.size(); i++) {
          if (DataBase.readers.get(i).getId() == id){
              DataBase.readers.set(i, reader);
              System.out.println("Успешно изменено !");
          }
        }
        return reader;

    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(libraryId)){
                for (int j = 0; j < DataBase.readers.size(); j++) {
                    if (DataBase.readers.get(i).getId() == readerId){
                        DataBase.libraries.get(i).readerList.add(DataBase.readers.get(i));
                    }
                }
            }
        }


    }
}
