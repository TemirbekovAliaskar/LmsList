package service.impl;
import models.DataBase;
import models.Library;
import service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceimpl implements LibraryService {
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        DataBase.libraries.addAll(libraries);
        return DataBase.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
       return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals (id)){
                return DataBase.libraries.get(i);
            }
        }return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(id)){
               DataBase.libraries.set(i,library);
                System.out.println("Успешно изменено !");
            }
        }
        return library;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(id)){
                DataBase.libraries.remove(DataBase.libraries.get(i));
                System.out.println("Успешно удалено !");
            }
        }
        return "";
    }
}
