package edu.uco.dware6.p7danielwa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        SmsMessage[] msg = null;
        if(b != null){
            Object[] pdus = (Object[]) b.get("pdus");

            msg = new SmsMessage[pdus.length];

            for(int i = 0; i < msg.length; i++){
                msg[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            SmsMessage currentMessage = msg[msg.length-1];

            switch(currentMessage.getDisplayOriginatingAddress()){
                case "1111111111":
                    if(currentMessage.getDisplayMessageBody().equalsIgnoreCase("phone")){
                        Intent i = new Intent(context, MapsActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                    }else if(currentMessage.getDisplayMessageBody().equalsIgnoreCase("web")){

                    }else{
                        toastOnError(currentMessage, context);
                    }
                    break;
                case "1111112222":

                    break;
                default:
                    toastOnError(currentMessage, context);
                    break;
            }

        }
    }

    private void toastOnError(SmsMessage m, Context c){
        String toastMessage = m.getDisplayOriginatingAddress() + " : " + m.getDisplayMessageBody();
        Toast.makeText(c, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
