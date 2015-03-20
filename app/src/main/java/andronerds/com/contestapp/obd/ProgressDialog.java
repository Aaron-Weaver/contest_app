package andronerds.com.contestapp.obd;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;


/**
 * Created by Dilancuan on 3/20/2015.
 */
public class ProgressDialog extends AsyncTask<android.app.ProgressDialog, Integer, Void> {
    @Override
    protected Void doInBackground(android.app.ProgressDialog... params) {
        android.app.ProgressDialog progress = params[0];

        Looper.prepare();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                OnBoardDiagnostic.setWaitingOnBluetooth(true);
                Message msg = Message.obtain();
                Bundle b = new Bundle();
                b.putString("Purpose","FAILED");
                msg.setData(b);
                OnBoardDiagnostic.mHandler.sendMessage(msg);
            }
        }, 20000 );

        while(OnBoardDiagnostic.isWaitingOnBluetooth());
        progress.dismiss();

        return null;
    }
}
