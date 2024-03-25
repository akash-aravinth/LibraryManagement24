package com.akasharavinth.librarymanagement.librarysetup;


import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.Library;

public class LibrarySetupModel {

    private LibrarySetupView librarySetupView;
    LibrarySetupModel(LibrarySetupView librarySetupView){
        this.librarySetupView = librarySetupView;
    }

    private Library library;
    public void startSetup() {
      if (library == null || library.getLibraryId() == 0){
          librarySetupView.initiateSetup();
          System.out.println(library);
      }else {
          librarySetupView.onSetupComplete(library);
          System.out.println(library + "  akash");
      }
    }


    public void setInitalValues(Library library) {
        this.library = DataManagement.getInstance().insertLibrary(library);
        library.setLibraryId(1);
        librarySetupView.onSetupComplete(library);
    }
}
