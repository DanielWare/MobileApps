package edu.uco.dware6.p5danielwa;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class ContactsActivity extends Activity implements ContactNamesListFragment.ListSelectionListener{

    public static ArrayList<Contact> contacts;
    private ContactInfoFragment infoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        String[] firstNames = getResources().getStringArray(R.array.FirstNames);
        String[] lastNames = getResources().getStringArray(R.array.LastNames);
        String[] phoneNums = getResources().getStringArray(R.array.PhoneNumbers);
        String[] emails = getResources().getStringArray(R.array.Emails);
        contacts = new ArrayList<>();
        for(int i = 0; i < firstNames.length; i++){
            contacts.add(new Contact(firstNames[i], lastNames[i], phoneNums[i], emails[i]));
        }

        Collections.sort(contacts, (a,b)-> a.getLastName().compareTo(b.getLastName()));
        infoFragment = (ContactInfoFragment) getFragmentManager().findFragmentById(R.id.contact_info);
    }

    @Override
    public void onListSelection(int index){
        if(infoFragment.getShownIndex() != index){
            infoFragment.displaySelectedContact(index);
        }
    }
}
