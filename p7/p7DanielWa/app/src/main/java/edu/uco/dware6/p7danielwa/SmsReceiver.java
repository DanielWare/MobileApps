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

            String number = currentMessage.getDisplayOriginatingAddress();

            switch(number){
                case "1111111111":
                    if(currentMessage.getDisplayMessageBody().equalsIgnoreCase("phone")){
                        Intent phoneIntent = new Intent(context, MapsActivity.class);
                        phoneIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        phoneIntent.putExtra("ContentType", ContentType.PHONE);
                        context.startActivity(phoneIntent);
                        break;
                    }else if(currentMessage.getDisplayMessageBody().equalsIgnoreCase("web")){
                        Intent webIntent = new Intent(context, MapsActivity.class);
                        webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        webIntent.putExtra("ContentType", ContentType.WEB);
                        context.startActivity(webIntent);
                        break;
                    }else{
                        toastOnError(currentMessage, context);
                        break;
                    }
                case "1111112222":
                    Intent weatherIntent = new Intent(context, WeatherActivity.class);
                    weatherIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    City c = new City(currentMessage.getDisplayMessageBody().toString());
                    weatherIntent.putExtra("city", c);
                    context.startActivity(weatherIntent);
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
