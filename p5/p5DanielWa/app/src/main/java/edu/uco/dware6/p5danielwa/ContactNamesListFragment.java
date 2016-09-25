package edu.uco.dware6.p5danielwa;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ContactNamesListFragment extends ListFragment {

    private ListSelectionListener listSelectionListener = null;

    public interface ListSelectionListener {
        void onListSelection(int index);
    }

    @Override
    public void onActivityCreated(Bundle savedState){
        super.onActivityCreated(savedState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayList<String> lastNames = new ArrayList<>();
        for(Contact c: ContactsActivity.contacts){
            lastNames.add(c.getLastName());
        }

        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.contact_last_name_item, lastNames));

        try{
            listSelectionListener = (ListSelectionListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement ListSelectionListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id){
        getListView().setItemChecked(pos, true);
        listSelectionListener.onListSelection(pos);
    }


}
