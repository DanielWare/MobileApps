package edu.uco.dware6.p5danielwa;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContactInfoFragment extends Fragment {

    private int currentIndex = -1;
    private TextView nameView;
    private TextView phoneNumView;
    private TextView emailView;

    @Override
    public void onActivityCreated(Bundle bundleSaved){
        super.onActivityCreated(bundleSaved);
        nameView = (TextView) getActivity().findViewById(R.id.full_name_view);
        phoneNumView = (TextView) getActivity().findViewById(R.id.phone_num_view);
        emailView = (TextView) getActivity().findViewById(R.id.email_view);

        emailView.setOnClickListener(v->{
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");//this is a magic line -- not sure why, but it fixes the intent launch
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {ContactsActivity.contacts.get(currentIndex).getEmail()});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.annoucement));
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.really_long_email_message));

            startActivity(Intent.createChooser(emailIntent, null));
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_contact_info, container, false);
    }

    public int getShownIndex(){
        return currentIndex;
    }

    public void displaySelectedContact(int index){
        if(index < 0)
            return;
        currentIndex = index;
        Contact contact = ContactsActivity.contacts.get(index);
        nameView.setText(contact.getLastNameFirstName());
        phoneNumView.setText(contact.getPhoneNum());
        emailView.setText(contact.getEmail());
    }

}
