package com.akasharavinth.librarymanagement.librarysetup;


import com.akasharavinth.librarymanagement.LibraryManagement;
import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.Library;

public class LibrarySetupModel {

    private LibrarySetupView librarySetupView;
    LibrarySetupModel(LibrarySetupView librarySetupView){
        this.librarySetupView = librarySetupView;
    }

    private Library library = DataManagement.getInstance().getLibrary();
    public void startSetup() {
      if (library == null){
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
        DataManagement.getInstance().setLibrary(library);
        librarySetupView.onSetupComplete(library);
    }

    public void createLibrary(String libraryName, long libraryId, String emailID, String address) {
        Library library = new Library();
        library.setLibraryName(libraryName);
        library.setLibraryPhoneNo(1);
        library.setLibraryEmailId(emailID);
        library.setLibraryAddress(address);
        DataManagement.getInstance().setLibrary(library);
        librarySetupView.onSetupComplete(library);
    }
}
